package com.liuqiang.service.service.impl.servicelogic;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liuqiang.commons.utils.MapperUtils;
import com.liuqiang.model.bo.servicelogic.ScoreProveBo;
import com.liuqiang.model.entity.servicelogic.ScoreProve;
import com.liuqiang.model.vo.servicelogic.ScoreProveVo;
import com.liuqiang.service.mapper.servicelogic.ScoreProveMapper;
import com.liuqiang.service.service.servicelogic.FileOssService;
import com.liuqiang.service.service.servicelogic.ScoreProveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * 考公考研成绩证明
 * @author LiuQiang
 */
@Service
public class ScoreProveServiceImpl extends ServiceImpl<ScoreProveMapper, ScoreProve>
        implements ScoreProveService {

    @Autowired
    private FileOssService fileOssService;

    @Override
    public Boolean saveScoreProve(ScoreProveVo scoreProveVo, MultipartFile file) {
        scoreProveVo.setProve(fileOssService.fileUpload(file));
        return this.saveOrUpdate(MapperUtils.INSTANCE.map(ScoreProve.class, scoreProveVo));
    }

    @Override
    public ScoreProveBo queryScoreProveInfo(String stuId) {
        QueryWrapper<ScoreProve> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name",stuId);
        return MapperUtils.INSTANCE.map(ScoreProveBo.class,this.getOne(queryWrapper));
    }
}
