package com.xj.dao;

import java.util.List;

import com.xj.pojo.Area;

public interface AreaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Area record);

    int insertSelective(Area record);

    Area selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Area record);

    int updateByPrimaryKey(Area record);
    
    List<Area> getSeProvince();
    
    List<Area> getSeCity(Integer id);
    
    List<Area> getSeDistrict(Integer id);
}