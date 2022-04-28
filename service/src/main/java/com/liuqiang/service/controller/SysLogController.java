package com.liuqiang.service.controller;

import com.github.pagehelper.PageInfo;
import com.liuqiang.commons.utils.ResultBody;
import com.liuqiang.model.bo.sys.SysLogBo;
import com.liuqiang.model.vo.sys.QueryVo;
import com.liuqiang.model.vo.sys.SysLogVo;
import com.liuqiang.service.service.sys.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 系统日志
 * @author LiuQiang
 * @date 10:29 上午
 */
@RestController
@RequestMapping("/syslog")
public class SysLogController {

    @Autowired
    private SysLogService sysLogService;

    //    @Log("条件查询系统日志")
    @GetMapping("condition")
    public ResultBody<PageInfo<SysLogBo>> condition(QueryVo queryVo, SysLogVo sysLogVo){

        return ResultBody.ok(sysLogService.condition(queryVo,sysLogVo));

    }
}
