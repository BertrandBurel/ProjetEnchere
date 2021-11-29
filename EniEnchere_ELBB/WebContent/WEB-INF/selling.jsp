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
		<title><fmt:message key="msg_selling_title"></fmt:message></title>
	</head>
	<body>
		<!-- Navigation -->
		<header class="py-5 bg-dark">
	        <div class="container">
	            <div class="row">
	            	<!-- Logo -->
	                <div class="col-3 text-white">
	                    <h2><fmt:message key="msg_website_title"></fmt:message></h2>
	                </div>
	                <!-- Title -->
	                <div class="col-6 text-white">
			            <h1><fmt:message key="msg_selling_title"></fmt:message></h1>
		            </div>
		            <!-- space to center the title -->
		            <div class="col-3"></div>
	            </div>
	            <p class="m-0 text-center text-white"></p>
	        </div>
	    </header>
	    <form class="container" method="post" action="selling_register">
	        <div class="row">
	        	<!-- <div class="col-3">
	        		<img></img>
	        	</div>
	        	<div class="col-9"> -->
	        	<div class="col-12">
	        		<div class="row">
	        			<!-- Article name -->
	        			<div class="col-2">
	        				<p><fmt:message key="msg_selling_form_name"></fmt:message></p>
	        			</div>
	        			<div class="col-10">
	        				<input type="text" name="name" maxlength="30" autofocus="autofocus"/>
	        			</div>
	        			<!-- Article description -->
	        			<div class="col-2">
	        				<p><fmt:message key="msg_selling_form_description"></fmt:message></p>
	        			</div>
	        			<div class="col-10">
	        				<textarea name="description" maxlength="300"></textarea>
	        			</div>
	        			<!-- Article category -->
	        			<div class="col-4">
	        				<p><fmt:message key="msg_selling_form_category"></fmt:message></p>
	        			</div>
	        			<div class="col-8">
							<select class="form-select form-control" name="category_choice">
								<option selected disabled value=""><fmt:message key="msg_index_category_choice"></fmt:message></option>
								<c:forEach items="${categories}" var="category">
								    <option value="${category.name}">${category.name}</option> <!-- TODO -->
								</c:forEach>
							</select>
	        			</div>
	        			<!-- Article photo TODO -->
	        			<!-- Article starting price -->
	        			<div class="col-4">
	        				<p><fmt:message key="msg_selling_form_price"></fmt:message></p>
	        			</div>
	        			<div class="col-8">
							<input type="number" name="start_price"/>
	        			</div>
	        			<!-- Article starting date -->
	        			<div class="col-4">
	        				<p><fmt:message key="msg_selling_form_strating_date"></fmt:message></p>
	        			</div>
	        			<div class="col-8">
							<input type="date" name="start_date" min="" max=""/> <!-- TODO -->
	        			</div>
	        			<!-- Article ending date -->
	        			<div class="col-4">
	        				<p><fmt:message key="msg_selling_form_ending_date"></fmt:message></p>
	        			</div>
	        			<div class="col-8">
							<input type="date" name="end_date" min="" max=""/> <!-- TODO -->
	        			</div>
	        			<div class="col-12">
	        			<!-- Whithdrawal field -->
	        			<fieldset>
    						<legend><fmt:message key="msg_selling_form_withdraw_title"></fmt:message></legend>
	        				<div class="row">
	        					<!-- Withdrawal road -->
			        			<div class="col-4">
			        				<p><fmt:message key="msg_selling_form_road"></fmt:message></p>
			        			</div>
			        			<div class="col-8">
			        				<input type="text" name="road" maxlength="30" value="${user.address}"/>
			        			</div>
			        			<!-- Withdrawal postal code -->
			        			<div class="col-4">
			        				<p><fmt:message key="msg_selling_form_postal_code"></fmt:message></p>
			        			</div>
			        			<div class="col-8">
			        				<input type="text" name="postal_code" maxlength="15" value="${user.postalCode}"/>
			        			</div>
			        			<!-- Withdrawal town -->
			        			<div class="col-4">
			        				<p><fmt:message key="msg_selling_form_town"></fmt:message></p>
			        			</div>
			        			<div class="col-8">
			        				<input type="text" name="town" maxlength="30" value="${user.city}"/>
			        			</div>
	        				</div>
	        			</fieldset>
	        			</div>
	        			<!-- Buttons -->
	        			<!-- Save -->
	        			<div class="col-4">
	        				<input type="submit" name="form_send" value="<fmt:message key="msg_selling_validation"></fmt:message>"/>
	        			</div>
	        			<!-- Cancel -->
	        			<div class="col-4">
	        				<input type="submit" name="form_send" value="<fmt:message key="msg_selling_cancel"></fmt:message>"/>
	        			</div>
	        			<!-- Space for buttons positionning -->
	        			<div class="col-4"></div>
	        		</div>
	        	</div>
	        </div>
	    </form>
	</body>
</html>