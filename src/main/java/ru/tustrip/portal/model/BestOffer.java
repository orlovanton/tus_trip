package ru.tustrip.portal.model;

import javax.persistence.*;

/**
 * Created by antonorlov on 20/05/16.
 */
@Entity
public class BestOffer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne
    private Tour tour;

    @Column
    private Integer order;

    public BestOffer() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }
}
