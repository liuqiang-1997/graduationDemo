package com.liuqiang.model.bo.servicelogic;

import lombok.Data;

import java.util.Date;

/**
 * 学生简历修订信息
 * @author LiuQiang
 */
@Data
public class ResumeReplyBo {
    /**
     * 简历存储地址
     */
    private String resumeAddress;
    /**
     * 修订意见
     */
    private String reply;
    /**
     * 意见反馈人ID（对应教师编号）
     */
    private String replyId;
    /**
     * 反馈时间
     */
    private Date replyTime;
}
