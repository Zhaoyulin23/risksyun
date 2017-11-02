package com.xj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xj.pojo.IndustryReport;

public interface IndustryReportMapper {
    int deleteByPrimaryKey(Integer industryStatisticsId);

    int insert(IndustryReport record);

    int insertSelective(IndustryReport record);

    IndustryReport selectByPrimaryKey(Integer industryStatisticsId);

    int updateByPrimaryKeySelective(IndustryReport record);

    int updateByPrimaryKey(IndustryReport record);

	List<IndustryReport> getIndustryReportList(@Param(value="startPos") Integer startPos,@Param(value="pageSize") Integer pageSize);

	int getCount();
}