package com.liuqiang.service.mapper.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liuqiang.model.bo.userinfo.StudentListBo;
import com.liuqiang.model.entity.user.StudentInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * 学生
 * @author LiuQiang
 */
@Mapper
@Repository
public interface UserRelationMapper extends BaseMapper<StudentInfo> {

    List<StudentListBo> getList(@Param("userNumber") String userNumber, @Param("stuId") String stuId);
}
