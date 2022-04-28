package com.liuqiang.commons.filter;

import com.google.common.base.Strings;
import com.liuqiang.commons.config.redis.RedisCache;

import com.liuqiang.commons.config.security.LoginUserDetails;
import com.liuqiang.commons.utils.JwtUtils;
import com.liuqiang.model.entity.servicelogic.CheckInfo;

import io.jsonwebtoken.Claims;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * @author LiuQiang
 * @date 2:58 下午
 */
@Component
public class JwtTokenFilter extends OncePerRequestFilter {

    @Autowired
    private RedisCache redisCache;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String userId;
        // 获取并解析请求中的token
        String token = httpServletRequest.getHeader("Authentication");
        if (StringUtils.isEmpty(token)){ filterChain.doFilter(httpServletRequest,httpServletResponse);
            return;
        }
        try {
            Claims claims = JwtUtils.paresJwt(token);
            userId = claims.get("number", String.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("token错误！");
        }

        // redis中获取用户信息
        String key = "user:" + userId;
        Object cacheObject = redisCache.getCacheObject(key);
        if (cacheObject == null) {
            throw new RuntimeException("用户未登录！！！");
        }

        LoginUserDetails userDetails =(LoginUserDetails) cacheObject;
        CheckInfo checkInfo = userDetails.getUser();

        // 存入SecurityContextHolder
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(checkInfo,
                null,userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        // 放行
        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }
}
