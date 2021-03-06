package ru.tustrip.portal.model;

import javax.annotation.Nullable;
import javax.persistence.*;

/**
 * Created by antonorlov on 22/05/16.
 */
@Entity
public class PortalUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false, unique = true)
    private String login;

    @Column
    @Nullable
    private String name;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private UserRole role;

    @Column
    private Long agentId;

    @Column
    private boolean blocked = false;


    //todo: additional info
//    private String name;
//    private String surname;
//    private String email;
//    private String vkId;
//    private Integer tourId;


    public PortalUser() {
    }

    public PortalUser(String login, String password, String email, UserRole role) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public PortalUser(String login, String password, String email, UserRole role, Long agentId) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.role = role;
        this.agentId = agentId;
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getAgentId() {
        return agentId;
    }

    public void setAgentId(Long agentId) {
        this.agentId = agentId;
    }

    @Nullable
    public String getName() {
        return name;
    }

    public void setName(@Nullable String name) {
        this.name = name;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }
}
