package com.xj.dao;

import java.util.List;

import com.xj.pojo.InformationShareholder;

public interface InformationShareholderMapper {
    int deleteByPrimaryKey(Integer isId);

    int insert(InformationShareholder record);

    int insertSelective(InformationShareholder record);

    InformationShareholder selectByPrimaryKey(Integer isId);

    int updateByPrimaryKeySelective(InformationShareholder record);

    int updateByPrimaryKey(InformationShareholder record);
    
    List<InformationShareholder> getInformationShareholderBySeId(Integer seId);
}