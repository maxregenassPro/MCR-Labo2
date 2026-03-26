package ch.heig.observer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConcreteClockObservable extends ClockObservable {
    private Timer  timer;
    private final int INTERVAL = 1000;

    public ConcreteClockObservable() {
        CreateTimer();
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
        this.notifyObservers();
    }

    public void CreateTimer(){
        timer = new Timer(INTERVAL, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                setTimer(timer);
            }
        });

        timer.setRepeats(true);
    }

    public void Run(){
        timer.start();
    }

    public void Stop(){
        timer.stop();
    }

    public void Clear(){
        CreateTimer();
    }
}
