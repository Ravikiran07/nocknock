<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<h1>Your One Time Password Is</h1>
<h3 style="color:red">${notsuccess}</h3>  

       <form:form method="post" action="otp/${id}/${otp}">  
      	<table >   
          <td>OTP : </td> 
          <td><form:input path="otp"/></td>
         </tr> 
         <tr>  
          <td> </td>  
          <td><input type="submit" value="submit" /></td>  
         </tr>  
        </table>  
       </form:form>  
</body>
</html>