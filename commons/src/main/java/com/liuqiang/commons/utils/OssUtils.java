package com.liuqiang.commons.utils;

import lombok.Data;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author LiuQiang
 * @date 10:39 上午
 */
@Component
@Data
public class OssUtils implements InitializingBean {

    @Value("${aliyun.oss.endpoint}")
    private String endPoint ;
    @Value("${aliyun.oss.accessKeyId}")
    private String accessKeyId;
    @Value("${aliyun.oss.secret}")
    private String secret;
    @Value("${aliyun.oss.bucket}")
    private String bucket;

    public static String ENDPOINT;
    public static String ACCESS_KEY_ID;
    public static String SECRET;
    public static String BUCKET;
    @Override
    public void afterPropertiesSet() throws Exception {
        ENDPOINT = endPoint;
        ACCESS_KEY_ID = accessKeyId;
        SECRET = secret;
        BUCKET = bucket;
    }
}
