<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<%@include file="subviews/head.jsp" %>
		<!-- Custom styles for this page -->
		<link href="${pageContext.request.contextPath}/resources/styles/home.css" rel="stylesheet">
	</head>
	<body>
		<!-- Navigation -->
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark static-top">
		  <div class="container">
		    <a class="navbar-brand" href="#">AFR</a>
		    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
		      <span class="navbar-toggler-icon"></span>
		    </button>
		    <div class="collapse navbar-collapse" id="navbarResponsive">
		      <ul class="navbar-nav ml-auto">
		        <li class="nav-item active">
		          <a class="nav-link" href="#">Home
		            <span class="sr-only">(current)</span>
		          </a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="#">About</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="#">Services</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="#">Contact</a>
		        </li>
		      </ul>
		    </div>
		  </div>
		</nav>
		
		<!-- Page Content -->
		<div class="container">
			<div class="countdown">
				<span id="race-time" hidden>${nextRace.date}</span>
				<div id="daysDiv">
					<span id="clock-days"></span>
					<span id="days-text"></span>
				</div>
				<div id="hoursDiv">
					<span id="clock-hours"></span>
					<span id="hrs-text"></span>
				</div>
				<div id="minutesDiv">
					<span id="clock-minutes"></span>
					<span id="mins-text"></span>
				</div>
				<div id="secondsDiv">
					<span id="clock-seconds"></span>
					<span id="secs-text"></span>
				</div>
			</div>
		
			<ul class="nav nav-tabs nav-justified">
				<li class="nav-item"><a class="nav-link active" data-toggle="tab" href="#driver">Driver Standings</a></li>
				<li class="nav-item"><a class="nav-link" data-toggle="tab" href="#constructor">Constructor Standings</a></li>
				<li class="nav-item"><a class="nav-link" data-toggle="tab" href="#lastRace">${lastRace.location.altName} Grand Prix Results</a></li>
			</ul>
			
			<div class="tab-content">
				<div id="driver" class="driver-standings tab-pane fade in active show">
					<div class="row">
						<div class="col-lg-12 text-center">
							<h1 class="mt-5">Driver Standings</h1>
						</div>
					</div>
					<table class="table table-hover">
						<thead>
							<tr>
								<th scope="col">Position</th>
								<th scope="col">Driver</th>
								<th scope="col">Team</th>
								<th scope="col">Points</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${driverStandings}" var="standing" varStatus="standingStatus">
								<tr>
									<th scope="row">${standingStatus.index + 1}</th>
									<td>${standing.driver.name}</td>
									<td>${standing.team.name}</td>
									<td><fmt:formatNumber type="number" minFractionDigits="0" value="${standing.points}"/></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				
				<div id="constructor" class="constructor-standings tab-pane fade">
					<div class="row">
						<div class="col-lg-12 text-center">
							<h1 class="mt-5">Constructor Standings</h1>
						</div>
					</div>
					<table class="table table-hover">
						<thead>
							<tr>
								<th scope="col">Position</th>
								<th scope="col">Team</th>
								<th scope="col">Points</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${constructorStandings}" var="standing" varStatus="standingStatus">
								<tr>
									<th scope="row">${standingStatus.index + 1}</th>
									<td>${standing.team.name}</td>
									<td><fmt:formatNumber type="number" minFractionDigits="0" value="${standing.points}"/></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				
				<div id="lastRace" class="last-race tab-pane fade">
					<div class="row">
						<div class="col-lg-12 text-center">
							<h1 class="mt-5">${lastRace.location.altName} Grand Prix Results</h1>
						</div>
					</div>
					<table class="table table-hover">
						<thead>
							<tr>
								<th scope="col">Position</th>
								<th scope="col">Driver</th>
								<th scope="col">Team</th>
								<th scope="col">Points</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${lastRaceResults}" var="result" varStatus="standingStatus">
								<tr>
									<th scope="row">${result.index + 1}</th>
									<td>${result.driver.name}</td>
									<td>${result.team.name}</td>
									<td><fmt:formatNumber type="number" minFractionDigits="0" value="${standing.points}"/></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>

		<!-- Footer -->
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/home.js"></script>
		<%@include file="subviews/footer.jsp" %>
	</body>
</html>