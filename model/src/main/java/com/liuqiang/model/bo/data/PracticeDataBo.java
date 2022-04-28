package com.liuqiang.model.bo.data;

import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 实习数据
 * @author LiuQiang
 */
@Data
public class PracticeDataBo {

    private String area;

    private Integer total;

//
//    /**
//     * 实习性质（0-参观实践/1-就业实习）
//     */
//    private List<Map<Integer,Integer>> nature;
//    /**
//     * 实习薪资
//     */
//    private List<Map<Integer,Integer>> pay;
//    /**
//     * 实习岗位
//     */
//    private List<Map<String,Integer>> job;
//    /**
//     * 面试轮数
//     */
//    private List<Map<Integer,Integer>> frequency;
//    /**
//     * 入职时间
//     */
//    private List<Map<String,Integer>> joinTime;

}
