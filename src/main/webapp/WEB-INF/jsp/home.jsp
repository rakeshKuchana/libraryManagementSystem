<!DOCTYPE html>
<html>
    <head>
        <title>home</title>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    </head>
    <body>
        <c:if test="${sessionScope.session_userRole == 'admin'}">
            <jsp:include page="WEB-INF/jsp/adminHome.jsp"/> 
        </c:if>
        
        <c:if test="${sessionScope.session_userRole == 'librarian'}">
            <jsp:include page="WEB-INF/jsp/librarianHome.jsp"/> 
        </c:if>
    </body>
</html>
