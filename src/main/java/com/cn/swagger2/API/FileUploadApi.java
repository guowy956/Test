package com.cn.swagger2.API;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by newtouch on 2017/8/17.
 */

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-09T10:04:35.830Z")
@Api(value = "fileUpdate", description = "the fileUpdate API")
@RequestMapping(value = "/cur_user")
public interface FileUploadApi {


    @ApiOperation(value = "文件上传", notes = "文件上传",tags = { })
    @ApiResponses({
            @ApiResponse(code = 200,message = "Successful response",response = SuccessModel.class),
            @ApiResponse(code = 200,message = "unexpected error")    })
    @RequestMapping(value = "file",method = RequestMethod.POST , produces="application/json;charset=utf-8")
    ResponseEntity<SuccessModel> fileUpdate (@ApiParam(value = "file detail")@RequestPart("file")MultipartFile file);


}
