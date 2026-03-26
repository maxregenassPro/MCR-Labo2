package ch.heig.render;

import ch.heig.observer.ClockObservable;
import ch.heig.observer.ConcreteClockObservable;
import ch.heig.observer.ConcreteClockObserver;

import javax.swing.*;

public class ClockWindow extends JFrame {


    private ClockCanvas _canvas;
    private ConcreteClockObserver _cco;

    ClockWindow(String title, ConcreteClockObservable ccoa, ClockCanvas canvas){
        _canvas=canvas;

        _cco=new ConcreteClockObserver(ccoa,_canvas);

        add(canvas);

        setTitle(title);

        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // pack and make it visible
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public ClockCanvas get_canvas(){
        return _canvas;
    }
}
