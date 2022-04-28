package com.liuqiang.service.service.sys;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.liuqiang.model.bo.sys.PermissionsBo;
import com.liuqiang.model.entity.sys.Permissions;
import com.liuqiang.model.vo.sys.PermissionsVo;
import com.liuqiang.model.vo.sys.QueryVo;

import java.util.List;

public interface PermissionsService extends IService<Permissions> {
    PageInfo<PermissionsBo> searchPermission(QueryVo queryVo, String name, String path);

    List<PermissionsBo> listPermission();

    PermissionsBo infoPermission(String name);

    Boolean saveUpdate(PermissionsVo permissionsVo);

    Boolean updateStatus(Integer status, Integer permissionId);

}
