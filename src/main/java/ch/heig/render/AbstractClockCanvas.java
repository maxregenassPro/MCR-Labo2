package ch.heig.render;

import javax.swing.*;
import java.awt.*;

public abstract class AbstractClockCanvas extends JPanel {

    public static final int SIZE = 300;
    public static final Color BACKGROUND_COLOR = new Color(0xffffff);


    protected int p_h,p_m,p_s;


    public final int size;

    public String clockName = "";

    AbstractClockCanvas(){
        this.size=SIZE;
        this.p_h=0;
        this.p_m=0;
        this.p_s=0;
    }

    AbstractClockCanvas(int size){
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


    public void drawTextCenter(Graphics g, int x, int y,String text, int size, int style){
        g.setFont(new Font("Arial", style, size));

        // size/2 (center) - text.lenght()/2 (center du text) * size/2 (millieux d'une lettre)
        g.drawString(text,x-text.length()*size/4,y+15);
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
