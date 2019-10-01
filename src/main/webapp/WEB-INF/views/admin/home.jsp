<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<%@include file="../subviews/head.jsp" %>
		<link href="${pageContext.request.contextPath}/resources/styles/admin/home.css" rel="stylesheet">
	</head>
	<body>
		<div>
			<nav>
				<div class="container">
					<a href="home" class="active">Home</a>
					<a href="drivers">Drivers</a>
					<a href="locations">Locations</a>
					<a href="races">Races</a>
					<a href="results">Results</a>
					<a href="seasons">Seasons</a>
					<a href="teams">Teams</a>
					<a href="tiers">Tiers</a>
				</div>
			</nav>
			
			<c:url var="logoutUrl" value="/logout" />
			<form action="${logoutUrl}" id="logout" method="post">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			</form>
			<a href="#" onclick="document.getElementById('logout').submit();">Logout</a>
		</div>
	</body>
</html>