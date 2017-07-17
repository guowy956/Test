package com.cn.swagger2.API;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

/**
 * guowy
 *
 * @author guowy
 * @create 2017-06-28 10:40
 **/
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-03-16T06:58:31.439Z")

@Controller
public class LoginTestController implements LoginTestApi{
    /**
     * 登录“探针”
     *      加载app.vue时首先调用这个接口，用来测试是否已登录，从而决定展示首页还是登录页
     *      如果能进入本接口，说明已登录;否则将会被LoginFilter过滤，返回401
     * @param model
     * @return
     */
    public ResponseEntity<SuccessModel> loginTest() {
        SuccessModel successModel = new SuccessModel();
        successModel.setCode(200);
        successModel.setMessage("已登录");
        successModel.setData("");
        return new ResponseEntity<SuccessModel>(successModel, HttpStatus.OK);
    }

}
