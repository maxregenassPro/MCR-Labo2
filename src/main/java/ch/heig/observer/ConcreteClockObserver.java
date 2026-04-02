package ch.heig.observer;


import ch.heig.render.ClockCanvas;

import javax.swing.*;
import java.util.Date;

public class ConcreteClockObserver implements ClockObserver{

    private final ConcreteClockObservable cco;
    private ClockCanvas _canvas;

    public ConcreteClockObserver(ConcreteClockObservable cco, ClockCanvas canvas) {
        this._canvas=canvas;
        this.cco = cco;
        this.cco.attach(this);
    }

    /**
     * get hours, minute, second from time (milliseconde)
     * @param time milisiconde
     * @return [hours, minute, second]
     */
    int[] getTime(long time){
        long hours = time / 3600000;
        long minute = time / 60000 - hours;
        long second = time / 1000 - minute - hours;

        return new int[]{Math.round(hours),Math.round(minute),Math.round(second)};
    }

    @Override
    public void Update() {
        int[] time = getTime(cco.getTime());
        _canvas.setTime(time[0],time[1],time[2]);
    }
}
