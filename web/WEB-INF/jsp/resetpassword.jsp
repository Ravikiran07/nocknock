<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<script type="text/javascript">
function confirmPass() {
    
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
    	
        var pass=document.getElementById("userPassword").value;
        var confPass=document.getElementById("userConfirmPassword").value;
        if(pass!=confPass)
        {
           document.getElementById("uconfirmpasserror").innerHTML="password did not match";
         	return false;
        }
        
        else 
   	        {
   	          document.getElementById("uconfirmpasserror").innerHTML="";
   	          return true;
   	 }
         
    }  
</script>
<h1>Enter the Registered Email Address</h1>
       <form:form method="post" action="resetpassword" onsubmit="return confirmPass();">  
      	<table ><tr>  
          <td><form:input type="hidden" path="sk_member_id" value='<%=request.getParameter("mkey")%>'/></td>
          </tr>
          <tr><td>new password :</td> 
          <td><form:input type="password" path="userPassword" required="true"/></td>
          <td><span style="color:red;" id="upasserror" > </span></td>
         </tr>   
         <tr>  
          <td>confirm password:</td> 
          <td><form:input type="password"  path="userConfirmPassword" required="true"/></td>
          <td><span style="color:red;" id="uconfirmpasserror" > </span></td>
         </tr>  
         <tr>
          <td><input type="submit" value="submit"/></td>  
         </tr>  

        </table>  
       </form:form>
       <div class="warning-msg ${msg_symbol}">
        <p class="message-text" id='warning_text'>${msg_status}</p>
    </div>  
</body>
</html> 