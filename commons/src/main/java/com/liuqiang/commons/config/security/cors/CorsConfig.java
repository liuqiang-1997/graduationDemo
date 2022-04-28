package com.liuqiang.commons.config.security.cors;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 跨域配置
 * @author LiuQiang
 * @date 11:56 下午
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 设置跨域请求路径(/** 所有)
        registry.addMapping("/**")
                // 设置请求方式
        .allowedMethods("PUT","GET","POST","DELETE")
                // 设置Header属性
        .allowedHeaders("*")
                // 设置时间
        .maxAge(36000L)
                // 设置cookie
        .allowCredentials(true)
                // 域名
        .allowedOrigins("*");

    }
}
