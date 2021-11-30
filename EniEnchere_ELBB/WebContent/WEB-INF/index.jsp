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
		<c:choose>
			<c:when test="${connected == true}">
				<%@ include file="inclusions/connected_header.jsp" %>
			</c:when>
			<c:otherwise>
				<%@ include file="inclusions/header.jsp" %>
			</c:otherwise>
		</c:choose>
	    <div class="container">
	        <div class="row">
	        	<!-- Title -->
	            <div class="col-12">
					<h1><fmt:message key="msg_index_title"></fmt:message></h1>
				</div>
			</div>
			<c:choose>
				<c:when test="${connected == true}">
					<%@ include file="inclusions/connected_search.jsp" %>
				</c:when>
				<c:otherwise>
					<%@ include file="inclusions/search.jsp" %>
				</c:otherwise>
			</c:choose>
		</div>
		<%@ include file="inclusions/sold_article_list.jsp" %>
	</body>
</html>