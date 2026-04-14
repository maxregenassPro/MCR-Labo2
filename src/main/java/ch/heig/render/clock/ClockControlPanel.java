package ch.heig.render.clock;

import ch.heig.observer.ConcreteClockObservable;
import ch.heig.render.window.ClockWindow;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ClockControlPanel extends JFrame {
    private final List<ConcreteClockObservable> _clocks=new ArrayList<>();
    private final List<ClockWindow> _clockWindows=new ArrayList<>();

    public ClockControlPanel(int nClocks){
        if(nClocks<0 || nClocks>9)throw new IllegalArgumentException();

        // create window
        JPanel panel = new JPanel(new GridLayout(nClocks+1, 7, 10, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        for (int i = 1; i <= nClocks; i++) {
            String name = "Chrono #" + i;
            JLabel label = new JLabel(name);
            ConcreteClockObservable ccoa=new ConcreteClockObservable(name);

            _clocks.add(ccoa);

            JButton btnStart = new JButton("Démarrer");
            btnStart.addActionListener(e -> {
                ccoa.Run();
            });

            JButton btnStop = new JButton("Arrêter");
            btnStop.addActionListener(e -> {
                ccoa.Stop();
            });

            JButton btnReset = new JButton("Réinitialiser");
            btnReset.addActionListener(e -> {
                ccoa.Clear();
            });

            JButton btnRomain = new JButton("Cadran romain");
            btnRomain.addActionListener(e -> {
                ClockFactory.createRom(ccoa,name);
            });

            JButton btnArabe = new JButton("Cadran arabe");
            btnArabe.addActionListener(e -> {
                ClockFactory.createArb(ccoa,name);
            });

            JButton btnNum = new JButton("Numérique");
            btnNum.addActionListener(e -> {
                ClockFactory.createNum(ccoa,name);

            });


            panel.add(label);
            panel.add(btnStart);
            panel.add(btnStop);
            panel.add(btnReset);
            panel.add(btnRomain);
            panel.add(btnArabe);
            panel.add(btnNum);

        }

        JLabel label = new JLabel("Tout les chronos");
        JButton btnRom = new JButton("Cadran romain");
        btnRom.addActionListener(e -> {
            System.out.println("test");
            System.out.println(_clocks.size() + " | "+nClocks);
            ClockFactory.createAllRom(_clocks.toArray(new ConcreteClockObservable[0]),"Cadran romain");
        });
        JButton btnArabe = new JButton("Cadran arabe");
        btnArabe.addActionListener(e -> {
            ClockFactory.createAllArb(_clocks.toArray(new ConcreteClockObservable[0]),"Cadran arabe");
        });
        JButton btnNum = new JButton("Numérique");
        btnNum.addActionListener(e -> {
            ClockFactory.createAllNum(_clocks.toArray(new ConcreteClockObservable[0]),"Numérique");
        });




        panel.add(label);
        panel.add(btnRom);
        panel.add(btnArabe);
        panel.add(btnNum);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        add(panel);
        pack();
    }


}
