$clickUpdate = function(id) {
	var data = {}
	data["id"] = $("#id_" + id).text();
	data["date"] = $("#date_" + id).val() + " AEDT";
	data["seasonId"] = $("#season_" + id).val();
	data["locationId"] = $("#location_" + id).val();
	
	var button = document.getElementById("update_" + id);
	button.disabled = true;

	$.ajax({
		type: "POST",
		contentType: "application/json",
		url: "/admin/saveRace",
		data: JSON.stringify(data),
		dataType: 'json',
		timeout: 600000,
		success: function (data) {
			var message = "";
			if (data.errorMessages != null) {
				message = "Failed to save race. Received the following system errors: \n";
				message = message + data.errorMessages;
			} else {
				$("#id_" + id).html(data.race.id);
				message = "Successfully saved race with ID " + data.race.id;
			}
			button.disabled = false;
			alert(message);
		},
		error: function (e) {
			button.disabled = false;
			alert("Failed to save race");
		}
	});
}

jQuery(document).ready(function() {
	$("#add").click(function(event) {
		var table = document.getElementById("raceTable");

		var rowCount = table.rows.length;
		var row = table.insertRow(rowCount);

		var cell1 = row.insertCell(0);
		var element1 = document.createElement("span");
		element1.id ="id_" + (rowCount - 1);
		cell1.appendChild(element1);

		var cell2 = row.insertCell(1);
		var element2 = document.createElement("input");
		element2.type = "datetime-local";
		element2.id = "date_" + (rowCount - 1);
		element2.attr("pattern", "[0-9]{4}-[0-9]{2}-[0-9]{2}T[0-9]{2}:[0-9]{2}");
		cell2.appendChild(element2);
		
		var cell3 = row.insertCell(2);
		var element3 = $('#hiddenSeasonList').clone()
		element3.attr("id", "season_" + (rowCount - 1));
		element3.removeAttr("hidden");
		element3.appendTo(cell3);
		
		var cell4= row.insertCell(3);
		var element4 = $('#hiddenLocationList').clone()
		element4.attr("id", "location_" + (rowCount - 1));
		element4.removeAttr("hidden");
		element4.appendTo(cell4);

		var cell5 = row.insertCell(4);
		var cell5ID = "update_" + (rowCount - 1);
		var element5 = document.createElement("input");
		element5.type = "button";
		element5.id = cell5ID;
		element5.value = "Update";
		cell5.appendChild(element5);

		$("#" + cell5ID).click(function() { $clickUpdate((rowCount - 1)); });
	})
});