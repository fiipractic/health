var selectedId = 0;
var persons = [];
$(document).ready(function() {
	$("#listPersons").click(function() {
		loadPersons();
	});

	$("#deletePerson").click(function(id) {
		deletePerson(selectedId);
	});

	$("#savePerson").click(function(id) {
		if ($(this).attr('editing') === 'false') {
			createPerson();
		} else {
			updatePerson(selectedId);
		}
	});
	$("#updatePerson").click(function(id) {

	});
	$("#openCreate").click(function() {
		$("#savePerson").attr('editing', 'false');
		document.getElementById("myModalLabel").innerHTML = "Create person"
	});
	$("#openEdit").click(function(id) {
		if (selectedId === 0) {
			alert(" You must select a person in order to edit it!");
		} else {
			$("#savePerson").attr('editing', 'true');
			document.getElementById("myModalLabel").innerHTML = "Edit person"

			var selectedPerson = findPErsonById(selectedId);
			$("#firstname").val(selectedPerson.firstName);
			$("#lastname").val(selectedPerson.lastName);
			$("#cnp").val(selectedPerson.cnp);
		}
	});

});

/**
 * This function loads the existing persons from the database. Sends a REST
 * request (using ajax) to /person/list request handler.
 */
var loadPersons = function() {
	$.ajax({
		url : window.location.href + '/person/list',
		dataType : 'json',
		cache : false,
		success : function(data) {
			// clear the existing rows
			$("#persons tr:first").siblings("tr").remove();
			// update the HTML by adding a table>row for each person
			for (var i = 0; i < data.length; i++) {
				var person = data[i];
				var $row = "<tr id=" + person.id + ">" + "<td>" + person.id
						+ "</td>" + "<td>" + person.firstName + "</td>"
						+ "<td>" + person.lastName + "</td>" + "<td>"
						+ person.cnp + "</td>" + "</tr>";
				$("#persons tr:last").after($row);
				addRowHandlers("persons");
				persons.push(person);
			}
		}
	});
};

/**
 * This function deletes an existing person from the database. Sends a REST
 * request (using ajax) to /person/delete/{id} request handler.
 */
var deletePerson = function(id) {
	$.ajax({
		url : window.location.href + '/person/delete/' + id,
		dataType : 'json',
		type : 'PUT',
		success : function(result) {
			if (result.Status === "Success") {
				$("#persons").find("#" + id).remove();
			} else {
				alert(result.Message);
			}
		}
	});
};

function addRowHandlers(tableId) {
	var table = document.getElementById(tableId);
	var rows = table.getElementsByTagName("tr");
	for (i = 1; i < rows.length; i++) {
		var currentRow = table.rows[i];
		var createClickHandler = function(row) {
			return function() {
				var id = row.id;
				row.classList.add("selected")
				$(row).addClass("selected").siblings("tr").removeClass(
						"selected");
				selectedId = id;
			};
		};

		currentRow.onclick = createClickHandler(currentRow);
	}
}

function createPerson() {

	var firstname = $("#firstname").val();
	var lastname = $("#lastname").val();
	var cnp = $("#cnp").val();

	$.ajax({
		url : window.location.href + '/person/create',
		contentType : 'application/json; charset=utf-8',
		dataType : 'json',
		type : 'POST',
		data : JSON.stringify({
			"firstName" : firstname,
			"lastName" : lastname,
			"cnp" : cnp
		}),
		success : function(result) {
			$('#myModal').modal('hide');
			loadPersons();
		}
	});
}

function updatePerson(id) {

	var firstname = $("#firstname").val();
	var lastname = $("#lastname").val();
	var cnp = $("#cnp").val();

	$.ajax({
		url : window.location.href + '/person/update/' + id,
		contentType : 'application/json; charset=utf-8',
		dataType : 'json',
		type : 'PUT',
		data : JSON.stringify({
			"firstName" : firstname,
			"lastName" : lastname,
			"cnp" : cnp
		}),
		success : function(result) {
			$('#myModal').modal('hide');
			loadPersons();
		}
	});
}

function findPErsonById(id) {
	var foundPerson = {};
	for (i = 0; i < persons.length; i++) {
		if (persons[i].id === parseInt(id, 10)) {
			foundPerson = persons[i];
			break;
		}
	}
	return foundPerson;
}
