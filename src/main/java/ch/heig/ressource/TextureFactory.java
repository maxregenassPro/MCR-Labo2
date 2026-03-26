// use to manage textures


package ch.heig.ressource;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.Map;

public class TextureFactory {
    private static Map<String,BufferedImage> _map=new HashMap<>();


    public static void loadTexture(String path){
        URL url = TextureFactory.class.getClassLoader().getResource(path);
        if(url==null){
            System.out.println("honnono");
            return;
        }
        BufferedImage img;
        try {
            img = ImageIO.read(url);
        } catch (IOException e) {
            System.out.println("ho hsishis");
            return;
        }
        _map.put(path,img);
    }

    public static BufferedImage getTexture(String path, int width, int height){
        BufferedImage img = _map.get(path);
        if(img==null){
            // load try to load the texture
            loadTexture(path);
        }
        BufferedImage resizedImage = new BufferedImage(
                width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImage.createGraphics();
        g2.drawImage(img, 0, 0, width, height, null);

        g2.dispose();
        return resizedImage;
    }

}
