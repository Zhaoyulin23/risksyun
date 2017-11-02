package com.xj.dao;

import java.util.List;

import com.xj.pojo.PlaFun;

public interface PlaFunMapper {
    int deleteByPrimaryKey(Integer funId);

    int insert(PlaFun record);

    int insertSelective(PlaFun record);

    PlaFun selectByPrimaryKey(Integer funId);

    int updateByPrimaryKeySelective(PlaFun record);

    int updateByPrimaryKey(PlaFun record);
    
    List<PlaFun> selectAll();
}