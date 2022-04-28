package com.liuqiang.model.entity.sys;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统日志
 * @author LiuQiang
 */
@Data
@TableName("sys_log")
public class SysLog implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 用户名
     */
    @TableField("user_name")
    private String userName;
    /**
     * 用户操作
     */
    @TableField("operation")
    private String operation;
    /**
     * 请求方法
     */
    @TableField("method")
    private String method;
    /**
     * 请求参数
     */
    @TableField("params")
    private String params;
    /**
     * IP地址
     */
    @TableField("ip_address")
    private String ipAddress;
    /**
     * 操作时间
     */
    @TableField("create_time")
    private Date createTime;
}
