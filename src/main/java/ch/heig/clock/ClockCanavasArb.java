/**
 *   Autheur: Theo Bensaci, Maxime Regenass
 *   Date: 14:53 02.04.2026
 *   Description: Clock with arabic renderer
 */

package ch.heig.clock;

import java.awt.Color;

import ch.heig.observer.ClockObservable;

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
