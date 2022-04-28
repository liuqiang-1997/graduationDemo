package com.liuqiang.commons.excel;

import com.liuqiang.commons.excel.annotation.ExcelField;
import lombok.Data;

import java.util.Objects;


/**
 * 系统用户数据
 * @author LiuQiang
 * @date 4:10 下午
 */
@Data
public class UserData {

    /**
     * 登陆账号
     */
    @ExcelField(title = "用户账号")
    private String userNumber;
    /**
     * 用户名称
     */
    @ExcelField(title = "用户名称")
    private String userName;
    /**
     * 用户角色
     */
    @ExcelField(title = "用户角色")
    private Long roleId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserData userData = (UserData) o;
        return Objects.equals(userNumber, userData.userNumber) &&
                Objects.equals(userName, userData.userName) &&
                Objects.equals(roleId, userData.roleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userNumber, userName, roleId);
    }
}
