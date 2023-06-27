<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<html>
<head>
    <!-- METADATA -->
    <!-- charset para caracteres especiales -->
    <meta charset="utf-8">
    <!-- author -->
    <meta name="author" content="Juan Pablo R.">
    <!-- description -->
    <meta name="description" content="Página de prueba sobre un formulario de ingreso de usuario">
    <!-- keywords -->
    <meta name="keywords" content="registro de usuario, formulario de registro, crear cuenta, registro en linea">
    <!-- minimum responsive viewport -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- TITLE -->
    <title>REGISTRO DE USUARIO : MY APP</title>
    <!-- FAVICON -->
    <link rel="icon" type="image/x-icon" href="img/Register-icon.png">
    <!-- CSS -->
    <link rel="stylesheet" href="css/styles_default.css">
    <!-- bootstrap css / icons -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/boostrap.min.css"
          rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
          crossorigin="anonymous">

    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
    <!-- custom css -->
    <link rel="stylesheet" href="css/register.css">

</head>

<header><h1>My app</h1>
<nav>
    <a href="index">Login</a>  |  <a href="categoryL">Category</a>  |  <a href="productL">Product</a>  |  <a href="sena">SENA</a>
</nav>
</header>

<body class="text-center">
<!-- login form -->
<main class="form-register w -100 m-auto">
    <form class="" action="registerUser" method="post">
        <img class="mb-4" src="img/RegisterLogo.png" alt="MY APP" width="100">
        <h4 class="text-secondary">Yugi web</h4>
        <h2 class="h5 mb-3 fw-normal">Ingreso</h2>

        <div class="form-floating">
            <label for="floatingInput">
            Name: <input type="text" class="form-control" id="floatingInput" name="user_firstname"
                    placeholder="Ingress your Name" autofocus required pattern="[A-Z a-z]{2,30}">
            </label>
        </div>

        <div class="form-floating">
            <label for="floatingInput2">
            Last Name: <input type="text" id="floatingInput2" name="user_lastname"
                              placeholder="Ingress your Lastname" required pattern="[A-Z a-z]{2,40}">
            </label>
        </div>

        <div class="form-floating">
            <br>
            <label for="email">
                Email: <input type="email" id="email" name="user_email"
                              placeholder="Ingress your Email" required pattern="{70}">
            </label>
        </div>

        <div class="form-floating">
            <label for="floatingPassword">
            Password: <input type="password" class="form-control" id="floatingPassword" name="user_password"
                             placeholder="Ingress your Password" required pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,16}$">
            </label>
        </div>

        <button class="w-100 btn btn-primary" type="submit">Submit</button>
</form>
</main>

<footer>
    <p class="mt-3 mb-3 text-muted">Todos los derechos estan reservados Juan Pablo Rodriguez©<%=displayDate()%></p>
</footer>

<!-- Bootstrap script-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
<%!
    public String displayDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY");
        Date date = Calendar.getInstance().getTime();
        return dateFormat.format(date);
    }
%>
</body>
</html>