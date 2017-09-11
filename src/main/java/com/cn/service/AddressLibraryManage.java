package com.cn.service;

import com.cn.mapper.BaseManage;
import com.cn.model.domain.AddressLibrary;
import com.cn.model.domain.AddressLibraryExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by newtouch on 2017/9/7.
 */
@Service
public class AddressLibraryManage extends BaseManage<Long> {

    @Autowired
    private AddressLibraryService<AddressLibrary,AddressLibraryExample,Long> service;

    @Override
    public AddressLibraryService<AddressLibrary,AddressLibraryExample,Long> getService() {
        return  service;
    }

    public Boolean isAddressLibraryExist(Long ID) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
        .append("COUNT(*) ")
        .append("FROM ")
        .append("address_library ")
        .append("WHERE 1=1 ");
        if(null != ID)
            sql.append("and id <>"+ID);
        int count = getService().countBySQL(sql.toString());
        return count == 0 ? false : true;
    }

    public List<Map<String,Object>> selectByUserID(Long userId) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM address_library WHERE 1=1 ").append("AND user_id = "+userId);
        return getService().findBySQL(sql.toString());
    }
}
