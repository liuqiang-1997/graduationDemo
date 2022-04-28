package com.liuqiang.service.controller;

import com.liuqiang.commons.utils.ResultBody;
import com.liuqiang.service.service.servicelogic.InterviewService;
import com.liuqiang.service.service.servicelogic.MonthlyService;
import com.liuqiang.service.service.servicelogic.PracticeService;
import com.liuqiang.service.service.servicelogic.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 成绩信息
 * @author LiuQiang
 * @date 10:18 上午
 */
@RestController
@RequestMapping("/grade")
public class GradeController {

    @Autowired
    private InterviewService interviewService;

    @Autowired
    private PracticeService practiceService;

    @Autowired
    private MonthlyService monthlyService;

    @Autowired
    private ResumeService resumeService;

    @PutMapping("/interview")
    public ResultBody<Boolean> updateInterViewGrade(@RequestParam("id") Integer id,
                                                    @RequestParam("stuId") String stuId,
                                                    @RequestParam("grade") Double grade){
        return ResultBody.ok(interviewService.updateInterViewGrade(id,stuId,grade));
    }

    @PutMapping("/pratice")
    public ResultBody<Boolean> updatePracticeGrade(@RequestParam("id") Integer id,
                                                   @RequestParam("stuId") String stuId,
                                                   @RequestParam("grade") Double grade){
        return ResultBody.ok(practiceService.updatePracticeGrade(id,stuId,grade));
    }

    @PutMapping("/monyhly")
    public ResultBody<Boolean> updateMonthlyGrade(@RequestParam("id") Integer id,
                                                  @RequestParam("stuId") String stuId,
                                                  @RequestParam("grade") Double grade){
        return ResultBody.ok(monthlyService.updateMonthlyGrade(id,stuId,grade));
    }

    @PutMapping("/resume")
    public ResultBody<Boolean> updateResumeGrade(@RequestParam("stuId") String stuId,
                                                 @RequestParam("grade") Double grade){
        return ResultBody.ok(resumeService.updateResumeGrade(stuId,grade));
    }
}
