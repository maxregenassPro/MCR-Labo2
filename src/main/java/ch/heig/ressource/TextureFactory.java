/**
 *   Autheur: Theo Bensaci, Maxime Regenass
 *   Date: 14:53 19.03.2026
 *   Description: Fly weight factory use for texture
 */



package ch.heig.ressource;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

public class TextureFactory {
    private static Map<String,BufferedImage> _map=new HashMap<>();


    /**
     * Load a texture from io
     * @param path texture path
     */
    public static void loadTexture(String path) throws IOException {
        URL url = TextureFactory.class.getClassLoader().getResource(path);
        if(url==null){
            throw new IOException("no file found");
        }
        BufferedImage img;
        img = ImageIO.read(url);
        _map.put(path,img);
    }

    /**
     * Get a texture and scale it
     * @param path path
     * @param width texture width
     * @param height texture height
     * @return scaled texture
     */
    public static BufferedImage getTexture(String path, int width, int height){
        BufferedImage img = _map.get(path);
        if(img==null){
            // load try to load the texture
            try{
                loadTexture(path);
            } catch (Exception e) {
                System.out.print(e.getMessage());
                return null;
            }
        }
        BufferedImage resizedImage = new BufferedImage(
                width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImage.createGraphics();
        g2.drawImage(img, 0, 0, width, height, null);

        g2.dispose();
        return resizedImage;
    }

}
