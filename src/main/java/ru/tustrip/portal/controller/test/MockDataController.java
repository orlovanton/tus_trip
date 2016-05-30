package ru.tustrip.portal.controller.test;

import org.apache.commons.io.IOUtils;
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
import ru.tustrip.portal.service.ImageService;
import ru.tustrip.portal.service.TourService;
import ru.tustrip.portal.service.UserService;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

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

    @Autowired
    private ImageService imageService;

    @RequestMapping("test/initAdmin")
    @ResponseBody
    public String initAdmin(final Model model) throws Exception {

        if (userService.getUser("admin") == null) {
            PortalUser admin = new PortalUser("admin", "mouse", "orlov88@gmail.com", UserRole.ROLE_ADMIN);
            userService.saveUser(admin);

            return "Init Done [admin/mouse]";
        } else {
            return "Test admin already exists";
        }

    }

    @RequestMapping("test/initAgent")
    @ResponseBody
    public String initAgent(final Model model) throws Exception {
        PortalUser agentUser = userService.getUser("agent");
        Agent savedAgent;
        if (agentUser == null) {
            Agent agent = BaseMock.getAgent();
            savedAgent  = agentService.saveAgent(agent);
            agentUser = new PortalUser("agent", "mouse", "mouse-rpg@gmail.com", UserRole.ROLE_AGENT, savedAgent.getId());
            userService.saveUser(agentUser);
        }else{
            savedAgent = agentService.getAgent(agentUser.getAgentId());
        }

        Tour tour = BaseMock.getTour(0);
        Tour tour1 = BaseMock.getTour(1);


        tour.setAgent(savedAgent);
        tour1.setAgent(savedAgent);

        Tour tourSaved = tourService.saveTour(tour);
        Tour tour1Saved = tourService.saveTour(tour1);

        ClassLoader classLoader = getClass().getClassLoader();
        File f = new File(classLoader.getResource(tourSaved.getMainImageUrl()).getFile());
        InputStream inputStream = new FileInputStream(f);
        byte[] bytes = IOUtils.toByteArray(inputStream);
        String imgRelPath = imageService.saveTourPromoImage(bytes, tourSaved);
        tourSaved.setMainImageUrl("/promo_image/" + imgRelPath);
        tourService.saveTour(tourSaved);

        File f1 = new File(classLoader.getResource(tour1Saved.getMainImageUrl()).getFile());
        inputStream = new FileInputStream(f1);
        bytes = IOUtils.toByteArray(inputStream);
        imgRelPath = imageService.saveTourPromoImage(bytes, tour);
        tour1Saved.setMainImageUrl("/promo_image/" + imgRelPath);
        tourService.saveTour(tour1Saved);


        return "Init Done [admin/mouse]";

//        }else{
//            return "test agent already exists [agent/mouse]";
//        }
    }
}
