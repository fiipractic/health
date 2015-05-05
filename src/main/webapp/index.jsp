<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/persons.css" rel="stylesheet">
<link href="resources/css/bootstrap-theme.min.css" rel="stylesheet">
<script src="resources/js/bootstrap.min.js"></script>
<script src="resources/js/health.js"></script>
</head>
<body>
	<div class="page-header">
		<h1>Persons</h1>
	</div>
	<div class="row">
		<div class="col-md-12">
			<table id="persons" class="table table-striped">
				<thead>
					<tr>
						<th>Id</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>CNP</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
			<button type="button" id="listPersons" class="btn btn-sm btn-primary">List
				persons</button>
			<button type="button" id="deletePerson" class="btn btn-sm btn-danger">Delete
				person</button>
			<button type="button" id="openCreate" class="btn btn-sm btn-primary" data-toggle="modal"
				data-target="#myModal">Create person</button>
			<button type="button" id="openEdit" class="btn btn-sm btn-primary" data-toggle="modal"
				data-target="#myModal">Edit person</button>
		</div>


		<!-- Modal -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">Create person</h4>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label for="firstname">Firstname:</label> <input type="text"
								class="form-control" id="firstname">
						</div>
						<div class="form-group">
							<label for="lastname">Lastname:</label> <input type="text"
								class="form-control" id="lastname">
						</div>
						<div class="form-group">
							<label for="cnp">CNP:</label> <input type="number"
								class="form-control" id="cnp">
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						<button id="savePerson" type="button" class="btn btn-primary">Save</button>
					</div>
				</div>
			</div>
		</div>

	</div>

</body>
</html>
