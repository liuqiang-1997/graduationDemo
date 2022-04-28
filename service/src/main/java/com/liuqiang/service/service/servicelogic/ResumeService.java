package com.liuqiang.service.service.servicelogic;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.liuqiang.model.bo.servicelogic.ResumeBo;
import com.liuqiang.model.entity.servicelogic.Resume;
import com.liuqiang.model.vo.servicelogic.ResumeVo;
import com.liuqiang.model.vo.sys.QueryVo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 简历信息
 * @author liuqiang
 */
public interface ResumeService extends IService<Resume> {
    Boolean saveResume(ResumeVo resumeVo, MultipartFile file);

    ResumeBo queryResume(String resumeUser);

    Boolean updateResumeGrade(String stuId, Double grade);

    PageInfo<ResumeBo> search(QueryVo queryVo,String stuName);
}
