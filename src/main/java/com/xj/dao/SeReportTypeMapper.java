package com.xj.dao;

import java.util.List;

import com.xj.pojo.SeReportType;

public interface SeReportTypeMapper {
    int deleteByPrimaryKey(Integer rtId);

    int insert(SeReportType record);

    int insertSelective(SeReportType record);

    SeReportType selectByPrimaryKey(Integer rtId);

    int updateByPrimaryKeySelective(SeReportType record);

    int updateByPrimaryKey(SeReportType record);
    
    public List<SeReportType> getSeReportTypeList();
}