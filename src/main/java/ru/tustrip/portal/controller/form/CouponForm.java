package ru.tustrip.portal.controller.form;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by antonorlov on 26/05/16.
 */
public class CouponForm {

    @NotNull
    private Long tourId;
    /**
     * User name
     */
    @NotNull
    @Size(min=2, max=120)
    private String name;

    @NotNull
    @Email
    private String email;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getTourId() {
        return tourId;
    }

    public void setTourId(Long tourId) {
        this.tourId = tourId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CouponForm{");
        sb.append("tourId=").append(tourId);
        sb.append(", name='").append(name).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
