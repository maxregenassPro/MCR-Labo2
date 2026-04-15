/**
 *   Autheur: Theo Bensaci, Maxime Regenass
 *   Date: 14:54 19.03.2026
 *   Description: interface use to make a observer
 */

package ch.heig.observer;

public interface Iobserver {
    /**
     * Update the observer
     */
    void update();

    /**
     * Detach the observer
     */
    void detach();
}
