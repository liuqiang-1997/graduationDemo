package com.liuqiang.service.service.sys;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liuqiang.model.bo.sys.RoleUserBo;
import com.liuqiang.model.entity.servicelogic.CheckInfo;
import com.liuqiang.model.vo.servicelogic.CheckInfoVo;
import com.liuqiang.model.vo.user.UserVo;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public interface CheckService extends IService<CheckInfo> {
    HashMap<String,Object> login(UserVo userVo);

    String logout();

    /**
     * 系统用户数据导出
     * @param response
     * @throws IOException
     */
    void export(HttpServletResponse response) throws IOException;

    /**
     * 用户数据导入
     * @param file 导入数据
     */
    void imports(MultipartFile file) throws Exception;

    /**
     * xin
     * @param checkInfo
     * @return
     */
    Boolean saveUpdate(CheckInfoVo checkInfo);

    List<RoleUserBo> queryRoleUser(Integer roleId);
}
