package com.liuqiang.model.entity.user;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统用户信息
 * @author LiuQiang
 * @date 11:18 下午
 */
@Data
@TableName("sys_user")
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 用户账号
     */
    @TableField("user_number")
    private String userNumber;
    /**
     * 用户名称
     */
    @TableField("user_name")
    private String userName;
    /**
     * 邮箱
     */
    @TableField("email")
    private String email;
    /**
     * 手机号
     */
    @TableField("mobile")
    private String mobile;
    /**
     * qq号
     */
    @TableField("qq_number")
    private String qqNumber;
    /**
     * 微信号
     */
    @TableField("vx_number")
    private String vxNumber;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 创建人
     */
    @TableField("create_user_id")
    private String createUserId;
}
