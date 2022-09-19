/**
 * @author Shira Goldstein
 *
 * ID:211398086
 */


import game.AnimationRunner;
import level.LevelInformation;
import level.DirectHit;
import level.WideEasy;
import level.Green3;
import level.FinalFour;
import level.GameFlow;

import java.util.ArrayList;
import java.util.List;

/**
 * Game.Ass6Game.
 * The class Create a game object, initializes and runs it.
 */
public class Ass6Game {
    /**
     * @param args an array of command-line arguments for the application
     */
    public static void main(String[] args) {
        AnimationRunner ar = new AnimationRunner();
        //biuoop.KeyboardSensor ks = gui.getKeyboardSensor();
        List<LevelInformation> levels = new ArrayList<>();
        if (args.length == 0) {
            levels.add(new DirectHit());
            levels.add(new WideEasy());
            levels.add(new Green3());
            levels.add(new FinalFour());

            levels.get(3).setLast(true);
        } else {
            for (int i = 0; i < args.length; i++) {
                try {
                    Integer.valueOf(args[i]);
                } catch (Exception e) {
                    int y;
                    continue;
                }
                if (Integer.valueOf(args[i]) == 1) {
                        levels.add(new DirectHit());
                    } else {
                        if (Integer.valueOf(args[i]) == 2) {
                            levels.add(new WideEasy());
                        } else {
                            if (Integer.valueOf(args[i]) == 3) {
                                levels.add(new Green3());
                            } else {
                                if (Integer.valueOf(args[i]) == 4) {
                                    levels.add(new FinalFour());
                                } else {
                                    int x;
                                }
                            }
                        }
                    }
            }

            if (levels.size() != 0) {
                    levels.get(levels.size() - 1).setLast(true);
            } else {
                levels.add(new DirectHit());
                levels.add(new WideEasy());
                levels.add(new Green3());
                levels.add(new FinalFour());

                levels.get(3).setLast(true);
            }
        }
        GameFlow gameFlow = new GameFlow(ar);
        gameFlow.runLevels(levels);
        /*GameLevel game = new GameLevel(levels.get(0), ar);
        game.initialize();
        game.run();*/
    }
}
