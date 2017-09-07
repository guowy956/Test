package com.cn.service.file;

import com.alibaba.fastjson.parser.deserializer.StringFieldDeserializer;
import com.cn.exception.BusinessException;
import com.cn.model.entity.CustomerScanningCopy;
import com.cn.service.CustomerScanningCopyService;
import com.cn.service.base.BaseService;
import com.cn.util.MD5Util;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by newtouch on 2017/8/28.
 */
@Service
public class FileOperationManager extends BaseService<Long> {

    @Autowired
    CustomerScanningCopyService<CustomerScanningCopy, String, Long> customerScanningCopyService;

    public CustomerScanningCopyService<CustomerScanningCopy, String, Long> getCustomerScanningCopyService() {
        return customerScanningCopyService;
    }

    public CustomerScanningCopy upload2(String orderNum, MultipartFile file, Date repairTime) {
        try {
            String md5Hex = DigestUtils.md5Hex(file.getBytes());
            logger.debug("请求文件MD5为{}-{}" + md5Hex);
            String md5String = MD5Util.getMD5String(file.getBytes());
            logger.debug("(另外一种方法)请求文件MD5为{}-{}" + md5String);
            md5Hex = DigestUtils.md5Hex(orderNum + md5Hex);
            logger.debug("组装后的MD5{}-{}" + md5Hex);

            String filename = file.getOriginalFilename();
            String[] split = filename.split("\\.");
            String fileType = split[0];
            String fileSuffix = split[1].toLowerCase();
            List<CustomerScanningCopy> customerScanningCopyList = getCustomerScanningCopy(orderNum, md5Hex);
            if (!CollectionUtils.isEmpty(customerScanningCopyList)) {
                logger.debug("此订单号下已经上传此附件，orderNum:{},md5:{},fileType:{}", orderNum, md5Hex, fileType);
                throw new BusinessException("此订单号下已经上传此附件");
            }
            logger.debug(String.valueOf(file.getSize()));
            getCustomerScanningCopyService().uploadCustomerScanningCopy(orderNum, md5Hex, fileSuffix);
            String fileUrl = getCustomerScanningCopyService().preview(orderNum, md5Hex, fileSuffix);
            CustomerScanningCopy entry = saveCustomerScanningCopy(orderNum,md5Hex,fileType,fileSuffix,fileUrl,"","",repairTime);
            return  entry;
        } catch (IOException e) {
            throw new BusinessException("数据异常");
        }
    }

    public List<CustomerScanningCopy> getCustomerScanningCopy(String orderNum, String MD5) {
        return getCustomerScanningCopyService().selectByOrderNumAndMd5(orderNum, MD5);
    }

    public CustomerScanningCopy saveCustomerScanningCopy(String orderNum, String fileMd5, String fileType, String fileSuffix, String fileUrl, String minMd5, String previewThumbnailUrl, Date repairTime) {
        return saveCopy(orderNum, fileMd5, fileType, fileSuffix, fileUrl, minMd5, previewThumbnailUrl, repairTime);
    }

    private CustomerScanningCopy saveCopy(String orderNum, String fileMd5, String fileType, String fileSuffix, String fileUrl, String minMd5, String previewThumbnailUrl, Date repairTime) {
        CustomerScanningCopy customerScanningCopy = new CustomerScanningCopy();
        customerScanningCopy.setOrderNum(orderNum);
        customerScanningCopy.setFileMd5(fileMd5);
        customerScanningCopy.setFileType(fileType);
        customerScanningCopy.setFileSuffix(fileSuffix);
        customerScanningCopy.setFilePreview(fileUrl);
        customerScanningCopy.setMinFileMd5(minMd5);
        customerScanningCopy.setMinFilePreview(previewThumbnailUrl);
        customerScanningCopy.setRepairTime(repairTime);
        int insert = getCustomerScanningCopyService().insert(customerScanningCopy);
        if(insert>0){
            return customerScanningCopy;
        }else{
            throw new BusinessException("数据异常");
        }

    }

    public List<CustomerScanningCopy> findFileByOrderNum(String orderNum) {
        return getCustomerScanningCopyService().findFileByOrderNum(orderNum);
    }
}
