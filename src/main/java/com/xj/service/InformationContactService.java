package com.xj.service;

import java.util.List;

import com.xj.pojo.InformationContact;

public interface InformationContactService {
	
	public List<InformationContact> getInformationContactListBySeId(Integer se_id);

	public int addInformationContact(InformationContact informationContact);
	
	public int updateInformationContact(InformationContact informationContact);
	
	public int delInformationContact(Integer ic_id);
	
	public InformationContact getInformationContract(Integer ic_id);
	
}
