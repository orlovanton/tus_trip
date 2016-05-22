package ru.tustrip.portal.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tustrip.portal.UserAlreadyExistsException;
import ru.tustrip.portal.model.PortalUser;
import ru.tustrip.portal.repository.PortalUserRepository;

/**
 * Created by antonorlov on 22/05/16.
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory
            .getLogger(UserServiceImpl.class);

    @Autowired
    private PortalUserRepository userRepository;


    @Override
    public PortalUser getUser(String login) {
        return userRepository.findPortalUserByLogin(login);
    }

    @Override
    public PortalUser getUser(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public PortalUser saveUser(PortalUser user) throws UserAlreadyExistsException {
        //проверяем нет ли такого юзера
        PortalUser portalUserByLogin = userRepository.findPortalUserByLogin(user.getLogin());
        if (user.getId() == null && portalUserByLogin != null) {
            throw new UserAlreadyExistsException("User with login[" + user.getLogin() + "] already Exists");
        }
        return userRepository.save(user);

    }

    @Override
    public void blockUser(PortalUser user) {

    }

    @Override
    public void unblockUser(PortalUser user) {

    }
}
