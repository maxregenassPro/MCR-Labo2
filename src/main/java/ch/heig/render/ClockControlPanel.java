package ch.heig.render;

import ch.heig.observer.ConcreteClockObservable;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ClockControlPanel {
    private final int nbChrono;
    public ClockControlPanel(int nbChrono) {
        this.nbChrono = nbChrono;
    }

    public void CreateView(){
        List<ConcreteClockObservable> allClocks = new ArrayList<>(nbChrono);


        if (nbChrono < 1 || nbChrono > 9){
            System.out.println("Invalid parameter");
            return;
        }

        JFrame frame = new JFrame("Panneau de contrôle");
        JPanel panel = new JPanel(new GridLayout(nbChrono, 7, 10, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        for (int i = 1; i <= nbChrono; i++) {
            JLabel label = new JLabel("Chrono #" + i);
            ConcreteClockObservable ccoa=new ConcreteClockObservable();
            allClocks.add(ccoa);

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
                ClockWindowFactory.createRom(ccoa);
            });

            JButton btnArabe = new JButton("Cadran arabe");
            btnArabe.addActionListener(e -> {
                ClockWindowFactory.createArb(ccoa);
            });

            JButton btnNum = new JButton("Numérique");
            btnNum.addActionListener(e -> {
                ClockWindowFactory.createNum(ccoa);

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
        JButton btnArabe = new JButton("Cadran arabe");
        JButton btnNum = new JButton("Numérique");



        panel.add(label);
        panel.add(btnRom);
        panel.add(btnArabe);
        panel.add(btnNum);

        frame.add(panel);
        frame.pack();
    }
}
