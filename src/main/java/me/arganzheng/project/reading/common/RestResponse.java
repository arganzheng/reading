package me.arganzheng.project.reading.common;

import org.apache.commons.lang.StringUtils;

/**
 * <pre>
 * REST 返回格式，这样可以利用@ResponseBody注解。
 * 这里使用errorCode和errorMessage，而不是Http BookStatus Code。不是纯粹的RESTful规范，不过个人觉得简单一下。
 * 
 * </pre>
 * 
 * @author arganzheng
 * @date 2013-12-07
 */
public class RestResponse<T> {

    public static final RestResponse SUCCESS       = new RestResponse();

    public static final RestResponse ERROR_UNKNOWN = new RestResponse(RestErrorCode.UNKONW_ERROR, "系统异常！");

    private int                      errorCode     = 0;
    private String                   errorMessage  = StringUtils.EMPTY;
    private T                        data;

    public RestResponse(int errorCode, String errorMessage){
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public RestResponse(){
    }

    public RestResponse(T data){
        this.data = data;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
