/**
 *   Autheur: Theo Bensaci, Maxime Regenass
 *   Date: 11:43 13.04.2026
 *   Description: window with multiple clock
 */

package ch.heig.clock;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MultipleClockWindow extends JFrame {

    public static final int MIN_SIZE =540;

    private final int _nClock;
    private final JPanel _panel;

    private boolean _vertical = false;

    MultipleClockWindow(String title, AbstractClockCanvas[] canvas){
        setTitle(title);

        _nClock=canvas.length;

        _panel = new JPanel(new GridLayout(_nClock, 0, 10, 10));
        _panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                for(AbstractClockCanvas acc : canvas){
                    acc.onClose();
                }
            }
        });

        for(AbstractClockCanvas acc : canvas){
            _panel.add(acc);
        }


        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                boolean v =getContentPane().getSize().width>getContentPane().getSize().height;
                if(v!=_vertical){
                    if(v){
                        _panel.setLayout(new GridLayout(1, _nClock, 10, 10));
                    }
                    else{
                        _panel.setLayout(new GridLayout(_nClock, 1, 10, 10));
                    }
                    _vertical=v;
                }
                super.componentResized(e);
            }
        });

        JPanel cPanel = new JPanel();
        cPanel.setLayout(new GridBagLayout());
        cPanel.add(_panel);

        add(cPanel);


        // pack and make it visible
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        setPreferredSize(new Dimension(MIN_SIZE, MIN_SIZE * _nClock));
        setMinimumSize(new Dimension(MIN_SIZE, MIN_SIZE));


    }
}
