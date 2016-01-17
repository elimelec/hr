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
                <th class="text-left">Comments</th>                
            </tr>
        </thead>
        <tbody class="table-hover">	
            <c:forEach var="position" items="${positions}" varStatus="counter">
                    <tr>
                        <td class="text-left">${counter.count}</td>
                        <td class="text-left">
                            <c:choose>
                                <c:when test="${viewer == true}">
                                    <a href="${pageContext.request.contextPath}/view-requirements?id=${position.idposition}">${position.name}</a>  
                                </c:when>    
                                <c:otherwise>
                                    <a href="${pageContext.request.contextPath}/add-edit-position?id=${position.idposition}">${position.name}</a>                  
                                </c:otherwise>
                            </c:choose>                        
                        </td>
                        <td class="text-left"><a href="${pageContext.request.contextPath}/position-comments?position=${position.idposition}">View Comments</a></td>
                    </tr>
            </c:forEach>               
        </tbody>
    </table>
    
    <c:if test="${viewer != true}">
        <a class="btn" href="${pageContext.request.contextPath}/add-edit-position">Add Position</a>    
        <a class="btn" href="${pageContext.request.contextPath}/cvs">View CVs</a>    
    </c:if>
</div>
