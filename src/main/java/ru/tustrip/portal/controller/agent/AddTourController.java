package ru.tustrip.portal.controller.agent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.tustrip.portal.controller.form.TourForm;
import ru.tustrip.portal.model.Agent;
import ru.tustrip.portal.model.Tour;
import ru.tustrip.portal.service.AgentService;
import ru.tustrip.portal.service.ImageService;
import ru.tustrip.portal.service.TourService;
import ru.tustrip.portal.service.security.AgentUserDetails;

import javax.validation.Valid;

/**
 * Created by antonorlov on 21/05/16.
 */
@Controller
public class AddTourController {

    private static final Logger logger = LoggerFactory
            .getLogger(AddTourController.class);

    @Autowired
    private ImageService imageService;

    @Autowired
    private TourService tourService;

    @Autowired
    private AgentService agentService;


    @RequestMapping(value = "/agent_interface/add_tour/", method = RequestMethod.GET)
    public String addTourGet(final Model model, TourForm tourForm) {
        logger.info("addTourGet called");
        return "agent/add_tour";
    }

    @RequestMapping(value = "/agent_interface/add_tour/", method = RequestMethod.POST)
    public String addTourPost(final Model model, @Valid TourForm tourForm,
                              BindingResult bindingResult, Authentication authentication) {
        logger.info("addTourPost called");
        final Agent agent;
        if (authentication.getPrincipal() instanceof AgentUserDetails) {
            AgentUserDetails userDetails = (AgentUserDetails) authentication.getPrincipal();

            final Long agentId = userDetails.getAgentId();
            agent = agentService.getAgent(agentId);
            if (agent == null) {
                logger.error("No agent forun in context");
                return "redirect:/error";
            }
        } else {
            logger.error("No agent forun in context");
            return "redirect:/error";
        }
        logger.info("tourForm submitted");
        logger.info(tourForm.toString());

        if (bindingResult.hasErrors()) {
            return "agent/add_tour";
        }


        Tour tour = transformIntoTour(tourForm, agent);

        Tour savedTour = tourService.saveTour(tour);
        //todo: next step
        logger.info("tour add forwarding to step 2");
        return "redirect:/agent_interface/add_tour_image/" + savedTour.getId();
    }

    @RequestMapping(value = "/agent_interface/add_tour_image/{tourId}", method = RequestMethod.GET)
    public String addTourImageGet(final Model model, @PathVariable Long tourId) {
        Tour tour = tourService.getTour(tourId);
        model.addAttribute("tour", tour);
        //todo: push created tour
        return "agent/add_tour_image";
    }


    @RequestMapping(value = "/agent_interface/add_tour_image/", method = RequestMethod.POST)
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                   @RequestParam("tourId") Long tourId,
                                   RedirectAttributes redirectAttrs) {

        final String fileName = file.getOriginalFilename();

        logger.info("Uploading file {}", fileName);
        if (!file.isEmpty()) {
//            File saveFile;
            try {
                byte[] bytes = file.getBytes();
                Tour tour = tourService.getTour(tourId);
                String imgRelPath = imageService.saveTourPromoImage(bytes, tour);

                tour.setMainImageUrl("/promo_image/" + imgRelPath);

                tourService.saveTour(tour);

            } catch (Exception e) {
                logger.error("Failed to upload " + fileName, e);
//                List<DocumentError> errors = new ArrayList<>();
//                errors.add(new DocumentError(DocumentError.Message.GENERAL_ERROR));
//                redirectAttrs.addAttribute("errors", errors);
//                return "redirect:/index";
            }
            logger.info("{} successfully uploaded", fileName);
            //todo: success page
            return "redirect:/agent_interface/";
        } else {
            logger.error("Failed to upload " + fileName + " because the file was empty.");
            return "redirect:/error";
        }
    }


    private static Tour transformIntoTour(final TourForm tourForm, final Agent agent) {
        Tour tour = new Tour();
        tour.setName(tourForm.getName());
        tour.setPrice(tourForm.getPrice());
        tour.setDescription(tourForm.getDescription());
        tour.setAgent(agent);
        //todo:
        String activity = tourForm.getActivity();

        return tour;
    }
}


