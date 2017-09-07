package com.cn.swagger2.API;

import com.cn.exception.BusinessException;
import com.cn.model.entity.CustomerScanningCopy;
import com.cn.model.entity.Product;
import com.cn.service.CustomerScanningCopyService;
import com.cn.service.ProductService;
import com.cn.service.file.FileOperationManager;
import com.cn.util.StringUtil;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * Created by newtouch on 2017/8/28.
 */
@Controller
public class FileOperationController extends BaseController implements FileOperationApi {


    @Autowired
    ProductService<Product,String,Long> productService;

    public ProductService<Product,String,Long> getProductService(){
        return productService;
    }

    @Autowired
    CustomerScanningCopyService<CustomerScanningCopy , String ,Long> customerScanningCopyService;

    public CustomerScanningCopyService<CustomerScanningCopy , String ,Long> getCustomerScanningCopyService(){
        return customerScanningCopyService;
    }

    @Autowired
    FileOperationManager fileOperationManager;


    public ResponseEntity<SuccessModel> fileUpload(@ApiParam(value = "单号")@RequestPart("orderNum")String  orderNum,
                                                     @ApiParam(value = "file detail")@RequestPart("file")MultipartFile file) {
        Product product = getProductService().getListById(orderNum);
        if(StringUtils.isEmpty(product)||StringUtils.isEmpty(product.getProductCode())){
            throw new BusinessException("该条信息不存在");
        }
        Date repairTime = null;
        if(Integer.valueOf(product.getProductStatus()).compareTo(Integer.valueOf(300))>0)
            repairTime = new Date();
            CustomerScanningCopy customerScanningCopy = fileOperationManager.upload2(orderNum,file,repairTime);
        return new ResponseEntity<SuccessModel>(new SuccessModel().message("上传成功").data(customerScanningCopy), HttpStatus.OK);
    }

    public ResponseEntity<SuccessModel> fileDownLoad(@ApiParam(value = "单号")@PathVariable("orderNum")String  orderNum) {
        List<CustomerScanningCopy> copyList = fileOperationManager.findFileByOrderNum(orderNum);
        return new ResponseEntity<SuccessModel>(new SuccessModel().data(copyList),HttpStatus.OK);
    }

    @Override
    public String getPreviewUrl(@ApiParam(value = "md5")@PathVariable("orderNum")String  md5,
                                                     @ApiParam(value = "type")@PathVariable("orderNum")String  type,
                                                     @ApiParam(value = "缩略图")@PathVariable("orderNum")String  thumbnails,
                                                     HttpServletResponse httpServletResponse) {
        String previewUrl = null;
        if(StringUtil.isEmpty(thumbnails)){
            previewUrl  = getCustomerScanningCopyService().getPreviewUrl(md5,type);
        }else{
            previewUrl  = getCustomerScanningCopyService().getPreviewThumbnailsUrl(md5,type);
        }
        return previewUrl;
    }
}
