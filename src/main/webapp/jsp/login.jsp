<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/main.css"/>
        <script type="text/javascript" src="js/LoginFormValidator.js"></script>
    </head>
	<body>
            <!--Header-->
            <header id="header">
		<h1 id="appName">Library Management System</h1>
		<!--<a href="../">Home</a>-->
            </header>
            <center>
                <form id="loginForm" action="../login" method="post" onsubmit="return validateLoginForm()">
                    <table>
                        <tr>
                            <td><input type="text" name="username" placeholder="username" autocomplete="off"/></td>
                        </tr>
                        <tr>
                            <td><input type="password" name="password" placeholder="password"/></td>
                        </tr>
                        <tr>
                            <td><input type="Submit" value="Login"/></td>
                        </tr>
                    </table>
                </form>
            </center>
        
            <footer id="footer">
                <p>copyright @ rakesh</p>
            </footer>
	</body>
</html>