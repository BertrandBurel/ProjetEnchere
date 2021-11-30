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
					<!-- Buy fields -->
					<div class="col-6">
						<input type="radio" name="auction_type" id="auction_buy"/>
						<label for="auction_buy"><fmt:message key="msg_index_search_purchase"></fmt:message></label>
						<div class="row">
							<div class="col-12">
								<input type="checkbox" name="open_auctions" id="open_auctions" disabled/>
								<label for="open_auctions"><fmt:message key="msg_index_search_open_auctions"></fmt:message></label>
							</div>
							<div class="col-12">
								<input type="checkbox" name="ongoing_auctions" id="ongoing_auctions" disabled/>
								<label for="ongoing_auctions"><fmt:message key="msg_index_search_ongoing_auctions"></fmt:message></label>
							</div>
							<div class="col-12">
								<input type="checkbox" name="won_auctions" id="won_auctions" disabled/>
								<label for="won_auctions"><fmt:message key="msg_index_search_won_auctions"></fmt:message></label>
							</div>
						</div>
					</div>
					<!-- Sell fields -->
					<div class="col-6">
						<input type="radio" name="auction_type" id="auction_sell"/>
						<label for="auction_sell"><fmt:message key="msg_index_search_sells"></fmt:message></label>
						<div class="row">
							<div class="col-12">
								<input type="checkbox" name="open_sells" id="open_sells" disabled/>
								<label for="open_sells"><fmt:message key="msg_index_search_open_sells"></fmt:message></label>
							</div>
							<div class="col-12">
								<input type="checkbox" name="ongoing_sells" id="ongoing_sells" disabled/>
								<label for="ongoing_sells"><fmt:message key="msg_index_search_ongoing_sells"></fmt:message></label>
							</div>
							<div class="col-12">
								<input type="checkbox" name="closed_sells" id="closed_sells" disabled/>
								<label for="closed_sells"><fmt:message key="msg_index_search_closed_sells"></fmt:message></label>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- Search button -->
			<div  class="col-6">
				<input class="btn btn-primary form-control-lg" type="submit" value="<fmt:message key="msg_index_search_button"></fmt:message>"/>
			</div>
		</form>
		
		<!-- Script for checkbox enabling when parent radio is checked -->
		<script type="text/javascript">
	        var open_auctions = document.getElementById("open_auctions");
	        var ongoing_auctions = document.getElementById("ongoing_auctions");
	        var won_auctions = document.getElementById("won_auctions");
	        
	        var open_sells = document.getElementById("open_sells");
	        var ongoing_sells = document.getElementById("ongoing_sells");
	        var closed_sells = document.getElementById("closed_sells");
	        
	        var auction_buy = document.getElementById("auction_buy");
	        var auction_sell = document.getElementById("auction_sell");
	        
	        
	        auction_buy.addEventListener("change", function(event) {
		        if (event.target.checked) {
		        	open_auctions.disabled = false;
		        	ongoing_auctions.disabled = false;
		        	won_auctions.disabled = false;
		        	
		        	open_sells.disabled = true;
		        	ongoing_sells.disabled = true;
		        	closed_sells.disabled = true;
		        	open_sells.checked = false;
		        	ongoing_sells.checked = false;
		        	closed_sells.checked = false;
		        }
	        }, false);
	        auction_sell.addEventListener("change", function(event) {
		        if (event.target.checked) {
	        		open_auctions.disabled = true;
		        	ongoing_auctions.disabled = true;
		        	won_auctions.disabled = true;
		        	open_auctions.checked = false;
		        	ongoing_auctions.checked = false;
		        	won_auctions.checked = false;
		        	
		        	open_sells.disabled = false;
		        	ongoing_sells.disabled = false;
		        	closed_sells.disabled = false;
		        }
	        }, false);
		</script>
	</body>
</html>