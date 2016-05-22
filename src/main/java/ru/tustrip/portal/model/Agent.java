package ru.tustrip.portal.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by antonorlov on 19/05/16.
 */
@Entity
public class Agent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    private Location location;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Activity> activityList;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Contact> contacts;

    @Column
    private String contactPerson;

    @Column
    private Integer orderNum = 0;

    //todo: legal info


    public Agent() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Activity> getActivityList() {
        return activityList;
    }

    public void setActivityList(List<Activity> activityList) {
        this.activityList = activityList;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Agent{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", location=").append(location);
        sb.append(", activityList=").append(activityList);
        sb.append(", contacts=").append(contacts);
        sb.append(", contactPerson='").append(contactPerson).append('\'');
        sb.append(", orderNum=").append(orderNum);
        sb.append('}');
        return sb.toString();
    }
}
