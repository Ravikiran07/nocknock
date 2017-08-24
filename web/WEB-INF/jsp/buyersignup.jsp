<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  


<script type="text/javascript">
function confirmPass() {
    	
    	 x=document.getElementById("userName").value

    	 var letters=/^[A-Za-z]+$/;  
    	 if(!x.match(letters))  
	     {  
    		 document.getElementById("unameerror").innerHTML="enter only letters ";
	      return false;
	     }  
    	 
    	 
    	 else if(x.length>20)
    		 {
    		 document.getElementById("unameerror").innerHTML="username cannot be greater than 20 characters ";
    		 return false;
    		 }
    	 else 
    		 {
    		 document.getElementById("unameerror").innerHTML="";
    		 
    		 }
    	 
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
    	
        var pass = document.getElementById("userPassword").value
        var confPass = document.getElementById("userConfirmPassword").value
        if(pass != confPass)
        {
           document.getElementById("uconfirmpasserror").innerHTML="password did not match";
        }
        else
   	 {
   	 document.getElementById("uconfirmpasserror").innerHTML="";
   	 }
        
        x=document.getElementById("userPhone").value
        
        var phoneno = /^\d{10}$/;
        if(!x.match(phoneno))
        	{
        	   document.getElementById("uphoneerror").innerHTML="enter the valid phone number";
        	return false;
        	}
        else
      	 {
      	 document.getElementById("uphoneerror").innerHTML="";
      	 }   
    }
</script>

<h1>Buyer SignUp</h1>
       <form:form method="post" action="buyersignup">  
      	<table > <tr>  
          <td>Name :</td> 
          <td><form:input path="userName" required="true"/></td>
          <td><span style="color:red;" id="unameerror" > </span></td>
         </tr>  
         <tr>  
          <td>Email :</td>  
          <td><form:input path="userEmail" required="true" /></td>
          <td><span style="color:red;" id="uemail" > </span></td>
         </tr> 
         <tr>  
          <td>password :</td>  
          <td><form:input  type="password" path="userPassword" required="true" /></td>
           <td><span style="color:red;" id="upasserror" > </span></td>
         </tr> 
         
         <tr>  
          <td>Confirm password :</td>  
          <td><form:input type="password" path="userConfirmPassword" required="true" /></td>
          <td><span style="color:red;" id="uconfirmpasserror" > </span></td>
         </tr> 
         <tr>  
          <td>Phone no :</td>  
          <td><form:input path="userPhone" required="true" /></td>
          <td><span style="color:red;" id="uphoneerror" > </span></td>
         </tr>
          
         <tr>  
          <td> </td>  
          <td><input type="submit" value="Signup"  onclick="confirmPass()"/></td>  
         </tr>  
        </table>  
       </form:form>  
       
       <div class="warning-msg ${msg_symbol}">
        <p class="message-text" id='warning_text'>${msg_status}</p>
    </div>
</body>
</html>