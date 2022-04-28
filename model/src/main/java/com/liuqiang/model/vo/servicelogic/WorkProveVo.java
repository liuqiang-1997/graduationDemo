package com.liuqiang.model.vo.servicelogic;

import lombok.Data;

/**
 * 就业证明
 * @author LiuQiang
 */
@Data
public class WorkProveVo {
    /**
     * 学生学号
     */
    private String stuId;
    /**
     * 学生姓名
     */
    private String stuName;
    /**
     * 三方协议
     */
    private String tripartite;
    /**
     * 劳动合同
     */
    private String laborContract;
    /**
     * 录用通知
     */
    private String offer;
    /**
     * 灵活就业证明
     */
    private String flexible;
    /**
     * 营业执照(法人资格)
     */
    private String permit;
}
