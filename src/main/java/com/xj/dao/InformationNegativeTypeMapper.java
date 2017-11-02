package com.xj.dao;

import java.util.List;

import com.xj.pojo.InformationNegativeType;

public interface InformationNegativeTypeMapper {
    int deleteByPrimaryKey(Integer intId);

    int insert(InformationNegativeType record);

    int insertSelective(InformationNegativeType record);

    InformationNegativeType selectByPrimaryKey(Integer intId);

    int updateByPrimaryKeySelective(InformationNegativeType record);

    int updateByPrimaryKey(InformationNegativeType record);
    
    List<InformationNegativeType> getInformationNegativeTypeList();
}