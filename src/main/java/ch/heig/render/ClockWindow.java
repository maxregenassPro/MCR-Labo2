package ch.heig.render;

import javax.swing.*;

public class ClockWindow extends JFrame {



    ClockWindow(ClockCanvas canvas){
        add(canvas);


        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // pack and make it visible
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
