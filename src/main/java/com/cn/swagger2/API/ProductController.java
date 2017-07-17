package com.cn.swagger2.API;

import com.cn.model.entity.Product;
import com.cn.model.select.ProductS;
import com.cn.service.ProductService;
import com.cn.util.ApiResponse;
import io.swagger.annotations.ApiParam;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * ProducrController
 *
 * @author guowy
 * @create 2017-06-22 13:48
 **/
@Controller
public class ProductController extends BaseController implements ProductApi {

    @Autowired
    ProductService<Product ,Product , Long> productService;

    private ProductService<Product ,Product , Long> getService(){
        return productService;
    }

    @Override
    public ResponseEntity<SuccessModel> list(
            @ApiParam(value = "分页开始索引") @RequestParam(value = "start",defaultValue = "0", required = false) Integer start,
            @ApiParam(value = "每页数量") @RequestParam(value = "length",defaultValue = "9", required = false) Integer length,
            @ApiParam(value = "产品名字") @RequestParam(name = "productName", required = false) String productName,
            @ApiParam(value = "产品类型") @RequestParam(name = "productType", required = false) String productType,
            @ApiParam(value = "产品品牌") @RequestParam(name = "brand", required = false) String brand,
            @ApiParam(value = "最高价格(区间)") @RequestParam(name = "maxPrice",defaultValue = "0", required = false) Integer maxPrice,
            @ApiParam(value = "最低价格(区间)") @RequestParam(name = "minPrice",defaultValue = "0", required = false) Integer minPrice,
            @ApiParam(value = "产品状态") @RequestParam(name = "productStatus", required = false) String productStatus,
            @ApiParam(value = "商家") @RequestParam(name = "business", required = false) String business) {
        List<Product> list = getService().getList(productName,brand,business,maxPrice,minPrice,productStatus,productType,new RowBounds(start, length));
        return ApiResponse.success(list,"查询成功");
    }

    @Override
    public ResponseEntity<SuccessModel> list() {
        List<Product> list =  getService().getAll();
        return ApiResponse.success(list,"查询成功");
    }

    @Override
    public ResponseEntity<SuccessModel> add(@ApiParam(value = " ") @RequestBody Product body) {
       int flag =  getService().insert(body);
        return ApiResponse.success(flag,"添加成功");
    }

    @Override
    public ResponseEntity<SuccessModel> update(@ApiParam(value = " ") @RequestBody Product body) {
        return null;
    }

    @Override
    public ResponseEntity<SuccessModel> delete(@ApiParam(value = " ") @RequestBody Product body) {
        return null;
    }
}
