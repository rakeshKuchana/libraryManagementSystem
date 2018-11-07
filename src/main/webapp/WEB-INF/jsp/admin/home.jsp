<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <head>
        <title>home</title>
        <link rel="stylesheet" type="text/css" href="/libraryManagementSystem/css/admin/home.css"/>
        <script src="/libraryManagementSystem/js/admin/home.js" type="text/javascript"></script>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</head>
<body>
    <header>
        <form action="/libraryManagementSystem/search" method="GET">
            <input type="text" name="username" placeholder="Search Librarian here by user ID or Email ID" autocomplete="off" />
            <button id="search" type="submit" name="action" value="search"><img id="search-img" src="/libraryManagementSystem/img/search-icon.png"></button>
        </form>
        <a id="librarianRegistration" href="/libraryManagementSystem/librarianRegistration">Register Librarian</a>
        <a id="logout" href="/libraryManagementSystem/logout">Logout</a>
    </header>

<body>

    <c:choose>
        <c:when test="${requestScope.userList != null}">
            <table>
                <thead>
                    <tr>
                        <th>User ID</th>
                        <th>Name</th>
                        <th>Email Address</th>
                        <th>Gender</th>
                        <th>Date Of Birth</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="user" items="${requestScope.userList}">
                    <form action="/libraryManagementSystem/delete" method="POST" onsubmit="return confirmDelete()">
                        <input type="hidden" name="userId" value="${user.userId}"/>
                        <tr>
                            <td><c:out value="${user.userId}"/></td>
                            <td><c:out value="${user.firstName}"/></td>
                            <td><c:out value="${user.emailAddress}"/></td>
                            <td><c:out value="${user.gender}"/></td>
                            <td><c:out value="${user.dateOfBirth}"/></td>
                            <td><button id="delete" type="submit" name="action" value="delete"><img id="delete-img" src="/libraryManagementSystem/img/delete-icon.png"></button></td>
                        </tr>
                    </form>

                </c:forEach>    

            </tbody>
        </table>
    </c:when>
    <c:when test="${requestScope.errMsg != null}">
        <table>
            <thead>
                <tr><th id="err-msg"><c:out value="${requestScope.errMsg}"/></th></tr>
            </thead>
        </table>
    </c:when>
    <c:otherwise>

    </c:otherwise>
</c:choose>

</body>

</body>
</html>