package com.xj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xj.dao.InformationIpoMapper;
import com.xj.pojo.InformationIpo;

@Service("informationIpoService")
public class InformationIpoServiceImpl implements InformationIpoService {

	@Autowired
	private InformationIpoMapper informationIpoMapper;
	
	public List<InformationIpo> getInformationIpoList(Integer seId) {
		
		return informationIpoMapper.getInformationIpoList(seId);
	}

	public InformationIpo getInformationIpo(Integer ipoId) {
		
		return informationIpoMapper.selectByPrimaryKey(ipoId);
	}

	public int addInformationIpo(InformationIpo informationIpo) {
		
		return informationIpoMapper.insertSelective(informationIpo);
	}

	public int updateInformationIpo(InformationIpo informationIpo) {
		
		return informationIpoMapper.updateByPrimaryKeySelective(informationIpo);
	}

	public int deleteInformationIpo(Integer ipoId) {
		
		return informationIpoMapper.deleteByPrimaryKey(ipoId);
	}

}
