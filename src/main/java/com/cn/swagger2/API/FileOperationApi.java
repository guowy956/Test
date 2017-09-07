package com.cn.swagger2.API;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by newtouch on 2017/8/28.
 */


@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-09T10:04:35.830Z")
@Api(value = "FileOperation", description = "the FileOperation API")
@RequestMapping(value = "/cur_user")
public interface FileOperationApi {

    @ApiOperation(value = "新增(上传)", notes = "新增(上传)",tags = { })
    @ApiResponses({
            @ApiResponse(code = 200,message = "Successful response",response = SuccessModel.class),
            @ApiResponse(code = 200,message = "unexpected error")    })
    @RequestMapping(value = "fileOperatio",method = RequestMethod.POST ,
            produces="application/json;charset=utf-8",
            consumes = "multipart/form-data"
    )
    ResponseEntity<SuccessModel> fileUpload(
            @ApiParam(value = "单号")@RequestPart("orderNum")String  orderNum,
            @ApiParam(value = "file detail")@RequestPart("file")MultipartFile file);


    @ApiOperation(value = "获取图片(上传以后的)", notes = "获取图片(上传以后的)",tags = { })
    @ApiResponses({
            @ApiResponse(code = 200,message = "Successful response",response = SuccessModel.class),
            @ApiResponse(code = 200,message = "unexpected error")    })
    @RequestMapping(value = "/fileOperatio/{orderNum}",
            produces = { "application/json" },
            method = RequestMethod.GET )
    ResponseEntity<SuccessModel> fileDownLoad(@ApiParam(value = "单号")@PathVariable("orderNum")String  orderNum);

    @ApiOperation(value = "预览图片", notes = "预览图片",tags = { })
    @ApiResponses({
            @ApiResponse(code = 200,message = "Successful response",response = SuccessModel.class),
            @ApiResponse(code = 200,message = "unexpected error")    })
    @RequestMapping(value = "/preview/{md5}/{type}",
            method = RequestMethod.GET )
    String getPreviewUrl(@ApiParam(value = "md5")@PathVariable("orderNum")String  md5,
                                              @ApiParam(value = "type")@PathVariable("type")String  type,
                                              @ApiParam(value = "缩略图")@PathVariable("thumbnails")String  thumbnails, HttpServletResponse httpServletResponse);

}
