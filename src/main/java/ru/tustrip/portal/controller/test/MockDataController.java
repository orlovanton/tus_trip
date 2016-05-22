package ru.tustrip.portal.controller.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.tustrip.portal.mock.BaseMock;
import ru.tustrip.portal.model.Agent;
import ru.tustrip.portal.model.PortalUser;
import ru.tustrip.portal.model.Tour;
import ru.tustrip.portal.model.UserRole;
import ru.tustrip.portal.service.AgentService;
import ru.tustrip.portal.service.TourService;
import ru.tustrip.portal.service.UserService;

/**
 * Created by antonorlov on 22/05/16.
 */
@Controller
public class MockDataController {

    //todo: dev profile scope

    @Autowired
    private AgentService agentService;

    @Autowired
    private TourService tourService;

    @Autowired
    private UserService userService;

    @RequestMapping("test/initAdmin")
    @ResponseBody
    public String initAdmin(final Model model) throws Exception {

        if(userService.getUser("admin") == null) {
            PortalUser admin = new PortalUser("admin", "mouse", "orlov88@gmail.com", UserRole.ROLE_ADMIN);
            userService.saveUser(admin);

            return "Init Done [admin/mouse]";
        }else{
            return "Test admin already exists";
        }

    }

    @RequestMapping("test/initAgent")
    @ResponseBody
    public String initAgent(final Model model) throws Exception {
        if(userService.getUser("agent") == null){
            Agent agent = BaseMock.getAgent();
            Agent savedAgent = agentService.saveAgent(agent);

            PortalUser agentUser = new PortalUser("agent", "mouse", "orlov88@gmail.com", UserRole.ROLE_AGENT, savedAgent.getId());
            PortalUser portalUser = userService.saveUser(agentUser);

            Tour tour = BaseMock.getTour(0);
            Tour tour1 = BaseMock.getTour(1);

            tour.setAgent(savedAgent);
            tour1.setAgent(savedAgent);

            tourService.saveTour(tour);
            tourService.saveTour(tour1);

            return "Init Done [admin/mouse]";

        }else{
            return "test agent already exists [agent/mouse]";
        }
    }
}
