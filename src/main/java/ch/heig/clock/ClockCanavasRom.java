package ch.heig.clock;

import ch.heig.observer.ClockObservable;

import java.awt.*;

public class ClockCanavasRom extends AbstractClockCanavasAna{

    ClockCanavasRom(ClockObservable observable) {
        super(observable);
    }

    @Override
    public String getSpritePath() {
        return "cadran_chiffres_romains.jpg";
    }

    @Override
    public Color[] getColors() {
        return new Color[]{Color.black,Color.gray,Color.yellow};
    }
}
