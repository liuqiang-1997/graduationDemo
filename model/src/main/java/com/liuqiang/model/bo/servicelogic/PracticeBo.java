package com.liuqiang.model.bo.servicelogic;

import lombok.Data;

import java.util.Date;

/**
 * 实习信息详情
 * @author LiuQiang
 */
@Data
public class PracticeBo {
    /**
     * id
     */
    private Integer id;
    /**
     * 学生学号
     */
    private String stuId;
    /**
     * 学生姓名
     */
    private String stuName;
    /**
     * 实习公司
     */
    private String company;
    /**
     * 实习性质（0-参观实践/1-就业实习）
     */
    private Integer nature;
    /**
     * 实习薪资
     */
    private Double pay;
    /**
     * 实习岗位
     */
    private String job;
    /**
     * 入职时间
     */
    private Date joinTime;
    /**
     * 面试轮数
     */
    private Integer frequency;
    /**
     * 离职时间
     */
    private Date leaveTime;
    /**
     * 离职原因
     */
    private String leaveReason;

}
