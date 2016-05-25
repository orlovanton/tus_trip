package ru.tustrip.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.tustrip.portal.model.PortalUser;

/**
 * Created by antonorlov on 22/05/16.
 */
@Repository
public interface PortalUserRepository extends JpaRepository<PortalUser,Long> {

    PortalUser findPortalUserByLogin(final String name);

    PortalUser findPortalUserByEmail(final String email);
}
