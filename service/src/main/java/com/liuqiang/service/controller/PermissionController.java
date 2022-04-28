package com.liuqiang.service.controller;

import com.github.pagehelper.PageInfo;
import com.liuqiang.commons.utils.ResultBody;
import com.liuqiang.model.bo.sys.PermissionsBo;
import com.liuqiang.model.vo.sys.PermissionsVo;
import com.liuqiang.model.vo.sys.QueryVo;
import com.liuqiang.service.service.sys.PermissionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 权限信息
 * @author LiuQiang
 * @date 10:20 上午
 */
@RestController
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private PermissionsService permissionsService;

    //    @Log("新增/修改系统权限")
    @PostMapping("/save")
    public ResultBody<Boolean> savePermission(@RequestBody PermissionsVo permissionsVo){
        return ResultBody.ok(permissionsService.saveUpdate(permissionsVo));

    }

    //    @Log("查询系统权限信息列表")
    @GetMapping("/search")
    public ResultBody<PageInfo<PermissionsBo>> permissionSearch(QueryVo queryVo,
                                                                @RequestParam(value = "name",required = false) String name,
                                                                @RequestParam(value = "path",required = false) String path
    ){
        return ResultBody.ok(permissionsService.searchPermission(queryVo,name,path));
    }

    //    @Log("查询权限列表")
    @GetMapping("/list")
    public ResultBody<List<PermissionsBo>> permissionList(){
        return ResultBody.ok(permissionsService.listPermission());
    }

    //    @Log("查询系统权限详情")
    @GetMapping("/info")
    public ResultBody<PermissionsBo> permissionInfo(@RequestParam("name") String name){
        return ResultBody.ok(permissionsService.infoPermission(name));
    }

    //    @Log("解禁/禁用角色权限")
    @PostMapping("/use")
    public ResultBody<Boolean> permissionUse(@RequestParam("status") Integer status,
                                             @RequestParam("permissionId") Integer permissionId){
        return ResultBody.ok(permissionsService.updateStatus(status,permissionId));
    }

}
