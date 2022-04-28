package com.liuqiang.model.bo.servicelogic;

import lombok.Data;

import java.util.Date;

/**
 * 简历详情信息
 * @author LiuQiang
 */
@Data
public class ResumeBo {
    /**
     * 简历名称
     */
    private String resumeName;
    /**
     * 简历存储地址
     */
    private String resumeAddress;
    /**
     * 简历所属人（对应学生学号）
     */
    private String resumeUser;
    /**
     * 创建时间
     */
    private Date createTime;
}
