package com.liuqiang.model.vo.user;

import lombok.Data;


/**
 * 用户修改信息参数
 * @author LiuQiang
 */
@Data
public class InfoVo {
    /**
     * id
     */
    private Integer id;
    /**
     * 用户账号
     */
    private String userNumber;
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 登录密码
     */
    private String password;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * qq号
     */
    private String qqNumber;
    /**
     * 微信号
     */
    private String vxNumber;
}
