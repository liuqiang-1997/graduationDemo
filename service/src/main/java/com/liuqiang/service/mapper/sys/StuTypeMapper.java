package com.liuqiang.service.mapper.sys;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liuqiang.model.entity.sys.StuType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 学生类型
 * @author LiuQiang
 */
@Mapper
@Repository
public interface StuTypeMapper extends BaseMapper<StuType> {
}
