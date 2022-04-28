package com.liuqiang.service.mapper.sys;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liuqiang.model.bo.sys.SysLogBo;
import com.liuqiang.model.entity.sys.SysLog;
import com.liuqiang.model.vo.sys.SysLogVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 系统日志
 * @author LiuQiang
 */
@Mapper
@Repository
public interface SysLogMapper extends BaseMapper<SysLog> {
    List<SysLogBo> selectByCondition(SysLogVo sysLogVo);
}
