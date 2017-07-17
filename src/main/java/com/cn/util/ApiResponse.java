package com.cn.util;

import com.cn.swagger2.API.Response;
import com.cn.swagger2.API.SuccessModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * <B>文件名称：</B>ApiResponse<BR>
 * <B>文件描述：</B><BR>
 * <BR>
 * <B>版权声明：</B>(C)2016-2018<BR>
 * <B>公司部门：</B>东方银谷 研发二部 CBG<BR>
 * <B>创建时间：</B>2017/02/23<BR>
 *
 * @author guowy  guowy956@163.com
 * @version 1.0
 **/
public class ApiResponse {

    private static final String EMPTY = "";

    public static ResponseEntity<SuccessModel> success(Object data) {
        return success(data, EMPTY);
    }

    public static ResponseEntity<SuccessModel> success(String msg) {
        return success(EMPTY, msg);
    }

    public static ResponseEntity<SuccessModel> success(Object data, String msg) {
        SuccessModel successModel = Response.success(data, msg);
        return new ResponseEntity<SuccessModel>(successModel, HttpStatus.OK);
    }
}
