package ch.heig.observer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class ConcreteClockObservable extends ClockObservable {
    private Timer _timer;
    private Date _time;
    private final int INTERVAL = 1000;

    public ConcreteClockObservable() {
        CreateTimer();
    }

    public Timer getTimer() {
        return _timer;
    }

    public Date getTime() {
        return _time;
    }

    public void setTimer(Timer timer) {
        this._timer = timer;
    }

    private void update(){
        _time=new Date();
        this.notifyObservers();
    }

    public void CreateTimer(){
        _timer = new Timer(INTERVAL, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                {
                    update();
                }
            }
        });

        _timer.setRepeats(true);
    }

    public void Run(){
        _timer.start();
    }

    public void Stop(){
        _timer.stop();
    }

    public void Clear(){
        CreateTimer();
    }
}
