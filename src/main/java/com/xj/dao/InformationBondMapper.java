package com.xj.dao;

import java.util.List;

import com.xj.pojo.InformationBond;

public interface InformationBondMapper {
    int deleteByPrimaryKey(Integer ibId);

    int insert(InformationBond record);

    int insertSelective(InformationBond record);

    InformationBond selectByPrimaryKey(Integer ibId);

    int updateByPrimaryKeySelective(InformationBond record);

    int updateByPrimaryKey(InformationBond record);
    
    List<InformationBond> getInformationBondList(Integer seId);
}