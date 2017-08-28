package com.cn.swagger2.API;

import com.cn.model.entity.FileUpload;
import com.cn.model.entity.FileUploadSigning;
import com.cn.service.FileUploadService;
import com.cn.service.upload.FileUploadManager;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by newtouch on 2017/8/17.
 */
@Controller
public class FileUploadController extends BaseController implements FileUploadApi {


    @Autowired
    FileUploadService<FileUpload,String,Long> service;

    private FileUploadService<FileUpload,String,Long> getService(){
        return service;
    }


    @Autowired
    FileUploadManager fileUploadManager;




    @Override
    public ResponseEntity<SuccessModel> fileUpdate(@ApiParam(value = "file Upload") @RequestPart("file") MultipartFile file) {
        FileUpload fileUpload = fileUploadManager.upload(file);
        return new ResponseEntity<SuccessModel>(new SuccessModel().data(fileUpload).message("上传成功"), HttpStatus.OK);
    }
}
