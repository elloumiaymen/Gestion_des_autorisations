<%@ page import="tn.iit.glid22.Dao.EnseignantDao"%>
<%@ page import="tn.iit.glid22.model.Enseignant" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.stream.Collectors" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login Page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>

    <style>
        /* centrage des champs */
        form {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;

        }

        input[type="text"],
        input[type="password"],
        input[type="number"],
        input[type="email"] {
            width: 100%;
            max-width: 300px;
            margin-bottom: 10px;
            padding: 10px;
            border-radius: 5px;
            border: none;
            box-shadow: 0px 2px 4px rgba(0, 0, 0, 0.1);
            transition: all 0.3s ease-in-out;
        }

        input[type="text"]:focus,
        input[type="password"]:focus,
        input[type="number"]:focus,
        input[type="email"]:focus {
            background-color: #f5f5f5;
            outline: none;
            box-shadow: 0px 2px 4px rgba(0, 0, 0, 0.3);
        }
        input[type="submit"] {
            background-color: #ff9f5c;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            transition: all 0.3s ease-in-out;
            font-size: 16px;
            font-weight: bold;
            text-transform: uppercase;
        }

        input[type="submit"]:hover {
            background-color: #ffae75;
        }

        a {
            color: #FA8072;
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }

        /* messages d'erreur en rouge */
        .error {
            color: red;
        }

		.card {
            background: linear-gradient(to bottom, #fff9f5, #ffcca8);
            max-width: 500px;
            max-height: 600px;
            margin: 0 auto;
            padding: 0px;
            border-radius: 20px;
            box-shadow: 0px 2px 4px rgba(0, 0, 0, 0.1);
            display: flex;
            align-items: center;
            justify-content: center;
             margin-top:15%;
        }


        .form-group {
            display: flex;
            flex-direction: column;
            margin-bottom: 10px;
        }

        .form-group label {
            color: black;
            margin-bottom: 0px;
            font-weight: bold;
        }
         .card-body {
            display: flex;
            flex-direction: column;
            align-items: center;
            width: 100%;
            height: 100%
        }
       
    </style>
    <%@include file="Navbar.jsp"%>
    <meta charset="ISO-8859-1">
    <title>Modifier Enseignant</title>
</head>
<body>
    <%
    	EnseignantDao enseignantDao = new EnseignantDao();
    	List<Enseignant> listEnseignant = enseignantDao.getAll();
    	request.setAttribute("listEnseignant", listEnseignant);
        
        // Récupérer l'enseignant sélectionné par son ID
        int selectedEnseignantId = Integer.parseInt(request.getParameter("id"));
        Enseignant selectedEnseignant = null;        
        // Rechercher l'enseignant sélectionné dans la liste des enseignants
        for(Enseignant u : listEnseignant) {
            if (u.getId() == selectedEnseignantId) {
                selectedEnseignant = u;
                break;
            }
        }

    %>
<div class="container">
    <div class="card">
        <div class="card-body">
    <form action="UpdateController" method="post">
    
     <h2>Modifier Utilisateur</h2><br>
     
        <input type="hidden" name="id" value="<%= selectedEnseignantId %>">
 <div class="form-group">
        <label>Nom:</label>
        <input type="text" name="nom" value="<%= (selectedEnseignant != null) ? selectedEnseignant.getNom() : "" %>">
        </div>
 <div class="form-group">
        <label>Prénom:</label>
        <input type="text" name="prenom" value="<%= (selectedEnseignant != null) ? selectedEnseignant.getPrenom() : "" %>">
        </div>
 <div class="form-group">
        <label>Téléphone:</label>
        <input type="text" name="telephone" value="<%= (selectedEnseignant != null) ? selectedEnseignant.getTelephone() : "" %>">
        </div>
 <div class="form-group">
        <label>Email:</label>
        <input type="text" name="email" value="<%= (selectedEnseignant != null) ? selectedEnseignant.getEmail() : "" %>">
        </div>
        <br>

        <input type="submit" class="btn btn-primary" value="Enregistrer">
    </form>
     </div>
    </div>
</div>
</body>
<footer>
	<%@include file="Footer.jsp"%>
</footer>
</html>
