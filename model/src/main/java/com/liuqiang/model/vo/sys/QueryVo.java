package com.liuqiang.model.vo.sys;

import lombok.Data;

/**
 * @author LiuQiang
 * @date 12:10 上午
 */
@Data
public class QueryVo {
    public final static int DEFAULT_PAGE_NUM = 1;
    public final static int DEFAULT_PAGE_SIZE = 10;

    private String userNumber;

    private Integer pageNum = DEFAULT_PAGE_NUM;

    private Integer pageSize = DEFAULT_PAGE_SIZE;
}
