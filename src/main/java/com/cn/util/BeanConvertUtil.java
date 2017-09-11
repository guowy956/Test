package com.cn.util;

import com.cn.exception.BusinessException;
import com.cn.model.domain.AddressLibrary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by newtouch on 2017/9/8.
 */
public class BeanConvertUtil {

    private static Logger logger = LoggerFactory.getLogger(BeanConvertUtil.class);

    public static AddressLibrary addressLibraryConver(com.cn.model.entity.AddressLibrary addressLibrary){
        if (null != addressLibrary){
            AddressLibrary address = new AddressLibrary();
            try {
                PropertyUtils.copyProperties(address,addressLibrary);
            } catch (Exception e) {
                e.printStackTrace();
                logger.error(e.getMessage());
                throw new BusinessException("将 address 转换为 addressLibrary (DB)");
            }
            return address;
        }

        return null;
    }

}
