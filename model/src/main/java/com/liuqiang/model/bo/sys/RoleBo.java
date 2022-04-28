package com.liuqiang.model.bo.sys;

import lombok.Data;

import java.util.Date;

/**
 * 系统角色
 * @author LiuQiang
 */
@Data
public class RoleBo {
    /**
     *
     */
    private Integer id;
    /**
     * 角色ID
     */
    private Integer roleId;
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 角色状态 0-正常；1-禁用
     */
    private Integer status;
    /**
     * 角色备注
     */
    private String remark;
    private Date createTime;
    private Date updateTime;
}
