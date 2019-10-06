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
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
		  <div class="container">
		    <a class="navbar-brand" href="/">AFR</a>
		    <a class="nav-link afr-site current-site" href="/">T1</a>
		    <!--<a class="nav-link afr-site" href="#">T2</a>
		    <a class="nav-link afr-site" href="#">100%</a>
		    <a class="nav-link afr-site" href="#">F2</a>-->
		    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
		      <span class="navbar-toggler-icon"></span>
		    </button>
		    <div class="collapse navbar-collapse" id="navbarResponsive">
		      <ul class="navbar-nav ml-auto">
		        <li class="nav-item active">
		          <a class="nav-link" href="/">Home
		            <span class="sr-only">(current)</span>
		          </a>
		        </li>
		        <!--<li class="nav-item">
		          <a class="nav-link" href="#">Races</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="#">Standings</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="#">Drivers</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="#">Teams</a>
		        </li>-->
		      </ul>
		    </div>
		  </div>
		</nav>
		
		<!-- Page Content -->
		
		<div class="countdown navbar navbar-expand-lg navbar-light">
			<span id="race-time" hidden=true>${nextRace.date} GMT+<fmt:formatNumber type="number" maxFractionDigits="0" value="${(timeZone.getRawOffset() + timeZone.getDSTSavings()) / 3600000}"/>00</span>
			<div class="navbar-nav">
				<div class="next-race">
					<span><fmt:formatDate pattern="dd MMMM" value="${nextRace.date}" /></span>
					<img class="flag-med" src="${pageContext.request.contextPath}/resources/public/images/flags/${nextRace.location.map}"/>
				</div>
				<div class="next-race-right">
					<span>${nextRace.location.name}</span>
					<span>Season ${nextRace.season.number}</span>
				</div>
			</div>
			<div class="navbar-nav ml-auto clock-wrapper">
				<div class="clock-row clock-heading">${nextRace.season.tier.name} Race</div>
				<div class="clock-row">
					<div class="nav-item clock" id="daysDiv">
						<span class="clock-elem clock-num" id="clock-days"></span>
						<span class="clock-elem clock-text" id="days-text"></span>
					</div>
					<div class="nav-item clock" id="hoursDiv">
						<span class="clock-elem clock-num" id="clock-hours"></span>
						<span class="clock-elem clock-text" id="hrs-text"></span>
					</div>
					<div class="nav-item clock" id="minutesDiv">
						<span class="clock-elem clock-num" id="clock-minutes"></span>
						<span class="clock-elem clock-text" id="mins-text"></span>
					</div>
					<div class="nav-item clock" id="secondsDiv">
						<span class="clock-elem clock-num" id="clock-seconds"></span>
						<span class="clock-elem clock-text" id="secs-text"></span>
					</div>
				</div>
			</div>
		</div>
		
		<ul class="nav nav-tabs nav-justified">
			<li class="nav-item"><a class="nav-link active" data-toggle="tab" href="#driver">Driver Standings</a></li>
			<li class="nav-item"><a class="nav-link" data-toggle="tab" href="#constructor">Constructor Standings</a></li>
			<li class="nav-item"><a class="nav-link" data-toggle="tab" href="#lastRace">${lastRace.location.altName} Grand Prix Results</a></li>
		</ul>
		
		<div class="row spacer-row"></div>
		
		<div class="container">
			<div class="tab-content">
				<div id="driver" class="driver-standings tab-pane fade in active show">
					<table class="table table-hover">
						<tbody>
							<c:forEach items="${driverStandings}" var="standing" varStatus="standingStatus">
								<tr>
									<td>
										<span class="position">${standingStatus.index + 1}</span>
										<c:if test="${standingStatus.index + 1 < 10}">
											<span class="extra-margin"></span>
										</c:if>
										<span class="team" style="color:${standing.team.colour}"><i class="fas fa-square"></i></span>
										<span class="name-primary">${standing.driver.name}</span>
										<span class="name-secondary">${standing.team.name}</span>
										<span class="points"><fmt:formatNumber type="number" minFractionDigits="0" value="${standing.points}"/> PTS</span>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				
				<div id="constructor" class="constructor-standings tab-pane fade">
					<table class="table table-hover">
						<tbody>
							<c:forEach items="${constructorStandings}" var="standing" varStatus="standingStatus">
								<tr>
									<td>
										<span class="position">${standingStatus.index + 1}</span>
										<c:if test="${standingStatus.index + 1 < 10}">
											<span class="extra-margin"></span>
										</c:if>
										<span class="team" style="color:${standing.team.colour}"><i class="fas fa-square"></i></span>
										<span class="name-primary">${standing.team.name}</span>
										<span class="name-secondary"><c:forEach items="${standing.drivers}" var="driver" varStatus="driverIndex">${driver.name}<c:if test="${!driverIndex.last}"> | </c:if></c:forEach></span>
										<span class="points"><fmt:formatNumber type="number" minFractionDigits="0" value="${standing.points}"/> PTS</span>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				
				<div id="lastRace" class="last-race tab-pane fade">
					<table class="table table-hover">
						<tbody>
							<c:forEach items="${lastRaceResults}" var="result" varStatus="standingStatus">
								<tr>
									<td>
										<span class="position">${standingStatus.index + 1}</span>
										<c:if test="${standingStatus.index + 1 < 10}">
											<span class="extra-margin"></span>
										</c:if>
										<span class="team" style="color:${result.team.colour}"><i class="fas fa-square"></i></span>
										<span class="name-primary">${result.driver.name}</span>
										<span class="name-secondary">${result.team.name}</span>
										<span class="points"><fmt:formatNumber type="number" minFractionDigits="0" value="${result.points}"/> PTS</span>
									</td>
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