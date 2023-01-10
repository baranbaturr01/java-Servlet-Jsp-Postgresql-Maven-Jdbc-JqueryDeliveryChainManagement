$(document).submit(function () {
    console.log("login");
    var email = $("#email").val();
    var password = $("#password").val();
    var dataString = 'email=' + email + '&password=' + password;
    if ($.trim(email).length > 0 && $.trim(password).length > 0) {
        $.ajax({
            type: "POST",
            url: "http://localhost:8080/demo-1.0-SNAPSHOT/login",
            data: dataString,
            dataType: "json",
            crossDomain: true,
            cache: false,
            beforeSend: function () {
                $("#login").val('Connecting...');
            },
            success: function (data) {
                console.log(data);
                if (data.success === true) {
                    //localStorage.setItem("name", data.name);
                    //localStorage.setItem("email", data.email);
                    //     show the user that the registration was successful
                    alert("Login successful");
                }
            }
        });
    }
    return false;
}