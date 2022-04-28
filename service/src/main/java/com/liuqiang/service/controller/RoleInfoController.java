package com.liuqiang.service.controller;

import com.github.pagehelper.PageInfo;
import com.liuqiang.commons.utils.MapperUtils;
import com.liuqiang.commons.utils.ResultBody;
import com.liuqiang.model.bo.sys.RoleBo;
import com.liuqiang.model.entity.sys.Role;
import com.liuqiang.model.vo.sys.QueryVo;
import com.liuqiang.model.vo.sys.RoleVo;
import com.liuqiang.service.log.Log;
import com.liuqiang.service.service.sys.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 角色信息
 * @author LiuQiang
 * @date 10:20 上午
 */
@RestController
@RequestMapping("/role")
public class RoleInfoController {

    @Autowired
    private RoleService roleService;


    //    @Log("新增/修改系统角色")
    @PostMapping("/save")
    public ResultBody<Boolean> saveRole(@RequestBody RoleVo roleVo){
        Boolean aBoolean = roleService.saveUpdate(roleVo);
        return ResultBody.ok(aBoolean);
    }

//    @Log("查询系统角色信息列表")
    @GetMapping("/search")
    public ResultBody<PageInfo<RoleBo>> roleList(QueryVo queryVo,
                                                 @RequestParam(value = "roleName",required = false) String roleName,
                                                 @RequestParam(value = "status",required = false) Integer status){
        PageInfo<RoleBo> roleBoPageInfo = roleService.roleList(queryVo,roleName, status);
        return ResultBody.ok(roleBoPageInfo);
    }

    //    @Log("查询系统角色详情")
    @GetMapping("/role/info")
    public ResultBody<RoleBo> roleInfo(@RequestParam("roleId") Integer roleId){
        Role role = roleService.roleInfo(roleId);
        return ResultBody.ok(MapperUtils.INSTANCE.map(RoleBo.class,role));
    }

    //    @Log("获取全部系统角色")
    @GetMapping("/role/list")
    public ResultBody<List<RoleBo>> roleList(){
        return ResultBody.ok(roleService.roleList());
    }


    //    @Log("禁用/解禁系统角色")
    @PostMapping("/role/use")
    public ResultBody<Boolean> roleUse(@RequestParam("roleId") Integer roleId,
                                       @RequestParam("status") Integer status){
        return ResultBody.ok(roleService.updateStatus(roleId,status));
    }




}
