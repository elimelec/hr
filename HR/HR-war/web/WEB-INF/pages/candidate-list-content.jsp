
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix ="fmt" %>


<table>
	<tr>
            <th>ID</th>
            <th>Candidate Name</th>
	</tr>
	
	<c:forEach var="candidate" items="${candidates}">
		<tr>
                    <td>${candidate.idcandidate}</td>
                    <td class="text-left"><a href="${pageContext.request.contextPath}/reviewCv?id=${candidate.idcandidate}">${candidate.firstname}</a></td>
		</tr>
	</c:forEach>
</table>





