package com.liuqiang.model.bo.servicelogic;

import lombok.Data;

import java.util.Date;

/**
 * 考公考研成绩证明
 * @author LiuQiang
 */
@Data
public class ScoreProveBo {

    /**
     * 主键ID
     */
    private Long id;
    /**
     * 成绩提交人
     */
    private String userName;
    /**
     * 成绩证明
     */
    private String prove;
    /**
     * 提交时间
     */
    private Date sendTime;
    /**
     * 分数
     */
    private Double grade;
    /**
     * 类型 0-考研；1-考公
     */
    private Integer type;
}
