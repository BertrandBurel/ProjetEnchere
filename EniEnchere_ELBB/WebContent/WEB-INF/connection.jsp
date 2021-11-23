<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		 <!-- Bootstrap core CSS -->
 		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
		 <!-- Custom css for this template -->
		 <link href="css/connect.css" rel="stylesheet">
		<title>CONNECTION</title>
	</head>
	
	<body>
    <header class="py-5 bg-dark">
        <div class="container">
            <div class="row">
                <div class="col-12 text-white">
                    <h3>ENI-Enchères</h3>
                </div>
            </div>
            <p class="m-0 text-center text-white"></p>
        </div>
    </header>

    <article>
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-8 col-12">
                    <form method="post" action="">
                        <div class="form-group row">
                            <label for="identifier" class="col-5 col-form-label">Identifiant</label>
                            <div class="col-7">
                                <input class="form-control" type="text" id="identifier" placeholder="Pseudo">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="inputPassword" class="col-5 col-form-label">Mot de passe</label>
                            <div class="col-7">
                                <input class="form-control" type="password" id="inputPassword"
                                    placeholder="Mot de passe">
                            </div>
                        </div>
                        <div class="form-group row my-5">
                            <div class="col-5">
                                <input type="button" class="connectButton w-100 h-100" value="Connexion">
                            </div>
                            <div class="col-7">
                                <div class="col-12">
                                    <div class="form-check">
                                        <input class="form-check-input" type="checkbox" id="rememberMe">
                                        <label class="form-check-label" for="rememberMe">Se souvenir de moi</label>
                                    </div>
                                </div>
                                <div class="col-12">
                                    <a href="">Mot de passe oublié</a>
                                </div>
                            </div>
                        </div>
                        <div class="form-group row my-10 buttonzone">
                            <div class="col-12">
                                <input type="button" class="connectButton w-100 h-100" value="Créer un compte">
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </article>
		
		<!-- scripts bootstrap -->
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	</body>
</html>