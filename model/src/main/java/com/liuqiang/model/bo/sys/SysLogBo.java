package com.liuqiang.model.bo.sys;

import lombok.Data;

import java.util.Date;

/**
 * 系统日志信息
 * @author LiuQiang
 */
@Data
public class SysLogBo {
    /**
     * 主键ID
     */
    private Long id;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户操作
     */
    private String operation;
    /**
     * 请求方法
     */
    private String method;
    /**
     * 请求参数
     */
    private String params;
    /**
     * IP地址
     */
    private String ipAddress;
    /**
     * 操作时间
     */
    private Date createTime;
}
