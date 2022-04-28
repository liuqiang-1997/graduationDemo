package com.liuqiang.model.entity.servicelogic;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 学生面试信息
 * @author LiuQiang
 * @date 1:23 上午
 */
@Data
@TableName("pms_interview")
public class Interview implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 学生学号
     */
    @TableField("stu_id")
    private String stuId;
    /**
     * 学生姓名
     */
    @TableField("stu_name")
    private String stuName;
    /**
     * 面试单位
     */
    @TableField("company")
    private String company;
    /**
     * 单位性质 0-国企；1-私企；2-机关单位
     */
    @TableField("company_type")
    private Integer companyType;
    /**
     * 面试岗位
     */
    @TableField("job")
    private String job;
    /**
     * 面试来源
     */
    @TableField("source")
    private String source;
    /**
     * 面试薪资
     */
    @TableField("pay")
    private Double pay;
    /**
     * 简历投递时间
     */
    @TableField("send_time")
    private Date sendTime;
    /**
     * 面试邀请时间
     */
    @TableField("invite_time")
    private Date inviteTime;
    /**
     * 面试结果（0-面试/1-入职/2-无响应）
     */
    @TableField("result")
    private Integer result;
    /**
     * 分数
     */
    @TableField("grade")
    private Double grade;
}
