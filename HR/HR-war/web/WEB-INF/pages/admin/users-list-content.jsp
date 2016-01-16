
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix ="fmt" %>


<table class="table-fill bottom_margin">
    <thead>
        <tr>
            <th class="text-left">ID</th>
            <th class="text-left">Email</th>
            <th class="text-left">Edit</th>
            <th class="text-left">Delete</th>
        </tr>
    </thead>
    <tbody class="table-hover">	
        <c:forEach var="user" items="${users}">
            <tr>
                <td class="text-left">${user.iduser}</td>
                <td class="text-left">${user.email}</td>
                <td class="text-left"><a href="${pageContext.request.contextPath}/position-comments?position=${user.iduser}">Edit User</a></td>
                <td class="text-left"><a href="${pageContext.request.contextPath}/admin/delete-user?id=${user.iduser}">Delete User</a></td>
            </tr>
        </c:forEach>               
    </tbody>
</table>

<a class="btn" href="${pageContext.request.contextPath}/admin/add-user">Add User</a>    