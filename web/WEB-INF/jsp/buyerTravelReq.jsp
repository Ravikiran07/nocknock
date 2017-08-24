<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<script type="text/javascript">
function confirmPass() {
    	
    	var x=document.getElementById("BholidayKind").value;      
    	
                if(x=="")
                	{
                	document.getElementById("kinderror").innerHTML="please select the holiday";
                	return false;
                	}
                	 else 
        	    	 {
        	    	 document.getElementById("kinderror").innerHTML="";

        	    	 }
                
                var x=document.getElementById("BTravel").value;      
            	
                if(x=="")
                	{
                	document.getElementById("wherror").innerHTML="please select where to go";
                	return false;
                	}
                	 else 
        	    	 {
        	    	 document.getElementById("wherror").innerHTML="";
        	    	
        	    	 }
                
                var x=document.getElementById("kwhere").value;      
            	
                if(x=="")
                	{
                	document.getElementById("knowerror").innerHTML="please select the items in the list";
                	return false;
                	}
                	 else 
        	    	 {
        	    	 document.getElementById("knowerror").innerHTML="";
        	    
        	    	 }
              
                var x=document.getElementById("BTravelcity").value;      
            	
                if(x=="")
                	{
                	document.getElementById("holidayerror").innerHTML="please select the items in the list";
                	return false;
                	}
                	 else 
        	    	 {
        	    	 document.getElementById("holidayerror").innerHTML="";
        	    	 
        	    	 }
                
                var today =new Date();
                var x = document.getElementById("Bstartdate").value; 
                if (x==""){
                	document.getElementById("starterror").innerHTML="please select the date"
                    return false;
                } 
                else if (x>today) {
                	document.getElementById("starterror").innerHTML="please select the date";
                	return false;
                } 
                else {
                	 document.getElementById("starterror").innerHTML="";
                }
            
                var today =new Date();
                var x = document.getElementById("Benddate").value; 
                if (x==""){
                	document.getElementById("enderror").innerHTML="please select the date"
                    return false;
                } 
                else if (x>today) {
                	document.getElementById("enderror").innerHTML="please select the date";
                	return false;
                } 
                else {
                	 document.getElementById("enderror").innerHTML="";
                }
            
                
                
                var x=document.getElementById("Bflexibledate").value;      
            	
                if(x=="")
                	{
                	document.getElementById("flexeror").innerHTML="please select the items in the list";
                	return false;
                	}
                	 else 
        	    	 {
        	    	 document.getElementById("flexeror").innerHTML="";
        	    	 
        	    	 }
                
                var x=document.getElementById("Bduration").value; 
                var numbers = /^[0-9]+$/;
                if(!x.match(numbers))
            	{
            	   document.getElementById("durationeror").innerHTML="enter numbers only";
            	return false;
            	}
            else
          	 {
          	 document.getElementById("durationeror").innerHTML="";
          	 } 
                
                 var x=document.getElementById("Btraveldateflex").value;      
            	
                if(x=="")
                	{
                	document.getElementById("dayserror").innerHTML="please select the items in the list";
                	return false;
                	}
                	 else 
        	    	 {
        	    	 document.getElementById("dayserror").innerHTML="";
        	    
        	    	 }
        
                var x=document.getElementById("Badult").value; 
                var numbers = /^[0-9]+$/;
                if(!x.match(numbers))
            	{
            	   document.getElementById("baderror").innerHTML="enter numbers only";
            	return false;
            	}
            else
          	 {
          	 document.getElementById("baderror").innerHTML="";
          	 } 
                
                
                var x=document.getElementById("Bchildren").value; 
                var numbers = /^[0-9]+$/;
                if(!x.match(numbers))
            	{
            	   document.getElementById("bchilderror").innerHTML="enter  numbers only";
            	return false;
            	}
            else
          	 {
          	 document.getElementById("bchilderror").innerHTML="";
          	 } 
                
                var x=document.getElementById("Binfant").value; 
                var numbers = /^[0-9]+$/;
                if(!x.match(numbers))
            	{
            	   document.getElementById("infanterror").innerHTML="enter  numbers only";
            	return false;
            	}
            else
          	 {
          	 document.getElementById("infanterror").innerHTML="";
          	 } 

                var x=document.getElementById("Bsenior").value; 
                var numbers = /^[0-9]+$/;
                if(!x.match(numbers))
            	{
            	   document.getElementById("seniorerror").innerHTML="enter numbers only";
            	return false;
            	}
            else
          	 {
          	 document.getElementById("seniorerror").innerHTML="";
          	 }

                var x=document.getElementById("Bholidayt").value;      
            	
                if(x=="")
                	{
                	document.getElementById("holidaytherror").innerHTML="please select the holiday theme";
                	return false;
                	}
                	 else 
        	    	 {
        	    	 document.getElementById("holidaytherror").innerHTML="";
        	    	
        	    	 }   
                
                var x=document.getElementById("Bhoteltype").value;      
            	
                if(x=="")
                	{
                	document.getElementById("hotelerror").innerHTML="please select the hotel type";
                	return false;
                	}
                	 else 
        	    	 {
        	    	 document.getElementById("hotelerror").innerHTML="";
        	    	
        	    	 }  
                
                var x=document.getElementById("Bfood").value;      
            	
                if(x=="")
                	{
                	document.getElementById("fooderror").innerHTML="please select the food type";
                	return false;
                	}
                	 else 
        	    	 {
        	    	 document.getElementById("fooderror").innerHTML="";
        	    	
        	    	 }  
                
                var x=document.getElementById("budgetfrom").value; 
                var numbers = /^[0-9]+$/;
                if(!x.match(numbers))
            	{
            	   document.getElementById("fromerror").innerHTML="enter numbers only";
            	return false;
            	}
            else
          	 {
          	 document.getElementById("fromerror").innerHTML="";
          	 } 
                
                var x=document.getElementById("budgetto").value; 
                var numbers = /^[0-9]+$/;
                if(!x.match(numbers))
            	{
            	   document.getElementById("toerror").innerHTML="enter numbers only";
            	return false;
            	}
            else
          	 {
          	 document.getElementById("toerror").innerHTML="";
          	 }
                
                
               var x=document.getElementById("Bflight").value;      
            	
                if(x=="")
                	{
                	document.getElementById("flighterror").innerHTML="please select the items in the list";
                	return false;
                	}
                	 else 
        	    	 {
        	    	 document.getElementById("flighterror").innerHTML="";
        	    	
        	    	 }  
                
                
                var x=document.getElementById("offerrecieve").value;      
            	
                if(x=="")
                	{
                	document.getElementById("offererror").innerHTML="please select the items in the list";
                	return false;
                	}
                	 else 
        	    	 {
        	    	 document.getElementById("offererror").innerHTML="";
        	    	return true;
        	    	 }
                
 }

</script>

<h1>Buyer Travel requirements Form</h1>
       <form:form method="get" action="buyersignup">  
      	<table > 
      	<tr>  
          <td>Kind of holiday :</td> 
          <td><form:select path="BholidayKind" id="BholidayKind" required="true">
        <form:option value="">Select</form:option>
          <form:option value="domestic">Domestic</form:option>
               <form:option value="international">International</form:option>
               <form:option value="explore both">Explore Both</form:option>
            </form:select></td>
            <td><span style="color:red;" id="kinderror" ></span></td>
         </tr>  
         <tr>  
          <td>Where To Travel :</td> 
          <td><form:select path="BTravel" id="BTravel" required="true" >
        <form:option value="">Select</form:option>
          <form:option value="BR">Bangalore</form:option>
               <form:option value="NY">Newyork</form:option>
               <form:option value="LN">London</form:option>
               <form:option value="idkwtg">I do not know where to go</form:option>
            </form:select></td> 
             <td><span style="color:red;" id="wherror"></span></td>
 
            <tr>  
             <td>Know where to go:</td>  
            
          <td><form:select path="kwhere" id="kwhere" required="true">
        <form:option value="">Select</form:option>
          <form:option value="yes">Yes</form:option>
               <form:option value="no">No</form:option> 
            </form:select></td> 
            <td><span style="color:red;" id="knowerror"></span></td>

         </tr>
            
         </tr> 
         <tr>  
          <td>Holiday Starting city</td>
          <td><form:select path="BTravelcity" id="BTravelcity" required="true">
        <form:option value="">Select </form:option>
          <form:option value="Bangalore">Bangalore</form:option>
               <form:option value="Newyork">Newyork</form:option>
               <form:option value="London">London</form:option>
            </form:select></td>  
              <td><span style="color:red;" id="holidayerror" required="true"></span></td>
         </tr> 
         <tr>  
          <td>Starting date :</td>  
          <td><form:input  type="date" path="Bstartdate" required="true"/></td>
           <td><span style="color:red;" id="starterror"></span></td>
         </tr> 
         
         <tr>  
          <td>Ending date:</td>  
          <td><form:input type="date" path="Benddate" required="true"/></td>
           <td><span style="color:red;" id="enderror"></span></td>
         </tr> 
         
         <tr>  
          <td>Flexible date :</td>  
          <td><form:select path="Bflexibledate" id="Bflexibledate" required="true">
        <form:option value="">Select</form:option>
          <form:option value="yes">Yes</form:option>
               <form:option value="no">No</form:option> 
            </form:select></td> 
            <td><span style="color:red;" id="flexeror"></span></td>
         </tr> 
         
         <tr>  
          <td>Duration days :</td>  
          <td><form:input  type="text" path="Bduration" required="true"/></td>
          <td><span style="color:red;" id="durationeror"></span></td>
         </tr> 
         <tr>  
          <td>Travel days flexible :</td>  
          <td><form:select path="Btraveldateflex" id="Btraveldateflex" required="true">
        <form:option value="">Select</form:option>
          <form:option value="yes">Yes</form:option>
               <form:option value="no">No</form:option> 
            </form:select></td> 
            <td><span style="color:red;" id="dayserror"></span></td>
         </tr>
         </tr> 
         <tr>  
          <td>Adult count :</td>  
          <td><form:input path="Badult"/></td>
          <td><span style="color:red;" id="baderror" required="true" ></span></td>
         </tr> 
         
         <tr>  
          <td>Children count:</td>  
          <td><form:input path="Bchildren"/></td>
          <td><span style="color:red;" id="bchilderror" required="true" ></span></td>
         </tr> 
         
         <tr>  
          <td>Infant count :</td>  
          <td><form:input path="Binfant"/></td>
          <td><span style="color:red;" id="infanterror" required="true"></span></td>
         </tr> 
         
          <tr>  
          <td>Senior citizen count:</td>  
          <td><form:input  path="Bsenior"/></td>
          <td><span style="color:red;" id="seniorerror" required="true"></span></td>
         </tr> 
         
         	<tr>  
          <td>Holiday Theme : </td> 
          <td><form:select path="Bholidayt" id="Bholidayt" required="true">
        <form:option value="">Select</form:option>
          <form:option value="famly">Family Trip</form:option>
               <form:option value="honeymoon">Honeymoon Trip</form:option>
            </form:select> </td>
            <td><span style="color:red;" id="holidaytherror"></span></td>
         </tr> 
         
         
         <tr>  
          <td>Hotel stay type :</td>  
          <td><form:select path="Bhoteltype" id="Bhoteltype" required="true">
        <form:option value="">Select</form:option>
          <form:option value="seven star">seven star</form:option>
               <form:option value="five star">five star </form:option> 
               <form:option value="three star">Three star </form:option> 
            </form:select></td>
            <td><span style="color:red;" id="hotelerror"></span></td>
         </tr> 
               <tr>  
          <td>Food preference:</td>  
            <td><form:select path="Bfood" id="Bfood" required="true">
        <form:option value="">Select</form:option>
          <form:option value="veg">veg</form:option>
               <form:option value="non-veg">non veg</form:option> 
               <form:option value="Both">Both</form:option> 
            </form:select></td>
            <td><span style="color:red;" id="fooderror"></span></td>
         </tr> 
         
          <tr>  
          <td>Budget From:</td>  
          <td><form:input  path="budgetfrom" required="true"/></td>
           <td><span style="color:red;" id="fromerror" ></span></td>
         </tr> 
         <tr>  
          <td>Budget To:</td>  
          <td><form:input   path="budgetto" required="true"/></td>
           <td><span style="color:red;" id="toerror" ></span></td>
         </tr> 
         <tr>  
          <td>Flights include:</td>  
          
          <td><form:select path="Bflight" id="Bflight" required="true">
        <form:option value="">Select</form:option>
          <form:option value="yes">yes</form:option>
               <form:option value="No">No</form:option> 
            </form:select></td>
            <td><span style="color:red;" id="flighterror"></span></td>
          
         </tr> 
         <tr>  
          <td>Special Requirement description:</td>  
          <td><form:textarea path="reqdesc" rows="5" cols="20" required="true"/></td>
         </tr> 
         
         <tr>  
          <td>offer recieve  Preference : </td> 
          <td><form:select path="offerrecieve" id="offerrecieve" required="true">
        <form:option value="">Select</form:option>
        <form:option value="localtravel">Local travel agent</form:option>
            </form:select> </td>
            <td><span style="color:red;" id="offererror"></span></td>
         </tr> 
         <tr>  
          <td></td>  
          <td><input type="submit" value="Submit" onclick="confirmPass()"/></td> 
          <td><a href="buyersignup">skip</a> 
          </tr>  
        </table>  
       </form:form>  
</body>
</html>