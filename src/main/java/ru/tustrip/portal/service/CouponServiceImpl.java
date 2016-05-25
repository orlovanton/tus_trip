package ru.tustrip.portal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tustrip.portal.model.Coupon;
import ru.tustrip.portal.model.PortalUser;
import ru.tustrip.portal.model.Tour;
import ru.tustrip.portal.repository.CouponRepository;

import java.util.List;

/**
 * Created by antonorlov on 26/05/16.
 */
@Service
public class CouponServiceImpl implements CouponService {

    @Autowired
    private CouponRepository repository;

    @Override
    public List<Coupon> getCoupons(PortalUser user) {

        return repository.findCouponByUserId(user.getId());
    }

    @Override
    public List<Coupon> getCoupons(Tour tour) {
        return repository.findCouponByTourId(tour.getId());
    }

    @Override
    public Coupon getCoupon(final Long couponId) {
        return repository.findOne(couponId);
    }

    @Override
    public Coupon saveCoupon(final Coupon coupon) {
        Coupon save = repository.save(coupon);
        return save;
    }
}
