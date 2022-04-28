package com.liuqiang.service.controller;

import com.liuqiang.commons.utils.ResultBody;
import com.liuqiang.service.service.sys.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 学院专业班级信息
 * @author LiuQiang
 * @date 10:25 上午
 */
@RestController
@RequestMapping("/specialty")
public class SpecialtyController {

    @Autowired
    private SpecialtyService specialtyService;

    @PostMapping("/save")
    public ResultBody saveSpecialty(){

        return null;
    }
}
