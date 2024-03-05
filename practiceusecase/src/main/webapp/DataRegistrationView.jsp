<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="UserRegistrationCtl" method="post">


<% String h = (String)request.getAttribute("msg"); 
   

%>

<table>
				<input type="hidden" name="id">
			<%-- 		value="<%=(dto != null) ? dto.getId() : ""%>"> --%>
				<tr>
					<th>Name:</th>
					<td><input type="text" name="name" placeholder="Enter Your Name">
						<%-- value="<%=(dto != null) ? dto.getName() : ""%>"></td> --%>
				</tr>


				<tr>
					<th>Address :</th>
					<td><input type="text" name="address" placeholder="Enter Address">
						<%-- value="<%=(dto != null) ? dto.getAddress() : ""%>"></td> --%>
				</tr>
				<tr>
				<th></th>
				<td> <button type="submit" name="operation">Save</button></td>
			</table>




</form>



</body>
</html>