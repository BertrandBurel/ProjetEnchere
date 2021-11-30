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
	                <div class="col-6 text-white">
	                    <h2><fmt:message key="msg_website_title"></fmt:message></h2>
	                </div>
	                <div class="col-6 text-white">
	                	<div class="row">
	                		<div class="col-3 text-white">
			            		<a href="<%=request.getContextPath()%>/index"><fmt:message key="msg_index_auctions_list"></fmt:message></a>
			            	</div>
	                		<div class="col-3 text-white">
			            		<a href="<%=request.getContextPath()%>/selling"><fmt:message key="msg_index_sell_article"></fmt:message></a>
			            	</div>
	                		<div class="col-3 text-white">
	                			<!-- TODO -->
			            		<a href="<%=request.getContextPath()%>/404"><fmt:message key="msg_index_profile"></fmt:message></a>
			            	</div>
	                		<div class="col-3 text-white">
			            		<a href="<%=request.getContextPath()%>/ServletSignout"><fmt:message key="msg_index_disconnexion"></fmt:message></a>
			            	</div>
		            	</div>
		            </div>
	            </div>
	            <p class="m-0 text-center text-white"></p>
	        </div>
	    </header>
	</body>
</html>