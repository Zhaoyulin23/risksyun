package com.xj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xj.pojo.SignleEnterprise;

public interface SignleEnterpriseMapper {
    int deleteByPrimaryKey(Integer seId);

    int insert(SignleEnterprise record);

    int insertSelective(SignleEnterprise record);

    SignleEnterprise selectByPrimaryKey(Integer seId);

    int updateByPrimaryKeySelective(SignleEnterprise record);

    int updateByPrimaryKey(SignleEnterprise record);
    
    int getCount();
    
    List<SignleEnterprise> getSignleEnterpriseList(@Param(value="startPos") Integer startPos,@Param(value="pageSize") Integer pageSize);
}