// ID: 211398086
package game;

import biuoop.DrawSurface;
import collision.Collidable;
import geometry.Point;
import geometry.Rectangle;
import level.LevelInformation;
import listener.BallRemover;
import listener.BlockRemover;
import listener.ScoreTrackingListener;
import sprites.Block;
import sprites.Ball;
import sprites.SpriteCollection;
import sprites.Paddle;
import sprites.ScoreIndicator;
import sprites.Sprite;

import java.awt.Color;
import java.util.ArrayList;

import static biuoop.KeyboardSensor.SPACE_KEY;

/**
 * @author Shira Goldstein
 *
 * ID:211398086
 */

/**
 * A Game.Game.
 * The class describe a Game.Game object and its operations -
 * addCollidable, addSprite, initialize and run.
 * It is implemented using sprites.SpriteCollection, Game.GameEnvironment and GUI.
 */
public class GameLevel implements Animation {
    //fields
    private SpriteCollection sprites;
    private GameEnvironment environment;
    //private GUI gui = new GUI("game", 800, 600);
    private Counter blockcounter;
    private Counter ballcounter;
    private Counter score;
    //private AnimationRunner runner = new AnimationRunner(this.gui);
    private AnimationRunner ar;
    private boolean running;
    private LevelInformation level;

    //constructors
    /**
     * create a Game.Game with the specified sprites.SpriteCollection and Game.GameEnvironment.
     * @param sprites the sprites.SpriteCollection
     * @param environment the Game.GameEnvironment
     */
    public GameLevel(SpriteCollection sprites, GameEnvironment environment) {
        this.sprites = sprites;
        this.environment = environment;
    }
    /**
     * create a Game.Game with a new collidables arraylists
     * of sprites.Sprite and new environment.
     * @param level the LevelInformation
     * @param ar the AnimationRunner
     * @param score the game score
     */
    public GameLevel(LevelInformation level, AnimationRunner ar, Counter score) {
        this.sprites = new SpriteCollection(new ArrayList<Sprite>());
        this.environment = new GameEnvironment();
        this.blockcounter = new Counter(0);
        this.ballcounter = new Counter(0);
        //this.score = new Counter(0);
        this.score = score;
        this.level = level;
        this.ar = ar;
    }
    /**
     * create a Game.Game with the specified ball.
     * @param ball the ball
     */
    public GameLevel(Ball ball) {
        this.sprites = new SpriteCollection(new ArrayList<Sprite>());
        this.environment = ball.getGameEnvironment();
    }

    /**
     * add the given collision.Collidable to the Game.GameEnvironment.
     * @param c the collision.Collidable that we add to the list
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    /**
     * add the given sprites.Sprite to the sprites.SpriteCollection of the game.
     * @param s the sprites.Sprite that we add to the list
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }
    /**
     * Initialize a new game: create the Blocks and
     * sprites.Ball (and sprites.Paddle) and add them to the game.
     */
    public void initialize() {

        BlockRemover blockRemover = new BlockRemover(this, this.blockcounter);

        BallRemover ballRemover = new BallRemover(this, this.ballcounter);

        ScoreTrackingListener scoreListener = new ScoreTrackingListener(this.score);

        Sprite scoreIndicator = new ScoreIndicator(this.score);

        for (int i = 0; i < this.level.numberOfBalls(); i++) {
            Ball ball = new Ball(new Point(400, 540), 5, Color.white, this.environment);
            ball.setVelocity(level.initialBallVelocities().get(i));
            ball.addToGame(this);
            this.ballcounter.increase(1);
        }

        //creating a paddle
        if (level.numberOfBalls() == 10) {
            biuoop.KeyboardSensor keyboard = ar.getGui().getKeyboardSensor();
            Paddle paddle = new Paddle(keyboard, new Point(100, 565), level.paddleWidth());
            paddle.addToGame(this);
        } else {
            biuoop.KeyboardSensor keyboard = ar.getGui().getKeyboardSensor();
            Paddle paddle = new Paddle(keyboard);
            paddle.addToGame(this);
        }

        //creating the blocks
        Block topBlock = new Block(new Rectangle(new Point(20, 0), 760, 60), Color.gray);
        Block downBlock = new Block(new Rectangle(new Point(20, 600), 760, 0), Color.white);
        Block rightBlock = new Block(new Rectangle(new Point(0, 0), 40, 600), Color.gray);
        Block leftBlock = new Block(new Rectangle(new Point(760, 0), 40, 600), Color.gray);

        downBlock.addHitListener(ballRemover);

        //create the frame blocks
        topBlock.addToGame(this);
        downBlock.addToGame(this);
        rightBlock.addToGame(this);
        leftBlock.addToGame(this);

        //add the score indicator block
        this.addSprite(scoreIndicator);

        //create the blocks
        for (Block block : level.blocks()) {
            block.addToGame(this);
            this.blockcounter.increase(1);
            block.addHitListener(blockRemover);
            block.addHitListener(scoreListener);
        }
    }


    /**
     * run the game: use the Blocks and
     * sprites.Ball (and sprites.Paddle) and run them in the game.
     */
    public void run() {
        this.ar.run(new CountdownAnimation(2, 3, this.sprites, this.level));
        this.running = true;
        this.ar.run(this);
    }

    /**
     * remove the given collidable from the game.
     * @param c the one we remove
     */
    public void removeCollidable(Collidable c) {
        this.environment.getCollidables().remove(c);
    }

    /**
     * remove the given Sprite from the game.
     * @param s the one we remove
     */
    public void removeSprite(Sprite s) {
        this.sprites.getSprites().remove(s);
    }

    /**
     * @return true if the animation should stop,
     * else return false
     */
    public boolean shouldStop() {
        return !this.running;
    }

    /**
     * make one frame of the animation.
     * @param d the DrawSurface of the animation game
     */
    public void doOneFrame(DrawSurface d) {
        level.getBackground().drawOn(d);
        this.sprites.drawAllOn(d);
        d.setColor(Color.black);
        d.drawText(630, 15, "Level Name: " + level.levelName(), 13);
        this.sprites.notifyAllTimePassed();

        if (this.blockcounter.getValue() == 0 && this.ballcounter.getValue() != 0) {
            this.score.increase(100);
            //ar.getGui().close();
            this.running = false;
            if (this.level.getIsLast()) {
                this.ar.run(new YouWinScreen(this.ar.getGui().getKeyboardSensor(), this.score.getValue()));
                ar.getGui().close();
            }
        }
        if (/*this.blockcounter.getValue() == 0 ||*/ this.ballcounter.getValue() == 0) {
            //ar.getGui().close();
            this.running = false;
            this.ar.run(new GameOverScreen(this.ar.getGui().getKeyboardSensor(), this.score.getValue()));
            ar.getGui().close();
        }
        if (this.ar.getGui().getKeyboardSensor().isPressed("p")) {
            //this.ar.run(new PauseScreen(this.ar.getGui().getKeyboardSensor()));
            this.ar.run(new KeyPressStoppableAnimation(this.ar.getGui().getKeyboardSensor(),
                    SPACE_KEY, new PauseScreen(this.ar.getGui().getKeyboardSensor())));
        }
    }

    /**
     * @return Counter the block counter
     */
    public Counter getBlockCounter() {
        return this.blockcounter;
    }
    /**
     * @return Counter the ball counter
     */
    public Counter getBallCounter() {
        return this.ballcounter;
    }
}
