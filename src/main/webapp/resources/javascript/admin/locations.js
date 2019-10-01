$clickUpdate = function(id) {
	var data = {}
	data["id"] = $("#id_" + id).text();
	data["name"] = $("#name_" + id).val();
	data["altName"] = $("#altName_" + id).val();
	data["map"] = $("#map_" + id).val();
	
	var button = document.getElementById("update_" + id);
	button.disabled = true;

	$.ajax({
		type: "POST",
		contentType: "application/json",
		url: "/admin/saveLocation",
		data: JSON.stringify(data),
		dataType: 'json',
		timeout: 600000,
		success: function (data) {
			button.disabled = false;
			$("#id_" + id).html(data.location.id)
			alert("Successfully saved location " + data.location.name + " with ID " + data.location.id);
		},
		error: function (e) {
			button.disabled = false;
			alert("Failed to save location " + $("#name_" + id).val());
		}
	});
}

jQuery(document).ready(function() {
	$("#add").click(function(event) {
		var table = document.getElementById("locationTable");

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
		element3.id = "altName_" + (rowCount - 1);
		cell3.appendChild(element3);

		var cell4 = row.insertCell(3);
		var element4 = document.createElement("input");
		element4.type = "text";
		element4.id = "map_" + (rowCount - 1);
		cell4.appendChild(element4);

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