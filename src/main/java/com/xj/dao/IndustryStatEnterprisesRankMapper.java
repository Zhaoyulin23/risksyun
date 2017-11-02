package com.xj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xj.pojo.IndustryStatEnterprisesRank;

public interface IndustryStatEnterprisesRankMapper {
    int deleteByPrimaryKey(Integer ierId);

    int insert(IndustryStatEnterprisesRank record);

    int insertSelective(IndustryStatEnterprisesRank record);

    IndustryStatEnterprisesRank selectByPrimaryKey(Integer ierId);

    int updateByPrimaryKeySelective(IndustryStatEnterprisesRank record);

    int updateByPrimaryKey(IndustryStatEnterprisesRank record);

	int getCount();

	List<IndustryStatEnterprisesRank> getIndustryStatEnterprisesRankList(
			@Param(value="startPos") Integer startPos,@Param(value="pageSize") Integer pageSize);
}