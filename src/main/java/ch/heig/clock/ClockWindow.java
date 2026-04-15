/**
 *   Autheur: Theo Bensaci, Maxime Regenass
 *   Date: 14:54 19.03.2026
 *   Description: Window with a single clock
 */

package ch.heig.clock;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class ClockWindow extends JFrame {

    ClockWindow(String title, AbstractClockCanvas canvas){
        add(canvas);

        setTitle(title);

        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                canvas.onClose();
            }
        });

        // pack and make it visible
        pack();
        setLocationRelativeTo(null);
        setVisible(true);


    }
}
