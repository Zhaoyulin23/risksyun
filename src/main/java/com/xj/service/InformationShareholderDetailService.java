package com.xj.service;

import java.util.List;

import com.xj.pojo.InformationShareholderDetail;
import com.xj.pojo.ShareholdersBackgroundType;

public interface InformationShareholderDetailService {

	public List<InformationShareholderDetail> getInformationShareholderDetailListByIsId(Integer isId);
	
	public InformationShareholderDetail getInformationShareholderDetail(Integer isdId);
	
	public int addInformationShareholderDetail(InformationShareholderDetail informationShareholderDetail);
	
	public int updateInformationShareholderDetail(InformationShareholderDetail informationShareholderDetail);
	
	public int deleteInformationShareholderDetail(Integer isdId);
	
	public List<ShareholdersBackgroundType> getSbTypeList();
}
