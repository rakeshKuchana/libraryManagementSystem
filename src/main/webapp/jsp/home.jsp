<!DOCTYPE html>
<html>
    <head>
        <title>home</title>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    </head>
    <body>
        <c:if test="${sessionScope.session_user.role == 'admin'}">
            <jsp:forward page="/jsp/admin/home.jsp"/>
        </c:if>
        
        <c:if test="${sessionScope.session_user.role == 'librarian'}">
            <jsp:forward page="/jsp/librarian/home.jsp"/>
        </c:if>
    </body>
</html>
