<!DOCTYPE html>
<html>
    <head>
        <title>add librarian</title>
        <link rel="stylesheet" type="text/css" href="/libraryManagementSystem/css/admin/librarianRegistration.css">
        <script type="text/javascript" src="/libraryManagementSystem/js/admin/librarianRegistration.js"></script>
    </head>
    <body>

        <header>
            <h1>Librarian Registration</h1>
            <a id="home" href="/libraryManagementSystem/home">Home</a>
            <a id="logout" href="/libraryManagementSystem/logout">Logout</a>
            <h2>LMS</h2>
        </header>

        <div class="transparent-block">

        </div>

        <form name="form" class="top-form" onsubmit="return validate();" action="/libraryManagementSystem/registration" method="post">
            <div class="table">
                <label>First Name</label><br>
                <input type="text" name="firstName" autocomplete="off" maxlength="30" onfocus="validateFirstName()" oninput="validateFirstName()" spellcheck="false"/><br>
                <label id="firstName"></label>
                <br>
                <label>Last Name</label><br>
                <input type="text" name="lastName" autocomplete="off" maxlength="30" onfocus="validateLastName()" oninput="validateLastName()" spellcheck="false"/><br>
                <label id="lastName"></label>
                <br>
                <label>Email</label><br>
                <input type="text" name="emailAddress" autocomplete="off" onfocus="validateEmail()" oninput="validateEmail()" spellcheck="false"/><br>
                <label id="email"></label>
                <br>
                <input type="submit" value="Register"/>
            </div>
        </form>

        <footer>
            <h4>Copyright @ rakesh</h4>
        </footer>

    </body>
</html>
