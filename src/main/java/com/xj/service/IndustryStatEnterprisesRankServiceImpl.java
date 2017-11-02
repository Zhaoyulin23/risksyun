package com.xj.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.xj.dao.IndustryStatEnterprisesRankMapper;
import com.xj.model.Page;
import com.xj.pojo.IndustryStatEnterprisesRank;

@Service("industryStatEnterprisesRankService")
public class IndustryStatEnterprisesRankServiceImpl implements IndustryStatEnterprisesRankService {

	@Autowired
	private IndustryStatEnterprisesRankMapper ierMapper;
	
	public ModelAndView getIndustryStatEnterprisesRankList(HttpServletRequest request,
			ModelAndView modelAndView) {
		
		//获取当前页数
		String pageNow = request.getParameter("pageNow"); 
		
		Page page = null; 
		
		//获取总数据条数
		int totalcount = (int) ierMapper.getCount();
		
		List<IndustryStatEnterprisesRank> list = new ArrayList<IndustryStatEnterprisesRank>();
		
		if(pageNow != null){
			page = new Page(totalcount, Integer.parseInt(pageNow));
		}else{
			page = new Page(totalcount, 1);
		}
		
		list = ierMapper.getIndustryStatEnterprisesRankList(page.getStartPos(), page.getPageSize());
		
		modelAndView.addObject("ier_list", list);
		
		modelAndView.addObject("page", page);
		
		return modelAndView;
	}

	public IndustryStatEnterprisesRank selectByPrimaryKey(int ier_id) {
		
		return ierMapper.selectByPrimaryKey(ier_id);
	}

	public int addIndustryStatEnterprisesRank(IndustryStatEnterprisesRank industryStatEnterprisesRank){
		return ierMapper.insertSelective(industryStatEnterprisesRank);
	}
	
	public int updateIndustryStatEnterprisesRank(IndustryStatEnterprisesRank industryStatEnterprisesRank){
		return ierMapper.updateByPrimaryKeySelective(industryStatEnterprisesRank);
	}
	
	public int deleteIndustryStatEnterprisesRank(Integer ier_id){
		return ierMapper.deleteByPrimaryKey(ier_id);
	}
}
