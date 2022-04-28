package com.liuqiang.commons.exception;

import com.liuqiang.commons.utils.ResultBody;



/**
 * @author: yuantl01
 * @date: 2019/7/23 14:50
 * @description: 异常工具类
 */
public class ExceptionUtils
{
    /**
     * 业务处理异常
     *
     * @param errCode 异常码
     * @return
     */
    public static BusinessException businessException(Integer errCode) {
        return new BusinessException(createResponse(errCode));
    }

    /**
     * 业务处理异常
     *
     * @param errCode 自定义异常码
     * @param msg     自定义异常提示
     * @return
     */
    public static BusinessException businessException(String errCode, String msg) {
        return new BusinessException(createResponse(errCode, msg));
    }

    /**
     * 业务处理异常
     *
     * @param errCode 异常码
     * @param args    错误描述信息中的参数
     * @return
     */
    public static BusinessException businessException(String errCode, String... args) {
        return new BusinessException(createResponse(errCode, args));
    }


    private static ResultBody createResponse(Integer errCode) {
        return ResultBody.fail(errCode, getMessage(errCode));
    }

    private static ResultBody createResponse(String errCode, String msg) {
        return ResultBody.fail(errCode, msg);
    }

    private static ResultBody createResponse(String errCode, String[] args) {
        return ResultBody.fail(errCode, getMessage(errCode, args));
    }

    /**
     * 获取错误信息
     *
     * @param errCode 错误码
     * @return
     */
    private static String getMessage(Integer errCode) {
        return ErrorUtils.getErrorDesc(errCode);
    }

    /**
     * 获取错误信息
     *
     * @param errCode 错误码
     * @param args    错误描述信息中的参数
     * @return
     */
    private static String getMessage(String errCode, String[] args) {
        return ErrorUtils.getParseErrorDesc(errCode, args);
    }

}
