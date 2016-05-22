package ru.tustrip.portal.controller.frontend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.tustrip.portal.model.Tour;
import ru.tustrip.portal.service.TourService;

import java.util.List;

/**
 * Created by antonorlov on 20/05/16.
 */
@Controller
public class MainPageController {

    @Autowired
    private TourService tourService;

    @RequestMapping("/")
    private String index(final Model model){

        List<Tour> tours = tourService.getAllTours();

        model.addAttribute("tours", tours);
        return "index";
    }
}
