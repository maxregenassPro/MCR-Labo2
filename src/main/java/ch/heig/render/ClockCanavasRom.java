package ch.heig.render;

import java.awt.*;

public class ClockCanavasRom extends AbstractClockCanavasAna{

    @Override
    public String getSprite() {
        return "cadran_chiffres_romains.jpg";
    }

    @Override
    public Color[] getColor() {
        return new Color[]{Color.black,Color.gray,Color.yellow};
    }
}
