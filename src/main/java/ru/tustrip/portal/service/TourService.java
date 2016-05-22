package ru.tustrip.portal.service;

import ru.tustrip.portal.model.Agent;
import ru.tustrip.portal.model.Tour;

import java.util.List;

/**
 * Created by antonorlov on 20/05/16.
 */
public interface TourService {

    Tour saveTour(final Tour tour);

    Tour getTour(final Long id);

    void deleteTour(final Tour tour);

    List<Tour> getAllTours();

    List<Tour> getAllPublishedTours();

    List<Tour> getAgentTours(final Agent agent);


}
