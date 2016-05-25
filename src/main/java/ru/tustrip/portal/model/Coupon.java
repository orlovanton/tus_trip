package ru.tustrip.portal.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by antonorlov on 21/05/16.
 */

@Entity
public class Coupon {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    private String code;

    @Column
    @NotNull
    private Long tourId;

    @Column
    @NotNull
    //todo: add foreign key
    private Long userId;

    public Coupon() {
    }

    public Coupon(String code, Long tourId, Long userId) {
        this.code = code;
        this.tourId = tourId;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getTourId() {
        return tourId;
    }

    public void setTourId(Long tourId) {
        this.tourId = tourId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
