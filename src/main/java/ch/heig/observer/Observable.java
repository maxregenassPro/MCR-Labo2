/**
 *   Autheur: Theo Bensaci, Maxime Regenass
 *   Date: 15:42 26.03.2026
 *   Description: Base observable class
 */

package ch.heig.observer;

import java.util.ArrayList;
import java.util.List;

public class Observable {
    private List<Iobserver> _observers = new ArrayList<>();

    public void attach(Iobserver observer) {
        _observers.add(observer);
    }

    public void detach(Iobserver observer) {
        _observers.remove(observer);
    }

    public void notifyObservers() {
        for (Iobserver observer : _observers) {
            observer.update();
        }
    }
}
