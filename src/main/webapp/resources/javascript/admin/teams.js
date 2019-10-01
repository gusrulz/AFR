$clickUpdate = function(id) {
	var data = {}
	data["id"] = $("#id_" + id).text();
	data["name"] = $("#name_" + id).val();
	data["colour"] = $("#colour_" + id).val();
	data["car"] = $("#car_" + id).val();
	data["logo"] = $("#logo_" + id).val();
	
	var button = document.getElementById("update_" + id);
	button.disabled = true;

	$.ajax({
		type: "POST",
		contentType: "application/json",
		url: "/admin/saveTeam",
		data: JSON.stringify(data),
		dataType: 'json',
		timeout: 600000,
		success: function (data) {
			button.disabled = false;
			$("#id_" + id).html(data.team.id)
			alert("Successfully saved team " + data.team.name + " with ID " + data.team.id);
		},
		error: function (e) {
			button.disabled = false;
			alert("Failed to save team " + $("#name_" + id).val());
		}
	});
}

jQuery(document).ready(function() {
	$("#add").click(function(event) {
		var table = document.getElementById("teamTable");

		var rowCount = table.rows.length;
		var row = table.insertRow(rowCount);

		var cell1 = row.insertCell(0);
		var element1 = document.createElement("span");
		element1.id ="id_" + (rowCount - 1);
		cell1.appendChild(element1);

		var cell2 = row.insertCell(1);
		var element2 = document.createElement("input");
		element2.type = "text";
		element2.id = "name_" + (rowCount - 1);
		cell2.appendChild(element2);

		var cell3 = row.insertCell(2);
		var element3 = document.createElement("input");
		element3.type = "text";
		element3.id = "colour_" + (rowCount - 1);
		cell3.appendChild(element3);

		var cell4 = row.insertCell(3);
		var element4 = document.createElement("input");
		element4.type = "text";
		element4.id = "car_" + (rowCount - 1);
		cell4.appendChild(element4);
		
		var cell5 = row.insertCell(4);
		var element5 = document.createElement("input");
		element5.type = "text";
		element5.id = "logo_" + (rowCount - 1);
		cell5.appendChild(element5);

		var cell6 = row.insertCell(5);
		var cell6ID = "update_" + (rowCount - 1);
		var element6 = document.createElement("input");
		element6.type = "button";
		element6.id = cell6ID;
		element6.value = "Update";
		cell6.appendChild(element6);

		$("#" + cell6ID).click(function() { $clickUpdate((rowCount - 1)); });
	})
});