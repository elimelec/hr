<!DOCTYPE html>
<html>
    <head>
        <%@page contentType="text/html" pageEncoding="UTF-8"%>
        <link rel="stylesheet" type="text/css"
              href="${pageContext.request.contextPath}/resources/style.css" />
        <link href='https://fonts.googleapis.com/css?family=Work+Sans:400,300,700' rel='stylesheet' type='text/css'>
        <title>Login</title>
    </head>
    <body>            
        <div class="container">
            <div class="profile">
                <button class="profile__avatar" id="toggleProfile">
                    <img src="${pageContext.request.contextPath}/resources/logo.png"/>
                </button>
              
                <div class="profile__form">
                    <form action="login" method="POST">
                          <div class="profile__fields">
                              <div class="field">                    
                                  <input type="email" placeholder="Email" name="email" id="email" class="input"/>
                              </div>
                              <div class="field">
                                  <input type="password" placeholder="Password" name="password" id="password" class="input"/>
                              </div>
                              <div class="profile__footer">
                                  <input class="btn" type="submit" value="Login"/>
                              </div>
                          </div>
                    </form>
                </div>
            </div>
         </div>
        
        <%@ include file="WEB-INF/pages/footer.jsp" %>        
        <script src="${pageContext.request.contextPath}/resources/admin.js"></script>
    </body>    
</html>
