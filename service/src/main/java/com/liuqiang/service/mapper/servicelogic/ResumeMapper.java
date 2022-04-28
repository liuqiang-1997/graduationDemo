package com.liuqiang.service.mapper.servicelogic;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liuqiang.model.entity.servicelogic.Resume;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 学生简历
 * @author LiuQiang
 */
@Mapper
@Repository
public interface ResumeMapper extends BaseMapper<Resume> {
}
