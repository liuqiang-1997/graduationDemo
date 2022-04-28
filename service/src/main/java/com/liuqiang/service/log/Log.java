package com.liuqiang.service.log;

import java.lang.annotation.*;

/**
 * @author LiuQiang
 * @date 1:03 上午
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Log {
    String value() default "";

}




