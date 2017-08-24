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
    	 
    }
</script>



<h1>Enter the Registered Email Address</h1>
       <form:form method="post" action="forgotsubmit">  
      	<table > <tr>  
          <td>Email Address :</td> 
          <td><form:input path="userEmail" required="true"/></td>
          <td><span style="color:red;" id="uemail" > </span></td>
         </tr>   
          <td><input type="submit" value="Submit" onclick="confirmPass()"/></td>  
         </tr>  
        </table>  
       </form:form> 
         <div class="warning-msg ${msg_symbol}">
        <p class="message-text" id='warning_text'>${msg_status}</p>
    </div> 
</body>
</html>