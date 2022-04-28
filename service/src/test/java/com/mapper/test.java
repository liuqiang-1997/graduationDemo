package com.mapper;

import com.liuqiang.service.mapper.sys.RolePermissionsMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author LiuQiang
 * @date 10:29 下午
 */

public class test {

    @Autowired
    private RolePermissionsMapper rolePermissionsMapper;

    @Test
    public void test1(){
        List<String> rolePermissions = rolePermissionsMapper.getRolePermissions(1L);
        System.out.println(rolePermissions);
    }
}
