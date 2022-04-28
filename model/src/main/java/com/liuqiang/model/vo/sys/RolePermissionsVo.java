package com.liuqiang.model.vo.sys;

import lombok.Data;

import java.util.List;

/**
 * 系统角色权限
 * @author LiuQiang
 */
@Data
public class RolePermissionsVo {
    /**
     * id
     */
    private Integer id;
    /**
     * 角色ID
     */
    private Integer roleId;
    /**
     * 权限ID
     */
    private List<Integer> permissionId;
    /**
     * 状态 0-正常；1-禁用
     */
    private Integer status;
    /**
     * 备注
     */
    private String remark;
}
