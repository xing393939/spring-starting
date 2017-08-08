<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Hello World</title>
</head>
<body>
   <h2>${userid}</h2>
   <p>${user.id}</p>
   <p>${user.username}</p>
   
   <c:forEach items="${articles}" var="item">  
   <p>${item.id}--${item.username}</p>
   </c:forEach>
</body>
</html>