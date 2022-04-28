package com.liuqiang.service.service.impl.user;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Strings;
import com.liuqiang.commons.excel.ExportExcel;
import com.liuqiang.commons.excel.ImportExcel;
import com.liuqiang.commons.excel.StudentRelationData;
import com.liuqiang.commons.utils.MapperUtils;
import com.liuqiang.model.bo.userinfo.StudentBo;
import com.liuqiang.model.bo.userinfo.StudentListBo;
import com.liuqiang.model.entity.user.StudentInfo;
import com.liuqiang.model.entity.user.UserInfo;
import com.liuqiang.model.vo.user.StudentVo;
import com.liuqiang.service.mapper.user.UserRelationMapper;
import com.liuqiang.service.mapper.user.UserInfoMapper;
import com.liuqiang.service.service.sys.SpecialtyService;
import com.liuqiang.service.service.user.UserRelationService;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;


/**
 * 学生
 * @author LiuQiang
 * @date 2:01 上午
 */
@Service
public class UserRelationServiceImpl extends ServiceImpl<UserRelationMapper, StudentInfo>
        implements UserRelationService {

    private final static String DOWNLOAD_ENTITY = "学生关系导出.xlsx";

   @Autowired
   private UserInfoMapper userInfoMapper;

   @Autowired
   private SpecialtyService specialtyService;

   @Autowired
   private UserRelationMapper userRelationMapper;

    @Override
    public StudentBo queryInfo(String stuId) {
        QueryWrapper<StudentInfo> studentWrapper = new QueryWrapper<>();
        studentWrapper.eq("stu_id",stuId);
        StudentInfo studentInfo = baseMapper.selectOne(studentWrapper);
        QueryWrapper<UserInfo> userInfoWrapper = new QueryWrapper<>();
        userInfoWrapper.eq("user_number", studentInfo.getTeaId())
                       .or()
                       .eq( "user_number",studentInfo.getCouId())
                       .or()
                       .eq("user_number",studentInfo.getStuId());
        List<UserInfo> userInfos = userInfoMapper.selectList(userInfoWrapper);
        StudentBo studentBo = new StudentBo();
        BeanUtils.copyProperties(studentInfo,studentBo);
        BeanUtils.copyProperties(userInfos.get(0),studentBo);
        studentBo.setTeacher(userInfos.get(1));
        studentBo.setCounselor(userInfos.get(2));
        return studentBo;
    }

    @Override
    public void export(HttpServletResponse response) throws IOException {
        ExportExcel exportExcel = new ExportExcel(null, StudentRelationData.class);
        exportExcel.setDataList(list()).write(response, DOWNLOAD_ENTITY).dispose();
    }

    @Override
    public void imports(MultipartFile file) {
        try {
            ImportExcel importExcel = new ImportExcel(file, 0, 0);
            List<StudentRelationData> importExcelDataList = importExcel.getDataList(StudentRelationData.class,
                                                            importExcel.getSheetList().get(0));
            List<StudentRelationData> relationData = importExcelDataList.stream().filter(t -> !Strings.isNullOrEmpty(t.getStuId()) &
                    !Strings.isNullOrEmpty(t.getTeaId()) &
                    !Strings.isNullOrEmpty(t.getCouId()) &
                    !Strings.isNullOrEmpty(t.getCollageCode()) &
                    !Strings.isNullOrEmpty(t.getSpecialtyCode()) &
                    !Strings.isNullOrEmpty(t.getClassCode())).collect(Collectors.toList());

           if( relationData.isEmpty()){
               // todo 返回数据文件不能为空信息
           }

           relationData.stream().forEach(t->{
               StudentInfo one = getOne(new QueryWrapper<StudentInfo>().eq("stu_id", t.getStuId())
                       .and(wrapper -> wrapper.eq("tea_id", t.getTeaId()))
                       .and(wrapper -> wrapper.eq("cou_id", t.getCouId()))
                       .and(wrapper -> wrapper.eq("collage_code", t.getCollageCode()))
                       .and(wrapper -> wrapper.eq("specialty_code", t.getSpecialtyCode()))
                       .and(wrapper -> wrapper.eq("class_code", t.getClassCode())));
               // todo 判断one是否为null返回数据重复信息
           });

//               specialtyService.getOne(new QueryWrapper<Specialty>().eq("id",t.getCollageCode()));
            // todo 返回学院是否存在信息

            HashSet<StudentRelationData> data = new HashSet<>(relationData);
            if (data.size()<relationData.size()) {
                // todo 返回数据文件中有重复信息
            }
            saveBatch(MapperUtils.INSTANCE.mapAsList(StudentInfo.class, relationData));
        } catch (InvalidFormatException | IOException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Boolean saveUpdate(StudentVo studentVo) {
        if (studentVo.getId() == null) {
            StudentInfo stuId = getOne(new QueryWrapper<StudentInfo>().eq("stu_id", studentVo.getStuId()));
            if (stuId != null) {
                return false;
            }
        }
        return saveOrUpdate(MapperUtils.INSTANCE.map(StudentInfo.class,studentVo),
                new UpdateWrapper<StudentInfo>().and(wrapper->wrapper.eq("stu_id",studentVo.getStuId())));
    }

    @Override
    public List<StudentListBo> getList(String userNumber, String stuId) {
            return userRelationMapper.getList(userNumber,stuId);
    }


}
