package ru.tustrip.portal.service.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * Created by antonorlov on 22/05/16.
 */
public class AgentUserDetails extends User {

    private Long agentId;

    public AgentUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities,
                            Long agentId) {
        super(username, password, authorities);
        this.agentId = agentId;
    }

    public Long getAgentId() {
        return agentId;
    }
}
