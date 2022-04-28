package com.liuqiang.model.entity.servicelogic;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 学生就业证明
 * @author LiuQiang
 * @date 1:35 上午
 */
@Data
@TableName("pms_work")
public class WorkProve implements Serializable {
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
     * 学生姓名
     */
    @TableField("stu_name")
    private String stuName;
    /**
     * 三方协议
     */
    @TableField("tripartite")
    private String tripartite;
    /**
     * 劳动合同
     */
    @TableField("labor_contract")
    private String laborContract;
    /**
     * 录用通知
     */
    @TableField("offer")
    private String offer;
    /**
     * 灵活就业证明
     */
    @TableField("flexible")
    private String flexible;
    /**
     * 营业执照(法人资格)
     */
    @TableField("permit")
    private String permit;
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
    /**
     * 分数
     */
    @TableField("grade")
    private Double grade;

}
