package ch.heig.observer;


import javax.swing.*;

public class ConcreteClockObserver implements ClockObserver{
    private Timer timer;
    private final ConcreteClockObservable cco;

    public ConcreteClockObserver(ConcreteClockObservable cco) {
        this.cco = cco;
    }

    @Override
    public void Update() {
        this.timer = cco.getTimer();
    }
}
