function validateLoginForm()
{
    var username = document.forms['loginForm']['username'].value;
    var password = document.forms['loginForm']['password'].value;
    
    if(username === '')
    {
        alert('Username is mandatory.');
        return false;
    }
    
    if(password === '')
    {
        alert('password is mandatory.');
        return false;
    }
    
}