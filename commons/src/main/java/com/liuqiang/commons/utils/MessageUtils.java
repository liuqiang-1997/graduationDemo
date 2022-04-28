package com.liuqiang.commons.utils;

import lombok.Data;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author LiuQiang
 * @date 4:38 下午
 */
@Data
public class MessageUtils implements InitializingBean {

    @Value("${cloopen.sms.accountsid}")
    private String accountsId;
    @Value("${cloopen.sms.authtoken}")
    private String authToken;
    @Value("${cloopen.sms.resturl}")
    private String restUrl;
    @Value("${cloopen.sms.port}")
    private String port;
    @Value("${cloopen.sms.appid}")
    private String appId;

    public static String ACCOUNT_SID;
    public static String AUTH_TOKEN;
    public static String REST_URL;
    public static String APP_ID;
    public static String PORT;
    @Override
    public void afterPropertiesSet() throws Exception {
        ACCOUNT_SID = accountsId;
        AUTH_TOKEN = authToken;
        REST_URL = restUrl;
        APP_ID = appId;
        PORT = port;
    }
}
