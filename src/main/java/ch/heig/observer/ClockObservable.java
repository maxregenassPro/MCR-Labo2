package ch.heig.observer;

import java.util.ArrayList;
import java.util.List;

public class ClockObservable {
    private List<ClockObserver> observers = new ArrayList<>();

    public void attach(ClockObserver observer) {
        observers.add(observer);
    }

    public void detach(ClockObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (ClockObserver observer : observers) {
            observer.Update();
        }
    }
}
