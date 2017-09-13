package com.cn.swagger2.API;

import com.cn.model.entity.AddressLibrary;
import com.cn.service.AddressLibraryManage;
import com.cn.util.ApiResponse;
import com.cn.util.BeanConvertUtil;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import javax.validation.Valid;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-09-07T09:32:08.696Z")

@Controller
public class AddressLibraryApiController extends BaseController implements AddressLibraryApi {


    @Autowired
    private AddressLibraryManage addressLibraryManage;


    public ResponseEntity<SuccessModel> createAddressLibrary(@ApiParam(value = "地址" ,required=true )  @Valid @RequestBody AddressLibrary body) {
        com.cn.model.domain.AddressLibrary addressLibrary = BeanConvertUtil.addressLibraryConver(body);
        addressLibraryManage.create(addressLibrary);
        return com.cn.util.ApiResponse.success("保存成功");
    }

    public ResponseEntity<SuccessModel> deleteAddressLibrary(@ApiParam(value = "地址id",required=true ) @PathVariable("id") Long id) {
        addressLibraryManage.removeById(id);
        return ApiResponse.success("删除成功");
    }

    public ResponseEntity<SuccessModel> getList() {
        return ApiResponse.success(addressLibraryManage.findAll(),"查询成功");
    }

    public ResponseEntity<SuccessModel> updateAddressLibrary(@ApiParam(value = "地址" ,required=true )  @Valid @RequestBody AddressLibrary body) {
        addressLibraryManage.modify(body);
        return ApiResponse.success("修改成功");
    }

    public ResponseEntity<SuccessModel> addressLibraryByUserID(@ApiParam(value = "用户ID. ",required=true ) @PathVariable("userId") Long userId) {
        Object list =  addressLibraryManage.selectByUserID(userId);
        return ApiResponse.success(list,"查询成功");
    }

    public ResponseEntity<SuccessModel> deleteList(@ApiParam(value = "地址id. ",required=true ) @PathVariable("idList") String idList) {
        addressLibraryManage.deleteList(idList);
        return ApiResponse.success("删除成功");
    }


}
