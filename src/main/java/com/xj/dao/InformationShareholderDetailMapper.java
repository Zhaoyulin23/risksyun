package com.xj.dao;

import java.util.List;

import com.xj.pojo.InformationShareholderDetail;

public interface InformationShareholderDetailMapper {
    int deleteByPrimaryKey(Integer isdId);

    int insert(InformationShareholderDetail record);

    int insertSelective(InformationShareholderDetail record);

    InformationShareholderDetail selectByPrimaryKey(Integer isdId);

    int updateByPrimaryKeySelective(InformationShareholderDetail record);

    int updateByPrimaryKey(InformationShareholderDetail record);
    
    public List<InformationShareholderDetail> getInformationShareholderDetailListByIsId(Integer isId);
}