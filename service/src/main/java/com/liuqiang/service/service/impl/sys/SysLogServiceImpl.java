package com.liuqiang.service.service.impl.sys;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liuqiang.commons.utils.MapperUtils;
import com.liuqiang.model.bo.sys.SysLogBo;
import com.liuqiang.model.entity.sys.SysLog;
import com.liuqiang.model.vo.sys.QueryVo;
import com.liuqiang.model.vo.sys.SysLogVo;
import com.liuqiang.service.mapper.sys.SysLogMapper;
import com.liuqiang.service.service.sys.SysLogService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * 系统日志
 * @author LiuQiang
 */
@Service
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLog>
        implements SysLogService {

    @Autowired
    private SysLogMapper sysLogMapper;

    @Override
    public PageInfo<SysLogBo> condition(QueryVo queryVo, SysLogVo sysLogVo) {
        PageHelper.startPage(queryVo.getPageNum(),queryVo.getPageSize());
        List<SysLogBo> logBoList = sysLogMapper.selectByCondition(sysLogVo);
        return new PageInfo<>(logBoList);
    }
}
