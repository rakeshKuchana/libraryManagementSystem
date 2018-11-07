var userIdValidationFailed = false;
var newPasswordValidatedFailed = false;
var confirmPasswordValidatedFailed = false;
var dateOfBirthValidationFailed = false;

function validateUserId()
{
    var userId = document["form"]["userId"].value;
    var errorElement = document.getElementById("userId");

    if (userId === "")
    {
        errorElement.innerHTML = "Cannot be Empty";
        userIdValidationFailed = true;
    } else
    {
        errorElement.innerHTML = "";
        userIdValidationFailed = false;
    }
}

function validateNewPassword()
{
    var newPassword = document["form"]["newPassword"].value;
    var errorElement = document.getElementById("newPassword");

    if (newPassword === "")
    {
        errorElement.innerHTML = "Cannot be Empty";
        newPasswordValidatedFailed = true;
    } else
    {
        errorElement.innerHTML = "";
        newPasswordValidatedFailed = false;
    }
}

function validateConfirmPassword()
{
    var confirmPassword = document["form"]["confirmPassword"].value;
    var errorElement = document.getElementById("confirmPassword");
    var newPassword = document["form"]["newPassword"].value;

    if (confirmPassword === "")
    {
        errorElement.innerHTML = "Cannot be Empty";
        confirmPasswordValidatedFailed = true;
    } else if (newPassword !== confirmPassword)
    {
        errorElement.innerHTML = "Not matching New password";
        confirmPasswordValidatedFailed = true;
    } else
    {
        errorElement.innerHTML = "";
        confirmPasswordValidatedFailed = false;
    }
}

function validateDateOfBirth()
{
    var day = document["form"]["day"].value;
    var month = document["form"]["month"].value;
    var year = document["form"]["year"].value;

    var errorElement = document.getElementById("dateOfBirth");

    if (day === "" || month === "" || year === "")
    {
        errorElement.innerHTML = "Select Date of Birth";
        dateOfBirthValidationFailed = true;

    } else
    {
        errorElement.innerHTML = "";
        dateOfBirthValidationFailed = false;
    }
}

function validate()
{
    validateUserId();
    validateNewPassword();
    validateConfirmPassword();
    validateDateOfBirth();

    if (userIdValidationFailed || newPasswordValidatedFailed || confirmPasswordValidatedFailed || dateOfBirthValidationFailed)
    {
        return false;
    }

}

window.onload = function(){
    document.getElementById("day").value=document.getElementById("dayValue").value;
    document.getElementById("month").value=document.getElementById("monthValue").value;
    document.getElementById("year").value=document.getElementById("yearValue").value;
    
    var gender = document.getElementById("gender").value;
    
    if (gender === 'male')
    {
        document.getElementById('maleGender').setAttribute('checked','checked');
    }
    else if (gender === 'female')
    {
        document.getElementById('femaleGender').setAttribute('checked','checked');
    }
}



