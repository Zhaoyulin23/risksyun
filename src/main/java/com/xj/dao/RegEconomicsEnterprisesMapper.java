package com.xj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xj.pojo.RegEconomicsEnterprises;

public interface RegEconomicsEnterprisesMapper {
    int deleteByPrimaryKey(String rgeId);

    int insert(RegEconomicsEnterprises record);

    int insertSelective(RegEconomicsEnterprises record);

    RegEconomicsEnterprises selectByPrimaryKey(String rgeId);

    int updateByPrimaryKeySelective(RegEconomicsEnterprises record);

    int updateByPrimaryKey(RegEconomicsEnterprises record);

	List<RegEconomicsEnterprises> getRegEconomicsEnterprisesList(@Param(value="startPos") Integer startPos,@Param(value="pageSize") Integer pageSize);

	int getCount();

}