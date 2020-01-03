<%@ taglib prefix="tile" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="sec"  uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%--
  Created by IntelliJ IDEA.
  User: surqu
  Date: 04-12-19
  Time: 22:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="fr">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <!-- Custom styles for this template -->
    <link href="https://fonts.googleapis.com/css?family=Pacifico|Raleway&display=swap" rel="stylesheet">
    <style>
        .row{margin-bottom: 5%}</style>
</head>
<body>

<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Déconnecter</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                Êtes-vous certain de vouloir vous déconnecter ?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">non</button>
                <a href="/logout"><button type="button" class="btn btn-primary">oui</button></a>
            </div>
        </div>
    </div>
</div>

<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="/" style="font-family: 'Pacifico', cursive;" >Buy My Bag</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="/" style="font-family: 'Pacifico', cursive;">Home</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="/about" style="font-family: 'Pacifico', cursive;">A Propos</a>
                </li>
                <sec:authorize access="!isAuthenticated()">
                    <li class="nav-item active">
                        <a class="nav-link" href="/login" style="font-family: 'Pacifico', cursive;">Se Connecter</a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="/signUp" style="font-family: 'Pacifico', cursive;">S'inscrire</a>
                    </li>
                </sec:authorize>
                <sec:authorize access="isAuthenticated()">
                    <li class="nav-item active">
                        <a class="nav-link" data-toggle="modal" data-target="#exampleModal" style="font-family: 'Pacifico', cursive;">${pageContext.request.userPrincipal.principal.username}</a>
                    </li>
                </sec:authorize>
                <li class="nav-item active">
                    <a class="nav-link" href="#" data-toggle="modal" data-target="#modalCart"style="font-family: 'Pacifico', cursive;">Mon Panier</a>
                </li>
                <li class="nav-item dropdown active" style="font-family: 'Pacifico', cursive;">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Language
                    </a>
                    <!-- Here's the magic. Add the .animate and .slide-in classes to your .dropdown-menu and you're all set! -->
                    <div class="dropdown-menu dropdown-menu-right animate slideIn" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="/language/fr">Français</a>
                        <a class="dropdown-item" href="/language/en">Anglais</a>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</nav>
<!--NAVBAR-->

    <tiles:insertAttribute name="main-content"/>

    <footer class="py-5 bg-dark ">
        <div class="container">
            <p class="m-0 text-center text-white">Copyright &copy; BuyMyBougaBouga 2019</p>
        </div>
    </footer>

    <!-- Bootstrap core JavaScript -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

<jsp:include page="../cart.jsp"/>
</body>
</html>
