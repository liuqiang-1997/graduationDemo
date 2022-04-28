package com.liuqiang.service.log;


import com.liuqiang.commons.utils.JwtUtils;
import com.liuqiang.model.entity.sys.SysLog;
import com.liuqiang.service.service.sys.SysLogService;
import io.jsonwebtoken.Claims;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.net.InetAddress;

import java.util.Objects;

/**
 * @author LiuQiang
 * @date 1:11 上午
 */
@Aspect
@Component
public class SysLogRecord {

    @Autowired
    private SysLogService sysLogService;

    @Pointcut("@annotation(com.liuqiang.service.log.Log)")
    public void pointcut() { }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();

        Object result = null;
        long beginTime = System.currentTimeMillis();
        try {
            // 执行方法
            result = point.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        // 执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;
        // 保存日志
        saveLog(point,time);
        System.err.println("point=="+point+";time"+time);
        return result;
    }

    private void saveLog(ProceedingJoinPoint joinPoint, long time) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        Log logAnnotation = method.getAnnotation(Log.class);
        if (logAnnotation != null) {
            // 注解上的描述
//            System.out.println(logAnnotation.value());
        }
        // 获取主机地址
        InetAddress addr = null;
        Claims claims = null;
        try {
            addr = InetAddress.getLocalHost();
            RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
            //从获取RequestAttributes中获取HttpServletRequest的信息
            assert requestAttributes != null;
            HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
            assert request != null;
            String token = request.getHeader("Authorization");
            claims = JwtUtils.paresJwt(token);

        } catch (Exception e) {
            e.printStackTrace();
        }
        // 请求的方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
//        System.err.println(className + "." + methodName + "()");
        // 请求的方法参数值
        Object[] args = joinPoint.getArgs();
        // 请求的方法参数名称
        LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
        String[] paramNames = u.getParameterNames(method);
        if (Objects.nonNull(args) && Objects.nonNull(paramNames) ) {
            StringBuilder params = new StringBuilder();
            for (int i = 0; i < args.length; i++) {
                if ("file".equals(paramNames[i])){
                    params.append(" ").append(paramNames[i]).append(":").append("file");
                    break;
                }
                params.append(" ").append(paramNames[i]).append(":").append(args[i]);

            }

            SysLog sysLog = new SysLog();
            if (Objects.nonNull(claims)){
                sysLog.setUserName(claims.getSubject());

            }
            assert logAnnotation != null;
            sysLog.setOperation(logAnnotation.value());
            sysLog.setMethod( methodName + "()");
            sysLog.setParams(params.toString());
            assert addr != null;
            sysLog.setIpAddress(addr.getHostAddress());
            // 保存系统日志
            sysLogService.save(sysLog);
        }
    }

}
