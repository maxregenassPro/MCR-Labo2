package ch.heig.render.clock;

import ch.heig.observer.ConcreteClockObservable;

import java.awt.*;

public class ClockCanavasArb extends AbstractClockCanavasAna{
    ClockCanavasArb(ConcreteClockObservable cco) {
        super(cco);
    }

    @Override
    public String getSprite() {
        return "cadran_chiffres_arabes.jpg";
    }

    @Override
    public Color[] getColor() {
        return new Color[]{Color.black,Color.blue,Color.red};
    }
}
