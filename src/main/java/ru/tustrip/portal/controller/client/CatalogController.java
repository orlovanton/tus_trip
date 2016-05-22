package ru.tustrip.portal.controller.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.tustrip.portal.model.Tour;
import ru.tustrip.portal.service.TourService;

import java.util.List;

/**
 * Created by antonorlov on 21/05/16.
 */
@Controller
public class CatalogController {

    @Autowired
    private TourService tourService;

    @RequestMapping("/catalog/")
    private String catalog(final Model model) {

        List<Tour> allTours = tourService.getAllTours();

        model.addAttribute("tours", allTours);

        return "client/catalog";

    }
}
