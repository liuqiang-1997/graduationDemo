package com.liuqiang.service.controller;

import com.github.pagehelper.PageInfo;
import com.liuqiang.commons.utils.ResultBody;
import com.liuqiang.model.bo.userinfo.StudentBo;
import com.liuqiang.model.bo.userinfo.StudentListBo;
import com.liuqiang.model.bo.userinfo.UserBo;
import com.liuqiang.model.vo.sys.QueryVo;
import com.liuqiang.model.vo.user.InfoVo;
import com.liuqiang.service.log.Log;
import com.liuqiang.service.service.sys.CheckService;
import com.liuqiang.service.service.user.UserRelationService;
import com.liuqiang.service.service.user.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * 用户个人信息
 * @author LiuQiang
 * @date 10:22 上午
 */
@Slf4j
@RestController
@RequestMapping("/user/info")
public class UserController {

    /**
     * 上传文件的最大限制（单位 ）
     **/
    private static final int MAX_UPLOAD_IMG_SIZE = 10;

    @Autowired
    private CheckService checkService;

    @Autowired
    private UserRelationService userRelationService;

    @Autowired
    private UserInfoService userInfoService;

    // todo 查询接口冗余
    /**
     * 查询所有用户联系信息
     * @param userId 模糊条件 用户账号
     * @param queryVo userNumber 必填  操作人账号
     * @return 用户联系信息
     */
    @GetMapping("/search")
    public ResultBody<PageInfo<UserBo>> queryUserInfo(QueryVo queryVo,
            @RequestParam(value = "userId",required = false) String userId){
        return ResultBody.ok(userInfoService.queryUserInfo(queryVo,userId));
    }

    /**
     * 个人查询用户联系信息
     * @param userNumber 用户账号
     * @return 用户联系信息
     */
    @GetMapping("/info")
    public ResultBody<UserBo> queryTeaInfo(@RequestParam("userNumber") String userNumber){
        return ResultBody.ok(userInfoService.queryManagerInfo(userNumber));
    }

    /**
     * 查看学生信息详情
     * @param stuId 学生学号
     * @return 详情信息
     */
//    @Log("查询学生个人详情")
    @GetMapping("/studentInfo")
    public ResultBody<StudentBo> queryStudentInfo(@RequestParam("stuId") String stuId){

        return ResultBody.ok(userInfoService.queryStudentInfo(stuId));
    }

    /**
     * 分页查看学生列表
     * @param queryVo 请求参数
     * @return 学生列表
     */
    @GetMapping("/studentList")
    public ResultBody<PageInfo<StudentListBo>> queryStudentList(QueryVo queryVo,
                                                                @RequestParam(value = "stuId",required = false)String stuId){
        return ResultBody.ok(userInfoService.queryStudentList(queryVo,stuId));
    }


    //    @Log("新增/修改用户联系方式")
    @PostMapping("/save")
    public ResultBody<Boolean> save(@RequestBody InfoVo infoVo){
        Boolean aBoolean = userInfoService.saveUpdate(infoVo);
        if (aBoolean) {
            return ResultBody.ok(aBoolean);
        }
        return ResultBody.fail("失败",aBoolean);
    }

    /**
     * 批量导出(0-系统用户；1-学生关系；2-用户联系方式)
     */
//    @Log("系统数据导出")
    @GetMapping("exports/{type}")
    public void exportData(HttpServletResponse response, @PathVariable("type") Integer type)
            throws IOException {

        switch (type){
            case 0:
                checkService.export(response);
                break;
            case 1:
                userRelationService.export(response);
                break;
            case 2:
                userInfoService.export(response);
                break;
            default:
                break;
        }

    }

    /**
     * 批量导入
     * @param file 导入的数据
     * @param type 导入数据类型(0-系统用户；1-学生关系；2-用户联系方式)
     * @return 导入结果
     */
//    @Log("系统数据导入")
    @PostMapping("/imports/{type}")
    public ResultBody<String> importData(@PathVariable("type") Integer type,
                                         @RequestParam("file") MultipartFile file) throws Exception {
        if (Objects.nonNull(file)) {
            long size = file.getSize();
            log.info("accessing to upload fileName = {}, size = {}", file.getOriginalFilename(), size);
            double K = (double) size / 1048576;
            if (K > MAX_UPLOAD_IMG_SIZE) {
                log.info("上传文件过大，为{}m，超过设置值{}m", K, MAX_UPLOAD_IMG_SIZE);
                return ResultBody.fail(500,"上传文件过大，请上传不超过" + MAX_UPLOAD_IMG_SIZE + "m大小的文件");
            }

            // 导入(0-系统用户；1-学生关系；2-用户联系方式)
            switch (type){
                case 0:
                    checkService.imports(file);
                    break;
                case 1:
                    userRelationService.imports(file);
                    break;
                case 2:
                    userInfoService.imports(file);
                    break;
                default:
                    break;
            }

            return ResultBody.ok("导入成功");
        }
        return ResultBody.fail("导入失败","false");
    }




}
