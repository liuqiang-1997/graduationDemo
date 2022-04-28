package com.liuqiang.model.bo.data;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 面试信息数据
 * @author LiuQiang
 */
@Data
public class InterviewDataBo implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 面试信息来源
     */
    private List<HashMap<String,Object>> source;
    /**
     * 面试薪资
     */
    private List<HashMap<String,Object>> pay;
    /**
     * 面试单位性质0-国企；1-私企；2-机关单位
     */
    private List<HashMap<String,Object>> companyType;

    /**
     * 面试结果
     */
    private List<HashMap<String,Object>> result;
}
