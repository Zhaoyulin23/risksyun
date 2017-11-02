package com.xj.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.xj.dao.SignleEnterpriseMapper;
import com.xj.model.Page;
import com.xj.pojo.SignleEnterprise;

@Service("signleEnterpriseService")
public class SignleEnterpriseServiceImpl implements SignleEnterpriseService {

	@Autowired
	private SignleEnterpriseMapper seMapper;
	
	public ModelAndView getSignleEnterpriseList(HttpServletRequest request,
			ModelAndView modelAndView) {
		
		//获取当前页数
		String pageNow = request.getParameter("pageNow"); 
		
		Page page = null; 
		
		//获取总数据条数
		int totalcount = (int) seMapper.getCount();
		
		List<SignleEnterprise> list = new ArrayList<SignleEnterprise>();
		
		if(pageNow != null){
			page = new Page(totalcount, Integer.parseInt(pageNow));
		}else{
			page = new Page(totalcount, 1);
		}
		list = seMapper.getSignleEnterpriseList(page.getStartPos(), page.getPageSize());
		
		modelAndView.addObject("se_list", list);
		
		modelAndView.addObject("page", page);
		
		return modelAndView;
	}

	public SignleEnterprise selectByPrimaryKey(int se_id) {
		
		return seMapper.selectByPrimaryKey(se_id);
	}

	public int addSignleEnterprise(SignleEnterprise signleEnterprise){
		return seMapper.insertSelective(signleEnterprise);
	}
	
	public int updateSignleEnterprise(SignleEnterprise signleEnterprise){
		return seMapper.updateByPrimaryKeySelective(signleEnterprise);
	}
	
	public int deleteSingleEnterprise(Integer se_id){
		return seMapper.deleteByPrimaryKey(se_id);
	}
}
