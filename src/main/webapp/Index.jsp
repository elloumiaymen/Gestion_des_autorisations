<%@page import="tn.iit.glid22.model.Enseignant"%>
<%@page import="tn.iit.glid22.Dao.EnseignantDao"%>
<%@ page import="javax.servlet.ServletContext"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.stream.Collectors"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.6.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<style>
.gradient-custom-1 {
	background: #cd9cf2;
	background: -webkit-linear-gradient(to top, rgb(255, 202, 168),
		rgba(246, 243, 255, 1));
	background: linear-gradient(to top, rgb(255, 202, 168),
		rgba(246, 243, 255, 1));
}

.link-blue {
	color: blue;
}

.link-red {
	color: red;
}

.link-green {
	color: green;
}

.link-special {
	color: black;
	background-color: #ffd9c2;
	border-radius: 5px;
	border: none;
}

table td, table th {
	text-overflow: ellipsis;
	white-space: nowrap;
	overflow: hidden;
}

tbody td {
	font-weight: 500;
	color: #999999;
}

.table-container {
	margin-top: 30px;
	display: flex;
	flex-direction: column;
	flex-grow: 1;
}

.table-responsive {
	flex-grow: 1;
	overflow-y: auto;
}

footer {
	width: 100%;
	padding: 0 0 0 0;
	margin: 0 0 0 0;
}
</style>

<%@include file="Navbar.jsp"%>

<meta charset="UTF-8">
<title>Gestion des autorisations</title>
</head>
<body>
	<%
	String search = request.getParameter("search");
	EnseignantDao enseignantDao = new EnseignantDao();
	@SuppressWarnings("unchecked")
	List<Enseignant> listEnseignant = (List<Enseignant>) application.getAttribute("listEnseignant");
	if (listEnseignant == null) {
		listEnseignant = enseignantDao.getAll();
		request.setAttribute("listEnseignant", listEnseignant);
	}
	%>
	<div class="gradient-custom-1">
		<section class="intro">
			<div class="gradient-custom-1 h-100">
				<div class="mask d-flex align-items-center h-100">
					<div class="container">
						<div class="row justify-content-center">
							<div class="col-12">
								<form action="EnseignantController" method="post"
									class="search-form">
									<div class="input-group search-input" style="margin-top: 20px;">
										<div class="input-group-prepend">
											<span class="input-group-text"><i class="fa fa-search"></i></span>
										</div>
										<input type="text" class="form-control"
											placeholder="Recherche" id="search" name="search">
										<div class="input-group-append">
											<button type="submit" class="link-special">Rechercher</button>
										</div>
									</div>

								</form>
								<!-- tableau -->
								<div class="table-container">
									<div class="table-responsive bg-white">
										<table class="table mb-0">
											<thead>
												<tr>
													<th scope="col">Nom</th>
													<th scope="col">Prénom</th>
													<th scope="col">Téléphone</th>
													<th scope="col">Email</th>
													<th scope="col">Action</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${listEnseignant}" var="enseignant"
													varStatus="theCount">
													<tr>
														<td style="color: #666666;">${enseignant.nom}</td>
														<td>${enseignant.prenom}</td>
														<td>${enseignant.telephone}</td>
														<td>${enseignant.email}</td>
														<td><a
															href="AutorisationController?id=${enseignant.id}"
															class="link-green"> <i
																class="fas fa-calendar-plus fa-lg"></i>
														</a> <a href="Update.jsp?id=${enseignant.id}"
															class="link-blue"> <i class="fas fa-user-edit fa-lg"></i>
														</a> <a href="DeleteController?id=${enseignant.id}"
															class="link-red"
															onclick="return confirm('Are you sure you want to delete?')">
																<i class="fas fa-trash-alt fa-lg"></i>
														</a></td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
							</div>
							<!-- end col -->
						</div>
						<!-- end row -->
					</div>
					<!-- end container -->
				</div>
				<!-- end mask -->
			</div>
			<!-- end gradient-custom-1 -->
		</section>
	</div>
</body>
<footer>
	<%@include file="Footer.jsp"%>
</footer>
</html>
