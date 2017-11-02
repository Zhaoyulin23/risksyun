package com.xj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xj.dao.InformationShareholderMapper;
import com.xj.pojo.InformationShareholder;

@Service("informationShareholderService")
public class InformationShareholderServiceImpl implements
		InformationShareholderService {

	@Autowired
	private InformationShareholderMapper informationShareholderMapper;
	
	public List<InformationShareholder> getInformationShareholderBySeId(
			Integer seId) {
		
		return informationShareholderMapper.getInformationShareholderBySeId(seId);
	}

	public InformationShareholder getInformationShareholder(Integer isId) {
		
		return informationShareholderMapper.selectByPrimaryKey(isId);
	}

	public int addInformationShareholder(
			InformationShareholder informationShareholder) {
		
		return informationShareholderMapper.insertSelective(informationShareholder);
	}

	public int updateInformationShareholder(
			InformationShareholder informationShareholder) {
		
		return informationShareholderMapper.updateByPrimaryKeySelective(informationShareholder);
	}

	public int deleteInformationShareholder(Integer isId) {
		
		return informationShareholderMapper.deleteByPrimaryKey(isId);
	}

}
