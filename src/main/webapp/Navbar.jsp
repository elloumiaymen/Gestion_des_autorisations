<style>
  .bg-custom {
    background-color: #332821 !important;
  }
  .link-special {
    color: black;
    background-color: #ffd9c2;
    border-radius: 5px;
    	border: none;
  }
  .nav-item.active .nav-link {
    color: #b28d75 !important;
    font-weight: bold;
  }
  .username-container {
    display: flex;
    align-items: center;
  }
  .username-container span,
  .username-container button {
    margin-right: 10px;
  }
</style>

<nav class="navbar navbar-expand-lg navbar-light bg-custom">
  <a class="navbar-brand" href="#">
    <img src="permpro.png" alt="Logo" width="80" height="40" class="d-inline-block align-top">
  </a>

  <!-- Rest of the code remains the same -->
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse justify-content-center" id="navbarNav">
    <ul class="navbar-nav ml-auto">
      <li class="nav-item active">
        <a class="nav-link text-white" href="Index.jsp">Accueil <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link text-white" href="Adduser.jsp">Ajouter un utilisateur</a>
      </li>
      <li class="nav-item">
        <a class="nav-link text-white" href="Enseignant.jsp">Ajouter un enseignant</a>
      </li>
    </ul>
  </div>
  <div class="collapse navbar-collapse justify-content-right">
    <ul class="ml-auto">
<li class="username-container">
  <% final String username = (String) request.getAttribute("username"); %>
  <span class="nav-link text-white">Utilisateur: <span id="username">Aymen Elloumi</span></span>
  <button onclick="window.location.href='Deconnexion'" class="link-special">Déconnexion</button>
</li>
</ul>
  </div>
</nav>
