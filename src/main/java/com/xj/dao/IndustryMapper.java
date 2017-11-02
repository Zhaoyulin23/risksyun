package com.xj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xj.pojo.Industry;

public interface IndustryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Industry record);

    int insertSelective(Industry record);

    Industry selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Industry record);

    int updateByPrimaryKeyWithBLOBs(Industry record);

    int updateByPrimaryKey(Industry record);
    
    List<Industry> getSeIndustryCategory();
    
    List<Industry> getSeIndustryClass(Integer industryCategory);
    
    List<Industry> getSeIndustrySclass(Integer industryClass);

	int getCount();

	List<Industry> getIndustryList(@Param(value="startPos") Integer startPos,@Param(value="pageSize") Integer pageSize);
}