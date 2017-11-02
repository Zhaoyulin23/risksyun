package com.xj.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.xj.dao.RegEconomicsEnterprisesRankMapper;
import com.xj.model.Page;
import com.xj.pojo.RegEconomicsEnterprisesRank;

@Service("regEconomicsEnterprisesRankService")
public class RegEconomicsEnterprisesRankServiceImpl implements RegEconomicsEnterprisesRankService {

	@Autowired
	private RegEconomicsEnterprisesRankMapper rerMapper;
	
	public ModelAndView getRegEconomicsEnterprisesRankList(HttpServletRequest request,
			ModelAndView modelAndView) {
		
		//获取当前页数
		String pageNow = request.getParameter("pageNow"); 
		
		Page page = null; 
		
		//获取总数据条数
		int totalcount = (int) rerMapper.getCount();
		
		List<RegEconomicsEnterprisesRank> list = new ArrayList<RegEconomicsEnterprisesRank>();
		
		if(pageNow != null){
			page = new Page(totalcount, Integer.parseInt(pageNow));
		}else{
			page = new Page(totalcount, 1);
		}
		
		list = rerMapper.getRegEconomicsEnterprisesRankList(page.getStartPos(), page.getPageSize());
		
		modelAndView.addObject("rer_list", list);
		
		modelAndView.addObject("page", page);
		
		return modelAndView;
	}

	public RegEconomicsEnterprisesRank selectByPrimaryKey(int rer_id) {
		
		return rerMapper.selectByPrimaryKey(rer_id);
	}

	public int addRegEconomicsEnterprisesRank(RegEconomicsEnterprisesRank regEconomicsEnterprisesRank){
		return rerMapper.insertSelective(regEconomicsEnterprisesRank);
	}
	
	public int updateRegEconomicsEnterprisesRank(RegEconomicsEnterprisesRank regEconomicsEnterprisesRank){
		return rerMapper.updateByPrimaryKeySelective(regEconomicsEnterprisesRank);
	}
	
	public int deleteRegEconomicsEnterprisesRank(Integer rer_id){
		return rerMapper.deleteByPrimaryKey(rer_id);
	}
}
