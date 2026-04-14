package ch.heig.observer;

import javax.swing.*;

public class ClockObservable extends Observable {
    private final Timer _timer;

    private long _time=-1;
    private long _lastUpdate=0;

    public final String name;

    public ClockObservable(String name) {
        this.name=name;

        _timer = new Timer(1000, arg0 -> {
            {
                long t = System.currentTimeMillis();
                _time+=(t-_lastUpdate);
                _lastUpdate=t;
                notifyObservers();
            }
        });

        _timer.setRepeats(true);
    }
    public ClockObservable() {
        this("default name");
    }

    public long getTime() {
        return _time;
    }


    public void run(){
        _lastUpdate=System.currentTimeMillis();
        _timer.start();
    }

    public void stop(){
        _timer.stop();
    }

    public void clear(){
        _lastUpdate=System.currentTimeMillis();
        _time=0;
        notifyObservers();
    }
}
