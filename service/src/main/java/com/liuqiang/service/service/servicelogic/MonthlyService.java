package com.liuqiang.service.service.servicelogic;

import com.baomidou.mybatisplus.extension.service.IService;

import com.github.pagehelper.PageInfo;
import com.liuqiang.model.bo.data.MonthlyDataBo;
import com.liuqiang.model.bo.servicelogic.MonthlyBo;
import com.liuqiang.model.entity.servicelogic.Monthly;
import com.liuqiang.model.vo.servicelogic.MonthlyVo;
import com.liuqiang.model.vo.sys.QueryVo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 月报/总结
 * @author liuqiang
 */
public interface MonthlyService extends IService<Monthly> {
    Boolean saveMonthly(MonthlyVo monthlyVo, MultipartFile file);

    MonthlyBo queryMonthlyInfo(Integer id, String stuId);

    Boolean updateMonthlyGrade(Integer id,String stuId, Double grade);

    PageInfo<MonthlyBo> searchMonthly(QueryVo queryVo);
    /**
     * 查询名下学生月报信息
     * @param queryVo 查询参数
     * @return 列表
     */
    PageInfo<MonthlyBo> queryMonthly(QueryVo queryVo,String stuId,Integer type);

    List<MonthlyDataBo> getMonthlyData(String teaId, String stuId, String stuName,Integer type);
}
