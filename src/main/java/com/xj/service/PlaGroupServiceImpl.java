package com.xj.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xj.dao.PlaFunMapper;
import com.xj.dao.PlaGroupMapper;
import com.xj.pojo.PlaFun;
import com.xj.pojo.PlaGroup;

@Service("plaGroupService")
public class PlaGroupServiceImpl implements PlaGroupService {
	
	@Autowired
	private PlaGroupMapper plaGroupMapper;
	
	@Autowired
	private PlaFunMapper plaFunMapper;
	
	public List<PlaGroup> groupList(){
		List<PlaGroup> list = new ArrayList<PlaGroup>();
		
		list = plaGroupMapper.selectAll();
		
		return list;
	}
	
	public PlaGroup groupDetail(int groupId){
		return plaGroupMapper.selectByPrimaryKey(groupId);
	}
	
	public int delete(int groupId){
		return plaGroupMapper.deleteByPrimaryKey(groupId);
	}
	
	public int insertGroup(PlaGroup plaGroup){
		return plaGroupMapper.insertSelective(plaGroup);
	}
	
	public int updateGroup(PlaGroup plaGroup){
		return plaGroupMapper.updateByPrimaryKeySelective(plaGroup);
	}
	
	public List<PlaFun> getFunList(){
		List<PlaFun> list = new ArrayList<PlaFun>();
		
		list = plaFunMapper.selectAll();
		
		return list;
	}
}
