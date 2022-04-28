package com.liuqiang.model.vo.servicelogic;

import lombok.Data;

import java.util.Date;

/**
 * 面试信息
 * @author LiuQiang
 */
@Data
public class InterviewVo {
    /**
     * 主键ID
     */
    private Long id;
    /**
     * 学生学号
     */
    private String stuId;
    /**
     * 学生姓名
     */
    private String stuName;
    /**
     * 面试单位
     */
    private String company;
    /**
     * 单位性质 0-国企；1-私企；2-机关单位
     */
    private Integer companyType;
    /**
     * 面试岗位
     */
    private String job;
    /**
     * 面试来源
     */
    private String source;
    /**
     * 面试薪资
     */
    private Double pay;
    /**
     * 简历投递时间
     */
    private Date sendTime;
    /**
     * 面试邀请时间
     */
    private Date inviteTime;
    /**
     * 面试结果（0-面试/1-入职/2-无响应）
     */
    private Integer result;
}
