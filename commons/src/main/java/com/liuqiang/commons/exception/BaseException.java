package com.liuqiang.commons.exception;

import java.io.Serializable;


/**
 * @date: 14:05
 */
public class BaseException extends RuntimeException implements Serializable
{

    public BaseException()
    {

    }

    public BaseException(String errorMsg)
    {
        super(errorMsg);
    }

    public BaseException(Throwable cause)
    {
        super(cause);
    }

    public BaseException(String errMsg, Throwable cause)
    {
        super(errMsg, cause);
    }
}
