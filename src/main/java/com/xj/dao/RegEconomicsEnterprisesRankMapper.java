package com.xj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xj.pojo.RegEconomicsEnterprisesRank;

public interface RegEconomicsEnterprisesRankMapper {
    int deleteByPrimaryKey(Integer rerId);

    int insert(RegEconomicsEnterprisesRank record);

    int insertSelective(RegEconomicsEnterprisesRank record);

    RegEconomicsEnterprisesRank selectByPrimaryKey(Integer rerId);

    int updateByPrimaryKeySelective(RegEconomicsEnterprisesRank record);

    int updateByPrimaryKey(RegEconomicsEnterprisesRank record);

	List<RegEconomicsEnterprisesRank> getRegEconomicsEnterprisesRankList(@Param(value="startPos") Integer startPos,@Param(value="pageSize") Integer pageSize);

	int getCount();
}