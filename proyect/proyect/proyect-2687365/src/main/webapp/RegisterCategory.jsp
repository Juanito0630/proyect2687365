<%--
  Created by IntelliJ IDEA.
  User: APRENDIZ
  Date: 30/05/2023
  Time: 11:16 a. m.
  To change this template use File | Settings | File Templates.
--%>
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
  <meta name="description" content="Página de prueba sobre un formulario de registro de categoria">
  <!-- keywords -->
  <meta name="keywords" content="registro de categoria, formulario de registro, crear categoria, registro en linea">
  <!-- minimum responsive viewport -->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- TITLE -->
  <title>REGISTRO DE CATEGORIA : MYAPP</title>
  <!-- FAVICON -->
  <link rel="icon" type="image/x-icon" href="img/Register-icon.jpg">
  <!-- CSS -->
  <link rel="stylesheet" href="css/styles_default.css">
  <!-- bootstrap css / icons -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
        crossorigin="anonymous">

  <link rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
  <!-- custom css -->
  <link rel="stylesheet" href="css/register.css">
</head>

<header><h1>Myapp</h1>
  <nav>
    <a href="index">Login</a>  |  <a href="categoryL">Category</a>  |  <a href="productL">Product</a>  |  <a href="sena">SENA</a>
  </nav>
</header>

<body class="text-center">
<!-- login form -->
<main class="form-register w -100 m-auto">
  <form class="" action="registerCategory" method="POST">
    <img class="mb-4" src="img/RegisterLogo.png" alt="MY APP" width=100>
    <h4 class="text-secondary">Yugi web</h4>
    <h1 class="h5 mb-3 fw-normal">Registrar</h1>
    <br/>

    <div class="form-floating">

      <label for="floatingInput">
        Name: <input type="text" class="form-control" id="floatingInput" name="category_name"
                     placeholder="Ingrese nombre de Categoria" autofocus required pattern="[A-Z a-z]{2,30}">
      </label>

    </div>

    <button class="w-100 btn btn-primary" type="submit">Submit</button>

  </form>
</main>

<footer>
  <p class="mt-3 mb-3 text-muted">Todos los derechos estan reservados Juan Pablo Rodriguez ©<%=displayDate()%></p>
</footer>

<!-- Bootstrap script-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
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