package com.liuqiang.model.bo.sys;

import lombok.Data;

/**
 * @author LiuQiang
 * @date 1:09 上午
 */
@Data
public class PermissionInfoBo {

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
