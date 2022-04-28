package com.liuqiang.model.vo.servicelogic;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * @author LiuQiang
 * @date 10:50 上午
 */
@Data
public class CheckInfoVo implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键ID
     */
    private Long id;
    /**
     * 登陆账号
     */
    private String userNumber;
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 登陆密码
     */
    private String password;
    /**
     * 用户角色
     */
    private Long roleId;
    /**
     * 用户账号状态 0-正常；1-禁用
     */
    private Integer status;
}
