package com.liuqiang.service.controller;

import com.github.pagehelper.PageInfo;
import com.liuqiang.commons.utils.ResultBody;
import com.liuqiang.model.bo.data.MonthlyDataBo;
import com.liuqiang.model.bo.servicelogic.MonthlyBo;
import com.liuqiang.model.vo.servicelogic.MonthlyVo;
import com.liuqiang.model.vo.sys.QueryVo;
import com.liuqiang.service.service.servicelogic.MonthlyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 实习月报/总结信息
 * @author LiuQiang
 * @date 10:18 上午
 */
@RestController
@RequestMapping("/monthly")
public class MonthlyController {

    @Autowired
    private MonthlyService monthlyService;



    /**
     * 查询名下学生月报/总结/申请/任务书信息
     * @param queryVo 查询参数(分页+学生ID)
     * @return 列表
     */
    @GetMapping("/search")
    public ResultBody<PageInfo<MonthlyBo>> queryMonthly(QueryVo queryVo,
                                                        @RequestParam(value = "stuId",required = false) String stuId,
                                                        @RequestParam(value="type") Integer type){
        return ResultBody.ok(monthlyService.queryMonthly(queryVo,stuId,type));
    }

    /**
     * 根据学生学号姓名查询月报/总结提交数
     * @param teaId 教师ID
     * @param stuId 学生ID
     * @param stuName 学生名称
     * @return
     */
    @GetMapping("/data")
    public ResultBody<List<MonthlyDataBo>> queryMonthlyData(
            @RequestParam("teaId") String teaId,
            @RequestParam(value = "type",defaultValue = "0",required = false) Integer type,
            @RequestParam(value = "stuId",required = false) String stuId,
            @RequestParam(value = "stuName",required = false) String stuName){

        return ResultBody.ok(monthlyService.getMonthlyData(teaId,stuId,stuName,type));
    }

    /**
     * 新增修改月报/总结
     * @param monthlyVo 月报/总结数据
     * @return 成功记录数
     */
//    @Log("保存月报总结")
    @PostMapping("/save")
    public ResultBody<Boolean> saveMonthly(MonthlyVo monthlyVo, @RequestParam("file") MultipartFile file){
        return ResultBody.ok(monthlyService.saveMonthly(monthlyVo,file));
    }


    /**
     * 查询月报总结详情
     * @param id 月报ID
     * @param stuId 学号
     * @return 详情数据
     */
//    @Log("查询月报总结信息详情")
    @GetMapping("/info")
    public ResultBody<MonthlyBo> queryMonthlyInfo(@RequestParam("id") Integer id,
                                                  @RequestParam("stuId") String stuId){
        return ResultBody.ok(monthlyService.queryMonthlyInfo(id,stuId));
    };

}
