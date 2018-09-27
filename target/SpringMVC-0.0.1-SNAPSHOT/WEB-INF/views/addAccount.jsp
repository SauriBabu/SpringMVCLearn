<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Account</title>
</head>
<body>
	<h3> Create Account</h3>
	Checking acc ----> ${acc.name } ===
	<s:form action="save" method="POST" modelAttribute="acc">
	<s:errors path="*"></s:errors>
	
	 <div>
		 <p>
		     <s:label path="id">Account Id</s:label>
		     </p>
		     
		     <p>
		     <s:input path="id"/>
		     <s:errors path="id"></s:errors>
		 </p>
	 </div>
	 
	 <div>
		 <p>
		     <s:label path="name">Name</s:label>
		     </p>
		     
		     <p>
		     <s:input path="name"/>
		     <s:errors path="name"></s:errors>
		 </p>
	 </div>
	 
	 <div>
		 <p>
		     <s:label path="balance">Balance</s:label>
		     </p>
		     
		     <p>
		     <s:input path="balance"/>
		     <s:errors path="balance" cssStyle="color:red"></s:errors>
		 </p>
	 </div>
	 
	 <div>
		 <p>
		     <s:label path="mailingAddress.city">City</s:label>
		     </p>
		     
		     <p>
		     <s:input path="mailingAddress.city"/>
		 </p>
	 </div>
	
	 <div>
		 <p>
		     <s:label path="mailingAddress.state">State</s:label>
		     </p>
		     
		     <p>
		     <s:input path="mailingAddress.state"/>
		 </p>
	 </div>
	 
	  <div>
		 <p>
		     <s:label path="mailingAddress.pincode">Pincode</s:label>
		     </p>
		     
		     <p>
		     <s:input path="mailingAddress.pincode"/>
		 </p>
	 </div>
	 <s:button type="submit">Submit</s:button>
	</s:form>
</body>
</html>