package com.xj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xj.dao.InformationContactMapper;
import com.xj.pojo.InformationContact;

@Service("informationContactService")
public class InformationContactServiceImpl implements InformationContactService {
	
	@Autowired
	private InformationContactMapper informationContactMapper;
	

	public List<InformationContact> getInformationContactListBySeId(
			Integer seId) {
		
		return informationContactMapper.getInformationContactListBySeId(seId);
	}

	public int addInformationContact(InformationContact informationContact) {
		
		return informationContactMapper.insertSelective(informationContact);
	}
	
	public int updateInformationContact(InformationContact informationContact) {
		
		return informationContactMapper.updateByPrimaryKeySelective(informationContact);
	}

	public int delInformationContact(Integer icId) {
		
		return informationContactMapper.deleteByPrimaryKey(icId);
	}
	
	public InformationContact getInformationContract(Integer icId){
		return informationContactMapper.selectByPrimaryKey(icId);
	}

}
