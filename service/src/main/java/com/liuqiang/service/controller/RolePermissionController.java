package com.liuqiang.service.controller;

import com.github.pagehelper.PageInfo;
import com.liuqiang.commons.utils.ResultBody;
import com.liuqiang.model.bo.sys.RolePermissionsBo;
import com.liuqiang.model.vo.sys.QueryVo;
import com.liuqiang.model.vo.sys.RolePermissionsVo;
import com.liuqiang.service.service.sys.RolePermissionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 角色权限
 * @author LiuQiang
 * @date 10:20 上午
 */
@RestController
@RequestMapping("role/permission")
public class RolePermissionController {

    @Autowired
    private RolePermissionsService rolePermissionsService;

    //    @Log("新增/修改角色权限")
    @PostMapping("/save")
    public ResultBody<Boolean> saveRolePermission(@RequestBody RolePermissionsVo rolePermissionsVo){
        return ResultBody.ok(rolePermissionsService.saveUpdate(rolePermissionsVo));
    }


    //    @Log("查询角色权限列表数据")
    @GetMapping("/search")
    public ResultBody<PageInfo<RolePermissionsBo>> search(QueryVo queryVo){

        return ResultBody.ok(rolePermissionsService.queryRolePermissionList(queryVo));
    }



}
