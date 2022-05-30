<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Insert title here</title>
</head>
<body>
<h1>${msg}</h1>
<c:forEach items="${friendlist}"  var="flist" >
	<div>${flist}</div>
</c:forEach>
</body>
</html>