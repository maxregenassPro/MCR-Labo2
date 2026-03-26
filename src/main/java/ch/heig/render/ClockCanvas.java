package ch.heig.render;

import ch.heig.observer.ConcreteClockObserver;

import javax.swing.*;
import java.awt.*;
import java.time.Clock;

public abstract class ClockCanvas extends JPanel {

    public static final int SIZE = 300;
    public static final Color BACKGROUND_COLOR = new Color(0xffffff);


    protected int p_h,p_m,p_s;


    public final int size;

    ClockCanvas(){
        this.size=SIZE;
        this.p_h=0;
        this.p_m=0;
        this.p_s=0;
    }

    ClockCanvas(int size){
        this.size=size;
    }



    @Override
    public Dimension getPreferredSize() {
        return new Dimension(size, size);
    }

    @Override
    public Dimension getMinimumSize() {
        return getPreferredSize();
    }

    @Override
    public Dimension getMaximumSize() {
        return getPreferredSize();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // draw background

        g.setColor(BACKGROUND_COLOR);
        g.fillRect(0,0,size,size);
    }


    public void setTime(int h, int m, int s){
        this.p_h=h%24;
        this.p_m=m%60;
        this.p_s=s%60;
        this.repaint();
    }
}
