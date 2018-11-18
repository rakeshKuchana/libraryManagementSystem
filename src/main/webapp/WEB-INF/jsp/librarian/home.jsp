<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <head>
        <title>home</title>
        <link rel="stylesheet" type="text/css" href="/libraryManagementSystem/css/librarian/home.css"/>
        <script src="/libraryManagementSystem/js/librarian/home.js" type="text/javascript"></script>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    </head>
    <body>
        <header>
            <form action="/libraryManagementSystem/searchBooks" method="GET">
                <input type="text" name="name" placeholder="Search a book here by name or author.." autocomplete="off" />
                <button id="search" type="submit" name="action" value="search"><img id="search-img" src="/libraryManagementSystem/img/search-icon.png"></button>
            </form>
           <!-- <a id="add-book" href="">Add Book</a>
            <a id="add-student" href="">Add Student</a>-->
            <a id="logout" href="/libraryManagementSystem/logout">Logout</a>
        </header>

    <body>

        <c:choose>
            <c:when test="${requestScope.booksList != null}">
                <table>
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Author</th>
                            <th>Status</th>
                            <th>Issued to</th>
                            <th>Issued date</th>
                            <th>Expected Return date</th>
                            <th>Issued by</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="book" items="${requestScope.booksList}">
                        <form action="/libraryManagementSystem/searchBooks" method="POST" onsubmit="return confirmS()">
                            <input type="hidden" name="id" value="${book.id}"/>
                            <input type="hidden" name="name" value="${book.name}"/>
                            <input type="hidden" name="author" value="${book.author}"/>
                            <tr>
                                <td><c:out value="${book.id}"/></td>
                                <td><c:out value="${book.name}"/></td>
                                <td><c:out value="${book.author}"/></td>
                                <td><c:out value="${book.status}"/></td>
                                <td><c:out value="${book.issued_to}"/></td>
                                <td><c:out value="${book.issue_date}"/></td>
                                <td><c:out value="${book.expected_return_date}"/></td>
                                <td><c:out value="${book.issued_by}"/></td>
                                <c:if test="${book.status == 'AVAILABLE'}">
                                    <td><button id="issue-book" type="submit" name="action" value="issue">Issue Book</button></td>
                                </c:if>
                                <c:if test="${book.status == 'ISSUED'}">
                                    <td><button id="issue-book" type="submit" name="action" value="return">Return Book</button></td>
                                </c:if>

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