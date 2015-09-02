<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
  <style> 
  body {text: white; background-color: white;  text-align: center; }
   p {background-color: white;}
   h1{text:white; text-aligh-left;}
   </style>
<title>Register</title>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">EvilGulp Store</a>
    </div>
    <div>
      <ul class="nav navbar-nav">
        <li ><a href="ProductList">Product List</a></li>
        <li ><a href="#">My Cart</a></li>
        <li><a href="#">Checkout</a></li>
        <li class="active"><a href="#">Login</a></li>
        <li><a href="#">Register</a></li>
      </ul>
    </div>
  </div>
</nav>

<div class="container">
  <div class="jumbotron">
    <h1>EvilGulp Store</h1>      
    <p>The world's most evil electronic store!</p> 
        <h2>Register</h2>  
      </div>
  </div>
<form role="form" action = "Login" method = "post">
    <div class="form-group">
      <label for="name"></label>
      <input type="text" class="form-control" id="user" name="user" placeholder="Enter user name">
    </div>
     <div class="form-group">
      <label for="address"></label>
      <input type="passsword" class="form-control" id="pwd" name= "pwd" placeholder="Enter password">
    </div>

    
    <button type="submit" class="btn btn-default">Register</button>
    </form>
       
    ${message}
  
</body>
</html>