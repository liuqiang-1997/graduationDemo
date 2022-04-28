package com.liuqiang.model.entity.servicelogic;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 考研考公成绩证明
 * @author LiuQiang
 */
@Data
@TableName("pms_score_prove")
public class ScoreProve implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 成绩提交人
     */
    @TableField("user_name")
    private String userName;
    /**
     * 成绩证明
     */
    @TableField("prove")
    private String prove;
    /**
     * 提交时间
     */
    @TableField("send_time")
    private Date sendTime;
    /**
     * 分数
     */
    @TableField("grade")
    private Double grade;
    /**
     * 类型 0-考研；1-考公
     */
    @TableField("type")
    private Integer type;
}
