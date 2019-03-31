package com.scut.leaflet.exception;

/**
 * ass we can!
 * created by shing
 * 2019-03-29 18:35
 */
public class shopInfoException extends RuntimeException {
    private Integer code;

    public shopInfoException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }

    public shopInfoException(Integer code, String message) {
        super(message);
        this.code = code;
    }

}
