package com.cn.service;

import com.cn.mapper.CommonMapper;
import com.cn.model.entity.FileUpload;
import com.cn.model.entity.FileUploadSigning;
import org.apache.ibatis.session.RowBounds;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.List;

/**
 * CommonsService
 *
 * @author guowy
 * @create 2017-06-22 10:15
 **/

public abstract class CommonsService<T,S,PK extends Serializable> {

    public abstract CommonMapper<T, S, PK> getMapper();

    public  int insert(T body) {
        return insert(body,true);
    }

    public int insert(T body,boolean isSelective){
        if(isSelective){
            return getMapper().insertSelective(body);
        }else{
            return getMapper().insert(body);
        }
    }

    public List<T> getAll() {
        return getMapper().getAll();
    }

    //校验文件是否已经上传
    public FileUpload fileUploadQuery(S md5) {
        return getMapper().selectBYExample(md5);
    }


    public FileUploadSigning selectByPrimaryKey(Long id){
        return  getMapper().selectByPrimaryKey(id);
    }

    public FileUploadSigning selectByPrimaryByOrderId(String orderId) {
        return getMapper().selectByPrimaryByOrderId(orderId);
    }

    public FileUploadSigning uploadFileByOrderNum(String orderId, FileUploadSigning fileUploadSigning) {
       return getMapper().uploadFileByOrderNum(orderId,fileUploadSigning);
    }
}
