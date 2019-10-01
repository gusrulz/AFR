<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<%@include file="../subviews/head.jsp" %>
		<link href="${pageContext.request.contextPath}/resources/styles/admin/tiers.css" rel="stylesheet">
	</head>
	<body>
		<div>
			<nav>
				<div class="container">
					<a href="home">Home</a>
					<a href="drivers">Drivers</a>
					<a href="locations">Locations</a>
					<a href="races">Races</a>
					<a href="results">Results</a>
					<a href="seasons" class="active">Seasons</a>
					<a href="teams">Teams</a>
					<a href="tiers">Tiers</a>
				</div>
			</nav>
			
			<div class="container" id="main">
				<table id="seasonTable">
					<tr>
						<th>ID</th><th>Number</th><th>Game</th><th>Tier</th>
					</tr>
					<c:forEach items="${seasons}" var="season" varStatus="loop">
						<tr>
							<td><span id="id_${loop.index}">${season.id}</span></td>
							<td><input type="text" id="number_${loop.index}" value="${season.number}"/></td>
							<td><input type="text" id="game_${loop.index}" value="${season.game}"/></td>
							<td><select id="tier_${loop.index}">
								 <c:forEach items="${tiers}" var="tier" varStatus="tLoop">
								 	<option <c:if test="${season.tier.id == tier.id}">selected</c:if> value="${tier.id}">${tier.name}</option>
								 </c:forEach>
							</select></td>
							<td><input type="button" id="update_${loop.index}" onclick="$clickUpdate('${loop.index}')" value="Update"/></td>
						</tr>
					</c:forEach>
				</table>
				<input id="add" type="button" value="Add"/>
				
				<select hidden="true" id="hiddenTierList">
					 <c:forEach items="${tiers}" var="tier" varStatus="tLoop">
					 	<option value="${tier.id}">${tier.name}</option>
					 </c:forEach>
				</select>
							
			</div>
		</div>
		<%@include file="../subviews/footer.jsp" %>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/admin/seasons.js"></script>
	</body>
</html>