package com.liuqiang.model.vo.sys;

;
import lombok.Data;

/**
 * 学院专业班级信息
 * @author LiuQiang
 * @date 12:50 上午
 */
@Data
public class SpecialtyVo {
    /**
     * 主键ID
     */
    private Long id;
    /**
     * 父级编号
     */
    private Integer parentCode;
    /**
     * 节点名称
     */
    private String nodeName;
    /**
     * 备注
     */
    private String remark;
    /**
     * 状态 0-正常；1-禁用
     */
    private Integer status;


}
