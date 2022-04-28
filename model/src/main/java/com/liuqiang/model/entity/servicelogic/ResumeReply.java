package com.liuqiang.model.entity.servicelogic;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 简历修订意见
 * @author LiuQiang
 * @date 1:30 上午
 */
@Data
@TableName("pms_resume_reply")
public class ResumeReply implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 简历id
     */
    @TableField("resume_name")
    private String resumeName;
    /**
     * 简历所属人（对应学生学号）
     */
    @TableField("resume_user")
    private String resumeUser;
    /**
     * 修订意见
     */
    @TableField("reply")
    private String reply;
    /**
     * 意见反馈人ID（对应教师编号）
     */
    @TableField("reply_id")
    private String replyId;
    /**
     * 反馈时间
     */
    @TableField("reply_time")
    private Date replyTime;
}
