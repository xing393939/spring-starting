<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div>
<c:forEach items="${articles}" var="item">  
    ${item.id}--${item.title}--${item.content}<br />
</c:forEach>
</div>