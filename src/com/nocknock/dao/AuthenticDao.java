package com.nocknock.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.nocknock.model.TravelBean;
import com.nocknock.model.UserBean;
import com.nocknock.mailapi.SendEmailUsingGMailSMTP;

public class AuthenticDao {
	
	ResourceBundle resource = ResourceBundle.getBundle("resources/nocknock");
	final String baseURL=resource.getString("siteURL");

	JdbcTemplate template;
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

public UserBean BuyerSignUpSave(UserBean userBean,TravelBean travelBean) {
	System.out.println("SELECT * FROM Knock.sp_signup(1,'"+userBean.getUserName()+"','"+userBean.getUserEmail()+"','"+userBean.getUserPassword()+"','"+userBean.getUserPhone()+"','BUYER',NULL)");
	
return template.queryForObject("SELECT * FROM Knock.sp_signup(1,'"+userBean.getUserName()+"','"+userBean.getUserEmail()+"','"+userBean.getUserPassword()+"','"+userBean.getUserPhone()+"','BUYER',NULL);",new RowMapper<UserBean>(){
	
	public UserBean mapRow(ResultSet rs, int row){
		try{
			userBean.setSignup_status(rs.getString("o_status"));
			System.out.println("*********************"+rs.getString("o_status"));
			Long sk_member_id=userBean.setSk_member_id(rs.getLong("o_sk_member_id"));
			System.out.println(sk_member_id+":sk_member_id");
			SendEmailUsingGMailSMTP mail= new SendEmailUsingGMailSMTP();
			
			String msg="<a href='"+baseURL+"Verify?key="+sk_member_id+" '>Confirm Email</a>";
			if(travelBean.getBholidayKind()!=null)
			{
				System.out.println("SELECT * FROM knock.sp_add_edit_travel_req('I','"+sk_member_id+"','"+travelBean.getBholidayKind()+"','"+travelBean.getBTravel()+"','"+travelBean.getBTravelcity()+"','"+travelBean.getBstartdate()+"','"+travelBean.getBenddate()+"', '"+travelBean.getBflexibledate()+"','"+travelBean.getBduration()+"','"+travelBean.getBtraveldateflex()+"','"+travelBean.getBadult()+"','"+travelBean.getBchildren()+"','"+travelBean.getBinfant()+"','"+travelBean.getBsenior()+"','"+travelBean.getBholidayt()+"','"+travelBean.getBhoteltype()+"','"+travelBean.getBfood()+"','"+travelBean.getBudgetfrom()+"','"+travelBean.getBudgetto()+"','"+travelBean.getBflight()+"','"+travelBean.getReqdesc()+"','"+travelBean.getOfferrecieve()+"','"+travelBean.getKwhere()+"',NULL)");
				template.execute("SELECT * FROM knock.sp_add_edit_travel_req('I','"+sk_member_id+"','"+travelBean.getBholidayKind()+"','"+travelBean.getBTravel()+"','"+travelBean.getBTravelcity()+"','"+travelBean.getBstartdate()+"','"+travelBean.getBenddate()+"', '"+travelBean.getBflexibledate()+"','"+travelBean.getBduration()+"','"+travelBean.getBtraveldateflex()+"','"+travelBean.getBadult()+"','"+travelBean.getBchildren()+"','"+travelBean.getBinfant()+"','"+travelBean.getBsenior()+"','"+travelBean.getBholidayt()+"','"+travelBean.getBhoteltype()+"','"+travelBean.getBfood()+"','"+travelBean.getBudgetfrom()+"','"+travelBean.getBudgetto()+"','"+travelBean.getBflight()+"','"+travelBean.getReqdesc()+"','"+travelBean.getOfferrecieve()+"','"+travelBean.getKwhere()+"',NULL)");

			}

			System.out.println("Message "+msg);      
			if(rs.getString("o_status").equals("SUCCESS"))
			{
				mail.sendMail(userBean.getUserEmail(), msg,0);

			}
			                 
	}catch (Exception e) {
		System.out.println(e);
	}
		
		return userBean;
	}
}); 
}
/**
 *update email verification status of buyer
 * @param key
 * @param userBean
 */

public   UserBean verifyEmail(String key,UserBean userBean) {	
	System.out.println("SELECT * FROM knock.sp_email_confirmation('"+key+"')");
	return template.queryForObject("SELECT * FROM knock.sp_email_confirmation('"+key+"');",new RowMapper<UserBean>(){
		public UserBean mapRow(ResultSet rs, int row) throws SQLException {
			boolean verify_status=rs.getBoolean("o_status");
			String emai_id=rs.getString("o_emailaddress");
			System.out.println(verify_status+":verify_status");
			//UserBean.setUserEmail(rs.getString("o_emailaddress"));
			//UserBean.setVerify_status(rs.getString("o_status"));
		
		SendEmailUsingGMailSMTP mail = new SendEmailUsingGMailSMTP();
		String msg="<p>Thank you for registering with nocknock. You are now ready to access the numerous featured offered by us to transform your workplace functioning seamlessly. Get started!</p>";
        
				System.out.println("Message "+msg);
				if(verify_status==true)
				{
					System.out.println("success");
					mail.sendMail(emai_id,msg,0);
				}
		
		

return userBean;
}
});

}

public UserBean BuyerSignIn(UserBean userBean) {
	
	return template.queryForObject("SELECT * FROM knock.sp_signin('"+userBean.getUserEmail()+"','"+userBean.getUserPassword()+"',NULL);",new RowMapper<UserBean>(){
		public UserBean mapRow(ResultSet rs, int row) throws SQLException {
			
			userBean.setSk_member_id(rs.getLong("o_sk_member_id"));
			userBean.setSignin_status(rs.getString("o_status"));
			System.out.println("*********************"+rs.getString("o_status"));
			
			return userBean;
	
		}
		});
	}

public TravelBean TravelReqSave(TravelBean travelBean) {
	System.out.println("SELECT * FROM knock.sp_add_edit_travel_req('I',2017084,'"+travelBean.getBholidayKind()+"','"+travelBean.getBTravel()+"','"+travelBean.getBTravelcity()+"','"+travelBean.getBstartdate()+"','"+travelBean.getBenddate()+"','"+travelBean.getBflexibledate()+"','"+travelBean.getBduration()+"','"+travelBean.getBtraveldateflex()+"','"+travelBean.getBadult()+"','"+travelBean.getBchildren()+"','"+travelBean.getBinfant()+"','"+travelBean.getBsenior()+"','"+travelBean.getBholidayt()+"','"+travelBean.getBhoteltype()+"','"+travelBean.getBfood()+"','"+travelBean.getBudgetfrom()+"','"+travelBean.getBudgetto()+"','"+travelBean.getBflight()+"','"+travelBean.getReqdesc()+"','"+travelBean.getOfferrecieve()+"','"+travelBean.getKwhere()+"',NULL );");
	
	return template.queryForObject("SELECT * FROM knock.sp_add_edit_travel_req('I',2017084,'"+travelBean.getBholidayKind()+"','"+travelBean.getBTravel()+"','"+travelBean.getBTravelcity()+"','"+travelBean.getBstartdate()+"','"+travelBean.getBenddate()+"', '"+travelBean.getBflexibledate()+"','"+travelBean.getBduration()+"','"+travelBean.getBtraveldateflex()+"','"+travelBean.getBadult()+"','"+travelBean.getBchildren()+"','"+travelBean.getBinfant()+"','"+travelBean.getBsenior()+"','"+travelBean.getBholidayt()+"','"+travelBean.getBhoteltype()+"','"+travelBean.getBfood()+"','"+travelBean.getBudgetfrom()+"','"+travelBean.getBudgetto()+"','"+travelBean.getBflight()+"','"+travelBean.getReqdesc()+"','"+travelBean.getOfferrecieve()+"','"+travelBean.getKwhere()+"',NULL);",new RowMapper<TravelBean>(){
		
		public TravelBean mapRow(ResultSet rs, int row){
			
			try{
				
				                 
		}catch (Exception e) {
			System.out.println(e);
		}
			
			return travelBean;
		}
	}); 

	
}


public UserBean forgot(UserBean userBean) {
	ResourceBundle resource = ResourceBundle.getBundle("resources/nocknock");
	String baseURL=resource.getString("siteURL");
	System.out.println("URL :"+baseURL);
	System.out.println("SELECT * FROM knock.sp_get_member_id('"+userBean.getUserEmail()+"');");
	return template.queryForObject("SELECT * FROM knock.sp_get_member_id('"+userBean.getUserEmail()+"');",new RowMapper<UserBean>(){
		public UserBean mapRow(ResultSet rs, int row) throws SQLException {
				Long sk_member_id = rs.getLong("o_member_id");
				userBean.setSignup_status(rs.getString("o_status"));
				System.out.println("*********************"+rs.getString("o_status"));
				
				SendEmailUsingGMailSMTP mail = new SendEmailUsingGMailSMTP();
					
				String msg="<td><a href='"+baseURL+"resetpassword?mkey="+sk_member_id+"'>Reset Password</a></td>";
				
           mail.sendMail(userBean.getUserEmail(),msg,userBean.getSk_member_id());
		
				return userBean;
					
		}
	});
	
} 

public UserBean resetpassword(UserBean userBean,Long mkey) {
    
	System.out.println("SELECT * FROM knock.sp_forgot_password('"+userBean.getSk_member_id()+"',1,'"+userBean.getUserPassword()+"',NULL);");
	return template.queryForObject("SELECT * FROM knock.sp_forgot_password('"+userBean.getSk_member_id()+"',1,'"+userBean.getUserPassword()+"',NULL);",new RowMapper<UserBean>(){
		public UserBean mapRow(ResultSet rs, int row) throws SQLException {
			
			
		return userBean;
		}
	});
	
}

	

public UserBean resend(UserBean userBean) {
	ResourceBundle resource = ResourceBundle.getBundle("resources/nocknock");
	String baseURL=resource.getString("siteURL");
	System.out.println("URL :"+baseURL);
	System.out.println("SELECT * FROM knock.sp_get_member_id('"+userBean.getUserEmail()+"');");
	return template.queryForObject("SELECT * FROM knock.sp_get_member_id('"+userBean.getUserEmail()+"');",new RowMapper<UserBean>(){
		public UserBean mapRow(ResultSet rs, int row) throws SQLException {
				Long sk_member_id = rs.getLong("o_member_id");
				userBean.setSignup_status(rs.getString("o_status"));
				System.out.println("*********************"+rs.getString("o_status"));
				SendEmailUsingGMailSMTP mail = new SendEmailUsingGMailSMTP();
				
				String msg="<a href='"+baseURL+"Verify?key="+sk_member_id+" '>Confirm Email</a>";
	
           mail.sendMail(userBean.getUserEmail(),msg,userBean.getSk_member_id());
				
				return userBean;
				
		}
	});
	
	
} 




} 

		
		
		


