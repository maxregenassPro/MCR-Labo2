package ch.heig.render.window;

import ch.heig.render.clock.AbstractClockCanvas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class MultipleClockWindow extends JFrame {

    public static final int SIZE=540;

    public final int _nClock;
    public final JPanel _panel;

    private boolean _vertical = false;

    public MultipleClockWindow(String title, AbstractClockCanvas[] canvas){
        setTitle(title);

        _nClock=canvas.length;

        _panel = new JPanel(new GridLayout(_nClock, 0, 10, 10));
        _panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

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

        setPreferredSize(new Dimension(SIZE,SIZE * _nClock));
        setMinimumSize(new Dimension(SIZE,SIZE));


    }
}
