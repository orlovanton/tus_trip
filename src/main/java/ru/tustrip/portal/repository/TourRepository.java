package ru.tustrip.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.tustrip.portal.model.Agent;
import ru.tustrip.portal.model.Tour;

import java.util.List;

/**
 * Created by antonorlov on 20/05/16.
 */
@Repository
public interface TourRepository  extends JpaRepository<Tour,Long>{

    List<Tour> findToursByAgent(final Agent agent);

    List<Tour> findToursByPublished(Boolean isPublished);

}
