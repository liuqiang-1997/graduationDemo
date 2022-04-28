package com.liuqiang.model.bo.data;

import lombok.Data;

/**
 * 月报总结数据
 * @author LiuQiang
 * @date 10:56 上午
 */
@Data
public class MonthlyDataBo {
    /**
     * 提交时间
     */
    private String sendTime;
    /**
     * 提交数
     */
    private Integer total;
    /**
     * 应提交数
     */
    private Integer num;
}
