package com.liuqiang.service.service.servicelogic;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.liuqiang.model.bo.servicelogic.PracticeBo;
import com.liuqiang.model.bo.data.PracticeDataBo;
import com.liuqiang.model.entity.servicelogic.Practice;
import com.liuqiang.model.vo.servicelogic.PracticeVo;
import com.liuqiang.model.vo.sys.QueryVo;

import java.util.List;

/**
 * 实习信息
 * @author liuqiang
 */
public interface PracticeService extends IService<Practice> {


    /**
     * 新增修改实习信息
     * @param practiceVo 实习信息
     * @return 成功记录数
     */
    Boolean saveOrUpdatePractice(PracticeVo practiceVo);

    List<PracticeBo> searchPractice(String stuId);

    PracticeBo queryPracticeInfo(Integer id, String stuId);
    /**
     * 查询名下学生实习信息
     * @param queryVo 查询参数
     * @return 分页列表
     */
    PageInfo<PracticeBo> queryPractice(QueryVo queryVo, String stuId);

    Boolean deletePractice(Integer id, String stuId);

    Boolean updatePracticeGrade(Integer id,String stuId, Double grade);

    /**
     * 查询学生实习薪资
     * @return 具体数据
     */
    List<PracticeDataBo> queryPracticeData(String stuId,String stuName);


}
