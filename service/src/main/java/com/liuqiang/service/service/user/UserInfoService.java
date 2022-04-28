package com.liuqiang.service.service.user;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.liuqiang.model.bo.servicelogic.InterviewBo;
import com.liuqiang.model.bo.userinfo.UserBo;
import com.liuqiang.model.bo.userinfo.StudentBo;
import com.liuqiang.model.bo.userinfo.StudentListBo;
import com.liuqiang.model.vo.sys.QueryVo;
import com.liuqiang.model.entity.user.UserInfo;
import com.liuqiang.model.vo.user.InfoVo;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 系统用户
 * @author liuqiang
 */
public interface UserInfoService extends IService<UserInfo> {
    /**
     * 根据用户账户修改
     * @param infoVo 数据
     * @return 记录数
     */
    Integer updateInfo(InfoVo infoVo);

    /**
     * 分页查看学生列表
     * @param queryVo 请求参数
     * @param stuId 学号
     * @return 学生列表
     */
    PageInfo<StudentListBo> queryStudentList(QueryVo queryVo, String stuId);

    /**
     * 查询个人数据
     * @param userNumber 工号
     * @return 个人数据
     */
    UserBo queryManagerInfo(String userNumber);

    /**
     * 教师/导员查看学生信息详情
     * @param stuId 学生学号
     * @return 学生信息详情
     */
    StudentBo queryStudentInfo(String stuId);

    /**
     * 查询名下学生面试信息
     * @param queryVo 查询参数
     * @return 分页列表
     */
    PageInfo<InterviewBo> queryInterview(QueryVo queryVo,String stuId,String stuName);


    /**
     * 系统用户联系方式
     * @param response
     */
    void export(HttpServletResponse response) throws IOException;

    /**
     * 系统用户联系方式导入
     * @param file 导入文件
     */
    void imports(MultipartFile file);

    /**
     * 管理员新增/修改用户联系方式
     * @param infoVo  用户联系方式数据
     * @return true成功
     */
    Boolean saveUpdate(InfoVo infoVo);

    /**
     * 分页查询用户信息数据
     * @param queryVo 分页数据
     * @return 分页列表
     */
    PageInfo<UserBo> queryUserInfo(QueryVo queryVo,String userId);
}
