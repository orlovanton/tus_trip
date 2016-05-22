package ru.tustrip.portal.service;

import org.springframework.stereotype.Service;
import ru.tustrip.portal.mock.BaseMock;
import ru.tustrip.portal.model.Tour;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by antonorlov on 20/05/16.
 */
@Service
public class TourServiceImpl implements TourService {

    @Override
    public void saveTour(Tour tour) {

    }

    @Override
    public Tour getTour(Integer id) {
        return BaseMock.getTour();
    }

    @Override
    public void deleteTour(Tour tour) {

    }

    @Override
    public List<Tour> getAllTours() {

        List<Tour> tours = new ArrayList<>();
        tours.add(BaseMock.getTour());
        tours.add(BaseMock.getTour());
        return tours;
    }
}
