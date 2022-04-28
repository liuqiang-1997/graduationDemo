package com.liuqiang.service.service.impl.servicelogic;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Strings;
import com.liuqiang.commons.utils.MapperUtils;
import com.liuqiang.model.bo.servicelogic.ResumeReplyBo;
import com.liuqiang.model.entity.servicelogic.Resume;
import com.liuqiang.model.entity.servicelogic.ResumeReply;
import com.liuqiang.model.vo.servicelogic.ResumeReplyVo;
import com.liuqiang.model.vo.sys.QueryVo;
import com.liuqiang.service.mapper.servicelogic.ResumeReplyMapper;
import com.liuqiang.service.service.servicelogic.ResumeReplyService;
import com.liuqiang.service.service.servicelogic.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 简历修订意见
 * @author LiuQiang
 */
@Service
public class ResumeReplyServiceImpl extends ServiceImpl<ResumeReplyMapper, ResumeReply>
        implements ResumeReplyService {
    @Autowired
    private ResumeService resumeService;
    @Override
    public ResumeReplyBo queryResumeReply(String resumeUser) {
        QueryWrapper<ResumeReply> wrapper = new QueryWrapper<>();
        wrapper.eq("resume_user",resumeUser);
        ResumeReply resumeReply = this.getOne(wrapper);
        QueryWrapper<Resume> wrapper1 = new QueryWrapper<>();
        wrapper1.eq("resume_name",resumeReply.getResumeName());
        Resume one = resumeService.getOne(wrapper1);
        ResumeReplyBo resumeReplyBo = MapperUtils.INSTANCE.map(ResumeReplyBo.class, resumeReply);
        resumeReplyBo.setResumeAddress(one.getResumeAddress());
        return resumeReplyBo;
    }

    @Override
    public Boolean insertResumeReply(ResumeReplyVo resumeReplyVo) {
        return this.saveOrUpdate(MapperUtils.INSTANCE.map(ResumeReply.class,resumeReplyVo));
    }

    @Override
    public PageInfo<ResumeReplyBo> search(QueryVo queryVo, String resumeUser) {
        PageHelper.startPage(queryVo.getPageNum(),queryVo.getPageSize());
        QueryWrapper<ResumeReply> wrapper = new QueryWrapper<>();
        if(!Strings.isNullOrEmpty(resumeUser)){
            wrapper.likeRight("resume_user",resumeUser);
        }
        return new PageInfo<>(MapperUtils.INSTANCE.mapAsList(ResumeReplyBo.class,list(wrapper)));
    }
}
