package com.xj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xj.dao.PlaGroupfunMapper;
import com.xj.pojo.PlaGroupfun;

@Service("plaGroupFunService")
public class PlaGroupFunServiceImpl implements PlaGroupFunService {
	
	@Autowired
	private PlaGroupfunMapper plaGroupfunMapper;
	
	public int insertGroupFun(PlaGroupfun plaGroupfun){
		return plaGroupfunMapper.insertSelective(plaGroupfun);
	}
	
	public int deletGroupFun(int groupId){
		return plaGroupfunMapper.deleteByGroupId(groupId);
	}
}
