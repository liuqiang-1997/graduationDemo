package com.liuqiang.service.service.impl.servicelogic;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.liuqiang.commons.utils.OssUtils;
import com.liuqiang.service.service.servicelogic.FileOssService;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author LiuQiang
 * @date 10:06 下午
 */
@Service
public class FileOssServiceImpl implements FileOssService {

    @Override
    public String fileUpload(MultipartFile file) {

        String endpoint = OssUtils.ENDPOINT;
        String accessKeyId = OssUtils.ACCESS_KEY_ID;
        String accessKeySecret = OssUtils.SECRET;
        String bucket = OssUtils.BUCKET;
        String filePath = "";


        try {
            // 创建OssClient实例
            OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
            // 通过请求参数获取上传的文件流
            InputStream inputStream = file.getInputStream();
            // 设置文件名(添加时间戳防止同名文件被覆盖)
            String name = new DateTime().getMillis()+file.getOriginalFilename();
            // 按照日期创建文件夹存储上传文件
            String time = new DateTime().toString("yyyy/MM/dd");
            String filename = time+"/"+name;
            ossClient.putObject(OssUtils.BUCKET, filename, inputStream);
            // 关闭OssClient
            ossClient.shutdown();
            filePath = "http://" + bucket + "." + endpoint + "/" + filename;
            return filePath;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }


    }
}
