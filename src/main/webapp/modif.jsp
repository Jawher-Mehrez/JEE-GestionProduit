<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="dao.Produit"%>   
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="modifProduit" method="post">
  <label for="fname">id: ${produit.id}</label><br>
  <input type="hidden" id="fname" name="id" value="${produit.id}" ><br>
  <label for="fname">Nom:</label><br>
  <input type="text" id="fname" name="nom" value="${produit.nom}" ><br>
  <label for="fname">Prix:</label><br>
  <input type="text" id="pname" name="prix" value="${produit.prix}" ><br>
  <label for="lname">Quantite:</label><br>
  <input type="text" id="qname" name="quantite" value="${produit.quantite}"><br><br>
  <input type="submit" value="modifier">
</form>
</body>
</html>