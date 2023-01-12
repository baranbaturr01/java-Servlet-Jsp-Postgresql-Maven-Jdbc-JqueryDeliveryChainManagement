$(document).ready(function () {
    //register
    $("#registerSupplier").submit(function () {
        console.log("tıklandı")
        var name = $("#name").val();
        var password = $("#passwordForRegister").val();
        var email = $("#emailForRegister").val();
        var phone = $("#phone").val();
        var dataString = 'name=' + name + '&password=' + password + '&email=' + email + '&phone=' + phone;
        if ($.trim(name).length > 0) {
            $.ajax({
                type: "POST",
                url: "http://localhost:8080/Delivery_Chain_Management-1.0-SNAPSHOT/registerSupplier",
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

                        localStorage.setItem("name", data.name);

                        window.location.href = "http://localhost:8080/Delivery_Chain_Management-1.0-SNAPSHOT/product-list";
                        alert("Registration successful");
                    }
                }
            });
        }
        return false;
    });
})