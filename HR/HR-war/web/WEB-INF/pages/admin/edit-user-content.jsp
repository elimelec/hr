
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix ="fmt" %>


<form action="${pageContext.request.contextPath}/admin/edit-user?id=${user.iduser}" method="POST">
    
    <label for="firstname">First Name: </label>
    <input type="text" name="firstname" value="${user.firstname}"/>    
    <br>
    
    <label for="lastname">Last Name: </label>
    <input type="text" name="lastname" value="${user.lastname}"/>    
    <br>
    
    <label for="email">Email: </label>
    <input type="email" name="email" value="${user.email}"/>    
    <br>
    
    <label for="role">Role: </label>
    <input type="radio" name="role" value="DIRECTOR DEPARTAMENT" checked="true"/>DIRECTOR DEPARTAMENT   
    <br>
    
    <label for="description">Description: </label>
    <input type="text" name="description" value="${user.description}"/>    
    <br>
    
    <label for="mobile">Mobile: </label>
    <input type="text" name="mobile" value="${user.mobile}"/>    
    <br>
    
    <label for="telephone">Telephone: </label>
    <input type="text" name="telephone" value="${user.telephone}"/>    
    <br>
  
    
    <input type="submit" value="Save"/>
</form>

