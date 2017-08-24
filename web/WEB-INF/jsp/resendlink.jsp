<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
 
<h1>Enter the Registered Email Address for resending the link</h1>
       <form:form method="post" action="resendlink">  
      	<table > <tr>  
          <td>Email Address :</td> 
          <td><form:input path="userEmail" required="true"/></td>
         </tr>   
          <td><input type="submit" value="Submit"/></td>  
         </tr>  
        </table>  
       </form:form>  
</body>
</html>
