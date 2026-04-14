package ch.heig.clock;

import ch.heig.observer.ClockObservable;
import ch.heig.ressource.TextureFactory;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class AbstractClockCanavasAna extends AbstractClockCanvas {


    AbstractClockCanavasAna(ClockObservable observable) {
        super(observable);
    }

    public abstract String getSpritePath();


    public abstract Color[] getColors();


    public void paintClockLine(Graphics g,Color color,float t, float length,float width){
        int center_x=size/2;
        int center_y=size/2;

        double rad = Math.PI*(t*2-0.5);
        double newX = (Math.cos(rad));
        double newY = (Math.sin(rad));
        newX*=length;
        newY*=length;

        newX+=center_x;
        newY+=center_y;

        g.setColor(color);
        ((Graphics2D) g).setStroke(new BasicStroke(width));
        g.drawLine(center_x,center_y,(int) newX,(int) newY);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // get img
        BufferedImage img = TextureFactory.getTexture(getSpritePath(),size,size);

        ((Graphics2D) g).drawImage(img , 0, 0, null);

        Color[] col = getColors();

        // hours
        paintClockLine(g,col[0],((p_h%12)/12f+p_m/1440f+p_s/86400f),size/4f,3);

        // minute
        paintClockLine(g,col[1],(p_m/60f+p_s/3600f),size/3.25f,3);

        // sec
        paintClockLine(g,col[2],(p_s/60f),size/3.25f,2);

        g.setColor(Color.black);
        drawTextCenter(g,size/2,size/2+15, getClockName(),15,Font.PLAIN);
    }
}
