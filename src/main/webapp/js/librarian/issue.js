var studentIdValidationFailed = false;

function validateStudentId()
{

    var value = document["form"]["studentId"].value;
    var errorElement = document.getElementById("studentId");


    if (value == "")
    {
        errorElement.innerHTML = "Cannot be Empty";
        studentIdValidationFailed = true;
    } else
    {
        errorElement.innerHTML = "";
        studentIdValidationFailed = false;
    }

}

function validate()
{
    validateStudentId();


    if (studentIdValidationFailed)
    {
        return false;
    }
}