$viewResults = function(raceId, raceName) {
	$.ajax({
		type: "GET",
		url: "/admin/getResults",
		data: {
			"raceId": raceId
		},
		timeout: 600000,
		success: function (data) {
			
			var table = document.getElementById("resultsTable");
			
			for (var i = 0; i < 20; i++) {
				var id = table.rows.length - 1;
				var row = table.insertRow(table.rows.length);
				
				var cell1 = row.insertCell(0);
				var element1 = document.createElement("span");
				element1.id ="resId_" + (id);
				
				if (data.results != null && data.results[i] != null) {
					element1.value = data.results[i].id;
					element1.innerHTML = data.results[i].id;
				}
				
				cell1.appendChild(element1);
				
				var cell2 = row.insertCell(1);
				var element2 = document.createElement("input");
				element2.id ="pos_" + (id);
				element2.type = "text";
				
				if (data.results != null && data.results[i] != null)
					element2.value = data.results[i].position;
				else
					element2.value = i + 1;
				
				cell2.appendChild(element2);
				
				var cell3 = row.insertCell(2);
				var element3 = $('#hiddenDriverList').clone()
				element3.attr("id", "driver_" + (id));
				element3.removeAttr("hidden");
				element3.appendTo(cell3);
				
				var cell4 = row.insertCell(3);
				var element4 = $('#hiddenTeamList').clone()
				element4.attr("id", "team_" + (id));
				element4.removeAttr("hidden");
				element4.appendTo(cell4);
				
				var cell5 = row.insertCell(4);
				var element5 = document.createElement("input");
				element5.id ="quali_" + (id);
				element5.type = "text";
				
				if (data.results != null && data.results[i] != null)
					element5.value = data.results[i].qualifying;
				
				cell5.appendChild(element5);
				
				var cell6 = row.insertCell(5);
				var element6 = document.createElement("input");
				element6.id ="fast_" + (id);
				element6.type = "text";
				
				if (data.results != null && data.results[i] != null)
					element6.value = data.results[i].fastestlap;
				
				cell6.appendChild(element6);
				
				var cell7 = row.insertCell(6);
				var element7 = document.createElement("input");
				element7.id ="race_" + (id);
				element7.type = "text";
				
				if (data.results != null && data.results[i] != null)
					element7.value = data.results[i].racetime;
				
				cell7.appendChild(element7);
				
				var cell8 = row.insertCell(7);
				var element8 = document.createElement("input");
				element8.id ="points_" + (id);
				element8.type = "text";
				
				if (data.results != null && data.results[i] != null) 
					element8.value = data.results[i].points;
				else {
					if (i == 0)
						element8.value = '25';
					else if (i == 1) {
						element8.value = '18';
					}
					else if (i == 2) {
						element8.value = '15';
					}
					else if (i == 3) {
						element8.value = '12';
					}
					else if (i == 4) {
						element8.value = '10';
					}
					else if (i == 5) {
						element8.value = '8';
					}
					else if (i == 6) {
						element8.value = '6';
					}
					else if (i == 7) {
						element8.value = '4';
					}
					else if (i == 8) {
						element8.value = '2';
					}
					else if (i == 9) {
						element8.value = '1';
					}
					else
						element8.value = '0';
				}
				
				cell8.appendChild(element8);
				
				if (data.results != null && data.results[i] != null)
					document.getElementById('driver_' + i).value = data.results[i].driver.id;
				
				if (data.results != null && data.results[i] != null)
					document.getElementById('team_' + i).value = data.results[i].team.id;
			}
			
			document.getElementById("results_heading").innerHTML = raceName;
			document.getElementById("results_heading").removeAttribute("hidden");
			
			table.removeAttribute("hidden");
			
			var racesTable = document.getElementById("raceTable");
			racesTable.setAttribute("hidden", "true");
			
			var button = document.getElementById("submitResultButton");
			button.onclick = function() { $saveResults(raceId); };
			button.removeAttribute("hidden");
		},
		error: function (e) {
			alert("Something went wrong");
		}
	});
}

$saveResults = function(raceId) {
	var resultList = [];
	var table = document.getElementById("resultsTable");
	
	for (var i = 0; i < 20; i++) {
		var id = document.getElementById("resId_" + i).value;
		var position = document.getElementById("pos_" + i).value;
		var driver = document.getElementById("driver_" + i).value;
		var team = document.getElementById("team_" + i).value;
		var qualifyingTime = document.getElementById("quali_" + i).value;
		var fastestLap = document.getElementById("fast_" + i).value;
		var raceTime = document.getElementById("race_" + i).value;
		var points = document.getElementById("points_" + i).value;
		
		if (driver == "")
			break;
		else {
			var result = {
					id: id,
					position: position,
					driver: driver,
					team: team,
					qualifying: qualifyingTime,
					fastestlap: fastestLap,
					racetime: raceTime,
					points: points
			}
			resultList.push(result);
		}
	}
	
	var data = 
	{ 
		raceId: raceId,
		results: resultList
	};
	
	$.ajax({
		type: "POST",
		contentType: "application/json",
		url: "/admin/saveResults",
		data: JSON.stringify(data),
		dataType: 'json',
		timeout: 600000,
		success: function (data) {
			alert("Successfully saved results");
			var table = document.getElementById("resultsTable");
			
			for (var i = 20; i > 0; i--) {
				table.deleteRow(i);
			}
			
			table.setAttribute("hidden", "true");
			
			var racesTable = document.getElementById("raceTable");
			racesTable.removeAttribute("hidden");
			
			var button = document.getElementById("submitResultButton");
			button.setAttribute("hidden", "true");
			
			document.getElementById("results_heading").setAttribute("hidden", "true");
		},
		error: function (e) {
			alert("Something went wrong");
		}
	});
}