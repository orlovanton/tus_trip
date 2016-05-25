package ru.tustrip.portal.controller.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.tustrip.portal.UserAlreadyExistsException;
import ru.tustrip.portal.controller.form.CouponForm;
import ru.tustrip.portal.model.Coupon;
import ru.tustrip.portal.model.PortalUser;
import ru.tustrip.portal.model.Tour;
import ru.tustrip.portal.model.UserRole;
import ru.tustrip.portal.service.CouponService;
import ru.tustrip.portal.service.EmailService;
import ru.tustrip.portal.service.TourService;
import ru.tustrip.portal.service.UserService;
import ru.tustrip.portal.utils.PortalRandomUtils;

import javax.validation.Valid;

/**
 * Created by antonorlov on 25/05/16.
 */
@Controller
public class GetCouponController {

    @Autowired
    private TourService tourService;
    @Autowired
    private UserService userService;

    @Autowired
    private CouponService couponService;

    @Autowired
    private EmailService emailService;

    @RequestMapping(value = "/get_coupon/{tourId}", method = RequestMethod.GET)
    private String couponGet(final Model model,
                             @PathVariable Long tourId,
                             CouponForm couponForm) {
        Tour tour = tourService.getTour(tourId);
        model.addAttribute("tour",tour);
        return "client/get_coupon";
    }

    @RequestMapping(value = "/get_coupon/", method = RequestMethod.POST)
    public String couponPost(final Model model, @Valid CouponForm couponForm,
                             BindingResult bindingResult) {

        String name = couponForm.getName();
        String email = couponForm.getEmail();

        //todo: check user exists
        Long tourId = couponForm.getTourId();

        Tour tour = tourService.getTour(tourId);
        if (tour == null) {
            return "redirect:/error";
        }


        //todo: register user
        //todo: send registration email

        //todo: wrong logic! separate page to login
        PortalUser dbUser = userService.getUserByEmail(email);
        if(dbUser == null){

            PortalUser portalUser = new PortalUser(email, PortalRandomUtils.generatePassword(), email, UserRole.ROLE_CLIENT);
            portalUser.setName(name);
            try {
                dbUser = userService.saveUser(portalUser);
            } catch (UserAlreadyExistsException ex) {
                return "redirect:/error";
            }

            if (dbUser == null) {
                return "redirect:/error";
            }

        }

        String couponNum = PortalRandomUtils.generateCouponNum();
        Coupon coupon = new Coupon(couponNum, tour.getId(), dbUser.getId());

        Coupon savedCoupon = couponService.saveCoupon(coupon);
        if (savedCoupon == null) {
            return "redirect:/error";
        }

        //todo: send coupon email
        emailService.sendCouponEmail(savedCoupon);

        return "redirect:/coupon_success/" + savedCoupon.getId();
    }


    @RequestMapping(value = "/coupon_success/{couponId}", method = RequestMethod.GET)
    private String couponSuccess(final Model model,
                                 @PathVariable Long couponId,
                                 CouponForm couponForm) {

        Coupon coupon = couponService.getCoupon(couponId);
        PortalUser user = userService.getUser(coupon.getUserId());
        Tour tour = tourService.getTour(coupon.getTourId());

        model.addAttribute("coupon",coupon);
        model.addAttribute("user",user);
        model.addAttribute("tour",tour);

        return "client/coupon_success";
    }
}
