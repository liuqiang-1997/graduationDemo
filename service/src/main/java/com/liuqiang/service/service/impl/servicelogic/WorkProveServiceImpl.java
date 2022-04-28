package com.liuqiang.service.service.impl.servicelogic;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liuqiang.commons.utils.MapperUtils;
import com.liuqiang.model.bo.servicelogic.WorkProveBo;
import com.liuqiang.model.entity.servicelogic.WorkProve;
import com.liuqiang.model.vo.servicelogic.WorkProveVo;
import com.liuqiang.service.mapper.servicelogic.WorkProveMapper;
import com.liuqiang.service.service.servicelogic.FileOssService;
import com.liuqiang.service.service.servicelogic.WorkProveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 学生就业证明
 * @author LiuQiang
 */
@Service
public class WorkProveServiceImpl extends ServiceImpl<WorkProveMapper, WorkProve>
        implements WorkProveService {

    @Autowired
    private FileOssService fileOssService;

    @Override
    public Boolean saveWorkProve(WorkProveVo workProveVo, List<MultipartFile> file) {
        // todo 批量上传返回对应地址
        return null;
    }

    @Override
    public WorkProveBo queryWorkProveInfo(String stuId) {
        QueryWrapper<WorkProve> wrapper = new QueryWrapper<>();
        wrapper.eq("stu_id",stuId);
        return MapperUtils.INSTANCE.map(WorkProveBo.class,this.getOne(wrapper));
    }
}
