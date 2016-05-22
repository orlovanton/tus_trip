package ru.tustrip.portal.controller.agent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.tustrip.portal.model.Agent;
import ru.tustrip.portal.model.Tour;
import ru.tustrip.portal.service.AgentService;
import ru.tustrip.portal.service.TourService;
import ru.tustrip.portal.service.security.AgentUserDetails;

import java.util.List;

/**
 * Created by antonorlov on 22/05/16.
 */
@Controller
public class AgentMainPageController {

    private static final Logger logger = LoggerFactory
            .getLogger(AgentMainPageController.class);
    @Autowired
    private AgentService agentService;

    @Autowired
    private TourService tourService;

    @RequestMapping("agent_interface/")
    public String mainAgentPage(final Model model, Authentication authentication) {

        if (authentication.getPrincipal() instanceof AgentUserDetails) {
            AgentUserDetails userDetails = (AgentUserDetails) authentication.getPrincipal();

            Long agentId = userDetails.getAgentId();
            Agent agent = agentService.getAgent(agentId);
            if(agent == null){
                logger.error("Agent with id["+ agentId + "] not found");
                return "error";
            }
            List<Tour> agentTours = tourService.getAgentTours(agent);

            model.addAttribute("tours", agentTours);
            return "agent/agent_main";

        } else {
            logger.error("User [" + authentication.getName() + "] is not agent");
            return "error";
        }

    }
}
