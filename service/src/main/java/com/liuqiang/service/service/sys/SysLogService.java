package com.liuqiang.service.service.sys;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.liuqiang.model.bo.sys.SysLogBo;
import com.liuqiang.model.entity.sys.SysLog;
import com.liuqiang.model.vo.sys.QueryVo;
import com.liuqiang.model.vo.sys.SysLogVo;

import java.util.List;

public interface SysLogService extends IService<SysLog> {


    PageInfo<SysLogBo> condition(QueryVo queryVo, SysLogVo sysLogVo);
}
