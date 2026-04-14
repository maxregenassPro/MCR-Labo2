package ch.heig.clock;

import ch.heig.observer.ClockObservable;

public class ClockFactory {


    public static ClockWindow createNum(ClockObservable observable, String title){
        return new ClockWindow(title,new ClockCanavasNum(observable));
    }

    public static ClockWindow createRom(ClockObservable observable, String title){
        return new ClockWindow(title,new ClockCanavasRom(observable));
    }


    public static ClockWindow createArb(ClockObservable observable, String title){
        return new ClockWindow(title,new ClockCanavasArb(observable));
    }

    public static MultipleClockWindow createAllRom(ClockObservable[] observables, String title){
        AbstractClockCanvas[] aca = new AbstractClockCanvas[observables.length];
        for (int i = 0; i < observables.length; i++) {
            aca[i]=new ClockCanavasRom(observables[i]);
        }
        return new MultipleClockWindow(title,aca);
    }

    public static MultipleClockWindow createAllArb(ClockObservable[] observables, String title){
        AbstractClockCanvas[] aca = new AbstractClockCanvas[observables.length];
        for (int i = 0; i < observables.length; i++) {
            aca[i]=new ClockCanavasArb(observables[i]);
        }
        return new MultipleClockWindow(title,aca);
    }

    public static MultipleClockWindow createAllNum(ClockObservable[] observables, String title){
        AbstractClockCanvas[] aca = new AbstractClockCanvas[observables.length];
        for (int i = 0; i < observables.length; i++) {
            aca[i]=new ClockCanavasNum(observables[i]);
        }
        return new MultipleClockWindow(title,aca);
    }
}
