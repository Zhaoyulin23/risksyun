package com.xj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xj.dao.InformationNegativeMapper;
import com.xj.dao.InformationNegativeTypeMapper;
import com.xj.pojo.InformationNegative;
import com.xj.pojo.InformationNegativeType;

@Service("informationNegativeService")
public class InformationNegativeServiceImpl implements
		InformationNegativeService {

	@Autowired
	private InformationNegativeMapper informationNegativeMapper;
	
	@Autowired
	private InformationNegativeTypeMapper informationNegativeTypeMapper;
	
	public List<InformationNegative> getInformationNegativeList(Integer seId) {
		
		return informationNegativeMapper.getInformationNegativeList(seId);
	}

	public InformationNegative getInformationNegative(Integer inId) {
		
		return informationNegativeMapper.selectByPrimaryKey(inId);
	}

	public int addInformationNegative(InformationNegative informationNegative) {
		
		return informationNegativeMapper.insertSelective(informationNegative);
	}

	public int updateInformationNegative(InformationNegative informationNegative) {
		
		return informationNegativeMapper.updateByPrimaryKeySelective(informationNegative);
	}

	public int deleteInformationNegative(Integer inId) {
		
		return informationNegativeMapper.deleteByPrimaryKey(inId);
	}

	public List<InformationNegativeType> getInformationNegativeTypeList() {
		
		return informationNegativeTypeMapper.getInformationNegativeTypeList();
	}

}
