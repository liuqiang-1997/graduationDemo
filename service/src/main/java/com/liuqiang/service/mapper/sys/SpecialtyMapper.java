package com.liuqiang.service.mapper.sys;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liuqiang.model.entity.sys.Specialty;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 学院专业信息
 * @author LiuQiang
 */
@Mapper
@Repository
public interface SpecialtyMapper extends BaseMapper<Specialty> {
}
