package ru.tustrip.portal.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.tustrip.portal.service.AgentService;
import ru.tustrip.portal.service.TourService;

/**
 * Created by antonorlov on 21/05/16.
 */
@Controller
public class AdminMainController {
    @Autowired
    private AgentService agentService;

    @Autowired
    private TourService tourService;

    @RequestMapping("/admin/")
    private String index(final Model model) {

//        model.addAttribute("agent",agentService.getAllAgents());
        model.addAttribute("tours",tourService.getAllTours());
        return "/admin/admin";
    }
}
