<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Ajouter un produit</h2>

<form action="addProduit" method="post">
  <label for="fname">Nom:</label><br>
  <input type="text" id="fname" name="nom" ><br>
  <label for="fname">Prix:</label><br>
  <input type="text" id="pname" name="prix" ><br>
  <label for="lname">Quantite:</label><br>
  <input type="text" id="qname" name="quantite"><br><br>
  <input type="submit" value="Ajouter">
</form>
</body>
</html>