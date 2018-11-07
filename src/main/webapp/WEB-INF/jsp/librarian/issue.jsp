<!DOCTYPE html>
<html>
    <head>
        <title>issue book</title>
        <link rel="stylesheet" type="text/css" href="/libraryManagementSystem/css/librarian/issue.css">
        <script type="text/javascript" src="/libraryManagementSystem/js/librarian/issue.js"></script>
    </head>
    <body>
        <header>
            <h1>Issue book</h1>
        </header>
        <form action="/libraryManagementSystem/issueBook" method="POST" name="form" onsubmit="return validate();">
            <table>
                <tr>
                    <td><label>ID:</label></td>
                    <td><input type="text" name="id" value="${requestScope.book.id}" spellcheck="false" readonly="readonly"></td>
                </tr>
                <tr>
                    <td><label>Name:</label></td>
                    <td><input type="text" name="name" value="${requestScope.book.name}" spellcheck="false" readonly="readonly"></td>
                </tr>
                <tr>
                    <td><label>Author:</label></td>
                    <td><input type="text" name="author" value="${requestScope.book.author}" spellcheck="false" readonly="readonly"></td>
                </tr>
                <tr>
                    <td><label>Issue to:</label></td>
                    <td><input type="text" name="studentId" onfocus="validateStudentId()" oninput="validateStudentId()"></td>
                    <td><label id="studentId"></label></td>
                </tr>
                <tr>
                    <td></td>
                    <td><button type="submit" name="action" value="issueBook">Issue Book</button></td>
                </tr>
            </table>
        </form>


    </body>
</html>