package com.liuqiang.service.mapper.sys;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liuqiang.model.bo.sys.PermissionsBo;
import com.liuqiang.model.entity.sys.Permissions;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 系统权限
 * @author LiuQiang
 */
@Mapper
@Repository
public interface PermissionsMapper extends BaseMapper<Permissions> {
    List<PermissionsBo> permissionList(@Param("name") String name, @Param("path") String path);

    List<PermissionsBo> selectByPermissionId(@Param("idList") List<Integer> idList);
}
