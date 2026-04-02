package ch.heig.render;

import java.awt.*;

public class ClockCanavasArb extends AbstractClockCanavasAna{
    @Override
    public String getSprite() {
        return "cadran_chiffres_arabes.jpg";
    }

    @Override
    public Color[] getColor() {
        return new Color[]{Color.black,Color.blue,Color.red};
    }
}
