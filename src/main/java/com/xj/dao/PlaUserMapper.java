package com.xj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xj.pojo.PlaUser;

public interface PlaUserMapper {
    int deleteByPrimaryKey(Integer plaUserId);

    int insert(PlaUser record);

    int insertSelective(PlaUser record);

    PlaUser selectByPrimaryKey(Integer plaUserId);

    int updateByPrimaryKeySelective(PlaUser record);

    int updateByPrimaryKey(PlaUser record);
    
    PlaUser selectByNamePwd(@Param("plaUserName") String plaUserName,@Param("pla_user_pwd") String pla_user_pwd);
    
    List<PlaUser> selectAll(@Param("plaUserName") String plaUserName);
}