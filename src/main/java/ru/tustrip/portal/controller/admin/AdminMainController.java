package ru.tustrip.portal.controller.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory
            .getLogger(AdminMainController.class);

    @Autowired
    private AgentService agentService;

    @Autowired
    private TourService tourService;

    @RequestMapping("/admin/")
    private String index(final Model model) {
        logger.info("Admin index called");
//        model.addAttribute("agent",agentService.getAllAgents());
        model.addAttribute("tours",tourService.getAllTours());
        model.addAttribute("agents", agentService.getAllAgents());
        logger.info("done");
        return "admin/admin";
    }
}
