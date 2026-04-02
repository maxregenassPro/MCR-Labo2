package ch.heig.render;

import ch.heig.observer.ConcreteClockObservable;

public class ClockWindowFactory {



    public static ClockWindow createNum(ConcreteClockObservable cco){
        return new ClockWindow("Num",cco,new ClockCanavasNum());
    }

    public static ClockWindow createRom(ConcreteClockObservable cco){
        return new ClockWindow("Rom",cco,new ClockCanavasRom());
    }

    public static ClockWindow createArb(ConcreteClockObservable cco){
        return new ClockWindow("Arb",cco,new ClockCanavasArb());
    }
}
