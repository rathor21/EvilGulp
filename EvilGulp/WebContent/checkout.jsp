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
<title>CheckOut</title>
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
        <li ><a href="ShoppingCart">My Cart</a></li>
        <li class="active"><a href="#">Checkout</a></li>
      </ul>
    </div>
  </div>
</nav>

<div class="container">
  <div class="jumbotron">
    <h1>EvilGulp Store</h1>      
    <p>The world's most evil electronic store!</p> 
      <h2>Checkout</h2> 
      </div>
     



<div class="container">
  
  <form role="form" action = "ProductList" method = "get">
    <div class="form-group">
      <label for="name"></label>
      <input type="text" class="form-control" id="name" placeholder="Enter name">
    </div>
     <div class="form-group">
      <label for="address"></label>
      <input type="text" class="form-control" id="address" placeholder="Enter address">
    </div>
     <div class="form-group">
      <label for="credit"></label>
      <input type="text" class="form-control" id="creditcard" placeholder="Enter credit card number">
    </div>
 
    ${message}
    <button type="submit" class="btn btn-default">Submit Order</button>
  </form>
</div>

</body>
</html>