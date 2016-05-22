package ru.tustrip.portal.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by antonorlov on 19/05/16.
 */
@Entity
public class Tour {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long Id;

    @Column
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    private Agent agent;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Activity> activityList;

    @ManyToOne(cascade = CascadeType.ALL)
    private Location location;

    //todo: timezone issue
    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date startDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date endDate;

    @Column
    private Double price;

    @Column
    private Double discount;

    @Column
    @Enumerated(value = EnumType.STRING)
    private Currency currency;

    @Column
    private Boolean isFlightIncluded;

    @Column
    private Boolean isPublished;

    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date publishDate;

    @Column(length = 200000)
    private String description;

    @Column
    private String mainImageUrl; //url of the main tour image

    //todo: maybe with description
//    private List<String> images;

    @Column
    private Integer orderNum; //sorting

    public Tour() {
    }

    public Long getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public List<Activity> getActivityList() {
        return activityList;
    }

    public void setActivityList(List<Activity> activityList) {
        this.activityList = activityList;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Boolean getIsFlightIncluded() {
        return isFlightIncluded;
    }

    public void setIsFlightIncluded(Boolean isFlightIncluded) {
        this.isFlightIncluded = isFlightIncluded;
    }

    public Boolean getIsPublished() {
        return isPublished;
    }

    public void setIsPublished(Boolean isPublished) {
        this.isPublished = isPublished;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMainImageUrl() {
        return mainImageUrl;
    }

    public void setMainImageUrl(String mainImageUrl) {
        this.mainImageUrl = mainImageUrl;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }
}
