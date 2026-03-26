package ch.heig;

import ch.heig.observer.ConcreteClockObservable;
import ch.heig.observer.ConcreteClockObserver;
import ch.heig.render.ClockWindowFactory;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        ConcreteClockObservable ccoa=new ConcreteClockObservable();
        ccoa.Run();
        ClockWindowFactory.createNum(ccoa);
        ClockWindowFactory.createArb(ccoa);
        ClockWindowFactory.createRom(ccoa);


    }
}