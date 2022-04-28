package com.liuqiang.service.service.impl.sys;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liuqiang.model.entity.sys.Specialty;
import com.liuqiang.service.mapper.sys.SpecialtyMapper;
import com.liuqiang.service.service.sys.SpecialtyService;
import org.springframework.stereotype.Service;

/**
 * 学院专业班级信息
 * @author LiuQiang
 */
@Service
public class SpecialtyServiceImpl extends ServiceImpl<SpecialtyMapper, Specialty>
        implements SpecialtyService {
}
