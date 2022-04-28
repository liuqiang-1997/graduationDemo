package com.liuqiang.commons.exception;


import com.liuqiang.commons.utils.ResultBody;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;


/**
 * @description: 自定义断言
 */
public class BusinessAssert
{
    public static void createException(String errorCode, String... args)
    {
        String errorMsg = Arrays.toString(args);
        throw ExceptionUtils.businessException(errorCode, errorMsg);
    }

    /**
     * 如果统一响应为失败响应，直接将异常继续往上抛
     *
     * @param response
     * @return
     */
    public static void isTrue(ResultBody response)
    {
        if (!response.isSuccess())
        {
            createException(response.getCode().toString(), response.getMessage());
        }
    }

    /**
     * 如果表达式结果为false，则抛出异常
     *
     * @param expression 传入的表达式
     * @param errorCode  错误信息枚举对象
     */
    public static void isTrue(boolean expression, String errorCode)
    {
        if (!expression)
        {
            createException(errorCode);
        }
    }

    /**
     * 如果表达式结果为false，则抛出异常
     *
     * @param expression 传入的表达式
     * @param errorCode  错误信息枚举对象
     * @param args       消息参数
     */
    public static void isTrue(boolean expression, String errorCode, String... args)
    {
        if (!expression)
        {
            createException(errorCode, args);
        }
    }

    /**
     * 如果表达式结果为true，则抛出异常
     *
     * @param expression 传入的表达式
     * @param errorCode  错误信息枚举对象
     */
    public static void notTrue(boolean expression, String errorCode)
    {
        if (expression)
        {
            createException(errorCode);
        }
    }

    /**
     * 如果表达式结果为true，则抛出异常
     *
     * @param expression 传入的表达式
     * @param errorCode  错误信息枚举对象
     * @param args       消息参数
     */
    public static void notTrue(boolean expression, String errorCode, String... args)
    {
        if (expression)
        {
            createException(errorCode, args);
        }
    }

    /**
     * 如果对象不为空，则抛出异常
     *
     * @param object    要检查的对象
     * @param errorCode 错误信息枚举对象
     * @param args      消息参数
     */
    public static void isNull(Object object, String errorCode, String... args)
    {
        if (object != null)
        {
            createException(errorCode, args);
        }
    }

    /**
     * 如果对象不为空，则抛出异常
     *
     * @param object    要检查的对象
     * @param errorCode 错误信息枚举对象
     */
    public static void isNull(Object object, String errorCode)
    {
        if (object != null)
        {
            createException(errorCode);
        }
    }

    /**
     * 如果对象为空，则抛出异常
     *
     * @param object    要检查的对象
     * @param errorCode 错误信息枚举对象
     * @param args      消息参数
     */
    public static void notNull(Object object, String errorCode, String... args)
    {
        if (object == null)
        {
            createException(errorCode, args);
        }
    }

    /**
     * 如果对象为空，则抛出异常
     *
     * @param object    要检查的对象
     * @param errorCode 错误信息枚举对象
     */
    public static void notNull(Object object, String errorCode)
    {
        if (object == null)
        {
            createException(errorCode);
        }
    }

    /**
     * 如果字符串为空字符串，则抛出异常
     *
     * @param text      要判断的字符串
     * @param errorCode 错误信息枚举对象
     */
    public static void notEmpty(String text, String errorCode)
    {
        if (!StringUtils.hasLength(text))
        {
            createException(errorCode);
        }
    }

    /**
     * 如果字符串为空字符串，则抛出异常
     *
     * @param text      要判断的字符串
     * @param errorCode 错误信息枚举对象
     * @param args      消息参数
     */
    public static void notEmpty(String text, String errorCode, String... args)
    {
        if (!StringUtils.hasLength(text))
        {
            createException(errorCode, args);
        }
    }

    /**
     * 如果字符串为非空字符串，则抛出异常
     *
     * @param text      要判断的字符串
     * @param errorCode 错误信息枚举对象
     */
    public static void isEmpty(String text, String errorCode)
    {
        if (StringUtils.hasLength(text))
        {
            createException(errorCode);
        }
    }

    /**
     * 如果字符串为非空字符串，则抛出异常
     *
     * @param text      要判断的字符串
     * @param errorCode 错误信息枚举对象
     * @param args      消息参数
     */
    public static void isEmpty(String text, String errorCode, String... args)
    {
        if (StringUtils.hasLength(text))
        {
            createException(errorCode, args);
        }
    }

    /**
     * 如果字符串中包含子字符串，则抛出异常
     *
     * @param textToSearch
     * @param substring
     * @param errorCode
     */
    public static void doesNotContain(String textToSearch, String substring, String errorCode)
    {
        if (StringUtils.hasLength(textToSearch) && StringUtils.hasLength(substring)
            && textToSearch.indexOf(substring) != -1)
        {
            createException(errorCode);
        }
    }

    /**
     * 如果字符串中包含子字符串，则抛出异常
     *
     * @param textToSearch
     * @param substring
     * @param errorCode
     * @param args
     */
    public static void doesNotContain(String textToSearch, String substring, String errorCode, String... args)
    {
        if (StringUtils.hasLength(textToSearch) && StringUtils.hasLength(substring)
            && textToSearch.indexOf(substring) != -1)
        {
            createException(errorCode, args);
        }
    }

    /**
     * 如果数组为空，则抛出异常
     *
     * @param array
     * @param errorCode
     */
    public static void notEmpty(Object[] array, String errorCode)
    {
        if (ObjectUtils.isEmpty(array))
        {
            createException(errorCode);
        }
    }

    /**
     * 如果数组为空，则抛出异常
     *
     * @param array
     * @param errorCode
     * @param args
     */
    public static void notEmpty(Object[] array, String errorCode, String... args)
    {
        if (ObjectUtils.isEmpty(array))
        {
            createException(errorCode, args);
        }
    }

    /**
     * 如果对象数组中存在空对象，则抛出异常
     *
     * @param array
     * @param errorCode
     */
    public static void noNullElements(Object[] array, String errorCode)
    {
        if (array != null)
        {
            for (int i = 0; i < array.length; i++)
            {
                if (array[i] == null)
                {
                    createException(errorCode);
                }
            }
        }
    }

    /**
     * 如果对象数组中存在空对象，则抛出异常
     *
     * @param array
     * @param errorCode
     * @param args
     */
    public static void noNullElements(Object[] array, String errorCode, String... args)
    {
        if (array != null)
        {
            for (int i = 0; i < array.length; i++)
            {
                if (array[i] == null)
                {
                    createException(errorCode, args);
                }
            }
        }
    }

    /**
     * 如果集合为空，则抛出异常
     *
     * @param collection
     * @param errorCode
     */
    public static void notEmpty(Collection<?> collection, String errorCode)
    {
        if (CollectionUtils.isEmpty(collection))
        {
            createException(errorCode);
        }
    }

    /**
     * 如果集合为空，则抛出异常
     *
     * @param collection
     * @param errorCode
     * @param args
     */
    public static void notEmpty(Collection<?> collection, String errorCode, String... args)
    {
        if (CollectionUtils.isEmpty(collection))
        {
            createException(errorCode, args);
        }
    }

    /**
     * 如果集合不为空，则抛出异常
     *
     * @param collection
     * @param errorCode
     */
    public static void isEmpty(Collection<?> collection, String errorCode)
    {
        if (!CollectionUtils.isEmpty(collection))
        {
            createException(errorCode);
        }
    }

    /**
     * 如果集合不为空，则抛出异常
     *
     * @param collection
     * @param errorCode
     * @param args
     */
    public static void isEmpty(Collection<?> collection, String errorCode, String... args)
    {
        if (!CollectionUtils.isEmpty(collection))
        {
            createException(errorCode, args);
        }
    }

    /**
     * 如果map为空，则抛出异常
     *
     * @param map
     * @param errorCode
     */
    public static void notEmpty(Map<?, ?> map, String errorCode)
    {
        if (CollectionUtils.isEmpty(map))
        {
            createException(errorCode);
        }
    }

    /**
     * 如果map为空，则抛出异常
     *
     * @param map
     * @param errorCode
     * @param args
     */
    public static void notEmpty(Map<?, ?> map, String errorCode, String... args)
    {
        if (CollectionUtils.isEmpty(map))
        {
            createException(errorCode, args);
        }
    }

    /**
     * 如果对象不是指定class的实例，则抛出异常
     *
     * @param clazz
     * @param obj
     * @param errorCode
     */
    public static void isInstanceOf(Class<?> clazz, Object obj, String errorCode)
    {
        notNull(clazz, errorCode);
        if (!clazz.isInstance(obj))
        {
            createException(errorCode);
        }
    }

    /**
     * 如果对象不是指定class的实例，则抛出异常
     *
     * @param clazz
     * @param obj
     * @param errorCode
     * @param args
     */
    public static void isInstanceOf(Class<?> clazz, Object obj, String errorCode, String... args)
    {
        notNull(clazz, errorCode, args);
        if (!clazz.isInstance(obj))
        {
            createException(errorCode, args);
        }
    }

    /**
     * 如果不全是数字，则抛出异常
     *
     * @param text
     * @param errorCode
     */
    public static void isDigit(String text, String errorCode)
    {
        notEmpty(text, errorCode);
        String regDigit = "[0-9]*";
        if (!text.matches(regDigit))
        {
            createException(errorCode);
        }
    }
}
