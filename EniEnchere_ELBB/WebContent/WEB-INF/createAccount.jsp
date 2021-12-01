<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="UTF-8">
    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <!-- Custom css for this template -->
    <link href="css/createAccount.css" rel="stylesheet">
    <title><fmt:message key="msg_create_account_title"></fmt:message></title>
</head>

<body>
	<!--<fmt:setLocale value="${!empty sessionScope.langue?sessionScope.langue:pageContext.request.locale}"/>-->
	<fmt:setLocale value="fr"/>
	<fmt:setBundle basename="fr.eni.enchere.messages.messages"/>
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
                    <form method="post" action="<%=request.getContextPath()%>/new_account">
                        <div class="form-group row">
                            <div class="col-12 col-sm-12 col-md- col-lg-6">
                            	<!-- Pseudo -->
                                <div class="row my-2">
                                    <div class="col-5">
                                        <label for="identifier" class="col-form-label">
                                        	<fmt:message key="msg_profile_pseudo"></fmt:message>
                                        </label>
                                    </div>
                                    <div class="col-7">
                                    	<fmt:message key="msg_profile_pseudo" var="pseudoPlaceholder"></fmt:message>
                                        <input class="form-control" type="text" id="identifier" name="identifier" maxlength="30"
                                        		pattern="^[a-zA-Z0-9]*$" placeholder="${pseudoPlaceholder}">
                                    </div>
                                </div>
                            </div>
                            <div class="col-12 col-sm-12 col-md-6 col-lg-6">
                            	<!-- Last name -->
                                <div class="row my-2">
                                    <label for="firstname" class="col-5 col-form-label">
                                    	<fmt:message key="msg_profile_lastname"></fmt:message>
                                    </label>
                                    <div class="col-7">
                                    	<fmt:message key="msg_profile_lastname" var="lastnamePlaceholder"></fmt:message>
                                        <input class="form-control" type="text" id="lastname" name="lastname" maxlength="30" 
                                        		pattern="[\u00C0-\u017Fa-zA-Z']+([- ][\u00C0-\u017Fa-zA-Z']+)*" placeholder="${lastnamePlaceholder}">
                                    </div>
                                </div>
                            </div>
                            <div class="col-12 col-sm-12 col-md-6 col-lg-6">
                            	<!-- First name -->
                                <div class="row my-2">
                                    <label for="lastname" class="col-5 col-form-label">
                                    	<fmt:message key="msg_profile_firstname"></fmt:message>
                                    </label>
                                    <div class="col-7">
                                    	<fmt:message key="msg_profile_firstname" var="firstnamePlaceholder"></fmt:message>
                                        <input class="form-control" type="text" id="firstname" name="firstname" maxlength="30" 
                                        		pattern="[\u00C0-\u017Fa-zA-Z']+([- ][\u00C0-\u017Fa-zA-Z']+)*" placeholder="${firstnamePlaceholder}">
                                    </div>
                                </div>
                            </div>
                            <div class="col-12 col-sm-12 col-md-6 col-lg-6">
                            	<!-- Email -->
                                <div class="row my-2">
                                    <label for="email" class="col-5 col-form-label">
                                    	<fmt:message key="msg_profile_email"></fmt:message>
                                    </label>
                                    <div class="col-7">
                                    	<fmt:message key="msg_profile_email" var="emailPlaceholder"></fmt:message>
                                        <input class="form-control" type="email" id="email" name="email" 
                                        		pattern="[a-z0-9._+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" placeholder="${emailPlaceholder}">
                                    </div>
                                </div>
                            </div>
                            <div class="col-12 col-sm-12 col-md-6 col-lg-6">
                            	<!-- Phone -->
                                <div class="row my-2">
                                    <label for="phonenumber" class="col-5 col-form-label">
                                    	<fmt:message key="msg_profile_phone"></fmt:message>
                                    </label>
                                    <div class="col-7">
                                    	<fmt:message key="msg_profile_phone" var="phonePlaceholder"></fmt:message>
                                        <input class="form-control" type="text" id="phonenumber" name="phone" 
                                        		pattern="(0|\\+33|0033)[1-9][0-9]{8}$" placeholder="${phonePlaceholder}">
                                    </div>
                                </div>
                            </div>
                            <div class="col-12 col-sm-12 col-md-6 col-lg-6">
                            	<!-- Address -->
                                <div class="row my-2">
                                    <label for="address" class="col-5 col-form-label">
                                    	<fmt:message key="msg_profile_address"></fmt:message>
                                    </label>
                                    <div class="col-7">
                                    	<fmt:message key="msg_profile_address" var="addressPlaceholder"></fmt:message>
                                        <input class="form-control" type="text" id="address" name="address" maxlength="30" 
                                        		pattern="^[\w'\-,]*[^._!¡?÷?¿\/\\+=@#$%ˆ&*(){}|~<>;:\[\]]*$" placeholder="${addressPlaceholder}">
                                    </div>
                                </div>
                            </div>
                            <div class="col-12 col-sm-12 col-md-6 col-lg-6">
                            	<!-- Postal code -->
                                <div class="row my-2">
                                    <label for="postalcode" class="col-5 col-form-label">
                                    	<fmt:message key="msg_profile_postal_code"></fmt:message>
                                    </label>
                                    <div class="col-7">
                                    	<fmt:message key="msg_profile_postal_code" var="postalCodePlaceholder"></fmt:message>
                                        <input class="form-control" type="text" id="postalcode" name="postalcode" maxlength="10" 
                                            	pattern="^\\d{5,10}$" placeholder="Code postal">
                                    </div>
                                </div>
                            </div>
                            <div class="col-12 col-sm-12 col-md-6 col-lg-6">
                            	<!-- City -->
                                <div class="row my-2">
                                    <label for="city" class="col-5 col-form-label">
                                    	<fmt:message key="msg_profile_city"></fmt:message>
                                    </label>
                                    <div class="col-7">
                                    	<fmt:message key="msg_profile_city" var="cityPlaceholder"></fmt:message>
                                        <input class="form-control" type="text" id="city" name="city" maxlength="30"
                                        		pattern="[\u00C0-\u017Fa-zA-Z']+([- ][\u00C0-\u017Fa-zA-Z']+)*" placeholder="${cityPlaceholder}">
                                    </div>
                                </div>
                            </div>
                            <div class="col-12 col-sm-12 col-md-6 col-lg-6">
                            	<!-- Password -->
                                <div class="row my-2">
                                    <label for="inputPassword" class="col-5 col-form-label">
                                    	<fmt:message key="msg_connect_password"></fmt:message>
                                    </label>
                                    <div class="col-7">
                                    	<fmt:message key="msg_connect_password" var="pwdPlaceholder"></fmt:message>
                                        <input class="form-control" type="password" id="inputPassword" name="password" maxlength="30"
                                            	pattern="[a-zA-Z0-9-*!@#]{1,30}$" placeholder="${pwdPlaceholder}">
                                    </div>
                                </div>
                            </div>
                            <div class="col-12 col-sm-12 col-md-6 col-lg-6">
                            	<!-- Confirm Password -->
                                <div class="row my-2">
                                    <label for="confirmPassword" class="col-5 col-form-label">
                                    	<fmt:message key="msg_create_account_confirm"></fmt:message>
                                    </label>
                                    <div class="col-7">
                                    	<fmt:message key="msg_create_account_confirm_password" var="confirmPwdPlaceholder"></fmt:message>
                                        <input class="form-control" type="password" id="confirmpassword" name="confirmpassword" maxlength="30" 
                                        		pattern="[a-zA-Z0-9-*!@#]{1,30}$" placeholder="${confirmPwdPlaceholder}">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="form-group row my-10 justify-content-center buttonzone">
                            <div class="col-5">
                            	<fmt:message key="msg_create_account_button_create" var="createButton"></fmt:message>
                                <input type="submit" class="createButton w-100 h-100" name="create" value="${createButton}">
                            </div>
                            <div class="offset-col-2 col-5">
                            	<fmt:message key="msg_create_account_button_cancel" var="cancelButton"></fmt:message>
                                <input type="submit" class="cancelButton w-100 h-100" name="cancel" value="${cancelButton}">
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