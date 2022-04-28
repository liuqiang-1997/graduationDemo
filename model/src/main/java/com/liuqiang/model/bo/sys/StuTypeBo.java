package com.liuqiang.model.bo.sys;

import lombok.Data;

/**
 * 学生类型
 * @author LiuQiang
 */
@Data
public class StuTypeBo {
    /**
     * 学生类型ID
     */
    private Integer typeId;
    /**
     * 类型名称
     */
    private String typeName;
    /**
     * 状态 0-正常；1-禁用
     */
    private Integer status;
}
