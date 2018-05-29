package com.einwin.devops.api.constant;

import com.einwin.framework.model.AppCode;

/**
 * 错误码（29000-29499）
 *
 * @author ：Joy
 * @createTime ：2018/03/15 15:46
 */
public enum DevopsCode implements AppCode {

    ARG_ERROR(29000, "参数错误，%s");

    private int code;
    private String message;
    private String format;

    private DevopsCode(int code, String message) {
        this.setCode(code);
        this.setMessage(message);
        this.format = message;
    }

    public DevopsCode format(Object... msgArgs) {
        this.message = String.format(this.format, msgArgs);
        return this;
    }

    @Override
    public String toString() {
        return Integer.toString(getCode());
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(int code) {
        this.code = code;
    }
}