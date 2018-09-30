<!DOCTYPE html>
<html>
    <head>
        <title>lms login</title>
        <link rel="stylesheet" type="text/css" href="/libraryManagementSystem/css/login.css">
        <script src="/libraryManagementSystem/js/LoginFormValidator.js"></script>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    </head>
    <body>
        <jsp:include page="/html/header.html"/>

        <div class="transparent-block">

        </div>

        <form class="top-form" action="/libraryManagementSystem/loginController" name="loginForm" method="post" onsubmit="return validateForm()">
            <table>
                <tbody>
                    <tr>
                        <td></td>
                        <td><label id="err-msg"><c:out value="${sessionScope.errMsg}"/></label></td>
                    </tr>
                    <tr>
                        <td><label>Username:</label></td>
                        <td><input type="text" name="username" autocomplete="off" placeholder="User ID / Email ID"/></td>
                    </tr>
                    <tr>
                        <td><label>Password:</label></td>
                        <td><input type="password" name="password"/></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Login"/></td>
                    </tr>
                </tbody>
            </table>
        </form>

       <jsp:include page="/html/footer.html"/>

    </body>
</html>