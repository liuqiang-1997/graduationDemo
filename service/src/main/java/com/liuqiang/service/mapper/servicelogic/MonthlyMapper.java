package com.liuqiang.service.mapper.servicelogic;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liuqiang.model.bo.data.MonthlyDataBo;
import com.liuqiang.model.entity.servicelogic.Monthly;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 实习月报
 * @author LiuQiang
 */
@Mapper
@Repository
public interface MonthlyMapper extends BaseMapper<Monthly> {
    List<MonthlyDataBo> getMonthlyData(@Param("teaId") String teaId, @Param("stuId") String stuId,
                                       @Param("stuName") String stuName,@Param("type")Integer type);
}
