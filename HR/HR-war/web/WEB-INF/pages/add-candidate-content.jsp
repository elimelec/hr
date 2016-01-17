<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<form action="apply-for-position" method="POST" id="add-candidate">

    <label for="firstname">First name:</label>
    <input type="text" name="firstname"/>
    <br>
    
    <label for="lastname">Last name:</label>
    <input type="text" name="lastname"/>
    <br>
    
    <label for="email">Email:</label>
    <input type="email" name="email"/>
    <br>
    
    <label for="address">Address:</label>
    <input type="text" name="address"/>
    <br>
    
    <label for="mobile">Mobile:</label>
    <input type="text" name="mobile"/>
    <br>

    <label for="cv">CV:</label>
    <textarea form="add-candidate" name="cv" rows="20" cols="35"></textarea>
    <br>
    
    <input type="submit" value="Apply"/>
</form>
