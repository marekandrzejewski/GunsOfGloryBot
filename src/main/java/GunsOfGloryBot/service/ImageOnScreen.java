package GunsOfGloryBot.service;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageOnScreen {
    public static boolean isOnScreen(String fileNameWithPath) {
        BufferedImage bi = ImageReading.readImage(fileNameWithPath);
        BufferedImage image = null;
        try {
            image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {

                boolean invalid = false;
                int k = x, l = y;
                for (int a = 0; a < bi.getWidth(); a++) {
                    l = y;
                    for (int b = 0; b < bi.getHeight(); b++) {
                        if (bi.getRGB(a, b) != image.getRGB(k, l)) {
                            invalid = true;
                            break;
                        } else {
                            l++;
                        }
                    }
                    if (invalid) {
                        break;
                    } else {
                        k++;
                    }

                }

                if (!invalid) {
                    return true;
                }
            }
        }
        return false; //If no image is found
    }


}
