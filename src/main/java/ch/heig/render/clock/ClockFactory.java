package ch.heig.render.clock;

import ch.heig.observer.ConcreteClockObservable;
import ch.heig.render.window.ClockWindow;
import ch.heig.render.window.MultipleClockWindow;

public class ClockFactory {


    public static ClockWindow createNum(ConcreteClockObservable cco, String title){
        return new ClockWindow(title,new ClockCanavasNum(cco));
    }

    public static ClockWindow createRom(ConcreteClockObservable cco,String title){
        return new ClockWindow(title,new ClockCanavasRom(cco));
    }

    public static ClockWindow createArb(ConcreteClockObservable cco, String title){
        return new ClockWindow(title,new ClockCanavasArb(cco));
    }

    public static MultipleClockWindow createAllRom(ConcreteClockObservable[] cco, String title){
        AbstractClockCanvas[] aca = new AbstractClockCanvas[cco.length];
        for (int i = 0; i < cco.length; i++) {
            aca[i]=new ClockCanavasRom(cco[i]);
        }
        return new MultipleClockWindow(title,aca);
    }

    public static MultipleClockWindow createAllArb(ConcreteClockObservable[] cco, String title){
        AbstractClockCanvas[] aca = new AbstractClockCanvas[cco.length];
        for (int i = 0; i < cco.length; i++) {
            aca[i]=new ClockCanavasArb(cco[i]);
        }
        return new MultipleClockWindow(title,aca);
    }

    public static MultipleClockWindow createAllNum(ConcreteClockObservable[] cco, String title){
        AbstractClockCanvas[] aca = new AbstractClockCanvas[cco.length];
        for (int i = 0; i < cco.length; i++) {
            aca[i]=new ClockCanavasNum(cco[i]);
        }
        return new MultipleClockWindow(title,aca);
    }
}
