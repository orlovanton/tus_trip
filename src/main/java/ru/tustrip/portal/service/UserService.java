package ru.tustrip.portal.service;

import ru.tustrip.portal.UserAlreadyExistsException;
import ru.tustrip.portal.model.PortalUser;

/**
 * Created by antonorlov on 22/05/16.
 */
public interface UserService {

    PortalUser getUser(final String login);

    PortalUser getUser(final Long id);

    PortalUser saveUser(final PortalUser user) throws UserAlreadyExistsException;

    void blockUser(final PortalUser user);

    void unblockUser(final PortalUser user);
}
