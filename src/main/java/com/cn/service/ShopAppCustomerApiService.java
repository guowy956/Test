package com.cn.service;

import com.cn.filter.CurrentUserUtils;
import com.cn.mapper.ShopAppCustomerMapper;
import com.cn.model.entity.ShopAppCustomer;
import com.cn.swagger2.API.SuccessModel;
import com.cn.util.ApiResponse;
import com.cn.util.StatusBooks;
import com.cn.util.StringUtil;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ShopAppCustomerApiService-接口
 *
 * @author guowy
 * @create 2017-05-27 15:11
 **/

@Service
public class ShopAppCustomerApiService {


    @Autowired
    private ShopAppCustomerMapper shopAppCustomerMapper;

    public List<ShopAppCustomer> list(int page, int rows, String id) {
        List<ShopAppCustomer> shopAppCustomers = shopAppCustomerMapper.shopAppCustomerList(new RowBounds(page, rows));
        return shopAppCustomers;
    }


    public int getTotalCount() {
        return shopAppCustomerMapper.getTotalCount();
    }
}
