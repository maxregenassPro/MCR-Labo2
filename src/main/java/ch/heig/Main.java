package ch.heig;

import ch.heig.observer.ConcreteClockObservable;
import ch.heig.observer.ConcreteClockObserver;
import ch.heig.render.ClockControlPanel;
import ch.heig.render.ClockWindowFactory;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        int nbChrono = 3;

        if (args.length > 0) {
            nbChrono = Integer.parseInt(args[0]);
        }

        ClockControlPanel ccp = new ClockControlPanel(nbChrono);
        ccp.CreateView();
    }
}