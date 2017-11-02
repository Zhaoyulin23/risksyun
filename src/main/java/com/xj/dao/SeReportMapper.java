package com.xj.dao;

import java.util.List;

import com.xj.pojo.SeReport;

public interface SeReportMapper {
    int deleteByPrimaryKey(Integer reportId);

    int insert(SeReport record);

    int insertSelective(SeReport record);

    SeReport selectByPrimaryKey(Integer reportId);

    int updateByPrimaryKeySelective(SeReport record);

    int updateByPrimaryKey(SeReport record);
    
    public List<SeReport> getSeReportListBySeId(Integer seId);
}