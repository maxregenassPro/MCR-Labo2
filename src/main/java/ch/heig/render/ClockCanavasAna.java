package ch.heig.render;

import ch.heig.observer.ConcreteClockObserver;
import ch.heig.ressource.TextureFactory;

import javax.swing.text.Position;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ClockCanavasAna extends ClockCanvas{

    private final String _sprite;

    public ClockCanavasAna(String sprite){
        _sprite=sprite;
    }

    public void paintClockLine(Graphics g,Color color,float t, float length,float width){
        int center_x=getWidth()/2;
        int center_y=getHeight()/2;

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
        BufferedImage img = TextureFactory.getTexture(_sprite,getWidth(),getHeight());

        ((Graphics2D) g).drawImage(img , 0, 0, null);

        // hours
        paintClockLine(g,Color.red,((p_h%12)/12f+p_m/1440f+p_s/86400f),getWidth()/4f,3);

        // minute
        paintClockLine(g,Color.yellow,(p_m/60f+p_s/3600f),getWidth()/3.25f,3);

        // sec
        paintClockLine(g,Color.blue,(p_s/60f),getWidth()/3.25f,2);
    }
}
