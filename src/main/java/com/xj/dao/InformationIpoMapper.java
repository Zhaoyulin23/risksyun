package com.xj.dao;

import java.util.List;

import com.xj.pojo.InformationIpo;

public interface InformationIpoMapper {
    int deleteByPrimaryKey(Integer ipoId);

    int insert(InformationIpo record);

    int insertSelective(InformationIpo record);

    InformationIpo selectByPrimaryKey(Integer ipoId);

    int updateByPrimaryKeySelective(InformationIpo record);

    int updateByPrimaryKey(InformationIpo record);
    
    List<InformationIpo> getInformationIpoList(Integer seId);
}