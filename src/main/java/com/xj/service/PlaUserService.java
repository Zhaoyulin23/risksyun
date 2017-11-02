package com.xj.service;

import java.util.List;

import com.xj.pojo.PlaUser;

public interface PlaUserService {

	public PlaUser doLogin(String userName, String userPassword);
	
	public int updateUser(PlaUser plaUser);
	
	public int saveUser(PlaUser plaUser);
	
	public List<PlaUser> selectUser(String plaUserName);
	
	public PlaUser getUser(int plaUserId);
	
	public int deleteUser(int plaUserId);
}
