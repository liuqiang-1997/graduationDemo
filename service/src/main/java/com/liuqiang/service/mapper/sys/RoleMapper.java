package com.liuqiang.service.mapper.sys;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liuqiang.model.bo.sys.RoleBo;
import com.liuqiang.model.entity.sys.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * 系统角色
 * @author LiuQiang
 */
@Mapper
@Repository
public interface RoleMapper extends BaseMapper<Role> {
    Role selectByRoleId(@Param("roleId") Integer roleId);

    List<RoleBo> roleList(@Param("roleName") String roleName, @Param("status") Integer status);
}
