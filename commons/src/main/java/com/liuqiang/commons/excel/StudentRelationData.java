package com.liuqiang.commons.excel;

import com.liuqiang.commons.excel.annotation.ExcelField;
import lombok.Data;

/**
 * 学生关系
 * @author LiuQiang
 * @date 4:04 下午
 */
@Data
public class StudentRelationData {
    /**
     * 学生账号
     */
    @ExcelField(title = "学生学号")
    private String stuId;
    /**
     * 教师ID
     */
    @ExcelField(title = "教师工号")
    private String teaId;
    /**
     * 辅导员ID
     */
    @ExcelField(title = "辅导员工号")
    private String couId;
    /**
     * 所属学院编号
     */
    @ExcelField(title = "学院编号")
    private String collageCode;
    /**
     * 所属专业编号
     */
    @ExcelField(title = "专业编号")
    private String specialtyCode;
    /**
     * 所属班级编号
     */
    @ExcelField(title = "班级编号")
    private String classCode;

}
