<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<%@include file="../subviews/head.jsp" %>
		<link href="${pageContext.request.contextPath}/resources/styles/admin/teams.css" rel="stylesheet">
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
					<a href="seasons">Seasons</a>
					<a href="teams" class="active">Teams</a>
					<a href="tiers">Tiers</a>
				</div>
			</nav>
			
			<div class="container" id="main">
				<table id="teamTable">
					<tr>
						<th>ID</th><th>Name</th><th>Colour</th><th>Car</th><th>Logo</th>
					</tr>
					<c:forEach items="${teams}" var="team" varStatus="loop">
						<tr>
							<td><span id="id_${loop.index}">${team.id}</span></td>
							<td><input type="text" id="name_${loop.index}" value="${team.name}"/></td>
							<td><input type="text" id="colour_${loop.index}" value="${team.colour}"/></td>
							<td><input type="text" id="car_${loop.index}" value="${team.car}"/></td>
							<td><input type="text" id="logo_${loop.index}" value="${team.logo}"/></td>
							<td><input type="button" id="update_${loop.index}" onclick="$clickUpdate('${loop.index}')" value="Update"/></td>
						</tr>
					</c:forEach>
				</table>
				<input id="add" type="button" value="Add"/>
			</div>
		</div>
		<%@include file="../subviews/footer.jsp" %>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/admin/teams.js"></script>
	</body>
</html>