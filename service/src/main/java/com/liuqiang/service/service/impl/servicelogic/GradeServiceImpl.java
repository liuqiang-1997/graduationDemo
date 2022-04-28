package com.liuqiang.service.service.impl.servicelogic;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liuqiang.model.entity.servicelogic.Grade;
import com.liuqiang.service.mapper.servicelogic.GradeMapper;
import com.liuqiang.service.service.servicelogic.GradeService;
import org.springframework.stereotype.Service;

/**
 * 学分成绩
 * @author LiuQiang
 */
@Service
public class GradeServiceImpl extends ServiceImpl<GradeMapper, Grade>
        implements GradeService {
}
