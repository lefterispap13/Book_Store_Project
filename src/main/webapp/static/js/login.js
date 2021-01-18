// $(function() {
//     $("#loginBtn").click(function () {
//         var username=$("#username").val();
//         var password=$("#password").val();
//         $.ajax({
//             cache: true,
//             type: "POST",
//             url: "http://localhost:8080/login",
//             contentType: "application/json;charset=UTF-8",
//             data:JSON.stringify({"username":username ,"password" : password}),
//             dataType: "json",
//             async: false,
//             error: function (request) {
//                 console.log("Connection error");
//             },
//             success: function (data) {
//                 //save token
//                 localStorage.setItem("token",data.token);
//
//
//             }
//         });
//     });
// });
// async function handleSubmit () {
//     var username = document.getElementById("username").value
//     var password = document.getElementById("password").value
//     const response = await fetch(`/auth/login`, {
//         method: 'POST',
//         body: JSON.stringify({ username, password })
//     })
//     //...
//     // Extract the JWT from the response
//     const { jwt_token } = await response.json()
//     //...
//     // Do something the token in the login method
//     await login({ jwt_token })
// }
$(function() {
    $("#loginBtn").click(function () {
        var username=$("#username").val();
        var password=$("#password").val();
        $.ajax({
            cache: true,
            type: "POST",
            url: "/authenticate",
            contentType: "application/json;charset=UTF-8",
            data:JSON.stringify({"username":username ,"password" : password}),
            dataType: "json",
            async: false,
            error: function (request) {
                console.log("Connection error");
            },
            success: function (data) {
                //save token
                localStorage.setItem("token",data.token);


            }
        });
    });
});
