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
		<!-- Result set -->
		<div class="container">
	        <div class="row">
	        	<c:forEach items="${article_list}" var="article">
					<div class="col-6 form-control" onclick="location.href='<%=request.getContextPath()%>/auction?article_no=${article.id}';" style="cursor: pointer;">
						<div class="row">
							<!-- <div class="col-3">
								<img src="" alt="<fmt:message key="msg_article_img_default"></fmt:message>"></img>
							</div> 
							<div class="col-9"> -->
							<div class="col-12">
								<h4 class="text-decoration-underline">${article.name}</h4>
								<p><fmt:message key="msg_article_price"></fmt:message>${article.initialPrice} <fmt:message key="msg_article_currency"></fmt:message></p>
								<p><fmt:message key="msg_article_end_date"></fmt:message>
									<fmt:parseDate value="${article.auctionEndDate}" pattern="yyyy-MM-dd" var="parsedDate" type="date" />
									<fmt:formatDate value="${parsedDate}" var="displayDate" type="date" pattern="dd.MM.yyyy" />
									${displayDate}
								</p>
								<p><fmt:message key="msg_article_seller"></fmt:message>${article.user.pseudonym}</p>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</body>
</html>