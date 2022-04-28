package com.liuqiang.service.controller;

import com.liuqiang.commons.utils.ResultBody;
import com.liuqiang.commons.utils.ReturnCodeUtils;
import com.liuqiang.model.bo.sys.RoleUserBo;
import com.liuqiang.model.entity.servicelogic.CheckInfo;
import com.liuqiang.model.vo.servicelogic.CheckInfoVo;
import com.liuqiang.model.vo.user.UserVo;
import com.liuqiang.service.service.sys.CheckService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * 用户登陆逻辑
 * @author LiuQiang
 * @date 8:58 下午
 */
@RestController
@Slf4j
@RequestMapping("/account")
public class CheckController {

    @Autowired
    private CheckService checkService;

    @PostMapping("/login")
    public ResultBody<HashMap<String,Object>> login(@RequestBody UserVo userVo){
        return ResultBody.ok("登录成功", checkService.login(userVo));
    }

    @PostMapping("/logout")
    public ResultBody<String> logout(){
        return ResultBody.ok(checkService.logout());
    }

    /**
     * 新增/修改用户账号信息
     * @param checkInfo 用户信息
     * @return true成功
     */
//    @Log("新增/修改系统用户身份信息")
    @PostMapping("/save")
    public ResultBody<Boolean> save(@RequestBody CheckInfoVo checkInfo){
        Boolean aBoolean = checkService.saveUpdate(checkInfo);
        if (aBoolean) {
            return ResultBody.ok(aBoolean);
        }
        return ResultBody.fail("失败",aBoolean);

    }


    /**
     * 查询系统角色用户信息列表
     * @param roleId 角色ID
     * @return list
     */
    @GetMapping("/list")
    public ResultBody<List<RoleUserBo>> roleUserList(@RequestParam("roleId") Integer roleId){
        return ResultBody.ok(checkService.queryRoleUser(roleId));

    }

}
