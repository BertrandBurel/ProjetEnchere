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
    <link href="createAccount.css" rel="stylesheet">
    <!-- Custom font for this template -->
    <link href="" rel="stylesheet">
    <title><fmt:message key="msg_create_account_title"></fmt:message></title>
</head>

<body>
    <header class="py-5 bg-dark">
        <div class="container">
            <div class="row">
                <div class="col-12 text-white">
                    <h3><fmt:message key="msg_website_title"></fmt:message></h3>
                </div>
            </div>
            <p class="m-0 text-center text-white"></p>
        </div>
    </header>

    <article>
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-12">
                    <div class="row align-items-center">
                        <div class="col-6 mx-auto">
                            <h3 class="text-center"><fmt:message key="msg_create_account_subtitle"></fmt:message></h3>
                        </div>
                    </div>
                    <form method="post" action="">
                        <div class="form-group row">
                            <div class="col-12 col-sm-12 col-md- col-lg-6">
                                <div class="row my-2">
                                    <div class="col-5">
                                        <label for="identifier" class="col-form-label">
                                        	<fmt:message key="msg_profile_pseudo"></fmt:message>
                                        </label>
                                    </div>
                                    <div class="col-7">
                                        <input class="form-control" type="text" id="identifier" placeholder="Pseudo">
                                    </div>
                                </div>
                            </div>
                            <div class="col-12 col-sm-12 col-md-6 col-lg-6">
                                <div class="row my-2">
                                    <label for="firstname" class="col-5 col-form-label">
                                    	<fmt:message key="msg_profile_lastname"></fmt:message>
                                    </label>
                                    <div class="col-7">
                                        <input class="form-control" type="text" id="firstname" placeholder="Nom">
                                    </div>
                                </div>
                            </div>
                            <div class="col-12 col-sm-12 col-md-6 col-lg-6">
                                <div class="row my-2">
                                    <label for="lastname" class="col-5 col-form-label">
                                    	<fmt:message key="msg_profile_firstname"></fmt:message>
                                    </label>
                                    <div class="col-7">
                                        <input class="form-control" type="text" id="lastname" placeholder="Prénom">
                                    </div>
                                </div>
                            </div>
                            <div class="col-12 col-sm-12 col-md-6 col-lg-6">
                                <div class="row my-2">
                                    <label for="email" class="col-5 col-form-label">
                                    	<fmt:message key="msg_profile_email"></fmt:message>
                                    </label>
                                    <div class="col-7">
                                        <input class="form-control" type="email" id="email" placeholder="email">
                                    </div>
                                </div>
                            </div>
                            <div class="col-12 col-sm-12 col-md-6 col-lg-6">
                                <div class="row my-2">
                                    <label for="phonenumber" class="col-5 col-form-label">
                                    	<fmt:message key="msg_profile_phone"></fmt:message>
                                    </label>
                                    <div class="col-7">
                                        <input class="form-control" type="text" id="phonenumber"
                                            placeholder="Téléphone">
                                    </div>
                                </div>
                            </div>
                            <div class="col-12 col-sm-12 col-md-6 col-lg-6">
                                <div class="row my-2">
                                    <label for="address" class="col-5 col-form-label">
                                    	<fmt:message key="msg_profile_address"></fmt:message>
                                    </label>
                                    <div class="col-7">
                                        <input class="form-control" type="text" id="address" placeholder="Adresse">
                                    </div>
                                </div>
                            </div>
                            <div class="col-12 col-sm-12 col-md-6 col-lg-6">
                                <div class="row my-2">
                                    <label for="postalcode" class="col-5 col-form-label">
                                    	<fmt:message key="msg_profile_postal_code"></fmt:message>
                                    </label>
                                    <div class="col-7">
                                        <input class="form-control" type="text" id="postalcode"
                                            placeholder="Code postal">
                                    </div>
                                </div>
                            </div>
                            <div class="col-12 col-sm-12 col-md-6 col-lg-6">
                                <div class="row my-2">
                                    <label for="city" class="col-5 col-form-label">
                                    	<fmt:message key="msg_profile_city"></fmt:message>
                                    </label>
                                    <div class="col-7">
                                        <input class="form-control" type="text" id="city" placeholder="Ville">
                                    </div>
                                </div>
                            </div>
                            <div class="col-12 col-sm-12 col-md-6 col-lg-6">
                                <div class="row my-2">
                                    <label for="inputPassword" class="col-5 col-form-label">
                                    	<fmt:message key="msg_connect_password"></fmt:message>
                                    </label>
                                    <div class="col-7">
                                        <input class="form-control" type="password" id="inputPassword"
                                            placeholder="Mot de passe">
                                    </div>
                                </div>
                            </div>
                            <div class="col-12 col-sm-12 col-md-6 col-lg-6">
                                <div class="row my-2">
                                    <label for="confirmPassword" class="col-5 col-form-label">
                                    	<fmt:message key="msg_create_account_confirm"></fmt:message>
                                    </label>
                                    <div class="col-7">
                                        <input class="form-control" type="password" id="confirmPassword"
                                            placeholder="Confirmation">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="form-group row my-10 justify-content-center buttonzone">
                            <div class="col-5">
                                <input type="button" class="createButton w-100 h-100" value="Créer">
                            </div>
                            <div class="offset-col-2 col-5">
                                <input type="button" class="cancelButton w-100 h-100" value="Annuler">
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