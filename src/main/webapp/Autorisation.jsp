<%@ page import="tn.iit.glid22.model.Enseignant"%>
<%@ page import="javax.servlet.ServletContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.5.3/jspdf.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jspdf-autotable/3.5.13/jspdf.plugin.autotable.min.js"></script>
<meta charset="UTF-8">
<title>Autorisation</title>
<style>
.gradient-custom-1 {
	background: #cd9cf2;
	background: -webkit-linear-gradient(to top, rgb(255, 202, 168),
		rgba(246, 243, 255, 1));
	background: linear-gradient(to top, rgb(255, 202, 168),
		rgba(246, 243, 255, 1));
}

input[type="submit"]:hover {
	background-color: #ffae75;
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

h1 {
	color: red;
	font-size: 20px;
	font-weight: bold;
}

.form-container {
	margin-top: 100px;
}

.table-container {
	margin-top: 20px;
}

.table-container h2 {
	margin-bottom: 20px;
}

.btn-container {
	margin-top: 20px;
	text-align: center;
}

.print-button {
	background-color: #ffcca8;
	color: #a8dbff;
	border: none;
	padding: 5px 10px;
	border-radius: 5px;
}
</style>
<%@ include file="Navbar.jsp"%>
</head>
<body>
	<script>
	function exportToPdf(date, description, enseignantNom, enseignantPrenom) {
		  var doc = new jsPDF();
		  // Set document properties
		  doc.setFontSize(20);
		  doc.setTextColor(32, 32, 32); // Set title color
		  doc.setFontStyle('bold');

		  // Title
		  doc.text("Institut International Technologie", 105, 20, {
		    align: 'center'
		  });

		  // Set document properties
		  doc.setFontSize(20);
		  doc.setTextColor(32, 32, 32); // Set title color
		  doc.setFontStyle('bold');

		  // Title
		  doc.text("Bon d'autorisation", 105, 40, {
		    align: 'center'
		  });

		  // Authorization information
		  doc.setFontSize(12);
		  doc.setTextColor(32, 32, 32); // Set text color
		  doc.setFontStyle('normal');
		  doc.text('Date: ' + date, 105, 60, {
		    align: 'center'
		  });
		  doc.text('Etablissement: ' + description, 105, 70, {
		    align: 'center'
		  });

		  // Teacher information
		  doc.setFontSize(14);
		  doc.setTextColor(0, 0, 255); // Set teacher information color
		  doc.setFontStyle('bold');
		  doc.text('Enseignant:', 105, 80, {
		    align: 'center'
		  });
		  doc.setFontSize(12);
		  doc.setTextColor(32, 32, 32); // Set text color
		  doc.setFontStyle('normal');
		  doc.text('Nom: ' + enseignantNom, 105, 90, {
		    align: 'center'
		  });
		  doc.text('Prénom: ' + enseignantPrenom, 105, 100, {
		    align: 'center'
		  });

		  // Footer
		  doc.setFontSize(10);
		  doc.setTextColor(150);
		  doc.text('© 2023 Institut International de Technologie Sfax Tunisie', 105, 285, {
		    align: 'center'
		  });

		  // Signature
		  doc.setFontSize(12);
		  doc.setTextColor(32, 32, 32); // Set text color
		  doc.setFontStyle('normal');
		  var signatureText = 'Signature: ';
		  var signatureTextWidth = doc.getStringUnitWidth(signatureText) * doc.internal.getFontSize() / doc.internal.scaleFactor;
		  var pageWidth = doc.internal.pageSize.getWidth();
		  var signatureX = pageWidth - (signatureTextWidth + 50);
		  var signatureY = doc.internal.pageSize.getHeight() - 50; // Adjusted signature position
		  doc.text(signatureText, signatureX, signatureY);

		  // Get the PDF content as a data URI
		  var pdfContent = doc.output('datauristring');

		  // Open a new window or tab with the PDF content
		  var printWindow = window.open();
		  printWindow.document.write('<iframe src="' + pdfContent + '" frameborder="0" style="position: absolute; top: 0; left: 0; width: 100%; height: 100%;"></iframe>');
		}

	</script>

	<font size="3" color="red">${message}</font>
	<div class="gradient-custom-1">
		<div class="container  "
			style="display: flex; flex-direction: column; min-height: 100vh;">
			<div class="row">
				<div class="col-md-3 form-container">
					<form action="AutorisationController" method="post">
						<h1 style="color:blue">Ajouter Autorisation</h1>
						<br>
						<div class="form-group">
							<label for="date" style="font-weight: bold;">Date :</label> <input
								type="date" name="date" id="date" required class="form-control">
						</div>

						<div class="form-group">
							<label for="nb_heure" style="font-weight: bold;">Nombre
								d'Heure :</label> <input type="number" name="nb_heure" id="nb_heure"
								required class="form-control">
						</div>

						<div class="form-group">
							<label for="description" style="font-weight: bold;">Etablissement
								:</label> <input name="description" id="description"
								class="form-control">
						</div>

						<div class="form-group">
							<input type="hidden" name="id" value="${currentEnseignant.id}">
							<input type="submit" value="Valider" class="btn btn-primary">
						</div>
					</form>
				</div>

				<div class="col-md-9">
					<div class="table-container">


						<h2 style="text-align: center; margin-bottom: 20px;">Liste
							des autorisations de ${currentEnseignant.prenom}
							${currentEnseignant.nom}:</h2>
						<br>
						<table class="table table-striped" id="my-table">
							<thead>
								<tr>
									<th>Date</th>
									<th>Nombre d'Heure</th>
									<th>Etablissement</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${listAutorisation}" var="autorisation"
									varStatus="theCount">
									<tr>
										<td>${autorisation.date}</td>
										<td>${autorisation.nb_heure}</td>
										<td>${autorisation.description}</td>
										<td>
											<button
												onclick="exportToPdf('${autorisation.date}', '${autorisation.description}', '${currentEnseignant.nom}', '${currentEnseignant.prenom}')"
												class="btn btn-print">
												<i class="fas fa-print"></i> Imprimer
											</button>
										</td>
									</tr>
								</c:forEach>
							</tbody>
							<tfoot>
								<tr>
									<td colspan="3" style="text-align: center;"><strong>Total
											des heures réalisées :</strong></td>
									<td><strong>${sum}</strong></td>
									<td></td>
								</tr>
								<tr>
									<td colspan="3" style="text-align: center;"><strong>Nombre
											d'Heures restantes dans l'année ${anneeActuelle} :</strong></td>
									<td><strong>${nbHrRestante}</strong></td>
									<td></td>
								</tr>
							</tfoot>
						</table>


					</div>
				</div>
			</div>
			<div class="btn-container">
				<div class="row"></div>
			</div>
		</div>
	</div>
</body>
<footer>
<%@ include file="Footer.jsp"%>
</footer>
</html>
