$clickUpdate = function(id) {
	var data = {}
	data["id"] = $("#id_" + id).text();
	data["name"] = $("#name_" + id).val();
	
	var button = document.getElementById("update_" + id);
	button.disabled = true;

	$.ajax({
		type: "POST",
		contentType: "application/json",
		url: "/admin/saveTier",
		data: JSON.stringify(data),
		dataType: 'json',
		timeout: 600000,
		success: function (data) {
			button.disabled = false;
			$("#id_" + id).html(data.tier.id)
			alert("Successfully saved tier " + data.tier.name + " with ID " + data.tier.id);
		},
		error: function (e) {
			button.disabled = false;
			alert("Failed to save tier " + $("#name_" + id).val());
		}
	});
}

jQuery(document).ready(function() {
	$("#add").click(function(event) {
		var table = document.getElementById("tierTable");

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
		var cell3ID = "update_" + (rowCount - 1);
		var element3 = document.createElement("input");
		element3.type = "button";
		element3.id = cell3ID;
		element3.value = "Update";
		cell3.appendChild(element3);

		$("#" + cell3ID).click(function() { $clickUpdate((rowCount - 1)); });
	})
});