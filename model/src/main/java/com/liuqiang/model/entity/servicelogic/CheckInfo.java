package com.liuqiang.model.entity.servicelogic;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 系统用户信息
 * @author LiuQiang
 */
@Data
@TableName("pms_user")
public class CheckInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 登陆账号
     */
    @TableField("user_number")
    private String userNumber;
    /**
     * 用户名称
     */
    @TableField("user_name")
    private String userName;
    /**
     * 登陆密码
     */
    @TableField("password")
    private String password;
    /**
     * 用户角色
     */
    @TableField("role_id")
    private Long roleId;
    /**
     * 用户账号状态 0-正常；1-禁用
     */
    @TableField("status")
    private Integer status;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 修改时间
     */
    @TableField("update_time")
    private Date updateTime;

}
