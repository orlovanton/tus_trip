package ru.tustrip.portal.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.tustrip.portal.model.PortalUser;
import ru.tustrip.portal.model.UserRole;
import ru.tustrip.portal.repository.PortalUserRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by antonorlov on 22/05/16.
 */
@Service
public class RepositoryUserDetailsService implements UserDetailsService {

    @Autowired
    private PortalUserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Set<GrantedAuthority> authorities = new HashSet<>();

        PortalUser dbPortalUser = repository.findPortalUserByLogin(username);

        if (dbPortalUser == null) {
            throw new UsernameNotFoundException("No user found with username: " + username);
        }


        final UserDetails principal;
        if (UserRole.ROLE_AGENT.equals(dbPortalUser.getRole())) {
            authorities.add(new SimpleGrantedAuthority(UserRole.ROLE_AGENT.name()));
            //админ
            principal = new AgentUserDetails(dbPortalUser.getLogin(),
                    dbPortalUser.getPassword(), authorities, dbPortalUser.getAgentId());

        } else if (UserRole.ROLE_ADMIN.equals(dbPortalUser.getRole())) {
            authorities.add(new SimpleGrantedAuthority(UserRole.ROLE_ADMIN.name()));
            principal = new User(dbPortalUser.getLogin(), dbPortalUser.getPassword(), authorities);
            //агент
        } else {
            // просто клиент
            authorities.add(new SimpleGrantedAuthority(UserRole.ROLE_CLIENT.name()));
            principal = new User(dbPortalUser.getLogin(), dbPortalUser.getPassword(), authorities);
        }


        return principal;
    }
}
