package ch.heig.render;

import java.awt.*;

public class ClockCanavasNum extends ClockCanvas{

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.YELLOW);
        g.drawString("test",size/2,size/2);
    }
}
