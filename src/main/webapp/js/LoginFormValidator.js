function validateForm()
{
    var user = document.forms["loginForm"]["username"].value;
    var password = document.forms["loginForm"]["password"].value;

    if (user === "")
    {
	alert("Username is mandatory.");
	return false;
    }

    if (password === "")
    {
        alert("Password is mandatory.");
	return false;
    }
}

function showPassword()
{
    
    var x = document.forms["loginForm"]["password"];
    
    if (x.type === "password")
    {
        x.type = "text";
    }
    else
    {
        x.type = "password";
    }
    
}