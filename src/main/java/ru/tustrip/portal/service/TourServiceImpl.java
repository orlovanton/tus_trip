package ru.tustrip.portal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tustrip.portal.model.Agent;
import ru.tustrip.portal.model.Tour;
import ru.tustrip.portal.repository.TourRepository;

import java.util.List;

/**
 * Created by antonorlov on 20/05/16.
 */
@Service
public class TourServiceImpl implements TourService {

    @Autowired
    private TourRepository repository;

    @Override
    public Tour saveTour(Tour tour) {
        return repository.save(tour);
    }

    @Override
    public Tour getTour(Long id) {
        return repository.findOne(id);
    }

    @Override
    public void deleteTour(Tour tour) {
        //todo
        throw new UnsupportedOperationException("not impl");
    }

    @Override
    public List<Tour> getAllTours() {
        return  repository.findAll();
    }

    @Override
    public List<Tour> getAllPublishedTours() {
        return repository.findToursByPublished(true);
    }

    @Override
    public List<Tour> getAgentTours(Agent agent) {
        return repository.findToursByAgent(agent);
    }
}
