package com.liuqiang.service.check;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liuqiang.commons.config.security.LoginUserDetails;
import com.liuqiang.model.entity.servicelogic.CheckInfo;

import com.liuqiang.service.mapper.sys.CheckMapper;
import com.liuqiang.service.mapper.sys.RolePermissionsMapper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * 用户信息检查
 * @author LiuQiang
 * @date 6:47 下午
 */
@Slf4j
@Service
public class UserCheckServiceImpl implements UserDetailsService {

    @Autowired
    private CheckMapper checkMapper;

    @Autowired
    private RolePermissionsMapper rolePermissionsMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        QueryWrapper<CheckInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("user_number",s);
        CheckInfo checkInfo = checkMapper.selectOne(wrapper);
        if (Objects.isNull(checkInfo)){
            throw new UsernameNotFoundException("用户名不存在");
        }
        // 查询对应权限
        List<String> rolePermissions = rolePermissionsMapper.getRolePermissions(checkInfo.getRoleId());

        return new LoginUserDetails(checkInfo,rolePermissions);
    }


}
