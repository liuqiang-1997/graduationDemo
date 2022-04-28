package com.liuqiang.commons.excel;


import com.liuqiang.commons.excel.annotation.ExcelField;
import lombok.Data;


/**
 * 系统用户联系方式数据
 * @author LiuQiang
 * @date 3:29 下午
 */
@Data
public class RelationData {

    /**
     * 用户账号
     */
    @ExcelField(title = "用户账号")
    private String userNumber;
    /**
     * 用户名称
     */
    @ExcelField(title = "用户名称")
    private String userName;
    /**
     * 邮箱
     */
    @ExcelField(title = "用户邮箱")
    private String email;
    /**
     * 手机号
     */
    @ExcelField(title = "手机号码")
    private String mobile;
    /**
     * qq号
     */
    @ExcelField(title = "QQ号码")
    private String qqNumber;
    /**
     * 微信号
     */
    @ExcelField(title = "微信号码")
    private String vxNumber;

    // todo 操作人
    private String createUserId;

}
