<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix ="fmt" %>

<div class="container top_margin">
   
    <div class="table-title">
        <h3>${param.title}</h3>
    </div>
    
    <table class="table-fill bottom_margin">
        <thead>
            <tr>
                <th class="text-left">ID</th>
                <th class="text-left">Name</th>
            </tr>
        </thead>
        <tbody class="table-hover">	
            <c:forEach var="position" items="${positions}">
                    <tr>
                        <td class="text-left">${position.idposition}</td>
                        <td class="text-left"><a href="${pageContext.request.contextPath}/add-edit-position?id=${position.idposition}">${position.name}</a></td>
                    </tr>
            </c:forEach>               
        </tbody>
    </table>
    
     <a class="btn" href="${pageContext.request.contextPath}/add-edit-position">Add Position</a>
    <!--<a class="btn" href="${pageContext.request.contextPath}/cvs">Add Position</a>-->
    
</div>
