package com.liuqiang.service.mapper.servicelogic;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liuqiang.model.entity.servicelogic.WorkProve;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 工作证明
 * @author LiuQiang
 */
@Mapper
@Repository
public interface WorkProveMapper extends BaseMapper<WorkProve> {
}
