package com.liuqiang.model.entity.servicelogic;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 学生实习信息
 * @author LiuQiang
 * @date 1:41 上午
 */
@Data
@TableName("pms_practice")
public class Practice implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * id
     */
    @TableId(type= IdType.AUTO)
    private Long id;
    /**
     * 学生学号
     */
    @TableField("stu_id")
    private String stuId;
    /**
     * 学生姓名
     */
    @TableField("stu_name")
    private String stuName;
    /**
     * 实习公司
     */
    @TableField("company")
    private String company;
    /**
     * 实习性质（0-参观实践/1-就业实习）
     */
    @TableField("nature")
    private Integer nature;
    /**
     * 实习薪资
     */
    @TableField("pay")
    private Double pay;
    /**
     * 实习岗位
     */
    @TableField("job")
    private String job;
    /**
     * 入职时间
     */
    @TableField("join_time")
    private Date joinTime;
    /**
     * 面试轮数
     */
    @TableField("frequency")
    private Integer frequency;
    /**
     * 离职时间
     */
    @TableField("leave_time")
    private Date leaveTime;
    /**
     * 离职原因
     */
    @TableField("leave_reason")
    private String leaveReason;
    /**
     * 分数
     */
    @TableField("grade")
    private Integer grade;


}
