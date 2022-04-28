package com.liuqiang.service.service.impl.sys;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liuqiang.commons.utils.MapperUtils;
import com.liuqiang.model.bo.sys.PermissionsBo;
import com.liuqiang.model.entity.sys.Permissions;
import com.liuqiang.model.entity.sys.RolePermissions;
import com.liuqiang.model.vo.sys.PermissionsVo;
import com.liuqiang.model.vo.sys.QueryVo;
import com.liuqiang.service.mapper.sys.PermissionsMapper;
import com.liuqiang.service.mapper.sys.RolePermissionsMapper;
import com.liuqiang.service.service.sys.PermissionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 系统权限
 * @author LiuQiang
 */
@Service
public class PermissionsServiceImpl extends ServiceImpl<PermissionsMapper, Permissions>
        implements PermissionsService {
    @Autowired
    private RolePermissionsMapper rolePermissionsMapper;

    @Autowired
    private PermissionsMapper permissionsMapper;

    @Override
    public PageInfo<PermissionsBo> searchPermission(QueryVo queryVo, String name, String path) {
        PageHelper.startPage(queryVo.getPageNum(),queryVo.getPageSize());
         List<PermissionsBo> list = permissionsMapper.permissionList(name,path);
        return new PageInfo<>(list);
    }

    @Override
    public List<PermissionsBo> listPermission() {
        return MapperUtils.INSTANCE.mapAsList(PermissionsBo.class,
                list(new QueryWrapper<Permissions>().eq("status",0)));
    }

    @Override
    public PermissionsBo infoPermission(String name) {
        return MapperUtils.INSTANCE.map(PermissionsBo.class,
                getOne(new QueryWrapper<Permissions>().eq("permission_name",name)));
    }

    @Override
    public Boolean saveUpdate(PermissionsVo permissionsVo) {
        if (permissionsVo.getId() == null) {
            List<Permissions> one = list(new QueryWrapper<Permissions>().eq("permission_name",
                    permissionsVo.getPermissionName())
                    .or(wrapper -> wrapper.eq("permission_path", permissionsVo.getPermissionPath())));
            if (one != null) {
                // todo 返回数据已存在，不能重复提示
                return false;
            }
        }
        return saveOrUpdate(MapperUtils.INSTANCE.map(Permissions.class,permissionsVo));
    }

    @Override
    public Boolean updateStatus(Integer status, Integer permissionId) {
        QueryWrapper<RolePermissions> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("permission_id",permissionId);
        queryWrapper.eq("status",0);
        List<RolePermissions> list = rolePermissionsMapper.selectList(queryWrapper);
        if (list == null || list.size()==0) {
            // todo 返回该权限已被使用，不能禁用提示
        }
        UpdateWrapper<Permissions> wrapper = new UpdateWrapper<>();
        wrapper.set("status",status);
        wrapper.eq("id",permissionId);
        return update(wrapper);
    }
}
