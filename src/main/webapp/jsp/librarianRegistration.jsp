<!DOCTYPE html>
<html>
    <head>
        
    </head>
    <body>
	<div>
            <form action="/libraryManagementSystem/librarianRegistration" method="post">
		<table>
                    <thead>
			<th colspan="2"><label>Register here</label></th>
                    </thead>
                    <tbody>
                        <tr>
                            <td><label>Email: </label></td>
                            <td><input type="email" name="emailId" value="${requestScope.registeredEmailId}" readonly="readonly"/></td>
                        </tr>
			<tr>
                            <td><label>First Name: </label></td>
                            <td><input type="text" name="firstName" placeholder="Not more than 30 characters" /></td>
			</tr>
                       	<tr>
                            <td><label>Last Name: </label></td>
                            <td><input type="text" name="lastName" placeholder="Not more than 30 characters"/></td>
			</tr>
			<tr>
                            <td><label>User ID: </label></td>
                            <td><input type="text" name="userId" placeholder="Not more than 30 characters"/></td>
			</tr>
			<tr>
                            <td><label>Gender: </label></td>
                            <td>
				<input type="radio" name="gender" value="male" checked/> Male
				<input type="radio" name="gender" value="female"/> Female
                            </td>
			</tr>
			<tr>
                            <td><label>Date Of Birth: </label></td>
                            <td><input type="text" name="dateOfBirth" placeholder="dd/mm/yyyy" /></td>
			</tr>
			<tr>
                            <td><label>Password: </label></td>
                            <td><input type="Password" name="password"/></td>
			</tr>
			<tr>
                            <td><label>Re-enter password: </label></td>
                            <td><input type="Password" name="password2"/></td>
			</tr>
			<tr>
                            <td></td>
                            <td><input type="submit" name="registerLibrarian" value="Register"/></td>
			</tr>
                    </tbody>
		</table>
            </form>
	</div>
    </body>
</html>