package com.liuqiang.service.controller;

import com.github.pagehelper.PageInfo;
import com.liuqiang.commons.utils.ResultBody;
import com.liuqiang.model.bo.data.InterviewDataBo;
import com.liuqiang.model.bo.servicelogic.InterviewBo;
import com.liuqiang.model.vo.servicelogic.InterviewVo;
import com.liuqiang.model.vo.sys.QueryVo;
import com.liuqiang.service.service.servicelogic.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 面试信息
 * @author LiuQiang
 * @date 10:17 上午
 */
@RestController
@RequestMapping("/interview")
public class InterviewController {

    @Autowired
    private InterviewService interviewService;

    /**
     * 新增修改面试信息
     * @param interviewVo 面试数据
     * @return true成功；false失败
     */
//    @Log("保存面试信息")
    @PostMapping("/save")
    public ResultBody<Boolean> saveInterview(@RequestBody InterviewVo interviewVo){
        return ResultBody.ok(interviewService.saveInterview(interviewVo));
    }


    /**
     * 面试信息详情查询
     * @param id 面试记录ID
     * @param stuId 学号
     * @return 面试详情
     */
//    @Log("个人面试信息详情查询")
    @GetMapping("/interview/info")
    public ResultBody<InterviewBo> queryInterviewInfo(@RequestParam("id") Integer id,
                                                      @RequestParam("stuId") String stuId){

        return ResultBody.ok(interviewService.queryInterviewInfo(id,stuId));
    }

    /**
     * 删除面试信息
     * @param stuId 学号
     * @param id 记录ID
     * @return 成功记录数
     */
//    @Log("删除个人面试信息")
    @PostMapping("/interview/delete/{stuId}/{id}")
    public ResultBody<Boolean> deleteInterview(@PathVariable("stuId") String stuId,
                                               @PathVariable("id") Integer id){

        return ResultBody.ok(interviewService.deleteInterview(id,stuId));
    }


    /**
     * 查询名下学生面试信息
     * @param queryVo 查询参数(分页+学生ID)
     * @return 列表
     */
    @GetMapping("/search")
    public ResultBody<PageInfo<InterviewBo>> queryInterview(QueryVo queryVo,
                                                            @RequestParam(value = "stuId",required = false) String stuId,
                                                            @RequestParam(value = "stuName",required = false) String stuName){
        return ResultBody.ok(interviewService.queryInterview(queryVo,stuId,stuName));
    }

    /**
     * 根据学生学号姓名查看学生面试数据
     * @param stuId 学号
     *  @param stuName 姓名
     * @return 面试数据集
     */
    @GetMapping("/data")
    public ResultBody<InterviewDataBo> queryInterviewData(
            @RequestParam(value = "stuId",required = false) String stuId,
            @RequestParam(value = "stuName",required = false) String stuName){

        return ResultBody.ok(interviewService.getInterviewData(stuId,stuName));
    }


}
