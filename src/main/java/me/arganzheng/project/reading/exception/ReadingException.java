package me.arganzheng.project.reading.exception;

/**
 * 异常基类
 * 
 * @author arganzheng
 * @date 2013-12-19
 */
public class ReadingException extends RuntimeException {

    private static final long serialVersionUID = 2518673347989758182L;

    public ReadingException(String msg){
        super(msg);
    }

    public ReadingException(String msg, Throwable e){
        super(msg, e);
    }

}
