package com.liuqiang.service.controller;

import com.liuqiang.commons.utils.ResultBody;
import com.liuqiang.model.bo.servicelogic.ScoreProveBo;
import com.liuqiang.model.vo.servicelogic.ScoreProveVo;
import com.liuqiang.service.service.servicelogic.ScoreProveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * 考公/研成绩证明
 * @author LiuQiang
 * @date 10:23 上午
 */
@RestController
@RequestMapping("/score")
public class ScoreProveController {

    @Autowired
    private ScoreProveService scoreProveService;

    /**
     * 新增修改成绩证明
     * @param scoreProveVo 数据
     * @return 成功记录数
     */
//    @Log("保存成绩证明")
    @PostMapping("/save")
    public ResultBody<Boolean> saveScoreProve(@RequestBody ScoreProveVo scoreProveVo,
                                              @RequestParam("file") MultipartFile file){

        return ResultBody.ok(scoreProveService.saveScoreProve(scoreProveVo,file));
    }

    /**
     * 根据学号查看成绩信息详情
     * @param stuId 学号
     * @return 详情信息
     */
//    @Log("查询证明详情")
    @GetMapping("/info")
    public ResultBody<ScoreProveBo> queryScoreProveInfo(@RequestParam("stuId") String stuId){
        return ResultBody.ok(scoreProveService.queryScoreProveInfo(stuId));
    }
}
