package GunsOfGloryBot.service;


import java.awt.*;
import java.awt.image.BufferedImage;



public class ImageSearch {

    //imageLocation:
    //Gives you the middle coordinates of an image.
    //int[0] = X
    //int[1] = Y

    //isOnScreen:
    //true = the picture is on screen
    //false = the picture is not on screen

    public int[] imageLocation(String fileNameWithPath) {
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
                    int[] locs = new int[2];
                    locs[0] = k - (bi.getWidth() / 2);
                    locs[1] = l - (bi.getHeight() / 2);
                    return locs;
                }
            }
        }
        return null;
    }

}