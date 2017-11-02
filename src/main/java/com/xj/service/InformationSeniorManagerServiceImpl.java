package com.xj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xj.dao.InformationSeniorManagerMapper;
import com.xj.pojo.InformationSeniorManager;

@Service("informationSeniorManagerService")
public class InformationSeniorManagerServiceImpl implements InformationSeniorManagerService{

	
	@Autowired
	private InformationSeniorManagerMapper informationSeniorManagerMapper;
	
	public List<InformationSeniorManager> getInformationSeniorManagerListBySeId(Integer se_id) {
		
		return informationSeniorManagerMapper.getInformationSeniorManagerListBySeId(se_id);
	}

	public InformationSeniorManager getInformationSeniorManagerDetail(
			Integer ismId) {
		
		return informationSeniorManagerMapper.selectByPrimaryKey(ismId);
	}

	public int addInformationSeniorManager(
			InformationSeniorManager informationSeniorManager) {
		
		return informationSeniorManagerMapper.insertSelective(informationSeniorManager);
	}

	public int updateInformationSeniorManager(
			InformationSeniorManager informationSeniorManager) {
		
		return informationSeniorManagerMapper.updateByPrimaryKeySelective(informationSeniorManager);
	}

	public int deleteInformationSeniorManager(Integer ismId) {
		
		return informationSeniorManagerMapper.deleteByPrimaryKey(ismId);
	}

}
