package com.liuqiang.model.vo.user;

import com.liuqiang.model.entity.user.UserInfo;
import lombok.Data;

/**
 * @author LiuQiang
 * @date 10:27 上午
 */
@Data
public class StudentVo {
    /**
     * id
     */
    private Integer id;
    /**
     * 学生学号
     */
    private String stuId;
    /**
     * 指导教师信息
     */
    private String teaId;
    /**
     * 辅导员信息
     */
    private String couId;
    /**
     * 所属学院编号
     */
    private Integer collageCode;
    /**
     * 所属专业编号
     */
    private Integer specialtyCode;
    /**
     * 所属班级编号
     */
    private Integer classCode;

}
