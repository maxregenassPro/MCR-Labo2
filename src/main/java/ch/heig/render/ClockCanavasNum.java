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
        g.setFont(new Font("Arial", Font.BOLD, 60));
        String txt = getTimeText();

        // size/2 (center) - txt.lenght()/2 (center du text) * 60/2 (millieux d'une lettre) -> size/2 - txt.length() * 60/4 (15)
        g.drawString(txt,size/2-txt.length()*15,size/2+15);
    }
}
