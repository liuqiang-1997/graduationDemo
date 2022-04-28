package com.liuqiang.model.vo.servicelogic;

import lombok.Data;

/**
 * 学生简历
 * @author LiuQiang
 */
@Data
public class ResumeVo {
    /**
     * 主键ID
     */
    private Long id;
    /**
     * 简历ID
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
}
