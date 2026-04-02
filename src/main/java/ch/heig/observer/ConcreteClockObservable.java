package ch.heig.observer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class ConcreteClockObservable extends ClockObservable {
    private Timer _timer;
    //private Date _time;

    private long _time=-1;
    private long _lastUpdate=0;

    private final int INTERVAL = 1000;

    public final String name;

    public ConcreteClockObservable(String name) {
        this.name=name;
        CreateTimer();
    }
    public ConcreteClockObservable() {
        this("default name");
    }

    public Timer getTimer() {
        return _timer;
    }

    public long getTime() {
        return _time;
    }

    public void setTimer(Timer timer) {
        this._timer = timer;
    }

    private void update(){
        long t = System.currentTimeMillis();
        _time+=(t-_lastUpdate);
        _lastUpdate=t;
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
        _lastUpdate=System.currentTimeMillis();
        _timer.start();
    }

    public void Stop(){
        _timer.stop();
    }

    public void Clear(){
        _lastUpdate=System.currentTimeMillis();
        _time=0;
    }
}
