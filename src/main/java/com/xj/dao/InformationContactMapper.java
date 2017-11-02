package com.xj.dao;

import java.util.List;

import com.xj.pojo.InformationContact;

public interface InformationContactMapper {
    int deleteByPrimaryKey(Integer icId);

    int insert(InformationContact record);

    int insertSelective(InformationContact record);

    InformationContact selectByPrimaryKey(Integer icId);

    int updateByPrimaryKeySelective(InformationContact record);

    int updateByPrimaryKey(InformationContact record);
    
    public List<InformationContact> getInformationContactListBySeId(Integer se_id);
    
}