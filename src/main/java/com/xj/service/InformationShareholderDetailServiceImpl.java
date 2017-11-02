package com.xj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xj.dao.InformationShareholderDetailMapper;
import com.xj.dao.ShareholdersBackgroundTypeMapper;
import com.xj.pojo.InformationShareholderDetail;
import com.xj.pojo.ShareholdersBackgroundType;

@Service("informationShareholderDetail")
public class InformationShareholderDetailServiceImpl implements
		InformationShareholderDetailService {

	@Autowired
	private InformationShareholderDetailMapper informationShareholderDetailMapper;
	
	@Autowired
	private ShareholdersBackgroundTypeMapper shareholdersBackgroundTypeMapper;
	
	public List<InformationShareholderDetail> getInformationShareholderDetailListByIsId(
			Integer isId) {
		
		return informationShareholderDetailMapper.getInformationShareholderDetailListByIsId(isId);
	}

	public InformationShareholderDetail getInformationShareholderDetail(Integer isdId) {
		
		return informationShareholderDetailMapper.selectByPrimaryKey(isdId);
	}

	public int addInformationShareholderDetail(
			InformationShareholderDetail informationShareholderDetail) {
		
		return informationShareholderDetailMapper.insertSelective(informationShareholderDetail);
	}

	public int updateInformationShareholderDetail(
			InformationShareholderDetail informationShareholderDetail) {
		
		return informationShareholderDetailMapper.updateByPrimaryKeySelective(informationShareholderDetail);
	}

	public int deleteInformationShareholderDetail(Integer isdId) {
		
		return informationShareholderDetailMapper.deleteByPrimaryKey(isdId);
	}
	
	public List<ShareholdersBackgroundType> getSbTypeList(){
		return shareholdersBackgroundTypeMapper.getSbTypeList();
	}

}
