package com.liuqiang.service.service.impl.sys;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liuqiang.model.entity.sys.StuType;
import com.liuqiang.service.mapper.sys.StuTypeMapper;
import com.liuqiang.service.service.sys.StuTypeService;
import org.springframework.stereotype.Service;

/**
 * 学生类型
 * @author LiuQiang
 */
@Service
public class StuTypeServiceImpl extends ServiceImpl<StuTypeMapper, StuType>
        implements StuTypeService {
}
