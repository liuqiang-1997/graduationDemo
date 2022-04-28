package com.liuqiang.model.bo.servicelogic;

import lombok.Data;

import java.util.Date;

/**
 * 月报/总结
 * @author LiuQiang
 */
@Data
public class MonthlyBo {
    /**
     * id
     */
    private Integer id;
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
     * 类型（0-月报；1-证明）
     */
    private Integer type;
}
