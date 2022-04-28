package com.liuqiang.service.controller;

import com.github.pagehelper.PageInfo;
import com.liuqiang.commons.utils.ResultBody;
import com.liuqiang.model.bo.servicelogic.ResumeReplyBo;
import com.liuqiang.model.vo.servicelogic.ResumeReplyVo;
import com.liuqiang.model.vo.sys.QueryVo;
import com.liuqiang.service.service.servicelogic.ResumeReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 简历修订
 * @author LiuQiang
 * @date 12:50 下午
 */
@RestController
@RequestMapping("/reply")
public class ResumeReplyController {

    @Autowired
    private ResumeReplyService resumeReplyService;

    /**
     * 新增/修改简历修订意见
     * @param resumeReplyVo 修订信息
     * @return true成功；false失败
     */
    @PostMapping("insert/resume/reply")
    public ResultBody<Boolean> insertResumeReply(@RequestBody ResumeReplyVo resumeReplyVo){
        return ResultBody.ok(resumeReplyService.insertResumeReply(resumeReplyVo));
    }

    /**
     * 获取简历建议列表
     * @param queryVo
     * @param resumeUser
     * @return
     */
    @GetMapping("/resumereply/search")
    public ResultBody<PageInfo<ResumeReplyBo>> resumeReplySearch(QueryVo queryVo,
                                                                 @RequestParam(value = "resumeUser",required = false) String resumeUser){

        return ResultBody.ok(resumeReplyService.search(queryVo,resumeUser));
    }

    /**
     * 查询简历修订意见
     * @param resumeUser 学号
     * @return 修订意见
     */
//    @Log("查询简历修订意见")
    @GetMapping("/resumereply/{resumeUser}")
    public ResultBody<ResumeReplyBo> queryResumeReply(@PathVariable("resumeUser") String resumeUser){
        return ResultBody.ok(resumeReplyService.queryResumeReply(resumeUser));
    }

}
