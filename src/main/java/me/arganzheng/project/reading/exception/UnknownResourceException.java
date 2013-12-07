package me.arganzheng.project.reading.exception;

import me.arganzheng.project.reading.common.RestErrorCode;
import me.arganzheng.project.reading.common.RestException;

public class UnknownResourceException extends RestException {

    private static final long serialVersionUID = -3163077053140122195L;

    public UnknownResourceException(String msg){
        super(RestErrorCode.RESOURCE_NOT_FOUND, msg);
    }
}
