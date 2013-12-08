package me.arganzheng.project.reading.exception;

public class AppException extends RuntimeException{
	
	public AppException(String msg){
		super(msg);
	}
	
	public AppException(String msg, Throwable e){
		super(msg, e);
	}
	
}
