package com.liuqiang.service.controller;

import com.liuqiang.commons.utils.ResultBody;
import com.liuqiang.model.bo.userinfo.StudentBo;
import com.liuqiang.model.vo.user.StudentVo;
import com.liuqiang.service.log.Log;
import com.liuqiang.service.service.user.UserRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户关系
 * @author LiuQiang
 * @date 10:27 上午
 */
@RestController
@RequestMapping("/relation")
public class UserRelationController {

    @Autowired
    private UserRelationService userRelationService;


    //    @Log("新增/修改学生人物关系")
    @PostMapping("/save")
    public ResultBody<Boolean> save(@RequestBody StudentVo studentVo){
        Boolean aBoolean = userRelationService.saveUpdate(studentVo);
        if (aBoolean) {
            return ResultBody.ok(aBoolean);
        }
        return ResultBody.fail("失败",aBoolean);
    }

    /**
     * 查询个人信息
     * @param stuId 查询参数
     * @return 个人信息
     */
//    @Log("查询学生个人信息")
    @GetMapping("/query")
    public ResultBody<StudentBo> queryInfo(@RequestParam("stuId") String stuId){
        return ResultBody.ok(userRelationService.queryInfo(stuId));
    }

}
