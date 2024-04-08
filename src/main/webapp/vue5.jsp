<%@page import="dao.Produit"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<div class="text-end">${username}</div>
<div class="my-3">
<a href="addProduit" class="btn btn-primary"> Ajouter un nouveau produit</a>
</div>
<div>
<form action="findProduit" method="post">
  <input type="text" id="rech" name="rech" >
  <input type="submit" value="recherche par Nom"> 
</form>

</div>

<table class="table table-hover">
<tr>
<th>ID</th>
<th>NOM</th>
<th>PRIX</th>
<th>QUANTITE</th>
<th>Action</th>
</tr>

<c:forEach var="p" items="${listeP}">
<tr>
<td>${p.id}</td>
<td>${p.nom}</td>
<td>${p.prix}</td>
<td>${p.quantite}</td>
<td>
<a href="suppProduit?id=${p.id}" class="btn btn-danger"> Supprimer</a>
<a href="modifProduit?id=${p.id}" class="btn btn-danger"> modifier</a>
</td>
</tr>

</c:forEach>
</table>

</body>
</html>