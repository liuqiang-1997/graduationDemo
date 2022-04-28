package com.liuqiang.service.mapper.sys;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liuqiang.model.bo.sys.PermissionInfoBo;
import com.liuqiang.model.bo.sys.PermissionsBo;
import com.liuqiang.model.bo.sys.RoleBo;
import com.liuqiang.model.bo.sys.RolePermissionsBo;
import com.liuqiang.model.entity.sys.Permissions;
import com.liuqiang.model.entity.sys.Role;
import com.liuqiang.model.entity.sys.RolePermissions;
import com.liuqiang.model.vo.sys.RolePermissionsVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 系统角色权限
 * @author LiuQiang
 */
@Mapper
@Repository
public interface RolePermissionsMapper extends BaseMapper<RolePermissions> {

    /**
     * 获取角色权限
     * @param roleId 角色ID
     * @return 权限列表
     */
    List<String> getRolePermissions(@Param("roleId") Long roleId);


    Boolean insertBatchs(@Param("rolePermission") RolePermissionsVo rolePermissionsVo,
                         @Param("list") List<Integer> permissionId);

    void deleteByRoleId(@Param("roleId") Integer roleId);


    List<RolePermissionsBo> getList();

    List<PermissionsBo> permissionList(@Param("idList") String idList);

    PermissionInfoBo permissionInfo(@Param("idList") String idList);

}
