<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<form action="add-edit-position" method="POST" id="add-edit-position">
    
    <label for="name">Name:</label>
    <input type="text" name="name" value="${position.name}"/>
    
    <label for="position_description">Responsibilities:</label>
    <textarea form ="add-edit-position" name="position_description" rows="20" cols="35">${position.responsabilitati}</textarea>
    
    <label for="no_positions">Number of positions:</label>
    <input type="text" name="no_positions" value="${position.noPositions}"/>
           
    <c:set var="opened" scope="session" value="${position.opened}"/>
    
    <label for="available">Availability:</label>
    <input type="radio" name="available" value="opened" <c:if test="${opened == 1}"> checked="true" </c:if>/>Open
    <input type="radio" name="available" value="closed" <c:if test="${opened == 0}"> checked="true" </c:if>/>Close
           
    <input type="hidden" name="id" value="${id}"/>
    <input type="submit" value="Save"/>
</form>
