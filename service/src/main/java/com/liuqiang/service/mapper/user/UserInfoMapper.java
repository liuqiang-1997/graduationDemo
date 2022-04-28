package com.liuqiang.service.mapper.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liuqiang.model.bo.userinfo.UserBo;
import com.liuqiang.model.entity.user.UserInfo;
import com.liuqiang.model.vo.sys.QueryVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 系统用户
 * @author LiuQiang
 */
@Mapper
@Repository
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    List<UserBo> queryUserInfo(@Param("queryVo") QueryVo queryVo,@Param("userId") String userId);
}
