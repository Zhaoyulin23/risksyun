package com.xj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xj.dao.InformationBondMapper;
import com.xj.pojo.InformationBond;

@Service("informationBondService")
public class InformationBondServiceImpl implements InformationBondService {

	@Autowired
	private InformationBondMapper informationBondMapper;
	
	public List<InformationBond> getInformationBondList(Integer seId) {
		
		return informationBondMapper.getInformationBondList(seId);
	}

	public InformationBond getInformationBond(Integer ibId) {
		
		return informationBondMapper.selectByPrimaryKey(ibId);
	}

	public int addInformationBond(InformationBond informationBond) {
		
		return informationBondMapper.insertSelective(informationBond);
	}

	public int updateInformationBond(InformationBond informationBond) {
		
		return informationBondMapper.updateByPrimaryKeySelective(informationBond);
	}

	public int deleteInformationBond(Integer ibId) {
		
		return informationBondMapper.deleteByPrimaryKey(ibId);
	}

}
