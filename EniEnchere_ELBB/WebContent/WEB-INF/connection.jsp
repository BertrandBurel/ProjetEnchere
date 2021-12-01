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
		<title><fmt:message key="msg_connect_title"></fmt:message></title>
	</head>
	
	<body>
    <header class="py-5 bg-dark">
        <div class="container">
            <div class="row">
                <div class="col-12 text-white">
                    <h2><fmt:message key="msg_website_title"></fmt:message></h2>
                </div>
            </div>
            <p class="m-0 text-center text-white"></p>
        </div>
    </header>

    <article>
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-8 col-12">
                	<c:if test="${errorConnect != null}">
                		<div class="alert alert-danger">
                			<p class="align-middle">${errorConnect}</p>
                		</div>
                	</c:if>
                    <form method="post" action="<%=request.getContextPath()%>/signin">
                    	<!-- Identifiant -->
                        <div class="form-group row">
                            <label for="identifier" class="col-5 col-form-label">
                            	<fmt:message key="msg_connect_identifier"></fmt:message>
                            </label>
                            <div class="col-7">
                            	<fmt:message key="msg_connect_idplaceholder" var="idPlaceholder"></fmt:message>
                            	<c:set var="userPseudo" value='${requestScope["pseudo"]}' />
                                <input class="form-control" type="text" id="identifier" name="identifier" placeholder="${idPlaceholder }" 
                                		<c:if test="${userPseudo !=null}">value="${userPseudo}"</c:if>>
                            </div>
                        </div>
                        <!-- Mot de passe -->
                        <div class="form-group row">
                            <label for="inputPassword" class="col-5 col-form-label">
                            	<fmt:message key="msg_connect_password"></fmt:message>
                            </label>
                            <div class="col-7">
                            	<fmt:message key="msg_connect_pwdplaceholder" var="pwdPlaceholder"></fmt:message>
                            	<c:set var="userPwd" value='${requestScope["password"]}' />
                                <input class="form-control" type="password" id="inputPassword" name="inputPassword" 
                                		placeholder="${pwdPlaceholder}" <c:if test="${userPwd !=null}">value="${userPwd}"</c:if>>
                            </div>
                        </div>
                        <!-- Connexion -->
                        <div class="form-group row my-5">
                        	<!-- Bouton -->
                            <div class="col-5">
                            	<fmt:message key="msg_connect_button" var="buttonConnect"></fmt:message>
                                <input type="submit" class="connectButton w-100 h-100" value="${buttonConnect }">
                            </div>
                            <!-- Checkbox et lien -->
                            <div class="col-7">
                                <div class="col-12">
                                    <div class="form-check">
                                        <input class="form-check-input" type="checkbox" id="rememberMe" name="rememberMe">
                                        <label class="form-check-label" for="rememberMe"><fmt:message key="msg_connect_checklabel"></fmt:message></label>
                                    </div>
                                </div>
                                <div class="col-12">
                                    <a href=""><fmt:message key="msg_connect_forgotpassword"></fmt:message></a>
                                </div>
                            </div>
                        </div>
                    </form>
                    <!-- Bouton création compte -->
                    <form method="post" action="<%=request.getContextPath()%>/create_account">
                        <div class="form-group row my-10 buttonzone">
                            <div class="col-12">
                            	<fmt:message key="msg_connect_createaccount" var="createAccount"></fmt:message>
                                <input type="submit" class="connectButton w-100 h-100" value="${createAccount }">
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