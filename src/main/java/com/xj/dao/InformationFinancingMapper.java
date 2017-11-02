package com.xj.dao;

import com.xj.pojo.InformationFinancing;

public interface InformationFinancingMapper {
    int deleteByPrimaryKey(Integer ifId);

    int insert(InformationFinancing record);

    int insertSelective(InformationFinancing record);

    InformationFinancing selectByPrimaryKey(Integer ifId);

    int updateByPrimaryKeySelective(InformationFinancing record);

    int updateByPrimaryKey(InformationFinancing record);
    
    InformationFinancing getInformationFinancingBySeId(Integer seId);
}