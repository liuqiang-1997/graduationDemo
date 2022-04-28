package com.liuqiang.model.entity.sys;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 学院专业信息
 * @author LiuQiang
 */
@Data
@TableName("pms_specialty")
public class Specialty implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 父级编号
     */
    @TableField("parent_code")
    private Integer parentCode;
    /**
     * 节点名称
     */
    @TableField("node_name")
    private String nodeName;
    /**
     * 备注
     */
    @TableField("remark")
    private String remark;
    /**
     * 状态 0-正常；1-禁用
     */
    @TableField("status")
    private Integer status;
}
