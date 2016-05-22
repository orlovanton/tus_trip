package ru.tustrip.portal.controller.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by antonorlov on 22/05/16.
 */
public class TourForm {

    @NotNull
    @Size(min=2, max=120)
    private String name;

    @NotNull
    private String activity;

//    private Date startDate;
//
//    private Date endDate;

    @NotNull
    private Double price;

    @NotNull
    //todo
//    @Size(min=100, max=2000)
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TourForm{");
        sb.append("name='").append(name).append('\'');
        sb.append(", activity='").append(activity).append('\'');
        sb.append(", price=").append(price);
        sb.append(", description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
