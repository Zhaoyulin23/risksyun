package com.xj.service;

import java.util.List;

import com.xj.pojo.PlaFun;
import com.xj.pojo.PlaGroup;

public interface PlaGroupService {
	
	public List<PlaGroup> groupList();
	
	public PlaGroup groupDetail(int groupId);
	
	public int delete(int groupId);
	
	public int insertGroup(PlaGroup plaGroup);
	
	public int updateGroup(PlaGroup plaGroup);
	
	public List<PlaFun> getFunList();
}
