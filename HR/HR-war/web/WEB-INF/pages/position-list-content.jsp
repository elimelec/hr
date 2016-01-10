<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix ="fmt" %>

<a href="${pageContext.request.contextPath}/position">Add Position</a>
<table>
	<tr>
            <th>ID</th>
            <th>Name</th>
	</tr>
	
	<c:forEach var="position" items="${positions}" varStatus="status">
		<tr>
                    <td>${position.idposition}</td>
                    <td><a href="${pageContext.request.contextPath}/position?id=${position.idposition}">${position.name}</a></td>
		</tr>
	</c:forEach>
</table>