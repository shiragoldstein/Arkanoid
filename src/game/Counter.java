package game;
/**
 * @author Shira Goldstein
 *
 * ID:211398086
 */


/**
 * A Counter.
 * The class describe a Counter and its operations -
 * increase, decrease and getValue.
 * It is implemented using an Integer
 */
public class Counter {
    //fields
    private int num;

    /**
     * create a Counter with the specified int.
     * @param num the number
     */
    //constructor
    public Counter(int num) {
        this.num = num;
    }
    /**
     * add number to current count.
     * @param number the number that we add
     */
    public void increase(int number) {
        this.num = this.num + number;
    }
    // subtract number from current count.
    /**
     * subtract number from current count.
     * @param number the number thet we subtract
     */
    public void decrease(int number) {
        this.num = this.num - number;
    }
    /**
     * get current count.
     * @return the current count
     */
    public int getValue() {
        return this.num;
    }
}
