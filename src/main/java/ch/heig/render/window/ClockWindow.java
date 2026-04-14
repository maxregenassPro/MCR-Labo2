package ch.heig.render.window;

import ch.heig.render.clock.AbstractClockCanvas;

import javax.swing.*;

public class ClockWindow extends JFrame {

    public ClockWindow(String title, AbstractClockCanvas canvas){
        add(canvas);

        setTitle(title);

        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // pack and make it visible
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
