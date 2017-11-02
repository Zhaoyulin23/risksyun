package com.xj.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xj.dao.PlaUserMapper;
import com.xj.pojo.PlaUser;
import com.xj.util.PubFunction;

@Service("plaUserService")
public class PlaUserServiceImpl implements PlaUserService {

	
	@Autowired
	private PlaUserMapper plaUserMapper;
	
	public PlaUser doLogin(String userName, String userPassword) {
		
		String userPwd = PubFunction.getSHA(userPassword);
		
		PlaUser plaUser = plaUserMapper.selectByNamePwd(userName, userPwd);
		
		return plaUser;
	}
	
	public List<PlaUser> selectUser(String plaUserName){
		List<PlaUser> list = new ArrayList<PlaUser>();
		
		if(plaUserName != null && plaUserName.length() >0){
			plaUserName = "%" + plaUserName + "%";
		}
		
		list = plaUserMapper.selectAll(plaUserName);
		
		return list;
	}
	
	public PlaUser getUser(int plaUserId){
		return plaUserMapper.selectByPrimaryKey(plaUserId);
	}
	
	
	public int updateUser(PlaUser plaUser){
		
		return plaUserMapper.updateByPrimaryKeySelective(plaUser);
	}
	
	public int saveUser(PlaUser plaUser){
		
		return plaUserMapper.insertSelective(plaUser);
	}

	public int deleteUser(int plaUserId){
		return plaUserMapper.deleteByPrimaryKey(plaUserId);
	}
}
