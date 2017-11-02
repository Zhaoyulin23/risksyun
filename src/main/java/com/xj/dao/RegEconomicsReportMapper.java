package com.xj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xj.pojo.RegEconomicsReport;

public interface RegEconomicsReportMapper {
    int deleteByPrimaryKey(Integer rerId);

    int insert(RegEconomicsReport record);

    int insertSelective(RegEconomicsReport record);

    RegEconomicsReport selectByPrimaryKey(Integer rerId);

    int updateByPrimaryKeySelective(RegEconomicsReport record);

    int updateByPrimaryKey(RegEconomicsReport record);

	List<RegEconomicsReport> getRegEconomicsReportList(@Param(value="startPos") Integer startPos,@Param(value="pageSize") Integer pageSize);

	int getCount();
}