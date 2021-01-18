function postApi() {

    $(document).ready(function () {
        var jsonData = {};
        var username = document.getElementById("username").value
        var firstName = document.getElementById("firstName").value
        var psw = document.getElementById("txtpassword").value
        var lastName = document.getElementById("lastName").value
        var dateOfBirth = document.getElementById("dateOfBirth").value
        var email = document.getElementById("email").value
        var cnfpsw = document.getElementById("txtConfirmPassword").value
        var gender = document.getElementById("gender").value
        // if (psw === cnfpsw) {
        var jsonRole = {"roleId": 2, "type": "user"}
        jsonData["password"] = psw
        jsonData["username"] = username
        jsonData["firstName"] = firstName
        jsonData["lastName"] = lastName
        jsonData["dateOfBirth"] = dateOfBirth
        jsonData["email"] = email
        jsonData["gender"] = gender
        jsonData["role"] = jsonRole
        jsonData["coins"] = 1000
        $.ajax({
            url: "http://localhost:8080/api/account/new",
            type: "POST",
            contentType: "application/json",
            // cors: true,
            dataType: "json",
            data: JSON.stringify(jsonData),
            success: function (jsonData) {
                alert("Account successfully created!");
                window.location.href = "index.html";
            },
            error: function (jqXHR, textStatus, errorThrown) {
            }
        });
        return true;
    });

}

function checkform()
{
    var f = document.forms["formregister"].elements;
    var cansubmit = true;

    for (var i = 0; i < 8; i++) {
        if (f[i].value.length <=3) cansubmit = false;
    }


    if (cansubmit) {
        document.getElementById('register').disabled = false;
    }
    else {
        document.getElementById('register').disabled = 'disabled';
    }
}

