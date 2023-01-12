<%--
  Created by IntelliJ IDEA.
  User: batur
  Date: 11.01.2023
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register Supplier</title>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;500;600&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/supplierCss.css">
    <script src="js/registerSupplier.js"></script>


</head>
<body>
<h2>Supplier Register / Login Form</h2>
<div class="container" id="container">
    <div class="form-container sign-up-container">
        <form id="registerSupplier" action="#">
            <h1>Hesap Oluştur</h1>
            <input type="text" id="name" placeholder="Name"/>
            <input type="email" id="emailForRegister" placeholder="Email"/>
            <input type="number" id="phone" placeholder="Phone"/>
            <input type="password" id="passwordForRegister" placeholder="Password"/>
            <button type="submit">Kayıt Ol</button>
        </form>
    </div>
    <div class="form-container sign-in-container">
        <form action="#">
            <h1>Giriş Yap</h1>
            <input type="email" id="emailForLogin" placeholder="Email"/>
            <input type="password" id="passwordForLogin" placeholder="Password"/>
            <button>Giriş</button>
        </form>
    </div>
    <div class="overlay-container">
        <div class="overlay">
            <div class="overlay-panel overlay-left">
                <h1>Tekrar Hoşgeldin</h1>
                <p>Zaten Sisteme Kayıtlıysan Lütfen Giriş Yap.</p>
                <button class="ghost" id="signIn">Giriş Yap</button>
            </div>
            <div class="overlay-panel overlay-right">
                <h1>Merhaba</h1>
                <p>Eğer Sistemde Kaydın Yoksa Lütfen Kayıt Ol.</p>
                <button class="ghost" id="signUp">Kayıt Ol</button>
            </div>
        </div>
    </div>
</div>

<footer>
    <p>
    </p>
</footer>
</body>

<script>
    const signUpButton = document.getElementById('signUp');
    const signInButton = document.getElementById('signIn');
    const container = document.getElementById('container');

    signUpButton.addEventListener('click', () => {
        container.classList.add("right-panel-active");
    });

    signInButton.addEventListener('click', () => {
        container.classList.remove("right-panel-active");
    });
</script>

</html>