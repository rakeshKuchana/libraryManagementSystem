<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <head>
        <title>home</title>
        <link rel="stylesheet" type="text/css" href="/libraryManagementSystem/css/admin/home.css"/>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    </head>
    <body>
        <header>
            <form action="/libraryManagementSystem/search" method="GET">
                <input type="text" name="username" placeholder="Search Librarian here by user ID or Email ID" autocomplete="off" />
                <button type="submit" name="action" value="search"><img src="/libraryManagementSystem/img/search-icon.png"></button>
            </form>
            <a id="librarianRegistration" href="/libraryManagementSystem/librarianRegistration">Register Librarian</a>
            <a id="logout" href="/libraryManagementSystem/logout">Logout</a>
        </header>

    <body>

        <c:choose>
            <c:when test="${requestScope.user != null}">
                <table>
                    <thead>
                        <tr>
                            <th colspan="2">Librarian Details</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>User ID:</td>
                            <td><c:out value="${requestScope.user.userId}"/></td>
                        </tr>
                        <tr>
                            <td>Name:</td>
                            <td><c:out value="${requestScope.user.firstName}"/></td>
                        </tr>
                        <tr>
                            <td>Email ID:</td>
                            <td><c:out value="${requestScope.user.emailId}"/></td>
                        </tr>
                        <tr>
                            <td>Gender:</td>
                            <td><c:out value="${requestScope.user.gender}"/></td>
                        </tr>
                        <tr>
                            <td>Date Of Birth</td>
                            <td><c:out value="${requestScope.user.date}"/></td>
                        </tr>
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