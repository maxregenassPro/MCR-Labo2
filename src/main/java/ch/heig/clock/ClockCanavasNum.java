package ch.heig.clock;

import ch.heig.observer.ClockObservable;

import java.awt.*;

public class ClockCanavasNum extends AbstractClockCanvas {

    ClockCanavasNum(ClockObservable observable) {
        super(observable);
    }

    public String getTimeText(){
        String s ="";
        s+=(p_h>9?"":"0")+p_h;
        s+=(p_m>9?":":":0")+p_m;
        s+=(p_s>9?":":":0")+p_s;
        return s;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.black);
        drawTextCenter(g,size/2,size/2, getClockName() +" : "+getTimeText(),20,Font.BOLD);
    }
}
