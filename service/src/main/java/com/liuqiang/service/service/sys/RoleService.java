package com.liuqiang.service.service.sys;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.liuqiang.model.bo.sys.RoleBo;
import com.liuqiang.model.entity.sys.Role;
import com.liuqiang.model.vo.sys.QueryVo;
import com.liuqiang.model.vo.sys.RoleVo;

import java.util.List;

public interface RoleService extends IService<Role> {
    /**
     * 新增/修改角色
     * @param roleVo 角色信息
     * @return true成功
     */
    Boolean saveUpdate(RoleVo roleVo);

    /**
     * 分页查询角色列表
     * @param queryVo
     * @param roleName
     * @param status
     * @return
     */
    PageInfo<RoleBo> roleList(QueryVo queryVo, String roleName, Integer status);

    /**
     * 查询角色详情
     * @param roleId
     * @return
     */
    Role roleInfo(Integer roleId);

    /**
     * 修改角色状态
     * @param
     * @return
     */
    Boolean updateStatus(Integer roleId,Integer status);

    List<RoleBo> roleList();
}
