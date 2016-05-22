package ru.tustrip.portal.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Created by antonorlov on 23/05/16.
 */
@Controller
public class ImageController {

    @Value("${image.upload.directory}")
    private String imageUploadDir;

    @RequestMapping(value = "/promo_image/{agentId}/{tourId}/{imageName:.+}", method = RequestMethod.GET)
    protected HttpEntity<byte[]> processDefinitionDetailImage(@PathVariable String agentId,
                                                              @PathVariable String tourId,
                                                              @PathVariable String imageName,
                                                              HttpServletRequest request,
                                                              Model model) throws Exception {


//        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().processDefinitionKey(processDefinitionKey).latestVersion().singleResult();

        File file = new File(imageUploadDir + "/" + agentId + "/" + tourId + "/" + imageName);

        try {
            InputStream image = new FileInputStream(file);
//        InputStream image = new ProcessDefinitionImageStreamResourceBuilder().buildStreamResource(processDefinition, repositoryService);
            byte[] imageBytes = IOUtils.toByteArray(image);

            HttpHeaders headers = new HttpHeaders();
            //todo: diff formats
            headers.setContentType(MediaType.IMAGE_JPEG);
            headers.setContentLength(imageBytes.length);


            return new HttpEntity<byte[]>(imageBytes, headers);

        } catch (Exception ex) {
            throw new Exception("fail to getImage");
        }


    }
}
