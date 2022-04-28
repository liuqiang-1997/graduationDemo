package com.liuqiang.service.service.sys;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.liuqiang.model.bo.sys.RolePermissionsBo;
import com.liuqiang.model.entity.sys.RolePermissions;
import com.liuqiang.model.vo.sys.QueryVo;
import com.liuqiang.model.vo.sys.RolePermissionsVo;

import java.util.List;

/**
 * 角色权限
 * @author liuqiang
 */
public interface RolePermissionsService extends IService<RolePermissions> {

    /**
     * 新增/修改角色权限
     * @param rolePermissionsVo 角色权限信息
     * @return true 成功
     */
    Boolean saveUpdate(RolePermissionsVo rolePermissionsVo);

    /**
     * 查询角色权限列表
     * @param queryVo
     * @return
     */
    PageInfo<RolePermissionsBo> queryRolePermissionList(QueryVo queryVo);

}
