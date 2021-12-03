<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="${!empty sessionScope.langue?sessionScope.langue:pageContext.request.locale}"/>
<fmt:setBundle basename="fr.eni.enchere.messages.messages"/>
<%@ page import="java.time.format.DateTimeFormatter" %>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<!-- Bootstrap core CSS -->
 		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
		<title><fmt:message key="msg_auction_title"></fmt:message></title>
	</head>
	<body>
		<%@ include file="inclusions/connected_header.jsp" %>
		<div class="container">
			<div class="row">
				<!-- title -->
				<div class="col-12 centered">
					<h1><fmt:message key="msg_auction_title"></fmt:message></h1>
				</div>
				<!-- article name -->
				<div class="col-12">
					<h3>${article.name}</h3>
				</div>
				<!-- description -->
				<div class="col-12">
					<div class="row">
						<div class="col-6">
							<p><fmt:message key="msg_auction_description"></fmt:message></p>
						</div>
						<div class="col-6">
							<p>${article.description}</p>
						</div>
					</div>
				</div>
				<!-- category -->
				<div class="col-12">
					<div class="row">
						<div class="col-6">
							<p><fmt:message key="msg_auction_category"></fmt:message></p>
						</div>
						<div class="col-6">
							<p>${category.name}</p>
						</div>
					</div>
				</div>
				<!-- best offert -->
				<div class="col-12">
					<div class="row">
						<div class="col-6">
							<p><fmt:message key="msg_auction_best_bid"></fmt:message></p>
						</div>
						<div class="col-6">
							<p>${auction.bidPrice}</p>
						</div>
					</div>
				</div>
				<!-- Initial price -->
				<div class="col-12">
					<div class="row">
						<div class="col-6">
							<p><fmt:message key="msg_auction_initial_price"></fmt:message></p>
						</div>
						<div class="col-6">
							<p>${article.initialPrice}</p>
						</div>
					</div>
				</div>
				<!-- End date -->
				<div class="col-12">
					<div class="row">
						<div class="col-6">
							<p><fmt:message key="msg_auction_end_date"></fmt:message></p>
						</div>
						<div class="col-6">
							<p>${article.auctionEndDate.format(DateTimeFormatter.ofPattern("dd MMMM yy"))}</p>
						</div>
					</div>
				</div>
				<!-- withdraw adress -->
				<div class="col-12">
					<div class="row">
						<div class="col-6">
							<p><fmt:message key="msg_auction_withdrawal"></fmt:message></p>
						</div>
						<div class="col-6">
							<p>${withdrawal.street} ${withdrawal.postalCode} ${withdrawal.town}</p>
						</div>
					</div>
				</div>
				<!-- Seller -->
				<div class="col-12">
					<div class="row">
						<div class="col-6">
							<p><fmt:message key="msg_auction_seller"></fmt:message></p>
						</div>
						<div class="col-6">
							<p>${seller.pseudonym}</p>
						</div>
					</div>
				</div>
				<!-- proposition -->
				<div class="col-12">
					<form class="row" action="auction" method="post">
						<input type="hidden" name="article_id" value="${article.id}" />
						<div class="col-4">
							<p><fmt:message key="msg_auction_my_bid"></fmt:message></p>
						</div>
						<div class="col-4">
							<input class="form-control-lg" type="number" name="bid" 
									value="${((auction == null)? article.initialPrice : auction.bidPrice) + 1 }" 
									min="${((auction == null)? article.initialPrice : auction.bidPrice) + 1 }"/>
							<input type="hidden" name="min_bid" value="${((auction == null)? article.initialPrice : auction.bidPrice) + 1 }" />
						</div>
						<div class="col-4">
							<input class="btn btn-primary form-control-lg" type="submit" value="<fmt:message key="msg_auction_validation"></fmt:message>"/>
						</div>
					</form>
				</div>
			</div>
		</div>
	</body>
</html>