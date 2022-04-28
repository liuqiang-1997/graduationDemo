package com.liuqiang.model.entity.servicelogic;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 学生简历信息
 * @author LiuQiang
 * @date 1:49 上午
 */
@Data
@TableName("pms_resume")
public class Resume implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 简历ID
     */
    @TableField("resume_name")
    private String resumeName;
    /**
     * 简历存储地址
     */
    @TableField("resume_address")
    private String resumeAddress;
    /**
     * 简历所属人（对应学生学号）
     */
    @TableField("resume_user")
    private String resumeUser;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 修改时间
     */
    @TableField("update_time")
    private Date updateTime;
    /**
     * 分数
     */
    @TableField("grade")
    private Double grade;
}
