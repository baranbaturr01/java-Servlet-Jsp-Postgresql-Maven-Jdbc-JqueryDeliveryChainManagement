$(document).ready(function () {
    //register
    $("#register").submit(function () {
        console.log("register2");
        var name = $("#name").val();
        var password = $("#password").val();
        var email = $("#email").val();
        var dataString = 'name=' + name + '&password=' + password + '&email=' + email;
        if ($.trim(name).length > 0) {
            $.ajax({
                type: "POST",
                url: "http://localhost:8080/demo-1.0-SNAPSHOT/register",
                data: dataString,
                dataType: "json",
                crossDomain: true,
                cache: false,
                beforeSend: function () {
                    $("#register").val('Connecting...');
                },
                success: function (data) {
                    console.log(data);
                    if (data.success === true) {

                        //localStorage.setItem("name", data.name);
                        //localStorage.setItem("email", data.email);
                        //     show the user that the registration was successful
                        alert("Registration successful");
                    }
                }
            });
        }
        return false;
    });
})