<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<script type="text/javascript">
    function confirmPass() {
    	
    	 x=document.getElementById("userEmail").value; 
    	 var mail = /^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/
    	     if(!x.match(mail))
    	    	 {
    	    	 document.getElementById("uemail").innerHTML="enter the valid email address";
    	    	 return false;
    	    	 }
    	 
    	     else
    	    	 {
    	    	 document.getElementById("uemail").innerHTML="";
    	    	 }
    	 
    	 x=document.getElementById("userPassword").value;      
     	
         if(x=="")
         	{
         	document.getElementById("upasserror").innerHTML="password cannot be blank";
         	return false;
         	}
         	
         	 else
 	    	 {
 	    	 document.getElementById("upasserror").innerHTML="";
 	    	 }
    }
    	
    	</script>
    <h3 style="color:red">${filesuccess}</h3>  
<h1>Sign In here</h1>
       <form:form method="post" action="buyerLogin">
      	<table >    
         <tr>  
          <td>Email :</td>  
          <td><form:input path="userEmail" required="true"/></td>
          <td><span style="color:red;" id="uemail" > </span></td>
         </tr> 
         <tr>  
          <td>password :</td>  
           <td><form:input  type="password" path="userPassword" required="true"/></td>
           <td><span style="color:red;" id="upasserror" > </span></td>
         </tr>
         <tr>  
          <td></td>  
          <td><input type="submit" value="login" onclick="confirmPass()" /></td>
          
         </tr>  
        </table>  
        
        <a href="forgotpassword">ForgotPassword</a>
       </form:form>  
         <div class="warning-msg ${msg_symbol}">
        <p class="message-text" id='warning_text'>${msg_status}</p>
    </div>
    
      <% /** <a href="resendlink">Resend link</a> */ %>
</body>
</html>