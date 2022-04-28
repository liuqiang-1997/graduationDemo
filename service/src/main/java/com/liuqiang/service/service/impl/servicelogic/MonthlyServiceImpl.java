package com.liuqiang.service.service.impl.servicelogic;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liuqiang.commons.utils.MapperUtils;
import com.liuqiang.model.bo.data.MonthlyDataBo;
import com.liuqiang.model.bo.servicelogic.MonthlyBo;
import com.liuqiang.model.entity.servicelogic.Monthly;
import com.liuqiang.model.entity.user.StudentInfo;
import com.liuqiang.model.vo.servicelogic.MonthlyVo;
import com.liuqiang.model.vo.sys.QueryVo;
import com.liuqiang.service.mapper.servicelogic.MonthlyMapper;
import com.liuqiang.service.mapper.user.UserRelationMapper;
import com.liuqiang.service.service.servicelogic.FileOssService;
import com.liuqiang.service.service.servicelogic.MonthlyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Objects;

/**
 * 实习月报
 * @author LiuQiang
 */
@Service
public class MonthlyServiceImpl extends ServiceImpl<MonthlyMapper, Monthly>
        implements MonthlyService {

    @Autowired
    private FileOssService fileOssService;
    @Autowired
    private MonthlyMapper monthlyMapper;
    @Autowired
    private UserRelationMapper userRelationMapper;


    @Override
    public Boolean saveMonthly(MonthlyVo monthlyVo, MultipartFile file) {
        monthlyVo.setMonthlyAddress(fileOssService.fileUpload(file));
        Monthly monthly = MapperUtils.INSTANCE.map(Monthly.class, monthlyVo);
        return this.saveOrUpdate(monthly);
    }

    @Override
    public MonthlyBo queryMonthlyInfo(Integer id, String stuId) {
        QueryWrapper<Monthly> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",id).eq("monthly_id",stuId);
        return MapperUtils.INSTANCE.map(MonthlyBo.class,this.getOne(queryWrapper));
    }

    @Override
    public Boolean updateMonthlyGrade(Integer id,String stuId, Double grade) {
        UpdateWrapper<Monthly> wrapper = new UpdateWrapper<>();
        wrapper.eq("monthly_id",stuId).eq("id",id).set("grade",grade);
        return this.update(wrapper);
    }

    @Override
    public PageInfo<MonthlyBo> searchMonthly(QueryVo queryVo) {
        QueryWrapper<Monthly> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("monthly_id",queryVo.getUserNumber());
        PageHelper.startPage(queryVo.getPageNum(), queryVo.getPageSize());
        List<Monthly> monthlyList = baseMapper.selectList(queryWrapper);

        return new PageInfo<>(MapperUtils.INSTANCE.mapAsList(MonthlyBo.class,monthlyList));

    }

    @Override
    public PageInfo<MonthlyBo> queryMonthly(QueryVo queryVo,String stuId,Integer type) {
        PageHelper.startPage(queryVo.getPageNum(),queryVo.getPageSize());
        QueryWrapper<Monthly> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("monthly_id",stuId).eq("type",type);

        return new PageInfo<>(MapperUtils.INSTANCE.mapAsList(MonthlyBo.class,list(queryWrapper)));
    }

    @Override
    public List<MonthlyDataBo> getMonthlyData(String teaId, String stuId, String stuName,Integer type) {
        List<MonthlyDataBo> monthlyData = monthlyMapper.getMonthlyData(teaId, stuId, stuName, type);
        if (Objects.isNull(stuId) && Objects.isNull(stuName)){
            QueryWrapper<StudentInfo> wrapper = new QueryWrapper<>();
            wrapper.eq("tea_id",teaId);
            Integer count = userRelationMapper.selectCount(wrapper);
            monthlyData.forEach(t->{t.setNum(count);});
        }

        return monthlyData;
    }
}
