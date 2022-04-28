package com.liuqiang.model.entity.servicelogic;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 学生学分成绩信息
 * @author LiuQiang
 * @date 1:54 上午
 */
@Data
@TableName("pms_grade")
public class Grade implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 学生学号
     */
    @TableField("stu_id")
    private String stuId;
    /**
     * 学生类型
     */
    @TableField("type_id")
    private Long typeId;
    /**
     * 实习分数
     */
    @TableField("practice_grade")
    private Double practiceGrade;
    /**
     * 学分成绩
     */
    @TableField("grade")
    private Double grade;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 修改时间
     */
    @TableField("update_time")
    private Date updateTime;
}
