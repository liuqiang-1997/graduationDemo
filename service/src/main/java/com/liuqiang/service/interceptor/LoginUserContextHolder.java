package com.liuqiang.service.interceptor;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liuqiang.commons.utils.JwtUtils;
import com.liuqiang.model.entity.servicelogic.CheckInfo;
import com.liuqiang.model.entity.user.LoginInfo;
import com.liuqiang.service.service.sys.CheckService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;


/**
 * @author LiuQiang
 */
@Component
public class LoginUserContextHolder {

    public static LoginInfo getCurrentUser() {
        //从Header中获取用户信息
        ServletRequestAttributes servletRequestAttributes =
            (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();

        String userIdStr = "99999";
        String userNameStr = "测试";
        if (Objects.nonNull(servletRequestAttributes)) {
            HttpServletRequest request = servletRequestAttributes.getRequest();
            String token = request.getHeader("Authentication");
            userIdStr = StringUtils.defaultString(JwtUtils.getUserNumber(token), userIdStr);
            userNameStr = StringUtils.defaultString(JwtUtils.getUserName(token), userNameStr);
        }
        return LoginInfo.builder()
            .userNumber(userIdStr)
            .userName(userNameStr)
            .build();

    }
}
