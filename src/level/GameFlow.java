package level;

import biuoop.KeyboardSensor;
import game.AnimationRunner;
import game.Counter;
import game.GameLevel;
import java.util.List;

/**
 * @author Shira Goldstein
 *
 * ID:211398086
 */


/**
 * A GameFlow.
 * The class describe a GameFlow and its operation -
 * runLevels.
 * It is implemented using a KeyboardSensor and AnimationRunner.
 */
public class GameFlow {
    //fields
    private AnimationRunner ar;
    private KeyboardSensor ks;

    /**
     * create a GameFlow with the specified AnimationRunner.
     * @param ar the AnimationRunner
     */
    //constructor
    public GameFlow(AnimationRunner ar) {
        this.ar = ar;
        //this.ks = ks;
    }

    /**
     * run all the levels in the given list.
     * @param levels the list of the levels
     */
    public void runLevels(List<LevelInformation> levels) {
        Counter counter = new Counter(0);
        for (LevelInformation levelInfo : levels) {
            GameLevel level = new GameLevel(levelInfo, this.ar, counter);
            level.initialize();
            //level.run();
            while (level.getBallCounter().getValue() != 0 && level.getBlockCounter().getValue() != 0) {
                level.run();
            }
            if (level.getBallCounter().getValue() == 0) {
                break;
            }
        }
    }
}
