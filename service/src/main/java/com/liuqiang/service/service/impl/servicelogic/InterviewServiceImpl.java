package com.liuqiang.service.service.impl.servicelogic;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Strings;
import com.liuqiang.commons.utils.MapperUtils;
import com.liuqiang.model.bo.servicelogic.InterviewBo;
import com.liuqiang.model.bo.data.InterviewDataBo;
import com.liuqiang.model.entity.servicelogic.Interview;
import com.liuqiang.model.vo.servicelogic.InterviewVo;
import com.liuqiang.model.vo.sys.QueryVo;
import com.liuqiang.service.mapper.servicelogic.InterviewMapper;
import com.liuqiang.service.service.servicelogic.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * 面试
 * @author LiuQiang
 */
@Service
public class InterviewServiceImpl extends ServiceImpl<InterviewMapper, Interview>
        implements InterviewService {

    @Autowired
    private InterviewMapper interviewMapper;

    @Override
    public Boolean saveInterview(InterviewVo interviewVo) {
        return this.saveOrUpdate(MapperUtils.INSTANCE.map(Interview.class, interviewVo));
    }

    @Override
    public PageInfo<InterviewBo> searchInterview(QueryVo queryVo) {
        QueryWrapper<Interview> wrapper = new QueryWrapper<>();
        wrapper.eq("stu_id",queryVo.getUserNumber());
        PageHelper.startPage(queryVo.getPageNum(),queryVo.getPageSize());
        return new PageInfo<>(MapperUtils.INSTANCE.mapAsList(InterviewBo.class,baseMapper.selectList(wrapper)));
    }

    @Override
    public InterviewBo queryInterviewInfo(Integer id, String stuId) {
        QueryWrapper<Interview> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",id).eq("stu_id",stuId);
        return MapperUtils.INSTANCE.map(InterviewBo.class,this.getOne(queryWrapper));

    }

    @Override
    public Boolean deleteInterview(Integer id, String stuId) {
        HashMap<String, Object> map = new HashMap<>(2);
        map.put("id",id);
        map.put("stu_id",stuId);
        return this.removeByMap(map);
    }

//    教师模块

    @Override
    public Boolean updateInterViewGrade(Integer id,String stuId, Double grade) {
        UpdateWrapper<Interview> wrapper = new UpdateWrapper<>();
        wrapper.eq("stu_id",stuId).eq("id",id).set("grade",grade);
        return this.update(wrapper);
    }

    @Override
    public InterviewDataBo getInterviewData(String stuId, String stuName) {

        // 面试单位性质0-国企；1-私企；2-机关单位
        List<HashMap<String,Object>> companyType = interviewMapper.selectCompanyType(stuId,stuName);
        // 面试信息来源
        List<HashMap<String,Object>> source = interviewMapper.selectSource(stuId,stuName);
        // 面试薪资
        List<HashMap<String,Object>> pay = interviewMapper.selectPay(stuId,stuName);
        // 面试结果
        List<HashMap<String,Object>> result = interviewMapper.selectResult(stuId,stuName);

        InterviewDataBo interviewDataBo = new InterviewDataBo();
        interviewDataBo.setCompanyType(companyType);
        interviewDataBo.setSource(source);
        interviewDataBo.setPay(pay);
        interviewDataBo.setResult(result);
        System.out.println(interviewDataBo.toString());
        return interviewDataBo;
    }

    @Override
    public PageInfo<InterviewBo> queryInterview(QueryVo queryVo,String stuId,String stuName) {
        PageHelper.startPage(queryVo.getPageNum(),queryVo.getPageSize());
        QueryWrapper<Interview> queryWrapper = new QueryWrapper<>();
        if(!Strings.isNullOrEmpty(stuId)){
            queryWrapper.likeRight("stu_id",stuId);
        }
        if(!Strings.isNullOrEmpty(stuName)){
            queryWrapper.likeRight("stu_name",stuName);
        }
        return new PageInfo<>(MapperUtils.INSTANCE.mapAsList(InterviewBo.class,list(queryWrapper)));
    }


}
