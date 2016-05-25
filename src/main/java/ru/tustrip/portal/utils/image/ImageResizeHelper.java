package ru.tustrip.portal.utils.image;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Author:      oav <br>
 * Date:        28.01.16, 18:45 <br>
 * Company:     SofIT labs <br>
 * Revision:    $Id$ <br>
 * Description: <br>
 */
public class ImageResizeHelper {


    private static final Logger LOGGER = LoggerFactory.getLogger(ImageResizeHelper.class.getName());

    public static void resizeImage(final String origFilePath, final String destFilePath, PromoImageSize size) {
        try {
            BufferedImage img = ImageIO.read(new File(origFilePath));

            BufferedImage scaledImg = Scalr.resize(img,
                    Scalr.Method.ULTRA_QUALITY, Scalr.Mode.FIT_TO_WIDTH, size.getWidth());

            File destFile = new File(destFilePath);

            ImageIO.write(scaledImg, "jpg", destFile);

        } catch (IOException ex) {
            LOGGER.error("Error resizing image", ex);
        }

        System.out.println("Done resizing");
    }


}
