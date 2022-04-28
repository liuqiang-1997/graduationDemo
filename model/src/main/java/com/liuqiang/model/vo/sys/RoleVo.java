package com.liuqiang.model.vo.sys;

import lombok.Data;

/**
 * 系统角色
 * @author LiuQiang
 */
@Data
public class RoleVo {
    /**
     * id
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
}
