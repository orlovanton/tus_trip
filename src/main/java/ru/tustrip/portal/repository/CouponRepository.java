package ru.tustrip.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.tustrip.portal.model.Coupon;

import java.util.List;

/**
 * Created by antonorlov on 26/05/16.
 */
@Repository
public interface CouponRepository extends JpaRepository<Coupon,Long> {

    List<Coupon> findCouponByUserId(final Long userId);
    List<Coupon> findCouponByTourId(final Long tourId);
}
