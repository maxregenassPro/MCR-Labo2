package ch.heig.render;

import javax.swing.*;
import java.awt.*;
import java.time.Clock;

public abstract class ClockCanvas extends JPanel {

    public static final int SIZE = 300;
    public static final Color BACKGROUND_COLOR = new Color(0x16162a);

    public final int size;

    ClockCanvas(){
        this.size=SIZE;
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
}
