<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<%@include file="../subviews/head.jsp" %>
		<link href="${pageContext.request.contextPath}/resources/styles/admin/results.css" rel="stylesheet">
	</head>
	<body>
		<div>
			<nav>
				<div class="container">
					<a href="home">Home</a>
					<a href="drivers">Drivers</a>
					<a href="locations">Locations</a>
					<a href="races">Races</a>
					<a href="results" class="active">Results</a>
					<a href="seasons">Seasons</a>
					<a href="teams">Teams</a>
					<a href="tiers">Tiers</a>
				</div>
			</nav>
			<div class="container" id="main">
				<table id="raceTable">
					<tr>
						<th>ID</th><th>Race</th>
					</tr>
					<c:forEach items="${races}" var="race" varStatus="loop">
						<tr>
							<td><span id="id_${loop.index}">${race.id}</span></td>
							<td><span id="name_${loop.index}">${race.season.tier.name} Season ${race.season.number} ${race.location.altName} Grand Prix</span></td>
							<td><input type="button" id="results_${loop.index}" onclick="$viewResults('${race.id}', '${race.season.tier.name} Season ${race.season.number} ${race.location.altName} Grand Prix')" value="View"/></td>
						</tr>
					</c:forEach>
				</table>
				<h1 id="results_heading" hidden="true"></h1>
				<table id="resultsTable" hidden="true">
					<tr>
						<th>ID</th><th>Position</th><th>Driver</th><th>Team</th><th>Qualifying Time</th><th>Fastest Lap</th><th>Race Time</th><th>Points</th>
					</tr>
				</table>
				<input hidden="true" id="submitResultButton" type="button" value="saveResults"/>
				<select hidden="true" id="hiddenDriverList">
					<option value="">None Selected</option>
					 <c:forEach items="${drivers}" var="driver" varStatus="dLoop">
					 	<option value="${driver.id}">${driver.name}</option>
					 </c:forEach>
				</select>
				<select hidden="true" id="hiddenTeamList">
					<option value="">None Selected</option>
					 <c:forEach items="${teams}" var="team" varStatus="tLoop">
					 	<option value="${team.id}">${team.name}</option>
					 </c:forEach>
				</select>
			</div>
		</div>
		<%@include file="../subviews/footer.jsp" %>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/admin/results.js"></script>
	</body>
</html>