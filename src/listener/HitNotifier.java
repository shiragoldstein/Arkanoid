package listener;
/**
 * @author Shira Goldstein
 *
 * ID:211398086
 */
/**
 * A HitNotifier interface.
 * The interface describe a HitNotifier interface and its operations -
 * addHitListener and removeHitListener.
 */
public interface HitNotifier {
    /**
     * Add hl as a listener to hit events.
     * @param hl the listener that we add to the list.
     */
    void addHitListener(HitListener hl);
    /**
     * remove hl from the listeners to hit events.
     * @param hl the listener that we remove from the list.
     */
    void removeHitListener(HitListener hl);
}
