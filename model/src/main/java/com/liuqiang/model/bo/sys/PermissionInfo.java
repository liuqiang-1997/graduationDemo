package com.liuqiang.model.bo.sys;

import lombok.Data;

/**
 * @author LiuQiang
 * @date 1:25 ä¸å
 */
@Data
public class PermissionInfo {
    /**
     * id
     */
    private Integer id;
    /**
     * æéID
     */
    private Integer permissionId;

    private PermissionInfoBo permissionInfoBo;
}
