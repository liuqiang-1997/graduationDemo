package com.liuqiang.service.service.impl.sys;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Strings;
import com.liuqiang.commons.utils.MapperUtils;
import com.liuqiang.model.bo.sys.RoleBo;
import com.liuqiang.model.entity.sys.Role;
import com.liuqiang.model.entity.sys.RolePermissions;
import com.liuqiang.model.vo.sys.QueryVo;
import com.liuqiang.model.vo.sys.RoleVo;
import com.liuqiang.service.mapper.sys.RoleMapper;
import com.liuqiang.service.mapper.sys.RolePermissionsMapper;
import com.liuqiang.service.service.sys.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 系统角色
 * @author LiuQiang
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>
        implements RoleService {

    @Autowired
    private RolePermissionsMapper rolePermissionsMapper;
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Boolean saveUpdate(RoleVo roleVo) {
        if (roleVo.getId() ==null){
            Role role = getOne(new QueryWrapper<Role>().eq("role_name", roleVo.getRoleName()));
            if (role!= null){
                // todo 返回数据存在，不可重复提示
                return false;
            }
        }
        return saveOrUpdate(MapperUtils.INSTANCE.map(Role.class,roleVo));
    }

    @Override
    public PageInfo<RoleBo> roleList(QueryVo queryVo, String roleName, Integer status) {

        PageHelper.startPage(queryVo.getPageNum(),queryVo.getPageSize());
        List<RoleBo> list = roleMapper.roleList(roleName,status);
        return new PageInfo<>(list);

    }

    @Override
    public Role roleInfo(Integer roleId) {
        QueryWrapper<Role> wrapper = new QueryWrapper<>();
        wrapper.eq("role_id",roleId);
        return getOne(wrapper);
    }

    @Override
    public Boolean updateStatus(Integer roleId,Integer status) {
        QueryWrapper<RolePermissions> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("role_id",roleId);
        queryWrapper.eq("status",0);
        List<RolePermissions> list = rolePermissionsMapper.selectList(queryWrapper);

        if (list == null || list.size() == 0){
            // todo 返回角色已被使用，不能禁用
        }
        UpdateWrapper<Role> wrapper = new UpdateWrapper<>();
        wrapper.set("status",status);
        wrapper.eq("id",roleId);


        return update(wrapper);

    }

    @Override
    public List<RoleBo> roleList() {
        return MapperUtils.INSTANCE.mapAsList(RoleBo.class,list(new QueryWrapper<Role>().eq("status",0)));
    }
}
