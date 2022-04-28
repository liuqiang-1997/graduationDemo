package com.liuqiang.commons.utils;

import lombok.Getter;

/**
 * @author LiuQiang
 * @date 10:34 下午
 */
@Getter
public enum ReturnCodeUtils {
    /**
     * 状态码
     */
    SUCCESS(200, "成功"),
    FAIL(201, "失败"),
    PARAM_ERROR(202, "参数不正确"),
    DATA_ERROR(204, "数据异常"),
    DATA_UPDATE_ERROR(205, "数据版本异常"),

    LOGIN_AUTH(208, "未登陆"),
    PERMISSION(209, "没有权限"),

    CODE_ERROR(210, "验证码错误"),
    LOGIN_MOBLE_ERROR(211, "账号不正确"),
    LOGIN_DISABLED_ERROR(212, "该用户已被禁用"),
    LOGIN_AURH(214, "需要登录"),
    LOGIN_ACL(215, "没有权限"),
    FETCH_ACCESSTOKEN_FAILD(218, "获取accessToken失败"),
    FETCH_USERINFO_ERROR(219, "获取用户信息失败"),
    LOGIN_ERROR( 23005, "登录失败"),;

    private Integer code;
    private String message;

    private ReturnCodeUtils(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
