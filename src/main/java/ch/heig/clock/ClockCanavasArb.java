package ch.heig.clock;

import ch.heig.observer.ClockObservable;

import java.awt.*;

public class ClockCanavasArb extends AbstractClockCanavasAna{
    ClockCanavasArb(ClockObservable observable) {
        super(observable);
    }

    @Override
    public String getSpritePath() {
        return "cadran_chiffres_arabes.jpg";
    }

    @Override
    public Color[] getColors() {
        return new Color[]{Color.black,Color.blue,Color.red};
    }
}
