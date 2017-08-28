package com.cn.service.upload;

import com.cn.exception.BadRequestException;
import com.cn.exception.BusinessException;
import com.cn.mapper.FileUploadSigningMapper;
import com.cn.model.entity.FileUpload;
import com.cn.model.entity.FileUploadSigning;
import com.cn.service.FileUploadService;
import com.cn.service.FileUploadSigningService;
import com.cn.util.MD5Util;
import com.cn.util.StringUtil;
import org.apache.commons.io.IOUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by newtouch on 2017/8/23.
 */
@Component
public class UploadHandLer {


    @Value("${upload.file.suffixes.image}")
    private String UPLOAD_SUFFIXES_IMAGE;


    @Value("${upload.file.suffixes.others}")
    private String UPLOAD_SUFFIXES_OTHERS;

    @Value("${upload.file.online.api.upload}")
    private String ONLINE_API_UPLOAD;

    @Autowired
    FileUploadManager fileUploadManager;

    @Autowired
    FileUploadService fileUploadService;

    @Autowired
    FileUploadSigningMapper fileUploadSigningMapper;


    public String getFileUploadSuffix(){
        return UPLOAD_SUFFIXES_IMAGE+UPLOAD_SUFFIXES_OTHERS;
    }

    public FileUpload validate(MultipartFile file){
        FileUpload uploadEntry = null;
        if(!validateSuffixes(getSuffixes(file))){
            throw new BadRequestException("只能上传"+getFileUploadSuffix()+"类型的文件");
        }

        return uploadEntry;
    }

    public Boolean validateSuffixes(String suffix){
        boolean validSuffixes = false;
        String[] split = getFileUploadSuffix().split(",");
        for (String s:split) {
            if(s.equals(suffix)){
                validSuffixes = true;
            }
        }
        return validSuffixes;
    }

    public String getSuffixes(MultipartFile file){
        String originalFilename = file.getOriginalFilename();
        return originalFilename.substring(originalFilename.lastIndexOf(".")+1);
    }

    public String getOldName(MultipartFile file){
        Assert.notNull(file);
        return file.getOriginalFilename();
    }

    public long getFielSize(MultipartFile file){
        Assert.notNull(file);
        return file.getSize();
    }

    public String getFileMd5(MultipartFile file){
        String md5 = null;
        InputStream IS= null;
        try {
            IS = file.getInputStream();
            md5 = DigestUtils.md5Hex(IOUtils.toByteArray(IS));
        } catch (IOException e) {
            e.printStackTrace();
        }
        IOUtils.closeQuietly(IS);
        return md5;
    }

    public String setFilePath(FileUpload fileUpload){
        String filePath = getFilePath(fileUpload.getPath());
        String newFilePath = fileUpload.getMd5() + "" + fileUpload.getSuffix();
        return  filePath+"/"+newFilePath;
    }

    public String getFilePath(String path){
        String filePath ="";
        if(StringUtil.isEmail(path)){
            filePath = ONLINE_API_UPLOAD;
        }else{
            filePath = ONLINE_API_UPLOAD+path;
        }
        return filePath;
    }

    public FileUpload upload(MultipartFile file) {
        LocalDateTime now = LocalDateTime.now();
        FileUpload uploadEntry = validate(file);
        if(uploadEntry!=null){
            return uploadEntry;
        }
        uploadEntry = new FileUpload();
        uploadEntry.setName(this.getOldName(file));
        uploadEntry.setMd5(this.getFileMd5(file));
        uploadEntry.setFileSize(this.getFielSize(file));
        uploadEntry.setSuffix(this.getSuffixes(file));
        uploadEntry.setCreateTime(new Date());
        uploadEntry.setPath("/preview/"+uploadEntry.getMd5()+"/"+uploadEntry.getSuffix());
//        查询当前文件是否上传
        FileUpload fileUpload =  fileUploadManager.fileUploadQuery(uploadEntry.getMd5());
        if(!ObjectUtils.isEmpty(fileUpload)){
            return fileUpload;
        }
        //fileUploadService.upload(file,uploadEntry.getMd5());
        uploadEntry = fileUploadManager.save(uploadEntry);
        return uploadEntry;
    }

    public String fileUpdateSign(String orderId, MultipartFile file) {
        String md5 = null;
        String fileName = file.getOriginalFilename();
        String[] args = fileName.split("\\.");
        String  fileType   = args[0];
        String  fileSuffix = args[1].toLowerCase();

        try {
             md5 = MD5Util.getMD5String(file.getBytes());
            fileUploadManager.upload(file,md5);
        } catch (IOException e) {
//            e.printStackTrace();
            throw new BusinessException("文件上传失败"+e.getMessage());
        }
        String pushFileName =  fileName + fileSuffix;
        FileUploadSigning signing = fileUploadManager.selectByPrimaryKey(orderId);
        if(signing == null){
            throw new BusinessException("信息不存在");
        }
        if(StringUtil.isNotEmpty(signing.getUploadIouPath())){
            pushFileName = signing.getUploadIouPath()+"，"+pushFileName;
        }
        FileUploadSigning fileUploadSigning = new FileUploadSigning();
        fileUploadSigning.setUploadIouPath(pushFileName);
        uploadFileByOrderNum(orderId,fileUploadSigning);
        return pushFileName;
    }

    private FileUploadSigning uploadFileByOrderNum(String orderId, FileUploadSigning fileUploadSigning) {
       return fileUploadManager.uploadFileByOrderNum(orderId,fileUploadSigning);
    }
}
