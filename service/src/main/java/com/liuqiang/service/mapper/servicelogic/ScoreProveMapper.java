package com.liuqiang.service.mapper.servicelogic;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liuqiang.model.entity.servicelogic.ScoreProve;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 考公考研成绩证明
 * @author LiuQiang
 */
@Mapper
@Repository
public interface ScoreProveMapper extends BaseMapper<ScoreProve> {
}
