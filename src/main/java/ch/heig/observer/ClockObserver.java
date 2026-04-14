package ch.heig.observer;


import ch.heig.clock.AbstractClockCanvas;

public class ClockObserver implements Iobserver {

    private final ClockObservable _observed;
    private AbstractClockCanvas _canvas;

    public ClockObserver(ClockObservable observable, AbstractClockCanvas canvas) {
        this._canvas=canvas;
        this._observed = observable;
        this._observed.attach(this);
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
    public void update() {
        int[] time = getTime(_observed.getTime());
        _canvas.setTime(time[0],time[1],time[2]);
    }

    @Override
    public void detach() {
        _observed.detach(this);
    }

    public String getClockName(){
        return _observed.name;
    }
}
