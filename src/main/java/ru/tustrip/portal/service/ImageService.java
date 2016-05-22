package ru.tustrip.portal.service;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.tustrip.portal.model.Tour;

import java.io.File;
import java.io.IOException;

/**
 * Created by antonorlov on 22/05/16.
 */
@Component
public class ImageService {


    private static final Logger logger = LoggerFactory
            .getLogger(ImageService.class);

    public static final String PROMO_IMG_PREFIX="promo_image";


    @Value("${image.upload.directory}")
    private String imageUploadDir;


    public String saveTourPromoImage(byte[] bytes, final Tour tour) {

        Long agentId = tour.getAgent().getId();
        Long tourId = tour.getId();

        File agentDir = new File(imageUploadDir + agentId + "/");
        createDirIfNotExists(agentDir);
        File tourDir = new File(agentDir.getPath() + tourId + "/");
        createDirIfNotExists(tourDir);

        String imageName = PROMO_IMG_PREFIX + agentId + "_" + tourId +".jpg";
        File imageFile = new File(tourDir + imageName);
        try {

            FileUtils.writeByteArrayToFile(imageFile, bytes);
        }catch (IOException ex){
//            todo
            logger.error("fail to save image", ex);
        }
        logger.info("image saved");
        return agentId + "/" + tourId +"/" + imageFile;
    }



    private static void createDirIfNotExists(File dir) {
        if (!dir.exists()) {
            if (dir.mkdir()) {
                System.out.println(dir.getName() + " created");
            }
        } else {
            System.out.println(dir.getName() + " already exists");
        }
    }


}
