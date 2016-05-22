package ru.tustrip.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.tustrip.portal.model.BestOffer;

/**
 * Created by antonorlov on 20/05/16.
 */
@Repository
public interface BestOfferRepository extends JpaRepository<BestOffer,Integer> {
}
