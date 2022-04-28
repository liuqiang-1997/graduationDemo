package com.liuqiang.service.mapper.servicelogic;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liuqiang.model.bo.data.PracticeDataBo;
import com.liuqiang.model.entity.servicelogic.Practice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 实习信息
 * @author LiuQiang
 */
@Mapper
@Repository
public interface PracticeMapper extends BaseMapper<Practice> {

    List<PracticeDataBo> queryPayDate(@Param("stuId") String stuId,@Param("stuName") String stuName);
}
