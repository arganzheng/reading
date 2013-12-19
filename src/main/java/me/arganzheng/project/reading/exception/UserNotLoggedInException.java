package me.arganzheng.project.reading.exception;

public class UserNotLoggedInException extends ReadingException {

    private static final long serialVersionUID = 3802813786119496861L;

    public UserNotLoggedInException(String msg){
        super(msg);
    }

}
