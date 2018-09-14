<!DOCTYPE html>
<html>
    <head>
        <link href="css/main.css" type="text/css" rel="stylesheet"/>
	<script src="js/LoginFormValidator.js"></script>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    </head>

    <body>
        <header>
            <h1>Library Management System</h1>
	</header>

        <div id="form-section">
            <form action="home" name="loginForm" method="post" onsubmit="return validateForm()">
		<table>
                    <tbody>
                        <tr>
                            <td></td>
                            <td><label id="err-msg"><c:out value="${requestScope.ErrorMsg}"/></label></td>
                        </tr>
                        <tr>
                            <td><label>Username:</label></td>
                            <td><input type="text" name="username" autocomplete="off" /></td>
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
	</div>

	<footer>
            <h4>Copyright @ rakesh</h4>
	</footer>
    </body>
</html>