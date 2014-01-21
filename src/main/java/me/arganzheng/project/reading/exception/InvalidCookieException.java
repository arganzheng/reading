package me.arganzheng.project.reading.exception;

/**
 * Exception thrown by a RememberMeServices implementation to indicate that a submitted cookie is of an invalid format
 * or has expired.
 * 
 * @author Luke Taylor
 */
public class InvalidCookieException extends ReadingException {

    private static final long serialVersionUID = -6212080697238132808L;

    public InvalidCookieException(String message){
        super(message);
    }
}
