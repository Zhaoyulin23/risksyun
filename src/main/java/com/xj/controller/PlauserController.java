package com.xj.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.xj.pojo.PlaFun;
import com.xj.pojo.PlaGroup;
import com.xj.pojo.PlaGroupfun;
import com.xj.pojo.PlaUser;
import com.xj.service.PlaGroupFunService;
import com.xj.service.PlaGroupService;
import com.xj.service.PlaUserService;
import com.xj.util.PubFunction;

@Controller
public class PlauserController {

	@Autowired
	private PlaUserService plaUserService;
	
	@Autowired
	private PlaGroupService plagGroupService;
	
	@Autowired
	private PlaGroupFunService plaGroupFunService;

	@RequestMapping(value = "/doLogin", method = RequestMethod.POST)
	public ModelAndView doLogin(HttpServletRequest request,
			HttpServletResponse response, @RequestParam String userName,
			@RequestParam String userPassword) {
		ModelAndView modelAndView = new ModelAndView();

		PlaUser plaUser = plaUserService.doLogin(userName, userPassword);

		if (plaUser != null) {
			//修改登录时间
			plaUser.setLastLoginTime(new Date());
			plaUserService.updateUser(plaUser);
			request.getSession(true).setAttribute("userinfo", plaUser);
			modelAndView.setViewName("view/index");
		} else {
			modelAndView.addObject("loginMessage", "用户名密码错误！");
			modelAndView.setViewName("view/login");
		}
		return modelAndView;
	}
	
	@RequestMapping(value="/logout")
	public ModelAndView logou(HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView();
		
		request.getSession().removeAttribute("userinfo");

        modelAndView.setViewName("/view/login");
		
		return modelAndView;
	}
	
	/**
	 * 获取用户列表
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "userList")
	public ModelAndView userList(HttpServletRequest request){
		
		ModelAndView modelAndView = new ModelAndView();
		
		PlaUser plaUser = (PlaUser)request.getSession().getAttribute("userinfo");
		 if(plaUser == null){
			 modelAndView.setViewName("/view/login");
			 return modelAndView;
			 
		 }
		 String plaUserName = request.getParameter("plaUserName");
		
		 List<PlaUser> list = new ArrayList<PlaUser>();
		 
		 list = plaUserService.selectUser(plaUserName);
		 
		 modelAndView.addObject("userList", list);
		 
		 modelAndView.setViewName("view/userManage");
		
		 return modelAndView;
		
	}
	
	/**
	 * 用户管理-修改-获取用户信息
	 * @param request
	 * @param plaUserId
	 * @return
	 */
	@RequestMapping(value = "userUpdate")
	public ModelAndView getUser(HttpServletRequest request,@RequestParam int plaUserId){
		ModelAndView modelAndView = new ModelAndView();
		
		PlaUser plaUser = (PlaUser)request.getSession().getAttribute("userinfo");
		 if(plaUser == null){
			 modelAndView.setViewName("/view/login");
			 return modelAndView;
			 
		 }
		 
		 PlaUser user = new PlaUser();
		 
		 user = plaUserService.getUser(plaUserId);
		 
		 modelAndView.addObject("user", user);
		 
		 //获取用户组
		 List<PlaGroup> group_list = new ArrayList<PlaGroup>();
		 group_list = plagGroupService.groupList();
		 modelAndView.addObject("group_list", group_list);
		 
		 modelAndView.setViewName("view/userUpdate");
		 
		 return modelAndView;
	}
	
	/**
	 * 获取用户组列表
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "groupList")
	public ModelAndView getGroupList(HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView();
		
		PlaUser plaUser = (PlaUser)request.getSession().getAttribute("userinfo");
		 if(plaUser == null){
			 modelAndView.setViewName("/view/login");
			 return modelAndView;
			 
		 }
		//获取用户组
		 List<PlaGroup> group_list = new ArrayList<PlaGroup>();
		 group_list = plagGroupService.groupList();
		 
		 modelAndView.addObject("group_list", group_list);
		 
		 modelAndView.setViewName("view/groupManage");
		 
		 return modelAndView;
	}
	
	/**
	 * 账号保存/添加
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/saveUser")
	public ModelAndView addUser(HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView();
		
		PlaUser plaUser = (PlaUser)request.getSession().getAttribute("userinfo");
		 if(plaUser == null){
			 modelAndView.setViewName("/view/login");
			 return modelAndView;
			 
		 }
		 
		 String userIdStr = request.getParameter("plaUserId");
		 
		 int plaUserGroup = Integer.parseInt(request.getParameter("plaUserGroup") == null || request.getParameter("plaUserGroup") == "" ? "0" : request.getParameter("plaUserGroup"));
		 
		 String plaUserName = request.getParameter("plaUserName"); 
		 
		 String plaUserPwd = request.getParameter("plaUserPwd"); 
		 
		 PlaUser user = new PlaUser();
		 user.setPlaUserName(plaUserName);
		 user.setPlaUserGroup(plaUserGroup);
		 if(plaUserPwd != null && plaUserPwd.length() > 0){
			 user.setPlaUserPwd(PubFunction.getSHA(plaUserPwd));
		 }
		 user.setCreateTime(new Date());
		 
		 if(userIdStr != null && userIdStr.length() > 0){
			 int plaUserId = Integer.parseInt(userIdStr);
			 user.setPlaUserId(plaUserId);
			 plaUserService.updateUser(user);
		 }else{
			 plaUserService.saveUser(user);
		 }
		 
		 modelAndView.setViewName("redirect:/userList");
		 
		 return modelAndView;
	}
	
	/**
	 * 修改密码
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/updatePwd")
	public ModelAndView updatePwd(HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView();
		
		PlaUser plaUser = (PlaUser)request.getSession().getAttribute("userinfo");
		 if(plaUser == null){
			 modelAndView.setViewName("/view/login");
			 return modelAndView;
			 
		 }
		 
		 String plaUserPwd = request.getParameter("plaUserPwd"); 
		 
		 String plaUserPwdAgain = request.getParameter("plaUserPwdAgain"); 
		 
		 if(plaUserPwd.equals(plaUserPwdAgain)){
			 
			 String pwd = PubFunction.getSHA(plaUserPwd);
			 plaUser.setPlaUserPwd(pwd);
			 plaUserService.updateUser(plaUser);
			 
		 }
		 
		 modelAndView.setViewName("view/userUpdatePwd");
		 
		 return modelAndView;
	}
	
	/**
	 * 删除用户
	 * @param request
	 * @param plaUserId
	 * @return
	 */
	@RequestMapping(value = "deleteUser")
	public ModelAndView deleteUser(HttpServletRequest request,@RequestParam int plaUserId){
		ModelAndView modelAndView = new ModelAndView();
		
		PlaUser plaUser = (PlaUser)request.getSession().getAttribute("userinfo");
		 if(plaUser == null){
			 modelAndView.setViewName("/view/login");
			 return modelAndView;
			 
		 }
		 
		 plaUserService.deleteUser(plaUserId);
		 
		 modelAndView.setViewName("redirect:/userList");
		 
		 return modelAndView;
	}
	
	/**
	 * 获取用户组列表
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "groupDetail")
	public ModelAndView getGroup(HttpServletRequest request,@RequestParam int groupId){
		ModelAndView modelAndView = new ModelAndView();
		
		PlaUser plaUser = (PlaUser)request.getSession().getAttribute("userinfo");
		 if(plaUser == null){
			 modelAndView.setViewName("/view/login");
			 return modelAndView;
			 
		 }
		 PlaGroup plaGroup = plagGroupService.groupDetail(groupId);
		 
		 modelAndView.addObject("plaGroup", plaGroup);
		 
		 List<PlaFun> fun_list = new ArrayList<PlaFun>();
		 fun_list =plagGroupService.getFunList(); 
		 modelAndView.addObject("fun_list", fun_list);
		 
		 modelAndView.setViewName("view/groupUpdate");
		 
		 return modelAndView;
	}

	/**
	 * 用户组保存/添加
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/saveGroup")
	public ModelAndView saveGroup(HttpServletRequest request,@RequestParam(value = "gfFunIds") int[] gfFunId){
		ModelAndView modelAndView = new ModelAndView();
		
		PlaUser plaUser = (PlaUser)request.getSession().getAttribute("userinfo");
		 if(plaUser == null){
			 modelAndView.setViewName("/view/login");
			 return modelAndView;
			 
		 }
		 
		 String groupIdStr = request.getParameter("groupId");
		 
		 
		 String groupName = request.getParameter("groupName"); 
		 
		 PlaGroup plaGroup = new PlaGroup();
		 
		 plaGroup.setGroupName(groupName);
		 
		 if(groupIdStr != null && groupIdStr.length() > 0){
			 int plaGroupId = Integer.parseInt(groupIdStr);
			 plaGroup.setGroupId(plaGroupId);
			 plagGroupService.updateGroup(plaGroup);
		 }else{
			 plagGroupService.insertGroup(plaGroup);
		 }
		 
		 //保存权限
		 System.out.println(gfFunId[0]);
		 if(gfFunId.length > 0){
			 //先重置
			 plaGroupFunService.deletGroupFun(plaGroup.getGroupId());
			 //添加权限
			 for(int funId : gfFunId){
				 PlaGroupfun plaGroupfun = new PlaGroupfun();
				 plaGroupfun.setGfGroupId(plaGroup.getGroupId());
				 plaGroupfun.setGfFunId(funId);
				 plaGroupFunService.insertGroupFun(plaGroupfun);
			 }
		 }
		 
		 modelAndView.setViewName("redirect:/groupList");
		 
		 return modelAndView;
	}
	
	/**
	 * 删除用户组
	 * @param request
	 * @param groupId
	 * @return
	 */
	@RequestMapping(value = "deleteGroup")
	public ModelAndView deleteGroup(HttpServletRequest request,@RequestParam int groupId){
		ModelAndView modelAndView = new ModelAndView();
		
		PlaUser plaUser = (PlaUser)request.getSession().getAttribute("userinfo");
		 if(plaUser == null){
			 modelAndView.setViewName("/view/login");
			 return modelAndView;
			 
		 }
		 
		 plagGroupService.delete(groupId);
		 
		 modelAndView.setViewName("redirect:/groupList");
		 
		 return modelAndView;
	}
	
	/**
	 * 用户组权限分配详情
	 * @param request
	 * @param groupId
	 * @return
	 */
	public ModelAndView groupFunDetail(HttpServletRequest request,@RequestParam int groupId){
		ModelAndView modelAndView = new ModelAndView();
		
		PlaUser plaUser = (PlaUser)request.getSession().getAttribute("userinfo");
		 if(plaUser == null){
			 modelAndView.setViewName("/view/login");
			 return modelAndView;
			 
		 }
		 
		 
		 
		 return modelAndView;
	}
}
