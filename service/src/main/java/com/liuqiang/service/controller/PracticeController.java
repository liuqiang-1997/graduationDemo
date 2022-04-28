package com.liuqiang.service.controller;

import com.github.pagehelper.PageInfo;
import com.liuqiang.commons.utils.ResultBody;
import com.liuqiang.model.bo.data.PracticeDataBo;
import com.liuqiang.model.bo.servicelogic.PracticeBo;
import com.liuqiang.model.vo.servicelogic.PracticeVo;
import com.liuqiang.model.vo.sys.QueryVo;
import com.liuqiang.service.service.servicelogic.PracticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 实习信息相关
 * @author LiuQiang
 * @date 10:15 上午
 */
@RestController
@RequestMapping("/practice")
public class PracticeController {

    @Autowired
    private PracticeService practiceService;



    /**
     * 新增修改实习信息
     * @param practiceVo 修改参数
     * @return boolean true成功；false失败
     */
//    @Log("新增修改实习信息")
    @PostMapping("/save")
    public ResultBody<Boolean> saveOrUpdatePractice(@RequestBody PracticeVo practiceVo){
        return ResultBody.ok(practiceService.saveOrUpdatePractice(practiceVo));
    }


    /**
     * 查询学生实习信息
     * @param queryVo 查询参数(分页+学生ID)
     * @return 列表
     */
    @GetMapping("/query/practice")
    public ResultBody<PageInfo<PracticeBo>> queryPractice(QueryVo queryVo, @RequestParam("stuId") String stuId){
        return ResultBody.ok(practiceService.queryPractice(queryVo,stuId));
    }
    /**
     * 查询详情
     * @param id 记录ID
     * @param stuId 学号
     * @return 实习信息详情
     */
//    @Log("查询实习信息详情")
    @GetMapping("/info")
    public ResultBody<PracticeBo> queryPracticeInfo(@RequestParam("id") Integer id, @RequestParam("stuId") String stuId){

        return ResultBody.ok(practiceService.queryPracticeInfo(id,stuId));
    }

    /**
     * 根据记录ID与学号删除
     * @param stuId 学号
     * @param id 记录ID
     * @return true成功；false失败
     */
//    @Log("删除实习信息")
    @PostMapping("/delete")
    public ResultBody<Boolean> deletePractice(@RequestParam("id") Integer id,@RequestParam("stuId") String stuId){
        return ResultBody.ok(practiceService.deletePractice(id,stuId));
    }

    /**
     * 教师查询实习薪资数据
     * @return 数据集
     */
    @GetMapping("/practice/data")
    public ResultBody<List<PracticeDataBo>> queryPracticeData(
            @RequestParam(value = "stuId",required = false) String stuId,
            @RequestParam(value = "stuName",required = false) String stuName){
        return ResultBody.ok(practiceService.queryPracticeData(stuId,stuName));
    }



}
