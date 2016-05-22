package ru.tustrip.portal.controller.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.tustrip.portal.model.Tour;
import ru.tustrip.portal.service.TourService;

/**
 * Created by antonorlov on 20/05/16.
 */
@Controller
public class TourCardController {

    @Autowired
    private TourService tourService;

    @RequestMapping("/tour/{id}")
    public String getTour(@PathVariable Long id, Model model){
        Tour tour = tourService.getTour(id);
        model.addAttribute("tour", tour);

        return "client/tour_card";

    }
}
