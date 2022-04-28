package com.liuqiang.service.mapper.servicelogic;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liuqiang.model.entity.servicelogic.Interview;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 面试信息
 * @author LiuQiang
 */
@Mapper
@Repository
public interface InterviewMapper extends BaseMapper<Interview> {
    @MapKey("type")
    List<HashMap<String, Object>> selectCompanyType(@Param("stuId") String stuId, @Param("stuName") String stuName);

    @MapKey("source")
    List<HashMap<String, Object>> selectSource(@Param("stuId") String stuId, @Param("stuName") String stuName);

    @MapKey("pay")
    List<HashMap<String, Object>> selectPay(@Param("stuId") String stuId, @Param("stuName") String stuName);

    @MapKey("result")
    List<HashMap<String, Object>> selectResult(@Param("stuId") String stuId, @Param("stuName") String stuName);
}
