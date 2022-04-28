package com.liuqiang.model.vo.servicelogic;

import lombok.Data;

import java.util.Date;

/**
 * 月报/总结信息
 * @author LiuQiang
 */
@Data
public class MonthlyVo {
    /**
     * 主键ID
     */
    private Long id;
    /**
     * 月报所属人ID
     */
    private String monthlyId;
    /**
     * 月报存储地址
     */
    private String monthlyAddress;
    /**
     * 月报提交时间
     */
    private Date sendTime;
    /**
     * 类型（0-月报；1-总结；2-申请；3-实习任务书）
     */
    private Integer type;
}
