package ru.tustrip.portal.controller.agent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.tustrip.portal.model.Agent;
import ru.tustrip.portal.model.Coupon;
import ru.tustrip.portal.model.Tour;
import ru.tustrip.portal.service.AgentService;
import ru.tustrip.portal.service.CouponService;
import ru.tustrip.portal.service.TourService;
import ru.tustrip.portal.service.UserService;
import ru.tustrip.portal.service.security.AgentUserDetails;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private CouponService couponService;

    @Autowired
    private UserService userService;

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
            Map<String,List<Coupon>> couponMap = new LinkedHashMap<>();

            for (Tour agentTour : agentTours) {
                List<Coupon> coupons = couponService.getCoupons(agentTour);
                couponMap.put(agentTour.getName(), coupons);
            }


            model.addAttribute("couponMap", couponMap);
            model.addAttribute("tours", agentTours);
            return "agent/agent_main";

        } else {
            logger.error("User [" + authentication.getName() + "] is not agent");
            return "error";
        }

    }
}
