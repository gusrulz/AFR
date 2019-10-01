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
					<a href="seasons">Seasons</a>
					<a href="teams">Teams</a>
					<a href="tiers" class="active">Tiers</a>
				</div>
			</nav>
			
			<div class="container" id="main">
				<table id="tierTable">
					<tr>
						<th>ID</th><th>Name</th>
					</tr>
					<c:forEach items="${tiers}" var="tier" varStatus="loop">
						<tr>
							<td><span id="id_${loop.index}">${tier.id}</span></td>
							<td><input type="text" id="name_${loop.index}" value="${tier.name}"/></td>
							<td><input type="button" id="update_${loop.index}" onclick="$clickUpdate('${loop.index}')" value="Update"/></td>
						</tr>
					</c:forEach>
				</table>
				<input id="add" type="button" value="Add"/>
			</div>
		</div>
		<%@include file="../subviews/footer.jsp" %>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/admin/tiers.js"></script>
	</body>
</html>