package com.liuqiang.model.vo.servicelogic;

import lombok.Data;

import java.util.Date;

/**
 * 简历修订意见
 * @author LiuQiang
 */
@Data
public class ResumeReplyVo {
    /**
     * id
     */
    private Long id;
    /**
     * 简历id
     */
    private String resumeName;
    /**
     * 简历所属人（对应学生学号）
     */
    private String resumeUser;
    /**
     * 修订意见
     */
    private String reply;
    /**
     * 意见反馈人ID（对应教师编号）
     */
    private String replyId;

}
