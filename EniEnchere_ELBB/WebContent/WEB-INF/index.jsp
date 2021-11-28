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
		<!-- Navigation -->
		<header class="py-5 bg-dark">
	        <div class="container">
	            <div class="row">
	            	<!-- Logo -->
	                <div class="col-9 text-white">
	                    <h2><fmt:message key="msg_website_title"></fmt:message></h2>
	                </div>
	                <!-- inscription/connection links -->
	                <div class="col-3 text-white">
			            <a href="/ServletSignin"><fmt:message key="msg_index_inscription"></fmt:message></a>
			            <a href=""><fmt:message key="msg_index_connexion"></fmt:message></a>
		            </div>
	            </div>
	            <p class="m-0 text-center text-white"></p>
	        </div>
	    </header>
	    <div class="container">
	        <div class="row">
	        	<!-- Title -->
	            <div class="col-12">
					<h1><fmt:message key="msg_index_title"></fmt:message></h1>
				</div>
			</div>
			<form class="row" method="post" action="index">
            	<!-- Search zone -->
                <div class="col-12">
					<h3><fmt:message key="msg_index_form_title"></fmt:message></h3>
				</div>
				<!-- Categories list -->
				<div class="col-6">
					<div class="row">
						<div class="col-6">
							<p><fmt:message key="msg_index_category"></fmt:message></p>
						</div>
						<div class="col-6">
							<select class="form-select form-control" name="category_choice">
								<option selected value=""><fmt:message key="msg_index_category_choice"></fmt:message></option>
								<c:forEach items="${categories}" var="category">
								    <option value="${category.name}">${category.name}</option>
								</c:forEach>
							</select>
						</div>
						<!-- Search text field -->
						<div class="input-group col-12">
							<input class="form-control" type="search" name="search_string" placeholder="<fmt:message key="msg_index_search_field"></fmt:message>"/>
							<span class="input-group-text" id="basic-addon1"><img src="img/search.png" alt="" width="30" height="24"></span>
						</div>
					</div>
				</div>
				<!-- Search button -->
				<div  class="col-6">
					<input class="btn btn-primary form-control-lg" type="submit" value="<fmt:message key="msg_index_search_button"></fmt:message>"/>
				</div>
			</form>
		</div>
		<%@ include file="inclusions/SoldArticleList.jsp" %>
	</body>
</html>