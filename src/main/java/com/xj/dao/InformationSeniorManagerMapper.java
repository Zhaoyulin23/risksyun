package com.xj.dao;

import java.util.List;

import com.xj.pojo.InformationSeniorManager;

public interface InformationSeniorManagerMapper {
    int deleteByPrimaryKey(Integer ismId);

    int insert(InformationSeniorManager record);

    int insertSelective(InformationSeniorManager record);

    InformationSeniorManager selectByPrimaryKey(Integer ismId);

    int updateByPrimaryKeySelective(InformationSeniorManager record);

    int updateByPrimaryKey(InformationSeniorManager record);
    
    public List<InformationSeniorManager> getInformationSeniorManagerListBySeId(Integer seId);
}