package ru.tustrip.portal.service;

import ru.tustrip.portal.model.Tour;

import java.util.List;

/**
 * Created by antonorlov on 20/05/16.
 */
public interface TourService {

    void saveTour(final Tour tour);

    Tour getTour(final Integer id);

    void deleteTour(final Tour tour);

    List<Tour> getAllTours();
}
