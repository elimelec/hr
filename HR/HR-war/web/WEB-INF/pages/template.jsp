<!DOCTYPE HTML>
<html>
<head>
<title>${param.title}</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/style.css" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
</head>
<body>
	<jsp:include page="/WEB-INF/pages/header.jsp"/>
        
	<!--<h1>${param.title}</h1>-->
        
	<jsp:include page="/WEB-INF/pages/${param.content}.jsp"/>
        
        <jsp:include page="/WEB-INF/pages/footer.jsp"/>
	
</body>

</html>