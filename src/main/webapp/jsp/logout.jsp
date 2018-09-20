<!DOCTYPE html>
<html>
    <head>
        <link href="/libraryManagementSystem/css/logout.css" type="text/css" rel="stylesheet"/>
    </head>
    <body>
        <!--invalidate session -->
        <%session.invalidate();%>
        
	<div>
       	    <p>You have successfully logged out. <a href="/libraryManagementSystem/">Click here</a> to login again.</p>
	</div>
    </body>
</html>
