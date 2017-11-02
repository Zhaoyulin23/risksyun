package com.xj.dao;

import java.util.List;

import com.xj.pojo.PlaGroup;

public interface PlaGroupMapper {
    int deleteByPrimaryKey(Integer groupId);

    int insert(PlaGroup record);

    int insertSelective(PlaGroup record);

    PlaGroup selectByPrimaryKey(Integer groupId);

    int updateByPrimaryKeySelective(PlaGroup record);

    int updateByPrimaryKey(PlaGroup record);
    
    List<PlaGroup> selectAll();
}