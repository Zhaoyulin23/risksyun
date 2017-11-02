package com.xj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xj.pojo.RegEconomicsMain;

public interface RegEconomicsMainMapper {
    int deleteByPrimaryKey(Integer remId);

    int insert(RegEconomicsMain record);

    int insertSelective(RegEconomicsMain record);

    RegEconomicsMain selectByPrimaryKey(Integer remId);

    int updateByPrimaryKeySelective(RegEconomicsMain record);

    int updateByPrimaryKey(RegEconomicsMain record);

	int getCount();

	List<RegEconomicsMain> getRegEconomicsMainList(@Param(value="startPos") Integer startPos,@Param(value="pageSize") Integer pageSize);
}