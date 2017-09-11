package com.cn.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.CollectionUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.*;

import static org.apache.commons.beanutils.PropertyUtils.*;

public class PropertyUtils {

    private static final Log log = LogFactory.getLog(PropertyUtils.class);

    public static void copyProperties(final Object dest, final Object orig)
            throws IllegalAccessException, InvocationTargetException,
            NoSuchMethodException {

        if (dest == null) {
            throw new IllegalArgumentException
                    ("No destination bean specified");
        }
        if (orig == null) {
            throw new IllegalArgumentException("No origin bean specified");
        }

        final PropertyDescriptor[] origDescriptors = getPropertyDescriptors(orig);
        for (PropertyDescriptor origDescriptor : origDescriptors) {
            final String name = origDescriptor.getName();
            final String type = origDescriptor.getPropertyType().toString();
            if (isReadable(orig, name) && isWriteable(dest, name)) {
                try {
                    final Object value = getSimpleProperty(orig, name);
                    if (type.equals("class java.util.Date"))
                    {
                        if(name.indexOf("Time") >= 0 || name.equals("birthday") || name.indexOf("date") >= 0 || name.indexOf("Date") >= 0){
                            if(null != value){
                                Date date = (Date) value;
                                setSimpleProperty( dest, name, date.getTime() );
                            }else{
                                setSimpleProperty( dest, name, null );
                            }
                        }else{
                            setSimpleProperty( dest, name, value );
                        }

                    }

                    if (type.equals("class java.lang.Long"))
                    {
                        if( value == null ){
                            setSimpleProperty(dest, name, value);
                            continue;
                        }
                        // 日期
                        if(name.indexOf("time") >= 0 || name.indexOf("Time") >= 0 || name.equals("birthday") || name.indexOf("date") >= 0 || name.indexOf("Date") >= 0){
                            Long v = (Long) value;
                            Date date = null;
                            if(v == 0){
                                date = null;
                            }else{
                                date = new Date(v);
                            }
                            setSimpleProperty(dest, name, date );
                        }else{
                            setSimpleProperty(dest, name, value);
                        }
                    }

                    if (type.equals("class java.lang.String")){

                        setSimpleProperty(dest, name, value);
                    }

                    if (type.equals("class java.lang.Integer"))
                    {
                        setSimpleProperty(dest, name, value);
                    }
                    if (type.equals("class java.lang.Short"))
                    {
                        setSimpleProperty(dest, name, value);
                    }
                    if (type.equals("class java.lang.Double"))
                    {
                        if(value == null){
                            setSimpleProperty(dest, name, value);
                        }else{
                            // 暂时将所有double 都转换成 BigDecimal
                            Double d = (Double) value;
                            String dTos = String.valueOf(d);
                            BigDecimal bigDecimal = new BigDecimal(dTos);
                            setSimpleProperty(dest, name, bigDecimal);
                        }

                    }
                    if (type.equals("class java.lang.Boolean"))
                    {
                        setSimpleProperty(dest, name, value);
                    }
                    if (type.equals("class java.math.BigDecimal"))
                    {
                        try {
                            if(dest.getClass().getDeclaredField(name).getType().toString().equals("class java.lang.Double") ){
                                if (null != value)
                                    setSimpleProperty(dest, name, ((BigDecimal)value).doubleValue());
                                else
                                    setSimpleProperty(dest, name, null);
                            }else {
                                setSimpleProperty(dest, name, value);
                            }
                        } catch (NoSuchFieldException e) {
                            e.printStackTrace();
                        }
                    }
                    if (type.equals("class java.lang.Byte"))
                    {
                        setSimpleProperty(dest, name, value);
                    }
                } catch (final NoSuchMethodException e) {
                    log.error("Error writing to '" + name + "' on class '" + dest.getClass() + "'", e);
                }
            }
        }

    }

    /**
     * 将a_bc转换成aBc形式
     * @param list
     * @return
     */
    public static List<Map<String,Object>> convertProperty(List<Map<String,Object>> list){
        if(CollectionUtils.isEmpty(list))
            return list;
        List<Map<String,Object>> result = new ArrayList<>(list.size());
        for(Map<String,Object> map:list){
            Map<String,Object> resultMap = new HashMap<String,Object>();
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                resultMap.put(columnToProperty(entry.getKey()),entry.getValue());
            }
            result.add(resultMap);
        }
        return result;
    }

    public static String columnToProperty(String column) {
        StringBuilder result = new StringBuilder();
        // 快速检查
        if (column == null || column.isEmpty()) {
            // 没必要转换
            return "";
        } else if (!column.contains("_")) {
            // 不含下划线，仅将首字母小写
            return column.substring(0, 1).toLowerCase() + column.substring(1);
        } else {
            // 用下划线将原始字符串分割
            String[] columns = column.split("_");
            for (String columnSplit : columns) {
                // 跳过原始字符串中开头、结尾的下换线或双重下划线
                if (columnSplit.isEmpty()) {
                    continue;
                }
                // 处理真正的驼峰片段
                if (result.length() == 0) {
                    // 第一个驼峰片段，全部字母都小写
                    result.append(columnSplit.toLowerCase());
                } else {
                    // 其他的驼峰片段，首字母大写
                    result.append(columnSplit.substring(0, 1).toUpperCase()).append(columnSplit.substring(1).toLowerCase());
                }
            }
            return result.toString();
        }

    }
}
