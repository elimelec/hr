
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix ="fmt" %>

<div class="container top_margin">
    <form  method="POST">

        <label for="firstname">First Name: </label>
        <input type="text" name="firstname"/>    
        <br>

        <label for="lastname">Last Name: </label>
        <input type="text" name="lastname"/>    
        <br>

        <label for="email">Email: </label>
        <input type="email" name="email"/>    
        <br>

        <label for="password">Password: </label>
        <input type="password" name="password"/>    
        <br>

        <label for="role">Role: </label>
        <input type="radio" name="role" value="DIRECTOR DEPARTAMENT" checked="true"/>DIRECTOR DEPARTAMENT   
        <input type="radio" name="role" value="ADMINISTRATOR"/>ADMINISTRATOR   
        <br>

        <label for="description">Description: </label>
        <input type="text" name="description"/>    
        <br>

        <label for="mobile">Mobile: </label>
        <input type="text" name="mobile"/>    
        <br>

        <label for="telephone">Telephone: </label>
        <input type="text" name="telephone"/>    
        <br>


        <input type="submit" value="Add" class="btn"/>
    </form>
</div>

