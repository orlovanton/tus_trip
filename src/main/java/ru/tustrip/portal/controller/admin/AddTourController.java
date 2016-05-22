package ru.tustrip.portal.controller.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import ru.tustrip.portal.controller.form.TourForm;
import ru.tustrip.portal.service.ImageService;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Iterator;

/**
 * Created by antonorlov on 21/05/16.
 */
@Controller
public class AddTourController {


    private static final Logger logger = LoggerFactory
            .getLogger(AddTourController.class);

    @Autowired
    private ImageService imageService;


    @RequestMapping(value = "/admin/add_tour/", method = RequestMethod.GET)
    private String addTourGet(final Model model, TourForm tourForm) {
        return "/admin/add_tour";
    }

    @RequestMapping(value = "/admin/add_tour/", method = RequestMethod.POST)
    private String addTourPost(final Model model, @Valid TourForm tourForm,
                               BindingResult bindingResult) {
        logger.info("tourForm submitted");
        logger.info(tourForm.toString());

        if (bindingResult.hasErrors()) {
            return "/admin/add_tour";
        }



        return "/admin/add_tour";
    }

    @RequestMapping(value = "/admin/add_tour_image/", method = RequestMethod.GET)
    private String addTourImageGet(final Model model) {
        return "/admin/add_tour";
    }

    @RequestMapping(value = "/admin/add_tour_image/", method = RequestMethod.POST)
    private String addTourImagePost(final Model model) {

        return "/admin/add_tour";
    }


    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public
    @ResponseBody
    String upload(MultipartHttpServletRequest request,
                  HttpServletResponse response) {

        //0. notice, we have used MultipartHttpServletRequest

        //1. get the files from the request object
        Iterator<String> itr = request.getFileNames();

        MultipartFile mpf = request.getFile(itr.next());
        System.out.println(mpf.getOriginalFilename() + " uploaded!");
//        try {
//
////            imageService.saveTourPromoImage(mpf.getBytes(), 0);
//
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }

        //2. send it back to the client as <img> that calls get method
        //we are using getTimeInMillis to avoid server cached image

//        return "<img src='http://localhost:8080/spring-mvc-file-upload/rest/cont/get/"+Calendar.getInstance().getTimeInMillis()+"' />";

        return "";
    }
}


