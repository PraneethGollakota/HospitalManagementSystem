<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DoctorPortal</title>
</head>
<%
Cookie ck[]=request.getCookies();
String doctorName=ck[0].getValue();
out.println(doctorName);
%>
<form action="checkAppointments">
Enter date:<input type="date" value="" name="date"><br>
<input type="submit" value="Check Appointments">
</form>
</html>