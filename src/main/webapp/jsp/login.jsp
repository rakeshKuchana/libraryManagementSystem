<!DOCTYPE html>
<html>
    <head>
        <link href="/libraryManagementSystem/css/main.css" type="text/css" rel="stylesheet"/>
	<script src="/libraryManagementSystem/js/LoginFormValidator.js"></script>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    </head>

    <body>
        <jsp:include page="/html/header.html"/>
       
        <div id="form-section">
            <form action="/libraryManagementSystem/loginController" name="loginForm" method="post" onsubmit="return validateForm()">
		<table>
                    <tbody>
                        <tr>
                            <td></td>
                            <td><label id="err-msg"><c:out value="${requestScope.ErrorMsg}"/></label></td>
                        </tr>
                        <tr>
                            <td><label>Username:</label></td>
                            <td><input type="text" name="username" autocomplete="off" placeholder="User ID/email ID"/></td>
			</tr>
			<tr>
                            <td><label>Password:</label></td>
                            <td><input type="password" name="password"/></td>
			</tr>
                        <tr>
                            <td></td>
                            <td class="checkbox"><input type="checkbox" onclick="showPassword()"/>Show password</td>
			</tr>
			<tr>
                            <td></td>
                            <td><input type="submit" value="Login"/></td>
			</tr>
                    </tbody>
		</table>
                <input type="hidden" name="targetURI" value="${param.pageId}"/>
            </form>
	</div>
                        
        <jsp:include page="/html/footer.html"/>
         
    </body>
</html>