package com.xj.dao;

import java.util.List;

import com.xj.pojo.InformationNegative;

public interface InformationNegativeMapper {
    int deleteByPrimaryKey(Integer inId);

    int insert(InformationNegative record);

    int insertSelective(InformationNegative record);

    InformationNegative selectByPrimaryKey(Integer inId);

    int updateByPrimaryKeySelective(InformationNegative record);

    int updateByPrimaryKey(InformationNegative record);
    
    List<InformationNegative> getInformationNegativeList(Integer seId);
}