package com.cn.mapper;

import com.cn.model.entity.UserRoleKey;

public interface UserRoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_role
     *
     * @mbggenerated Wed Jun 28 14:04:27 CST 2017
     */
    int deleteByPrimaryKey(UserRoleKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_role
     *
     * @mbggenerated Wed Jun 28 14:04:27 CST 2017
     */
    int insert(UserRoleKey record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_role
     *
     * @mbggenerated Wed Jun 28 14:04:27 CST 2017
     */
    int insertSelective(UserRoleKey record);
}