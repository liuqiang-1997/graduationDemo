package com.liuqiang.model.entity.user;

import lombok.Builder;
import lombok.Data;

/**
 * @author LiuQiang
 * @date 4:59 下午
 */
@Data
@Builder
public class LoginInfo {
    /**
     * 用户账号
     */
    private String userNumber;
    /**
     * 用户名称
     */
    private String userName;

}
