package com.liuqiang.model.entity.servicelogic;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 实习月报/实习证明
 * @author LiuQiang
 * @date 4:06 下午
 */
@Data
@TableName("pms_monthly")
public class Monthly implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO )
    private Long id;
    /**
     * 月报所属人ID
     */
    @TableField("monthly_id")
    private String monthlyId;
    /**
     * 月报存储地址
     */
    @TableField("monthly_address")
    private String monthlyAddress;
    /**
     * 月报提交时间
     */
    @TableField("send_time")
    private Date sendTime;
    /**
     * 类型（0-月报；1-证明）
     */
    @TableField("type")
    private Integer type;
    /**
     * 分数
     */
    @TableField("grade")
    private Double grade;
}
