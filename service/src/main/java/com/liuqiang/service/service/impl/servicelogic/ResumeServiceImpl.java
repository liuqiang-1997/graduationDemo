package com.liuqiang.service.service.impl.servicelogic;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Strings;
import com.liuqiang.commons.utils.MapperUtils;
import com.liuqiang.model.bo.servicelogic.ResumeBo;
import com.liuqiang.model.entity.servicelogic.Resume;
import com.liuqiang.model.vo.servicelogic.ResumeVo;
import com.liuqiang.model.vo.sys.QueryVo;
import com.liuqiang.service.mapper.servicelogic.ResumeMapper;
import com.liuqiang.service.service.servicelogic.FileOssService;
import com.liuqiang.service.service.servicelogic.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * 学生简历
 * @author LiuQiang
 */
@Service
public class ResumeServiceImpl extends ServiceImpl<ResumeMapper, Resume>
        implements ResumeService {

    @Autowired
    private FileOssService fileOssService;

    @Override
    public Boolean saveResume(ResumeVo resumeVo, MultipartFile file) {
        resumeVo.setResumeAddress(fileOssService.fileUpload(file));
        // todo 需做重命名校验
        return this.saveOrUpdate(MapperUtils.INSTANCE.map(Resume.class,resumeVo));

    }

    @Override
    public ResumeBo queryResume(String resumeUser) {
        QueryWrapper<Resume> wrapper = new QueryWrapper<>();
        wrapper.eq("resume_user",resumeUser);
        return MapperUtils.INSTANCE.map(ResumeBo.class,this.getOne(wrapper));
    }

    @Override
    public Boolean updateResumeGrade(String stuId, Double grade) {
        UpdateWrapper<Resume> wrapper = new UpdateWrapper<>();
        wrapper.eq("resume_user",stuId).set("grade",grade);
        return this.update(wrapper);
    }

    @Override
    public PageInfo<ResumeBo> search(QueryVo queryVo,String stuName) {
        PageHelper.startPage(queryVo.getPageNum(),queryVo.getPageSize());
        QueryWrapper<Resume> wrapper = new QueryWrapper<>();
        if (!Strings.isNullOrEmpty(stuName)) {
            wrapper.likeRight("resume_id",stuName);
        }

        return new PageInfo<>(MapperUtils.INSTANCE.mapAsList(ResumeBo.class,list(wrapper))) ;
    }
}
