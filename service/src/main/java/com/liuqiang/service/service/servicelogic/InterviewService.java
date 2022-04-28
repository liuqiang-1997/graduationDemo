package com.liuqiang.service.service.servicelogic;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.liuqiang.model.bo.servicelogic.InterviewBo;
import com.liuqiang.model.bo.data.InterviewDataBo;
import com.liuqiang.model.entity.servicelogic.Interview;
import com.liuqiang.model.vo.servicelogic.InterviewVo;
import com.liuqiang.model.vo.sys.QueryVo;

public interface InterviewService extends IService<Interview> {

    Boolean saveInterview(InterviewVo interviewVo);

    PageInfo<InterviewBo> searchInterview(QueryVo queryVo);

    InterviewBo queryInterviewInfo(Integer id, String stuId);

    Boolean deleteInterview(Integer id, String stuId);

    Boolean updateInterViewGrade(Integer id,String stuId, Double grade);

    InterviewDataBo getInterviewData(String stuId, String stuName);


    /**
     * 查询名下学生面试信息
     * @param queryVo 查询参数
     * @return 分页列表
     */
    PageInfo<InterviewBo> queryInterview(QueryVo queryVo,String stuId,String stuName);

}

