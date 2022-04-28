package com.liuqiang.service.service.servicelogic;

import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传服务
 * @author liuqiang
 */
public interface FileOssService {
    /**
     * 文件上传
     * @param file 被上传的文件
     * @return 文件存储路径
     */
    String fileUpload(MultipartFile file);
}
