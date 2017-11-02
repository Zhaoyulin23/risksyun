package com.xj.service;

import java.util.List;

import com.xj.pojo.InformationSeniorManager;

public interface InformationSeniorManagerService {
	
	public List<InformationSeniorManager> getInformationSeniorManagerListBySeId(Integer se_id);
	
	public InformationSeniorManager getInformationSeniorManagerDetail(Integer ismId);
	
	public int addInformationSeniorManager(InformationSeniorManager informationSeniorManager);
	
	public int updateInformationSeniorManager(InformationSeniorManager informationSeniorManager);
	
	public int deleteInformationSeniorManager(Integer ismId);
}
