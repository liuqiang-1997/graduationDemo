package com.liuqiang.service.controller;

import com.liuqiang.commons.utils.ResultBody;
import com.liuqiang.model.bo.servicelogic.WorkProveBo;
import com.liuqiang.model.vo.servicelogic.WorkProveVo;
import com.liuqiang.service.service.servicelogic.WorkProveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 工作证明信息
 * @author LiuQiang
 * @date 10:24 上午
 */
@RequestMapping("/work")
@RestController
public class WorkProveController {

    @Autowired
    private WorkProveService workProveService;


    /**
     * 新增修改就业证明
     * @param workProveVo 证明信息
     * @param file 证明文件
     * @return boolean
     */
//    @Log("保存就业证明")
    @PostMapping("/workprove/save")
    public ResultBody<Boolean> saveWorkProve(@RequestBody WorkProveVo workProveVo,
                                             @RequestParam("file") List<MultipartFile> file){
        return ResultBody.ok(workProveService.saveWorkProve(workProveVo,file));

    }

    /**
     * 查看就业证明详情
     * @param stuId 学号
     * @return 详情信息
     */
//    @Log("查看就业证明详情")
    @GetMapping("/workprove/info")
    public ResultBody<WorkProveBo> queryWorkProveInfo(@RequestParam("stuId") String stuId){
        return ResultBody.ok(workProveService.queryWorkProveInfo(stuId));
    }
}
