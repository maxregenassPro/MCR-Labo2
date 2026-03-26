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

    @Override
    public void Update() {
        Date d = cco.getTime();
        System.out.println(d.getHours()+"|"+d.getMinutes()+"|"+d.getSeconds());
        _canvas.setTime(d.getHours(),d.getMinutes(),d.getSeconds());
    }
}
