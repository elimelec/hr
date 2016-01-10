<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>

<div class="container top_margin">
   
    <div class="table-title">
        <h3>${position.name}: ${param.title}</h3>
    </div>
    
    <br>
    <ol>
        <c:forEach var="comment" items="${comments}">
            <li>
                ${comment.text}
            </li>
        </c:forEach>
    </ol>

    <form method="POST">
        <input type="text" name="newcomment"> <br>
        <input class="btn" type="submit" value="Add Comment">
    </form>

</div>