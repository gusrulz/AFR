$clickUpdate = function(id) {
	var data = {}
	data["id"] = $("#id_" + id).text();
	data["number"] = $("#number_" + id).val();
	data["game"] = $("#game_" + id).val();
	data["tierId"] = $("#tier_" + id).val();
	
	var button = document.getElementById("update_" + id);
	button.disabled = true;

	$.ajax({
		type: "POST",
		contentType: "application/json",
		url: "/admin/saveSeason",
		data: JSON.stringify(data),
		dataType: 'json',
		timeout: 600000,
		success: function (data) {
			button.disabled = false;
			$("#id_" + id).html(data.season.id)
			alert("Successfully saved season " + data.season.number + " with ID " + data.season.id);
		},
		error: function (e) {
			button.disabled = false;
			alert("Failed to save season " + $("#number_" + id).val());
		}
	});
}

jQuery(document).ready(function() {
	$("#add").click(function(event) {
		var table = document.getElementById("seasonTable");

		var rowCount = table.rows.length;
		var row = table.insertRow(rowCount);

		var cell1 = row.insertCell(0);
		var element1 = document.createElement("span");
		element1.id ="id_" + (rowCount - 1);
		cell1.appendChild(element1);

		var cell2 = row.insertCell(1);
		var element2 = document.createElement("input");
		element2.type = "text";
		element2.id = "number_" + (rowCount - 1);
		cell2.appendChild(element2);
		
		var cell3 = row.insertCell(2);
		var element3 = document.createElement("input");
		element3.type = "text";
		element3.id = "game_" + (rowCount - 1);
		cell3.appendChild(element3);
		
		var cell4 = row.insertCell(3);
		var element4 = $('#hiddenTierList').clone()
		element4.attr("id", "tier_" + (rowCount - 1));
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