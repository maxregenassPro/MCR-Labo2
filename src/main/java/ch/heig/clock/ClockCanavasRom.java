/**
 *   Autheur: Theo Bensaci, Maxime Regenass
 *   Date: 14:51 02.04.2026
 *   Description: Clock with romain renderer
 */

package ch.heig.clock;

import java.awt.Color;

import ch.heig.observer.ClockObservable;

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
