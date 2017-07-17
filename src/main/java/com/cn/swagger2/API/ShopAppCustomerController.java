package com.cn.swagger2.API;

import com.cn.model.entity.ShopAppCustomer;
import com.cn.service.ShopAppCustomerApiService;
import com.cn.util.ApiResponse;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 客户/用户 -- 管理
 *
 * @author guowy
 * @create 2017-05-27 15:03
 **/
//@Auth
@Controller
public class ShopAppCustomerController extends BaseController implements ShopAppCustomerApi{

    @Autowired
    private ShopAppCustomerApiService shopAppCustomerApiService;

    @Override
    public ResponseEntity<SuccessModel> list(
            @NotNull@ApiParam(value = "起始页", required = true)@RequestParam(name = "start", defaultValue = "1" , required = true ) int  start,
            @NotNull@ApiParam(value = "没也显示条数", required = true)@RequestParam(name = "length", defaultValue = "10" , required = true)  int length,
             @ApiParam(value = "用户/客户ID") @RequestParam(name = "ID", defaultValue = "10") String ID) {

        //start   1      length      10  --  这是第一页
        //start   length + start      length      10  --  这是第2页
        List<ShopAppCustomer> list  = shopAppCustomerApiService.list(start,length,ID);
        int totalCount = shopAppCustomerApiService.getTotalCount();
        return ApiResponse.success(page(list, totalCount), "查询成功");
    }
}
