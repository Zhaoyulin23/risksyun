package com.xj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xj.dao.InformationFinancingMapper;
import com.xj.pojo.InformationFinancing;

@Service("informationFinancingService")
public class InformationFinancingServiceImpl implements
		InformationFinancingService {

	
	@Autowired
	private InformationFinancingMapper informationFinancingMapper;
	
	public InformationFinancing getInformationFinancingBySeId(Integer seId) {
		
		return informationFinancingMapper.getInformationFinancingBySeId(seId);
	}

	public int addInformationFinancing(InformationFinancing informationFinancing) {
		
		return informationFinancingMapper.insertSelective(informationFinancing);
	}

	public int updateInformationFinancing(
			InformationFinancing informationFinancing) {
		
		return informationFinancingMapper.updateByPrimaryKeySelective(informationFinancing);
	}

}
