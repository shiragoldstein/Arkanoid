package game;

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;
/**
 * @author Shira Goldstein
 *
 * ID:211398086
 */


/**
 * A AnimationRunner.
 * The class describe a AnimationRunner and its operations -
 * run and getGui.
 * It is implemented using a GUI and int.
 */
public class AnimationRunner {
    //fields
    private GUI gui;
    private int framesPerSecond;

    //constructor
    /**
     * create an AnimationRunner.
     */
    public AnimationRunner() {
        this.gui = new GUI("game", 800, 600);
        this.framesPerSecond = 60;
    }

    /**
     * run the animation: use the gui and
     * run it in the game.
     * @param animation the animation that we run
     */
    public void run(Animation animation) {
        Sleeper sleeper = new Sleeper();
        int millisecondsPerFrame = 1000 / this.framesPerSecond;
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();

            animation.doOneFrame(d);

            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }

    /**
     * @return the AnimationRunner GUI.
     */
    public GUI getGui() {
        return this.gui;
    }
}
