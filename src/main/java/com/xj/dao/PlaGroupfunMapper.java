package com.xj.dao;

import com.xj.pojo.PlaGroupfun;

public interface PlaGroupfunMapper {
    int deleteByPrimaryKey(Integer groupfunId);

    int insert(PlaGroupfun record);

    int insertSelective(PlaGroupfun record);

    PlaGroupfun selectByPrimaryKey(Integer groupfunId);

    int updateByPrimaryKeySelective(PlaGroupfun record);

    int updateByPrimaryKey(PlaGroupfun record);
    
    int deleteByGroupId(Integer groupId);
}