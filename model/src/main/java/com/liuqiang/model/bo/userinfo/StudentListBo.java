package com.liuqiang.model.bo.userinfo;

import lombok.Data;

/**
 * @author LiuQiang
 * @date 9:24 下午
 */
@Data
public class StudentListBo {

    /**
     * 学生学号
     */
    private String stuId;
    /**
     * 学生姓名
     */
    private String stuName;
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

}
