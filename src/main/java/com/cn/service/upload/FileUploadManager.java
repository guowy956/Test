package com.cn.service.upload;

import com.cn.model.entity.FileUpload;
import com.cn.model.entity.FileUploadSigning;
import com.cn.service.FileUploadService;
import com.cn.service.FileUploadSigningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by newtouch on 2017/8/23.
 */
@Service
public class FileUploadManager {

    @Autowired
    UploadHandLer uploadHandLer;

    @Autowired
    FileUploadService fileUploadService;

    @Autowired
    FileUploadSigningService fileUploadSigningService;

    public FileUpload upload(MultipartFile file) {
        return uploadHandLer.upload(file);
    }

    public FileUpload  fileUploadQuery(String md5) {
        return fileUploadService.fileUploadQuery(md5);
    }

    public FileUpload save(FileUpload uploadEntry) {
        fileUploadService.insert(uploadEntry);
        return uploadEntry;
    }

    public String fileUpdateSign(String orderId, MultipartFile file) {
        return uploadHandLer.fileUpdateSign(orderId,file);
    }

    //TODO 方法还没写
    public void upload(MultipartFile file,String MD5) {
        upload(null,file,MD5);
    }


    public FileUploadSigning selectByPrimaryKey(String orderId) {
        return fileUploadSigningService.selectByPrimaryByOrderId(orderId);
    }

    public FileUploadSigning uploadFileByOrderNum(String orderId, FileUploadSigning fileUploadSigning) {
       return fileUploadSigningService.uploadFileByOrderNum(orderId,fileUploadSigning);
    }

    public void upload(String orderNum,MultipartFile file,String MD5 ){
//       与上传服务器进行链接的代码
    }
}
