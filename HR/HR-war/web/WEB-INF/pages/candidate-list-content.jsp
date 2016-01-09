
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix ="fmt" %>


<table>
	<tr>
            <th>ID</th>
            <th>CV</th>
	</tr>
	
	<c:forEach var="candidate" items="${candidates}">
		<tr>
                    <td>${candidate.idcandidate}</td>
                    <td><a href="${pageContext.request.contextPath}/cv?id=${candidate.idcandidate}">${candidate.cv}</a></td>
		</tr>
	</c:forEach>
</table>

