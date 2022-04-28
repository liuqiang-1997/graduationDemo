package com.liuqiang.model.vo.user;

import lombok.Data;

/**
 * 用户登陆参数
 * @author LiuQiang
 * @date 5:27 下午
 */
@Data
public class UserVo {
    /**
     * 用户账号
     */
    private String number;

    /**
     * 登录密码
     */
    private String password;

}
