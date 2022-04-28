package com.liuqiang.service.controller;

import com.github.pagehelper.PageInfo;
import com.liuqiang.commons.utils.ResultBody;
import com.liuqiang.model.bo.servicelogic.ResumeBo;
import com.liuqiang.model.bo.servicelogic.ResumeReplyBo;
import com.liuqiang.model.vo.servicelogic.ResumeReplyVo;
import com.liuqiang.model.vo.servicelogic.ResumeVo;
import com.liuqiang.model.vo.sys.QueryVo;
import com.liuqiang.service.service.servicelogic.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author LiuQiang
 * @date 10:19 上午
 */
@RequestMapping("/resume")
@RestController
public class ResumeController {

    @Autowired
    private ResumeService resumeService;



    /**
     * 查询简历列表
     * @param queryVo
     * @param stuName 学生名称
     * @return
     */
    @GetMapping("/search")
    public ResultBody<PageInfo<ResumeBo>> interviewList(QueryVo queryVo,
                                                        @RequestParam(value = "stuName",required = false) String stuName){
        return ResultBody.ok(resumeService.search(queryVo,stuName));
    }

    /**
     * 新增修改简历
     * @param resumeVo 简历
     * @return 成功记录数
     */
//    @Log("保存简历")
    @PostMapping("/save")
    public ResultBody<Boolean> saveResume(ResumeVo resumeVo, @RequestParam("file") MultipartFile file){

        return ResultBody.ok(resumeService.saveResume(resumeVo,file));
    }

    /**
     * 下载简历
     * @param response 数据
     * @param resumeUser 简历所有人
     * @return 简历
     */
//    @Log("下载简历")
    @GetMapping("/download")
    public void downloadResume(HttpServletResponse response,
                               @RequestParam("resumeUser") String resumeUser) throws MalformedURLException {


        ResumeBo resumeBo = resumeService.queryResume(resumeUser);
        String resumeAddress = resumeBo.getResumeAddress();
        // todo 待完成


    }

    /**
     * 根据学号查询简历
     * @param resumeUser 学号
     * @return 简历详情
     */
//    @Log("查询个人简历")
//    @PreAuthorize("hasAuthority('system/resume/info')")
    @GetMapping("/info")
    public ResultBody<ResumeBo> queryResume(@RequestParam("resumeUser") String resumeUser){
        return ResultBody.ok(resumeService.queryResume(resumeUser));
    }
}
