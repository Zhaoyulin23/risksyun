package com.xj.service;

import java.util.List;

import com.xj.pojo.InformationShareholder;

public interface InformationShareholderService {

	public List<InformationShareholder> getInformationShareholderBySeId(Integer seId);
	
	public InformationShareholder getInformationShareholder(Integer isId); 
	
	public int addInformationShareholder(InformationShareholder informationShareholder);
	
	public int updateInformationShareholder(InformationShareholder informationShareholder);
	
	public int deleteInformationShareholder(Integer isId);
}
