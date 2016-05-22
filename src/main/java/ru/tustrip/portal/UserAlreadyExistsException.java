package ru.tustrip.portal;

/**
 * Created by antonorlov on 22/05/16.
 */
public class UserAlreadyExistsException extends Exception {
    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
