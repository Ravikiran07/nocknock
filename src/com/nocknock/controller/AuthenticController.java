package com.nocknock.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.nocknock.dao.AuthenticDao;
import com.nocknock.model.TravelBean;
import com.nocknock.model.UserBean;




@Controller
public class AuthenticController {
@Autowired
AuthenticDao authenticDao;
	
	
	/**
	 * Buyer SignUp get Method to load buyersignup jsp page
	 * @return
	 */
	@RequestMapping("/buyersignup")
	public ModelAndView buyerSignUpForm(@ModelAttribute("buyerTravelReq") TravelBean travelBean,HttpServletRequest request, HttpServletResponse response){
		
		request.getSession().setAttribute("travelBean", travelBean);
		return new ModelAndView("buyersignup","command",new UserBean());
	}
	
	/**
	 * Buyer SignUp post method to save buyer signup details 
	 * 
	 */
	@RequestMapping(value="/buyersignup",method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("buyersignup") UserBean userBean,HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView model= null;
		try{
			TravelBean travelBean=(TravelBean)request.getSession().getAttribute("travelBean");
			System.out.println(travelBean.getBTravel()+":travelBean.getBTravel()"+"gggjh");
			authenticDao.BuyerSignUpSave(userBean,travelBean);
			
			if(userBean.getSignup_status().equals("SUCCESS")){
				
				System.out.println(userBean.getSignup_status()); 
			
				request.setAttribute("msg_status","<span style='color:green'>email verification link is sent to your email</span>");
				
				 request.setAttribute("msg_symbol", "success");
			}
		
			else{
			    request.setAttribute("msg_status", "<span style='color:red'>'"+userBean.getSignup_status()+"'</span>");
			    request.setAttribute("msg_symbol", "error");

			}
		}
		catch (Exception e)
			{
			System.out.println(e);
			}
	return new ModelAndView("buyersignup","command",new UserBean());
		
	} 
	/**
	 * 
	 * method for email verfication
	 */
	@RequestMapping("/Verify")
	public ModelAndView verify( HttpServletRequest request, HttpServletResponse response, UserBean userBean){
		ModelAndView model= null;
		model = new ModelAndView("buyerLogin","command",new UserBean());
		try{
		
			String key=(String)request.getParameter("key");
			System.out.println(key+":key");
			authenticDao.verifyEmail(key, userBean);
		}
		catch (Exception e) {
			System.out.println(e);
		}
			
		
		    return model;
	}
	
	/**
	 * Buyer SignIn get Method to load buyerLogin jsp page
	 * @return
	 */
	@RequestMapping("/buyerLogin")
	public ModelAndView buyerSignInForm(){
		return new ModelAndView("buyerLogin","command",new UserBean());
	}
	
	
	/**
	 * Buyer SignIn post method to Authenticate  buyer signin details 
	 * 
	 */

	
	@RequestMapping(value="/buyerLogin",method = RequestMethod.POST)
	public ModelAndView signin(@ModelAttribute("buyerLogin") UserBean userBean ,HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView model= null;
		
		authenticDao.BuyerSignIn(userBean);
			
		if(userBean.getSk_member_id()>=1)
		{
			
			
			request.setAttribute("msg_symbol", "success");
			model = new ModelAndView("welcome");
			
		}
		else
		{	
	
			
			request.setAttribute("msg_status","<span style='color:red'>'"+userBean.getSignin_status()+"'</span>");
			
			
			
			
			model = new ModelAndView("buyerLogin","command",new UserBean());
		
		}
			
		return model;
		
	} 

	/**
	 * Buyer Travel Req get Method to load buyerLogin jsp page
	 * @return
	 */
	
	@RequestMapping("/buyerTravelReq")
	public ModelAndView buyerTravelReqForm(){
		return new ModelAndView("buyerTravelReq","command",new TravelBean());
	}
	

	
	/**
	 * Buyer Travel  Req post method to save buyerTravelReq  details 
	 * 
	 */
	
	
	@RequestMapping(value="/buyerTravel",method = RequestMethod.POST)
	public ModelAndView saveBuyerTravel(@ModelAttribute("buyerTravelReq") TravelBean travelBean)
	{
		ModelAndView model= null;
		try{
			authenticDao.TravelReqSave(travelBean);
			}
		catch (Exception e)
			{
			System.out.println(e);
			}
	return new ModelAndView("buyerTravelReq","command",new TravelBean());
		
	} 
	
	
	
	/**
	 * forgot password get Method to load forgotpassword jsp page
	 * @return
	 */
	@RequestMapping("/forgotpassword")
	public ModelAndView forgotPasswordForm(){
		return new ModelAndView("forgotpassword","command",new UserBean());
	}
	
	/**
	 * forgot password post Method to submit email address
	 * @return
	 */
	
	@RequestMapping(value="/forgotsubmit",method = RequestMethod.POST)
	public ModelAndView forgotpasswordpost(@ModelAttribute("userBean") UserBean userBean,HttpServletRequest request, HttpServletResponse response){
		
		ModelAndView model= null;
		try{
			authenticDao.forgot(userBean);
		}catch (Exception e) {
			System.out.println(e);
			
		}
		
		if(userBean.getSignup_status().equals("SUCCESS")){
			
			System.out.println(userBean.getSignup_status()); 
		
			request.setAttribute("msg_status","<span style='color:green'>forgot password link has been sent to your registered email</span>");
			
			 request.setAttribute("msg_symbol", "success");
		}
	
		else{
		    request.setAttribute("msg_status", "<span style='color:red'>'"+userBean.getSignup_status()+"'</span>");
		    request.setAttribute("msg_symbol", "error");

		}
	
		return new ModelAndView("forgotpassword","command",new UserBean());
	}
	
	

	/**
	 * reset password get Method to load resetpassword jsp page
	 * @return
	 */
	@RequestMapping("/resetpassword")
	public ModelAndView resetform(){
		return new ModelAndView("resetpassword","command",new UserBean());
	}
	
	
	/**
	 * reset password post Method to change password
	 * @return
	 */
	
	@RequestMapping(value="/resetpassword",method = RequestMethod.POST)
	public ModelAndView resetpasswordpost(@ModelAttribute("userBean") UserBean userBean,HttpServletRequest request, HttpServletResponse response){
		
		try{
			Long mkey=(Long) request.getAttribute("mkey");
			authenticDao.resetpassword(userBean,mkey);
		}catch (Exception e){
			System.out.println(e);
		}
		
		
		return new ModelAndView("redirect:/buyerLogin");
	}
	
	
	/**
	 * resendlink get Method to load resendlink jsp page
	 * @return
	 */
	@RequestMapping("/resendlink")
	public ModelAndView resendlinkForm(){
		return new ModelAndView("resendlink","command",new UserBean());
	}
	
	
	
	
	@RequestMapping(value="/resendlink",method = RequestMethod.POST)
	public ModelAndView resendlinkpost(@ModelAttribute("userBean") UserBean userBean,HttpServletRequest request, HttpServletResponse response){
		
		try{
			authenticDao.resend(userBean);
		}catch (Exception e) {
			System.out.println(e);
			
		}
		   if(userBean.getSignup_status().equals("SUCCESS")){
			
			System.out.println(userBean.getSignup_status()); 
		
			request.setAttribute("msg_status","<span style='color:green'>'"+userBean.getSignup_status()+"'</span>");
			
			 request.setAttribute("msg_symbol", "success");
		}
	
		else{
		    request.setAttribute("msg_status", "<span style='color:red'>'"+userBean.getSignup_status()+"'</span>");
		    request.setAttribute("msg_symbol", "error");

		}
	
	
		return new ModelAndView("resendlink","command",new UserBean());
	}
	
	
}

