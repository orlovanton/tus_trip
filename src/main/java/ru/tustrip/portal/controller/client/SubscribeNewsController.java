package ru.tustrip.portal.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.tustrip.portal.controller.form.CouponForm;

/**
 * Created by antonorlov on 26/05/16.
 */

/**
 * Подписка на новости
 */
@Controller
public class SubscribeNewsController {

    @RequestMapping(value = "/subscibe_news/", method = RequestMethod.GET)
    private String couponGet(final Model model,
                             @PathVariable Long tourId,
                             CouponForm couponForm) {

        return "client/subscribe-news-modal";
    }
}
