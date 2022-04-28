package com.liuqiang.commons.exception;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.support.ResourceBundleMessageSource;
import java.util.Locale;


/**
 * @Description: 错误工具类，用于从错误码配置文件中获取错误提示信息等
 * @Date:Created in 2019/7/23 14:52.
 * @Modified By:
 */
@Slf4j
public class ErrorUtils
{
    private static ResourceBundleMessageSource resourceBundle = new ResourceBundleMessageSource();
    private static final String FILE_KEYWORKS = "error";


    /**
     * 获取错误码描述信息
     *
     * @param errCode 错误码
     * @return
     */
    public static String getErrorDesc(Integer errCode) {
        String errDesc = "";
        try {
            errDesc = resourceBundle.getMessage(Integer.toString(errCode), null, Locale.SIMPLIFIED_CHINESE);
        } catch (NoSuchMessageException ignored) {

        }
        return errDesc;
    }

    /**
     * 获取错误码描述信息
     *
     * @param errCode 错误码
     * @param args    错误描述信息中参数
     * @return
     */
    public static String getParseErrorDesc(String errCode, String[] args) {
        String errDesc = "";
        try {
            errDesc = resourceBundle.getMessage(errCode, args, Locale.SIMPLIFIED_CHINESE);
        } catch (NoSuchMessageException localNoSuchMessageException) {
        }
        return errDesc;
    }


}
