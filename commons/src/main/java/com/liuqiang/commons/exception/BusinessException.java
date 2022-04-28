package com.liuqiang.commons.exception;


import com.liuqiang.commons.utils.ResultBody;
import com.liuqiang.commons.exception.ErrorUtils;

/**
 * @author: LiuQiang
 * @description: 业务处理异常 业务逻辑异常
 */
public class BusinessException extends BaseException
{

    private ResultBody response = new ResultBody();

    public BusinessException(ResultBody response)
    {
        this.response = response;
    }

    public BusinessException(Integer errCode)
    {
        this.response.setCode(errCode);

        this.response.setMessage(ErrorUtils.getErrorDesc(errCode));
    }

    public BusinessException(Integer errCode, String errMsg)
    {
        super(errCode + ":" + errMsg);
        this.response.setCode(errCode);

        this.response.setMessage(errMsg);
    }

    public BusinessException(ResultBody response, Throwable cause)
    {
        super(response.getCode() + ":" + response.getMessage(), cause);
        this.response.setCode(response.getCode());
        this.response.setMessage(response.getMessage());

    }

    public BusinessException(Integer errCode, String errMsg, Throwable cause)
    {
        super(errCode + ":" + errMsg, cause);
        this.response.setCode(errCode);
        this.response.setMessage(errMsg);
    }

    public ResultBody getResponse()
    {
        return response;
    }

    public void setResponse(ResultBody response)
    {
        this.response = response;
    }
}
