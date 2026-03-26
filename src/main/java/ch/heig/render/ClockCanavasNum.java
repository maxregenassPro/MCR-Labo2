package ch.heig.render;

import ch.heig.observer.ConcreteClockObserver;

import java.awt.*;

public class ClockCanavasNum extends ClockCanvas{

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
        g.drawString(getTimeText(),size/2,size/2);
    }
}
