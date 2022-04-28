package com.liuqiang.service.mapper.sys;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liuqiang.model.entity.servicelogic.CheckInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 系统用户
 * @author LiuQiang
 */
@Mapper
@Repository
public interface CheckMapper extends BaseMapper<CheckInfo> {
}
