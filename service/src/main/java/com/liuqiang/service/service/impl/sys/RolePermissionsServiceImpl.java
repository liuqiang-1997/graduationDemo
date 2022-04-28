package com.liuqiang.service.service.impl.sys;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liuqiang.commons.utils.MapperUtils;
import com.liuqiang.model.bo.sys.PermissionsBo;
import com.liuqiang.model.bo.sys.RoleBo;
import com.liuqiang.model.bo.sys.RolePermissionsBo;
import com.liuqiang.model.entity.sys.Role;
import com.liuqiang.model.entity.sys.RolePermissions;
import com.liuqiang.model.vo.sys.QueryVo;
import com.liuqiang.model.vo.sys.RolePermissionsVo;
import com.liuqiang.service.mapper.sys.PermissionsMapper;
import com.liuqiang.service.mapper.sys.RoleMapper;
import com.liuqiang.service.mapper.sys.RolePermissionsMapper;
import com.liuqiang.service.service.sys.RolePermissionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 系统角色权限
 * @author LiuQiang
 */
@Service
public class RolePermissionsServiceImpl extends ServiceImpl<RolePermissionsMapper, RolePermissions>
        implements RolePermissionsService {

    @Autowired
    private RolePermissionsMapper rolePermissionsMapper;


    @Override
    public Boolean saveUpdate(RolePermissionsVo rolePermissionsVo) {
            rolePermissionsMapper.deleteByRoleId(rolePermissionsVo.getRoleId());
           return rolePermissionsMapper.insertBatchs(rolePermissionsVo,rolePermissionsVo.getPermissionId());
    }

    @Override
    public PageInfo<RolePermissionsBo> queryRolePermissionList(QueryVo queryVo) {
        PageHelper.startPage(queryVo.getPageNum(),queryVo.getPageSize());
        List<RolePermissionsBo> list = rolePermissionsMapper.getList();
        List<RolePermissionsBo> collect = list.stream().distinct().collect(Collectors.toList());
        return new PageInfo<>(collect);
    }
}
