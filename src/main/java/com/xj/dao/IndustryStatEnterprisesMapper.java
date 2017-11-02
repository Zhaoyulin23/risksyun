package com.xj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xj.pojo.IndustryStatEnterprises;

public interface IndustryStatEnterprisesMapper {
    int deleteByPrimaryKey(Integer iseId);

    int insert(IndustryStatEnterprises record);

    int insertSelective(IndustryStatEnterprises record);

    IndustryStatEnterprises selectByPrimaryKey(Integer iseId);

    int updateByPrimaryKeySelective(IndustryStatEnterprises record);

    int updateByPrimaryKey(IndustryStatEnterprises record);

	int getCount();

	List<IndustryStatEnterprises> getIndustryList(@Param(value="startPos") Integer startPos,@Param(value="pageSize") Integer pageSize);
}