package com.liuqiang.service.service.user;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liuqiang.model.bo.userinfo.StudentBo;
import com.liuqiang.model.bo.userinfo.StudentListBo;
import com.liuqiang.model.entity.user.StudentInfo;
import com.liuqiang.model.vo.user.StudentVo;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author liuqiang
 */
public interface UserRelationService extends IService<StudentInfo> {
    /**
     * 根据学号查询学生信息
     * @param stuId 学号
     * @return 学生信息
     */
    StudentBo queryInfo(String stuId);

    /**
     * 学生关系数据导出
     * @param response 导出数据
     * @throws IOException
     */
    void export(HttpServletResponse response) throws IOException;

    /**
     * 学生关系数据导入
     * @param file 导入文件
     */
    void imports(MultipartFile file);

    /**
     * 管理员新增/修改学生人物关系
     * @param studentVo 关系数据
     * @return true成功
     */
    Boolean saveUpdate(StudentVo studentVo);

    /**
     * 查看用户关系列表
     * @param userNumber 教师/辅导员
     * @param stuId 学生id
     * @return list
     */
    List<StudentListBo> getList(String userNumber, String stuId);


}
