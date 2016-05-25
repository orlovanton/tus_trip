package ru.tustrip.portal.service;

import ru.tustrip.portal.model.Coupon;
import ru.tustrip.portal.model.PortalUser;
import ru.tustrip.portal.model.Tour;

import java.util.List;

/**
 * Created by antonorlov on 26/05/16.
 */
public interface CouponService {

    List<Coupon> getCoupons(final PortalUser user);

    List<Coupon> getCoupons(final Tour tour);

    Coupon getCoupon(final Long couponId);

    Coupon saveCoupon(final Coupon coupon);

}
