package com.cn.service.upload;

import com.cn.model.entity.FileUpload;
import com.cn.service.FileUploadService;
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

}
