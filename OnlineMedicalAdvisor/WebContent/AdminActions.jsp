<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AdminActions</title>
</head>
<form action="deleteUser">
Enter user to delete:<input type="text" value="" name="username"><br>
<input type="submit" value="DELETE USER">
</form>
<br><br>
<form action="addDoctor">
Enter doctor ID:<input type="text" value="" name="id"><br>
Enter username for doctor:<input type="text" value="" name="username"><br>
Enter password for doctor:<input type="text" value="" name="password"><br>
Enter doctor's Specialization:<input type="text" value="" name="docspec"><br>
<input type="submit" value="ADD DOCTOR">
<input type="reset" value="reset">
</form>
<br><br><br>
<form action="generateAppointmentAdmin" method="post">
Enter username:<input type="text" name="username" value=""><br>
Enter appointment date:<input type="date" name="date" value=""><br>
<input type="submit" value="Check Appointment">
<input type="reset" value="RESET">
</form>
</html>