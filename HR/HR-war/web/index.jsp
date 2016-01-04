<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="WEB-INF/pages/header.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="login" method="POST">
            <input type="email" placeholder="Email" name="email">
            <input type="password" placeholder="Password" name="password">
            <input type="submit" value="Log in">
        </form>
    </body>
    <%@ include file="WEB-INF/pages/footer.jsp" %>
</html>
