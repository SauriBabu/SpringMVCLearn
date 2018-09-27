<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index</title>
</head>
<body>
 	<h2>
 		Spring MVC Application
 	</h2>
 	<h4>
 	<p>
 	formattedMessage:${formatterMessage}
 	</h4>
 	
 	<h1> Name of the company is : ${name}</h1>
 	
 	<h3>
 	<p>
 	Account id: ${acc.id }
 	</p>
 	
 	<p>
 	Balance: ${acc.balance }
 	</p>
 	
 	<p>
 	City:  ${acc.mailingAddress.city }
 	</p>
 	
 	<p>
 	State: ${acc.mailingAddress.state }
 	</p>
 	
 	<p>
 	Pin Code:${acc.mailingAddress.pincode }
 	
 	
 	</h3>
</body>
</html>