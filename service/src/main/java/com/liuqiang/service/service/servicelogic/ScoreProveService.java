package com.liuqiang.service.service.servicelogic;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liuqiang.model.bo.servicelogic.ScoreProveBo;
import com.liuqiang.model.entity.servicelogic.ScoreProve;
import com.liuqiang.model.vo.servicelogic.ScoreProveVo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 考公考研成绩证明
 * @author LiuQiang
 */
public interface ScoreProveService extends IService<ScoreProve> {
    /**
     * 新增修改
     * @param scoreProveVo 实体参数
     * @param file 证明文件
     * @return boolen
     */
    Boolean saveScoreProve(ScoreProveVo scoreProveVo, MultipartFile file);

    /**
     * 根据学号查询
     * @param stuId 学号
     * @return 成绩证明信息
     */
    ScoreProveBo queryScoreProveInfo(String stuId);
}
