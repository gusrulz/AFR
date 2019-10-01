// Set the date we're counting down to
var dateElement = document.getElementById('race-time');
var countDownDate = Date.parse(dateElement.innerHTML);

// Update the count down every 1 second
var x = setInterval(function() {

  // Get today's date and time
  var now = new Date().getTime();

  // Find the distance between now and the count down date
  var distance = countDownDate - now;

  // Time calculations for days, hours, minutes and seconds
  var days = Math.floor(distance / (1000 * 60 * 60 * 24));
  var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
  var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
  var seconds = Math.floor((distance % (1000 * 60)) / 1000);

  // Display the result in the element with id="demo"
  var clockDays = document.getElementById("clock-days");
  
  if (days == 0 && hours == 0) {
	  document.getElementById("daysDiv").setAttribute("style", "display: none;");
  } else {
	  document.getElementById("daysDiv").setAttribute("style", "display: block;");
	  
	  clockDays.innerHTML = days < 10 ? "0" + days : days;
	  if (days == 1) {
		  document.getElementById("days-text").innerHTML = "day";
	  } else {
		  document.getElementById("days-text").innerHTML = "days";
	  }
  }
  document.getElementById("clock-hours").innerHTML = hours < 10 ? "0" + hours : hours;
  if (hours == 1) {
	  document.getElementById("hrs-text").innerHTML = "hr";
  } else {
	  document.getElementById("hrs-text").innerHTML = "hrs";
  }
  document.getElementById("clock-minutes").innerHTML = minutes < 10 ? "0" + minutes : minutes;
  if (minutes == 1) {
	  document.getElementById("mins-text").innerHTML = "min";
  } else {
	  document.getElementById("mins-text").innerHTML = "mins";
  }
  
  var clockSecs = document.getElementById("clock-seconds");
  
  if (days != 0 || hours != 0) {
	  document.getElementById("secondsDiv").setAttribute("style", "display: none;");
  } else {
	  document.getElementById("secondsDiv").setAttribute("style", "display: block;");
	  clockSecs.innerHTML = seconds < 10 ? "0" + seconds : seconds;
	  
	  if (seconds == 1) {
		  document.getElementById("secs-text").innerHTML = "sec";
	  } else {
		  document.getElementById("secs-text").innerHTML = "secs";
	  }
  }

}, 1000);