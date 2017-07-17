package com.cn.service;

import com.cn.mapper.ProductMapper;
import com.cn.model.entity.Product;
import com.cn.model.select.ProductS;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * service
 *
 * @author guowy
 * @create 2017-06-22 15:29
 **/
@Service
public class ProductService <T,S,PK extends Serializable> extends CommonsService<T,S, PK>{

    @Autowired
    ProductMapper<T,S,PK> productMapper;
    @Override
    public ProductMapper<T, S, PK> getMapper(){
        return productMapper;
    }

    public List<Product> getList(String productName,  String brand, String business, Integer maxPrice, Integer minPrice, String productStatus, String productType, RowBounds rowBounds) {
        return getMapper().getList(productName, brand, business, maxPrice, minPrice, productStatus, productType);
    }
}
