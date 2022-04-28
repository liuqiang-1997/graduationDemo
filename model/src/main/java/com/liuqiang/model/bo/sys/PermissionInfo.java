package com.liuqiang.model.bo.sys;

import lombok.Data;

/**
 * @author LiuQiang
 * @date 1:25 上午
 */
@Data
public class PermissionInfo {
    /**
     * id
     */
    private Integer id;
    /**
     * 权限ID
     */
    private Integer permissionId;

    private PermissionInfoBo permissionInfoBo;
}
