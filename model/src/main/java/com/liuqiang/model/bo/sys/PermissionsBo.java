package com.liuqiang.model.bo.sys;

import lombok.Data;

/**
 * 系统权限
 * @author LiuQiang
 */
@Data
public class PermissionsBo {
    /**
     * id
     */
    private Integer id;
    /**
     * 权限ID
     */
    private Integer permissionId;
    /**
     * 权限名称
     */
    private String permissionName;
    /**
     * 权限路径
     */
    private String permissionPath;
    /**
     * 权限状态 0-正常；1-禁用
     */
    private Integer status;
    /**
     * 备注
     */
    private String remark;

}
