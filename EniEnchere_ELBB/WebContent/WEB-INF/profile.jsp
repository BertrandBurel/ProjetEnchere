<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${!empty sessionScope.langue?sessionScope.langue:pageContext.request.locale}"/>
<fmt:setBundle basename="fr.eni.enchere.messages.messages"/>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		 <!-- Bootstrap core CSS -->
 		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
		 <!-- Custom css for this template -->
		 <link href="css/connect.css" rel="stylesheet">
		<title><fmt:message key="msg_profile_title"></fmt:message></title>
	</head>
	
	<body>
	<header class="py-5 bg-dark">
        <div class="container">
            <div class="row">
                <div class="col-12 text-white">
                    <h3><fmt:message key="msg_connect_title"></fmt:message></h3>
                </div>
            </div>
            <p class="m-0 text-center text-white"></p>
        </div>
    </header>

    <article>
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-6 col-10">
                    <div class="row align-items-center">
                        <div class="col-6 mx-auto align-center">
                            <h3 class="text-center">${pseudo}</h3>
                        </div>
                    </div>
                    <form method="post" action="">
                    	<!-- Pseudo -->
                        <div class="form-group row">
                            <div class="col-5">
                                <label for="identifier" class="col-form-label">
                                	<fmt:message key="msg_profile_pseudo"></fmt:message>
                                </label>
                            </div>
                            <div class="col-7">
                                <input class="form-control-plaintext" type="text" id="identifier" value="${pseudo}">
                            </div>
                        </div>
                        <!-- Last name -->
                        <div class="form-group row">
                            <label for="firstname" class="col-5 col-form-label">
                            	<fmt:message key="msg_profile_lastname"></fmt:message>
                            </label>
                            <div class="col-7">
                                <input class="form-control-plaintext" type="text" id="firstname" value="${lastname}">
                            </div>
                        </div>
                        <!-- First name -->
                        <div class="form-group row">
                            <label for="lastname" class="col-5 col-form-label">
                            	<fmt:message key="msg_profile_firstname"></fmt:message>
                            </label>
                            <div class="col-7">
                                <input class="form-control-plaintext" type="text" id="lastname" value="${firstname}">
                            </div>
                        </div>
                        <!-- Email -->
                        <div class="form-group row">
                            <label for="email" class="col-5 col-form-label">
                            	<fmt:message key="msg_profile_email"></fmt:message>
                            </label>
                            <div class="col-7">
                                <input class="form-control-plaintext" type="email" id="email" value="${email}">
                            </div>
                        </div>
                        <!-- Phone -->
                        <div class="form-group row">
                            <label for="phonenumber" class="col-5 col-form-label">
                            	<fmt:message key="msg_profile_phone"></fmt:message>
                            </label>
                            <div class="col-7">
                                <input class="form-control-plaintext" type="text" id="phonenumber" value="${phone}">
                            </div>
                        </div>
                        <!-- Address -->
                        <div class="form-group row">
                            <label for="address" class="col-5 col-form-label">
                            	<fmt:message key="msg_profile_address"></fmt:message>
                            </label>
                            <div class="col-7">
                                <input class="form-control-plaintext" type="text" id="address" value="${address}">
                            </div>
                        </div>
                        <!-- Postal code -->
                        <div class="form-group row">
                            <label for="postalcode" class="col-5 col-form-label">
                            	<fmt:message key="msg_profile_postal_code"></fmt:message>
                            </label>
                            <div class="col-7">
                                <input class="form-control-plaintext" type="text" id="postalcode" value="${postal_code}">
                            </div>
                        </div>
                        <!-- City -->
                        <div class="form-group row">
                            <label for="city" class="col-5 col-form-label">
                            	<fmt:message key="msg_profile_city"></fmt:message>
                            </label>
                            <div class="col-7">
                                <input class="form-control-plaintext" type="text" id="city" value="${city}">
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