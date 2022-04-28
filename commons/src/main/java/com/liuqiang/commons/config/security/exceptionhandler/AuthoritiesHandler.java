package com.liuqiang.commons.config.security.exceptionhandler;

import com.alibaba.fastjson.JSON;
import com.liuqiang.commons.utils.ResultBody;
import com.liuqiang.commons.utils.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 认证异常
 * @author LiuQiang
 * @date 11:17 下午
 */
@Component
public class AuthoritiesHandler implements AuthenticationEntryPoint, AccessDeniedHandler {

    @Override
    public void commence(HttpServletRequest httpServletRequest,
                         HttpServletResponse httpServletResponse,
                         AuthenticationException e) throws IOException, ServletException {
        ResultBody<Object> resultBody = new ResultBody<>(HttpStatus.UNAUTHORIZED.value(), e.getMessage());
        WebUtils.render(httpServletResponse, JSON.toJSONString(resultBody));

    }

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        ResultBody<Object> resultBody = new ResultBody<>(HttpStatus.FORBIDDEN.value(), "对不起,您尚未开通此权限,请联系系统管理员");
        WebUtils.render(httpServletResponse, JSON.toJSONString(resultBody));
    }
}
