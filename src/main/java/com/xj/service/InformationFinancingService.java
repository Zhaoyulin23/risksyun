package com.xj.service;

import com.xj.pojo.InformationFinancing;

public interface InformationFinancingService {

	public InformationFinancing getInformationFinancingBySeId(Integer seId);
	
	public int addInformationFinancing(InformationFinancing informationFinancing); 
	
	public int updateInformationFinancing(InformationFinancing informationFinancing);
}
