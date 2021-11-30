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
	</head>
	<body>
		<header class="py-5 bg-dark">
	        <div class="container">
	            <div class="row">
	            	<!-- Logo -->
	                <div class="col-9 text-white">
	                    <h2><fmt:message key="msg_website_title"></fmt:message></h2>
	                </div>
	                <!-- inscription/connection links -->
	                <div class="col-3 text-white">
			            <a href=""><fmt:message key="msg_index_inscription"></fmt:message></a>
			            <a href="<%=request.getContextPath()%>/ServletToConnection"><fmt:message key="msg_index_connexion"></fmt:message></a>
		            </div>
	            </div>
	            <p class="m-0 text-center text-white"></p>
	        </div>
	    </header>
	</body>
</html>