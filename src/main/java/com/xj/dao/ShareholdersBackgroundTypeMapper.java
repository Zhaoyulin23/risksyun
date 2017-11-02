package com.xj.dao;

import java.util.List;

import com.xj.pojo.ShareholdersBackgroundType;

public interface ShareholdersBackgroundTypeMapper {
    int deleteByPrimaryKey(Integer sbId);

    int insert(ShareholdersBackgroundType record);

    int insertSelective(ShareholdersBackgroundType record);

    ShareholdersBackgroundType selectByPrimaryKey(Integer sbId);

    int updateByPrimaryKeySelective(ShareholdersBackgroundType record);

    int updateByPrimaryKey(ShareholdersBackgroundType record);
    
    List<ShareholdersBackgroundType> getSbTypeList();
}