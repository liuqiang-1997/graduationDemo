package com.liuqiang.service.service.impl.user;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Strings;
import com.liuqiang.commons.config.redis.RedisCache;
import com.liuqiang.commons.excel.ExportExcel;
import com.liuqiang.commons.excel.ImportExcel;
import com.liuqiang.commons.excel.RelationData;
import com.liuqiang.commons.utils.MapperUtils;
import com.liuqiang.model.bo.servicelogic.InterviewBo;
import com.liuqiang.model.bo.userinfo.UserBo;
import com.liuqiang.model.bo.userinfo.StudentBo;
import com.liuqiang.model.bo.userinfo.StudentListBo;
import com.liuqiang.model.entity.servicelogic.CheckInfo;
import com.liuqiang.model.entity.servicelogic.Interview;
import com.liuqiang.model.entity.sys.Specialty;
import com.liuqiang.model.vo.sys.QueryVo;
import com.liuqiang.model.entity.user.StudentInfo;
import com.liuqiang.model.entity.user.UserInfo;
import com.liuqiang.model.vo.user.InfoVo;
import com.liuqiang.service.interceptor.LoginUserContextHolder;
import com.liuqiang.service.mapper.sys.CheckMapper;
import com.liuqiang.service.mapper.user.UserInfoMapper;
import com.liuqiang.service.service.servicelogic.*;
import com.liuqiang.service.service.sys.SpecialtyService;
import com.liuqiang.service.service.user.UserRelationService;
import com.liuqiang.service.service.user.UserInfoService;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


/**
 * 系统管理员
 * @author LiuQiang
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo>
        implements UserInfoService {

    private final static String DOWNLOAD_ENTITY = "用户信息导出.xlsx";

    @Autowired
    private CheckMapper checkMapper;
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private UserRelationService userRelationService;

    @Autowired
    private InterviewService interviewService;

    @Autowired
    private SpecialtyService specialtyService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RedisCache redisCache;


    @Override
    public Integer updateInfo(InfoVo infoVo) {
        UserInfo userInfo = new UserInfo();
        CheckInfo checkInfo = new CheckInfo();
        UpdateWrapper<UserInfo> infoWrapper = new UpdateWrapper<>();
        infoWrapper.eq("user_number",infoVo.getUserNumber());
        UpdateWrapper<CheckInfo> checkWrapper = new UpdateWrapper<>();
        checkWrapper.eq("user_number",infoVo.getUserNumber());
        BeanUtils.copyProperties(infoVo,userInfo);
        checkInfo.setPassword(passwordEncoder.encode(infoVo.getPassword()));
        if (StringUtils.isNotEmpty( infoVo.getPassword())){
            return checkMapper.update(checkInfo,checkWrapper);
        }
        return baseMapper.update(userInfo, infoWrapper);
    }

    @Override
    public PageInfo<StudentListBo> queryStudentList(QueryVo queryVo, String stuId) {
              // todo 做缓存
        PageHelper.startPage(queryVo.getPageNum(),queryVo.getPageSize());
        List<StudentListBo> list = userRelationService.getList(queryVo.getUserNumber(),stuId);
        list.forEach(t->{
            QueryWrapper<Specialty> specialty = new QueryWrapper<>();
            specialty.eq("id",t.getCollageCode()).or()
                    .eq("id",t.getSpecialtyCode()).or()
                    .eq("id",t.getClassCode());
            List<Specialty> specialtyList = specialtyService.list(specialty);
            t.setCollageCode(specialtyList.get(0).getNodeName());
            t.setSpecialtyCode(specialtyList.get(1).getNodeName());
            t.setClassCode(specialtyList.get(2).getNodeName());
            CheckInfo checkInfo = checkMapper.selectOne(new QueryWrapper<CheckInfo>().eq("user_number", t.getStuId()));
            t.setStuName(checkInfo.getUserName());
        });

        return new PageInfo<>(list);
    }

    @Override
    public UserBo queryManagerInfo(String userNumber) {
        QueryWrapper<UserInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("user_number",userNumber);
        UserInfo teacherInfo = getOne(wrapper);
        return MapperUtils.INSTANCE.map(UserBo.class,teacherInfo);
    }

    @Override
    public StudentBo queryStudentInfo(String stuId) {
        QueryWrapper<UserInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("user_number",stuId);
        UserInfo userInfo = getOne(wrapper);
        QueryWrapper<StudentInfo> wrappers = new QueryWrapper<>();
        wrappers.eq("stu_id",stuId);
        StudentInfo studentInfo = userRelationService.getOne(wrappers);
        QueryWrapper<UserInfo> user = new QueryWrapper<>();
        QueryWrapper<Specialty> specialty = new QueryWrapper<>();
        specialty.eq("id",studentInfo.getCollageCode()).or()
                .eq("id",studentInfo.getSpecialtyCode()).or()
                .eq("id",studentInfo.getClassCode());
        List<Specialty> list = specialtyService.list(specialty);
        user.eq("user_number",studentInfo.getTeaId()).or()
                .eq("user_number",studentInfo.getCouId());
        List<UserInfo> userInfos = list(user);

        return StudentBo.builder().userNumber(userInfo.getUserNumber()).userName(userInfo.getUserName())
                                  .email(userInfo.getEmail()).vxNumber(userInfo.getVxNumber())
                                  .qqNumber(userInfo.getQqNumber()).mobile(userInfo.getMobile())
                                  .collageCode(list.get(0).getNodeName()).teacher(userInfos.get(0))
                                  .specialtyCode(list.get(1).getNodeName()).counselor(userInfos.get(1))
                                  .classCode(list.get(2).getNodeName()).build();
    }

    @Override
    public PageInfo<InterviewBo> queryInterview(QueryVo queryVo,String stuId,String stuName) {
        PageHelper.startPage(queryVo.getPageNum(),queryVo.getPageSize());
        QueryWrapper<Interview> queryWrapper = new QueryWrapper<>();
        if(!Strings.isNullOrEmpty(stuId)){
            queryWrapper.likeRight("stu_id",stuId);
        }
        if(!Strings.isNullOrEmpty(stuName)){
            queryWrapper.likeRight("stu_name",stuName);
        }
        return new PageInfo<>(MapperUtils.INSTANCE.mapAsList(InterviewBo.class,interviewService.list(queryWrapper)));
    }


    @Override
    public void export(HttpServletResponse response) throws IOException {
        ExportExcel exportExcel = new ExportExcel(null, RelationData.class);
        exportExcel.setDataList(list()).write(response, DOWNLOAD_ENTITY).dispose();
    }

    @Override
    public void imports(MultipartFile file) {
        try {
            ImportExcel importExcel = new ImportExcel(file, 0, 0);
            List<RelationData> dataList = importExcel.getDataList(RelationData.class, importExcel.getSheetList().get(0));
            List<RelationData> relationData = dataList.stream().filter(t -> !Strings.isNullOrEmpty(t.getUserNumber()) &
                    !Strings.isNullOrEmpty(t.getUserName()) &
                    !Strings.isNullOrEmpty(t.getEmail()) &
                    !Strings.isNullOrEmpty(t.getMobile()) &
                    !Strings.isNullOrEmpty(t.getQqNumber()) &
                    !Strings.isNullOrEmpty(t.getVxNumber())).collect(Collectors.toList());
            if( relationData.isEmpty()){
                // todo 返回数据文件不能为空信息
            }
            relationData.stream().forEach(t->{
                t.setCreateUserId(LoginUserContextHolder.getCurrentUser().getUserNumber());
                UserInfo one = getOne(new QueryWrapper<UserInfo>().eq("user_name", t.getUserName())
                        .and(wrapper -> wrapper.eq("user_number", t.getUserNumber())));
                // todo 判断one是否为null返回数据重复信息
            });
            HashSet<RelationData> data = new HashSet<>(relationData);
            if (data.size()<relationData.size()) {
                // todo 返回数据文件中有重复数据信息
            }

            saveBatch(MapperUtils.INSTANCE.mapAsList(UserInfo.class,relationData));


        } catch (InvalidFormatException | IOException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Boolean saveUpdate(InfoVo infoVo) {
        // todo 数据是否重复校验
        if (infoVo.getId() == null) {
            UserInfo userInfo = getOne(new QueryWrapper<UserInfo>().eq("user_number", infoVo.getUserNumber()));
            if (userInfo != null) {
                return false;
            }
        }
        return saveOrUpdate(MapperUtils.INSTANCE.map(UserInfo.class,infoVo),
                new UpdateWrapper<UserInfo>().and(wrapper -> wrapper.eq("user_number",infoVo.getUserNumber()))
                        .and(wrapper->wrapper.eq("user_name",infoVo.getUserName())));
    }

    @Override
    public PageInfo<UserBo> queryUserInfo(QueryVo queryVo,String userId) {
        PageHelper.startPage(queryVo.getPageNum(),queryVo.getPageSize());
        List<UserBo> userBos = userInfoMapper.queryUserInfo(queryVo, userId);

        return new PageInfo<>( userBos);
    }
}
