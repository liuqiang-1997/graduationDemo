package com.liuqiang.model.bo.userinfo;



import lombok.Data;



/**
 * 用户联系信息
 * @author LiuQiang
 */
@Data
public class UserBo {
    /**
     * 用户账号
     */
    private String userNumber;
    /**
     * 用户名称
     */
    private String userName;
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
