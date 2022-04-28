package com.liuqiang.model.entity.user;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 学生信息
 * @author LiuQiang
 * @date 1:29 下午
 */
@Data
@TableName("sys_student")
public class StudentInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 学生账号
     */
    @TableField("stu_id")
    private String stuId;
    /**
     * 教师ID
     */
    @TableField("tea_id")
    private String teaId;
    /**
     * 辅导员ID
     */
    @TableField("cou_id")
    private String couId;
    /**
     * 所属学院编号
     */
    @TableField("collage_code")
    private String collageCode;
    /**
     * 所属专业编号
     */
    @TableField("specialty_code")
    private String specialtyCode;
    /**
     * 所属班级编号
     */
    @TableField("class_code")
    private String classCode;

}
