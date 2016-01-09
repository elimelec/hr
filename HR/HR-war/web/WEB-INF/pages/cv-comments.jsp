<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>

<h1>Comments</h1>
<b>${cv.title}</b>
<br>
<ol>
    <c:forEach var="comment" items="${comments}">
        <li>
            ${comment.comment}
        </li>
    </c:forEach>
</ol>