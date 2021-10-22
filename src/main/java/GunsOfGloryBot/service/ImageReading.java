package GunsOfGloryBot.service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImageReading {
    public static BufferedImage readImage(String path) {
        BufferedImage image = null;

        try {
            image = ImageIO.read(new File(path));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return image;
    }
}
