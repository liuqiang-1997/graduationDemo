package com.liuqiang.model.bo.userinfo;

import com.liuqiang.model.entity.user.UserInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 学生个人信息
 * @author LiuQiang
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentBo {
    /**
     * 学生学号
     */
    private String userNumber;
    /**
     * 学生名称
     */
    private String userName;
    /**
     * 指导教师信息
     */
    private UserInfo teacher;
    /**
     * 辅导员信息
     */
    private UserInfo counselor;
    /**
     * 所属学院编号
     */
    private String collageCode;
    /**
     * 所属专业编号
     */
    private String specialtyCode;
    /**
     * 所属班级编号
     */
    private String classCode;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * qq号
     */
    private String qqNumber;
    /**
     * 微信号
     */
    private String vxNumber;

}
