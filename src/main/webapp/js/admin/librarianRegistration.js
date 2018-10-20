var firstNameValidationFailed = false;
var lastNameValidationFailed = false;
var emailValidationFailed = false;

function validateFirstName()
{

    var value = document["form"]["firstName"].value;
    var errorElement = document.getElementById("firstName");


    if (value === "")
    {
        errorElement.innerHTML = "Cannot be Empty";
        firstNameValidationFailed = true;
    } else
    {
        errorElement.innerHTML = "";
        firstNameValidationFailed = false;
    }

}

function validateLastName()
{

    var value = document["form"]["lastName"].value;
    var errorElement = document.getElementById("lastName");


    if (value === "")
    {
        errorElement.innerHTML = "Cannot be Empty";
        lastNameValidationFailed = true;
    } else
    {
        errorElement.innerHTML = "";
        lastNameValidationFailed = false;
    }

}

function validateEmail()
{

    var value = document["form"]["emailAddress"].value;
    var errorElement = document.getElementById("email");
    var emailPattern = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*\.\w{2,3}$/;


    if (value === "")
    {
        errorElement.innerHTML = "Cannot be Empty";
        emailValidationFailed = true;
    } else if (!emailPattern.test(value))
    {
        errorElement.innerHTML = "Invalid Email";
        emailValidationFailed = true;
    } else
    {
        errorElement.innerHTML = "";
        emailValidationFailed = false;
    }

}

function validate()
{
    validateFirstName();
    validateLastName();
    validateEmail();

    if (firstNameValidationFailed || lastNameValidationFailed || emailValidationFailed)
    {
        return false;
    }
}


