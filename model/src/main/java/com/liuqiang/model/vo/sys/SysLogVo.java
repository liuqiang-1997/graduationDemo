package com.liuqiang.model.vo.sys;

import lombok.Data;

import java.util.Date;

/**
 * 系统日志
 * @author LiuQiang
 */
@Data
public class SysLogVo {
    /**
     * 用户名
     */
    private String userName;

    /**
     * IP地址
     */
    private String ipAddress;

    /**
     * 开始时间
     */
    private Date createTime;
    /**
     * 结束时间
     */
    private Date endTime;
}
