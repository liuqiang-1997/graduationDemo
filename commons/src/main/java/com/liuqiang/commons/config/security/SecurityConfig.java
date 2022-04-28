package com.liuqiang.commons.config.security;


import com.liuqiang.commons.filter.JwtTokenFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;

/**
 * Security配置类
 * @author LiuQiang
 * @date 11:56 下午
 */
@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private JwtTokenFilter jwtTokenFilter;

    @Resource
    private AuthenticationEntryPoint authenticationEntryPoint;

    @Resource
    private AccessDeniedHandler accessDeniedHandler;


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.
//                // 关闭session
//                sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
//                // 除user/login接口外所有接口都需要认证
//                .authorizeRequests().antMatchers("/account/login", "/swagger-ui.html",
//                "/swagger-ui/*",
//                "/swagger-resources/**",
//                "/v2/api-docs",
//                "/v3/api-docs",
//                "/webjars/**").anonymous().anyRequest().authenticated().and()
//
//                // 关闭csrf
                csrf().disable();
        // 添加过滤器
        http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);

        // 配置认证与授权异常处理
        http.exceptionHandling().authenticationEntryPoint(authenticationEntryPoint)
                   .accessDeniedHandler(accessDeniedHandler);

        // 跨域
        http.cors();

    }

    /**
     * 创建密码解析
     * @return 加密密码
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
