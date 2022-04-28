package com.liuqiang.service.mapper.servicelogic;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liuqiang.model.entity.servicelogic.ResumeReply;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 简历修订意见
 * @author LiuQiang
 */
@Mapper
@Repository
public interface ResumeReplyMapper extends BaseMapper<ResumeReply> {
}
