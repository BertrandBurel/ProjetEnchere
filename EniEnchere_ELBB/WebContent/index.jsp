<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
		<title><fmt:message key="msg_index_title"></fmt:message></title>
	</head>
	<body>
		<header class="py-5 bg-dark">
	        <div class="container">
	            <div class="row">
	                <div class="col-9 text-white">
	                    <h2><fmt:message key="msg_website_title"></fmt:message></h2>
	                </div>
	                <div class="col-3 text-white">
			            <a href=""><fmt:message key="msg_index_inscription"></fmt:message></a>
			            <a href=""><fmt:message key="msg_index_connexion"></fmt:message></a>
		            </div>
	            </div>
	            <p class="m-0 text-center text-white"></p>
	        </div>
	    </header>
		<h1><fmt:message key="msg_index_title"></fmt:message></h1>
		<form method="post">
			<div class="container">
	            <div class="row">
	                <div class="col-12">
						<h3><fmt:message key="msg_index_form_title"></fmt:message></h3>
					</div>
					<div class="col-6">
						<input type="search"/>
					</div>
					<div class="col-12">
						<p></p>
						<input />
					</div>
					<div>
						<input />
					</div>
				</div>
			</div>
		</form>
		<ol>
			
		</ol>
	</body>
</html>