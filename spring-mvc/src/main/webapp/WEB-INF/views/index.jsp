<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<body>
<h2>Hello World! Hey bro how it is goin hey  fggg Hello</h2>

<% 
    String name = (String) request.getAttribute("message");
%>

<h1> <%=name%> </h1>
</body>
</html>
