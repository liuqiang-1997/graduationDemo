package com.liuqiang.service.service.servicelogic;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liuqiang.commons.utils.ResultBody;
import com.liuqiang.model.bo.servicelogic.WorkProveBo;
import com.liuqiang.model.entity.servicelogic.WorkProve;
import com.liuqiang.model.vo.servicelogic.WorkProveVo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface WorkProveService extends IService<WorkProve> {
    Boolean saveWorkProve(WorkProveVo workProveVo, List<MultipartFile> file);

    WorkProveBo queryWorkProveInfo(String stuId);
}
