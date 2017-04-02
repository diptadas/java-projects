<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page import="com.example.Student"%>
<html>
 
  <body>
		<form action = "MyServlet">	
			Student ID	
			<input type="text" name="id">	
			<input type="submit" value="submit">			
		</form>
		
		Student Name:
		
		 <%
           Student student = (Student) request.getAttribute("data");
           if(student != null) out.print(student.getName());
          %>
		
  </body>
</html>
