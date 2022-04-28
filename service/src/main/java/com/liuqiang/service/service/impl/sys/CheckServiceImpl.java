package com.liuqiang.service.service.impl.sys;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import com.liuqiang.commons.config.redis.RedisCache;
import com.liuqiang.commons.excel.ExportExcel;
import com.liuqiang.commons.excel.ImportExcel;
import com.liuqiang.commons.excel.UserData;
import com.liuqiang.commons.exception.BusinessAssert;
import com.liuqiang.commons.utils.JwtUtils;
import com.liuqiang.commons.utils.MapperUtils;
import com.liuqiang.commons.utils.ReturnCodeUtils;
import com.liuqiang.model.bo.sys.RoleUserBo;
import com.liuqiang.model.entity.servicelogic.CheckInfo;
import com.liuqiang.model.vo.servicelogic.CheckInfoVo;
import com.liuqiang.model.vo.user.UserVo;
import com.liuqiang.commons.config.security.LoginUserDetails;
import com.liuqiang.service.mapper.sys.CheckMapper;
import com.liuqiang.service.service.sys.CheckService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


/**
 * 用户登陆校验
 * @author LiuQiang
 */
@Service
public class CheckServiceImpl extends ServiceImpl<CheckMapper, CheckInfo>
        implements CheckService {

    private final static String DOWNLOAD_ENTITY = "系统用户导出.xlsx";

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RedisCache redisCache;

    @Override
    public HashMap<String,Object> login(UserVo userVo) {
        // 用户认证  authenticationManager.authenticate(token)底层调用loadUserByUsername方法进行认证
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userVo.getNumber(),
               userVo.getPassword());
        Authentication authenticate = authenticationManager.authenticate(token);

        if (Objects.isNull(authenticate)) {
            throw  new RuntimeException("登录失败");
        }
        // 生成jwt，将用户信息存入redis
        LoginUserDetails principal = (LoginUserDetails) authenticate.getPrincipal();
        CheckInfo user = principal.getUser();
        String userNumber = user.getUserNumber();
        String userName = user.getUserName();
        HashMap<String , Object> maps = new HashMap<>(1);
        maps.put("user",userName);
        maps.put("number",userNumber);
        String jwt = JwtUtils.createJwt(maps);
        HashMap<String , Object> map = new HashMap<>(1);
        map.put("Authorization",jwt);
        map.put("user",userName);
        map.put("number",userNumber);

        redisCache.setCacheObject("user:"+userNumber,principal);
        return map;
    }

    @Override
    public String logout() {
        UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        CheckInfo checkInfo = (CheckInfo) authentication.getPrincipal();
        String userNumber = checkInfo.getUserNumber();
        // 删除redis中缓存
        redisCache.deleteCacheObject("user:"+userNumber);
        return "注销成功";
    }

    @Override
    public void export(HttpServletResponse response) throws IOException {
        ExportExcel exportExcel = new ExportExcel(null, UserData.class);
        exportExcel.setDataList(list()).write(response, DOWNLOAD_ENTITY).dispose();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void imports(MultipartFile file) throws Exception {

            ImportExcel importExcel = new ImportExcel(file, 0, 0);
            List<UserData> dataList = importExcel.getDataList(UserData.class, importExcel.getSheetList().get(0));
            List<UserData> userDataList = dataList.stream().filter(t -> !Strings.isNullOrEmpty(t.getUserName()) &
                    !Strings.isNullOrEmpty(t.getUserNumber()) &
                    !Strings.isNullOrEmpty(t.getRoleId().toString())).collect(
                    Collectors.toList());

                  // todo 返回校验文件数据是否为空信息
            BusinessAssert.notEmpty(userDataList,"555","上传文件内容不能为空");

            userDataList.forEach(e ->{getOne(new QueryWrapper<CheckInfo>().eq("user_name",e.getUserName())
                                                      .or().eq("user_number",e.getUserNumber()));
                                                  // todo 返回校验数据是否已存在信息
            });

            HashSet<UserData> userData = new HashSet<>(userDataList);

            // todo 返回校验数据是否重复信息
            BusinessAssert.isTrue(userData.size() == userDataList.size(),
                    ReturnCodeUtils.DATA_ERROR.getCode().toString(),
                    "上传数据不能重复");

            // 插入数据
            saveBatch(MapperUtils.INSTANCE.mapAsList(CheckInfo.class,userDataList));



    }

    @Override
    public Boolean saveUpdate(CheckInfoVo checkInfo) {
        // todo 数据是否重复校验
        if (checkInfo.getId() == null){
            CheckInfo one = getOne(new QueryWrapper<CheckInfo>().eq("user_number", checkInfo.getUserNumber()));
            if (one != null) {
                return false;
            }
        }
        if (checkInfo.getPassword() != null) {
            checkInfo.setPassword(passwordEncoder.encode(checkInfo.getPassword()));
        }

        return saveOrUpdate(MapperUtils.INSTANCE.map(CheckInfo.class,checkInfo),new UpdateWrapper<CheckInfo>()
                .and(wrapper->wrapper.eq("user_number",checkInfo.getUserNumber()))
                .and(wrapper->wrapper.eq("user_name",checkInfo.getUserName())));

    }

    @Override
    public List<RoleUserBo> queryRoleUser(Integer roleId) {

        QueryWrapper<CheckInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("role_id",roleId);
        return MapperUtils.INSTANCE.mapAsList(RoleUserBo.class,list(wrapper));

    }
}
