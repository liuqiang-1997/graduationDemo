package com.liuqiang.model.bo.sys;

import com.liuqiang.model.entity.sys.Permissions;
import com.liuqiang.model.entity.sys.Role;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 系统角色权限
 * @author LiuQiang
 */
@Data
public class RolePermissionsBo {
    /**
     * id
     */
    private Integer id;
    /**
     * 角色ID
     */
    private Integer roleId;

    private String roleName;

    /**
     * 权限列表
     */
    private List<PermissionsBo> permissions;
    /**
     * 状态 0-正常；1-禁用
     */
    private Integer status;
    /**
     * 备注
     */
    private String remark;

}
