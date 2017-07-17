package com.cn.swagger2.API;

import com.cn.model.entity.Product;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * ProducrApi
 *
 * @author guowy
 * @create 2017-06-22 13:48
 **/

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-09T10:04:35.830Z")
@Api(value = "product", description = "the product API")
//@RequestMapping(value = "/api")
public interface ProductApi {

    @ApiOperation(value = "产品列表" , notes = "产品列表" , tags = { })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful response" ,response = SuccessModel.class),
            @ApiResponse(code = 200, message = "unexpected error") })
    @RequestMapping(value = "/product",method = RequestMethod.GET)
    ResponseEntity<SuccessModel> list(
            @ApiParam(value = "分页开始索引") @RequestParam(value = "start",defaultValue = "0",required = false) Integer start,
            @ApiParam(value = "每页数量") @RequestParam(value = "length",defaultValue = "9", required = false) Integer length,
            @ApiParam(value = "产品名字") @RequestParam(name = "productName",required = false) String productName,
            @ApiParam(value = "产品类型") @RequestParam(name = "productType",required = false) String productType,
            @ApiParam(value = "产品品牌") @RequestParam(name = "brand",required = false) String brand,
            @ApiParam(value = "最高价格(区间)") @RequestParam(name = "maxPrice",defaultValue = "0",required = false) Integer maxPrice,
            @ApiParam(value = "最低价格(区间)") @RequestParam(name = "minPrice",defaultValue = "0",required = false) Integer minPrice,
            @ApiParam(value = "产品状态") @RequestParam(name = "productStatus",required = false) String productStatus,
            @ApiParam(value = "商家") @RequestParam(name = "business",required = false) String business
            );
    @ApiOperation(value = "产品列表" , notes = "产品列表" , tags = { })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful response" ,response = SuccessModel.class),
            @ApiResponse(code = 200, message = "unexpected error") })
    @RequestMapping(value = "/getProductAll",method = RequestMethod.GET)
    ResponseEntity<SuccessModel> list();


    @ApiOperation(value = "添加产品" , notes = "产品列表" , tags = { })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful response" ,response = SuccessModel.class),
            @ApiResponse(code = 200, message = "unexpected error") })
    @RequestMapping(value = "/product",method = RequestMethod.POST)
    ResponseEntity<SuccessModel> add(@ApiParam(value = "角色") @RequestBody Product body );


    @ApiOperation(value = "修改产品" , notes = "产品列表" , tags = { })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful response" ,response = SuccessModel.class),
            @ApiResponse(code = 200, message = "unexpected error") })
    @RequestMapping(value = "/product",method = RequestMethod.PUT)
    ResponseEntity<SuccessModel> update(@ApiParam(value = "角色") @RequestBody Product body );


    @ApiOperation(value = "删除产品" , notes = "产品列表" , tags = { })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful response" ,response = SuccessModel.class),
            @ApiResponse(code = 200, message = "unexpected error") })
    @RequestMapping(value = "/product",method = RequestMethod.DELETE)
    ResponseEntity<SuccessModel> delete(@ApiParam(value = "角色") @RequestBody Product body );
}
