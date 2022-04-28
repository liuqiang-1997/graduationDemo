package com.liuqiang.service.service.impl.servicelogic;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liuqiang.commons.utils.MapperUtils;
import com.liuqiang.model.bo.servicelogic.PracticeBo;
import com.liuqiang.model.bo.data.PracticeDataBo;
import com.liuqiang.model.entity.servicelogic.Practice;
import com.liuqiang.model.vo.servicelogic.PracticeVo;
import com.liuqiang.model.vo.sys.QueryVo;
import com.liuqiang.service.mapper.servicelogic.PracticeMapper;
import com.liuqiang.service.service.servicelogic.PracticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * 实习信息
 * @author LiuQiang
 */
@Service
public class PracticeServiceImpl extends ServiceImpl<PracticeMapper, Practice>
        implements PracticeService {

    @Autowired
    private PracticeMapper practiceMapper;
    @Autowired
    private PracticeService practiceService;

    @Override
    public Boolean saveOrUpdatePractice(PracticeVo practiceVo) {
        return this.saveOrUpdate( MapperUtils.INSTANCE.map(Practice.class,practiceVo));
    }

    @Override
    public List<PracticeBo> searchPractice(String stuId) {
        QueryWrapper<Practice> wrapper = new QueryWrapper<>();
        wrapper.eq("stu_id",stuId);
        List<Practice> practices = baseMapper.selectList(wrapper);
        return MapperUtils.INSTANCE.mapAsList(PracticeBo.class, practices);
    }

    @Override
    public PageInfo<PracticeBo> queryPractice(QueryVo queryVo, String stuId) {
        PageHelper.startPage(queryVo.getPageNum(),queryVo.getPageSize());
        QueryWrapper<Practice> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("stu_id",stuId);
        return new PageInfo<>(MapperUtils.INSTANCE.mapAsList(PracticeBo.class,practiceService.list(queryWrapper)));
    }

    @Override
    public PracticeBo queryPracticeInfo(Integer id, String stuId) {
        HashMap<String, Object> map = new HashMap<>(2);
        map.put("id",id);
        map.put("stu_id",stuId);
        QueryWrapper<Practice> wrapper = new QueryWrapper<>();
        wrapper.allEq(map);
        return MapperUtils.INSTANCE.map(PracticeBo.class,baseMapper.selectOne(wrapper));
    }

    @Override
    public Boolean deletePractice(Integer id, String stuId) {
        HashMap<String, Object> map = new HashMap<>(2);
        map.put("id",id);
        map.put("stu_id",stuId);
        return this.removeByMap(map);
    }

    @Override
    public Boolean updatePracticeGrade(Integer id,String stuId, Double grade) {
        UpdateWrapper<Practice> wrapper = new UpdateWrapper<>();
        wrapper.eq("stu_id",stuId).eq("id",id).set("grade",grade);
        return this.update(wrapper);
    }

    @Override
    public List<PracticeDataBo> queryPracticeData(String stuId,String stuName) {
        return practiceMapper.queryPayDate(stuId,stuName);

    }


}
