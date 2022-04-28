package com.liuqiang.model.bo.servicelogic;

import lombok.Data;

import java.util.Date;

/**
 * 学生面试信息详情
 * @author LiuQiang
 */
@Data
public class InterviewBo {
    /**
     * id
     */
    private Long id;
    /**
     * 学生姓名
     */
    private String stuName;
    /**
     * 面试单位
     */
    private String company;
    /**
     * 单位类型
     */
    private String companyType;
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
