<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<%@include file="../subviews/head.jsp" %>
		<link href="${pageContext.request.contextPath}/resources/styles/admin/races.css" rel="stylesheet">
	</head>
	<body>
		<div>
			<nav>
				<div class="container">
					<a href="home">Home</a>
					<a href="drivers">Drivers</a>
					<a href="locations">Locations</a>
					<a href="races" class="active">Races</a>
					<a href="results">Results</a>
					<a href="seasons">Seasons</a>
					<a href="teams">Teams</a>
					<a href="tiers">Tiers</a>
				</div>
			</nav>
			
			<div class="container" id="main">
				<table id="raceTable">
					<tr>
						<th>ID</th><th>Date</th><th>Season</th><th>Location</th>
					</tr>
					<c:forEach items="${races}" var="race" varStatus="loop">
						<tr>
							<td><span id="id_${loop.index}">${race.id}</span></td>
							<td><input type="datetime-local" id="date_${loop.index}" value='${fn:replace(race.date, " ", "T")}'/></td>
							<td><select id="season_${loop.index}">
								 <c:forEach items="${seasons}" var="season" varStatus="sLoop">
								 	<option <c:if test="${race.season.id == season.id}">selected</c:if> value="${season.id}">${season.tier.name}: Season ${season.number} (${season.game})</option>
								 </c:forEach>
							</select></td>
							<td><select id="location_${loop.index}">
								 <c:forEach items="${locations}" var="location" varStatus="lLoop">
								 	<option <c:if test="${race.location.id == location.id}">selected</c:if> value="${location.id}">${location.name}</option>
								 </c:forEach>
							</select></td>
							<td><input type="button" id="update_${loop.index}" onclick="$clickUpdate('${loop.index}')" value="Update"/></td>
						</tr>
					</c:forEach>
				</table>
				<input id="add" type="button" value="Add"/>
				
				<select hidden="true" id="hiddenSeasonList">
					 <c:forEach items="${seasons}" var="season" varStatus="sLoop">
					 	<option value="${season.id}">${season.tier.name}: Season ${season.number} (${season.game})</option>
					 </c:forEach>
				</select>
				<select hidden="true" id="hiddenLocationList">
					 <c:forEach items="${locations}" var="location" varStatus="lLoop">
					 	<option value="${location.id}">${location.name}</option>
					 </c:forEach>
				</select>
							
			</div>
		</div>
		<%@include file="../subviews/footer.jsp" %>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/admin/races.js"></script>
	</body>
</html>