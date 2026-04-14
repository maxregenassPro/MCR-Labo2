package ch.heig.render.clock;

import ch.heig.observer.ConcreteClockObservable;

import java.awt.*;

public class ClockCanavasRom extends AbstractClockCanavasAna{

    ClockCanavasRom(ConcreteClockObservable cco) {
        super(cco);
    }

    @Override
    public String getSprite() {
        return "cadran_chiffres_romains.jpg";
    }

    @Override
    public Color[] getColor() {
        return new Color[]{Color.black,Color.gray,Color.yellow};
    }
}
