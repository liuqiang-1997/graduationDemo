package com.liuqiang.model.vo.servicelogic;

import lombok.Data;

/**
 * 考公考研成绩证明
 * @author LiuQiang
 */
@Data
public class ScoreProveVo {
    /**
     * 主键ID
     */
    private Long id;
    /**
     * 成绩提交人
     */
    private String userName;
    /**
     * 成绩证明
     */
    private String prove;
    /**
     * 类型 0-考研；1-考公
     */
    private Integer type;
}
