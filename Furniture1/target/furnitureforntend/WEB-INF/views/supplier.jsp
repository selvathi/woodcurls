<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<style>
.dark-row {
	background: #AEC5E8;
}

.light-row {
	background: #F1F3F0;
}

.movie-table-head {
	background:;
}

@import url(https://fonts.googleapis.com/css?family=Raleway:300,400,600)
	;

body {
	margin: 0;
	font-size: .9rem;
	font-weight: 400;
	line-height: 1.6;
	color: #212529;
	text-align: left;
	background-color: #f5f8fa;
}

.my-form {
	padding-top: 1.5rem;
	padding-bottom: 1.5rem;
}

.my-form .row {
	margin-left: 0;
	margin-right: 0;
}

.login-form {
	padding-top: 1.5rem;
	padding-bottom: 1.5rem;
}

.login-form .row {
	margin-left: 0;
	margin-right: 0;
}
</style>
<link rel="dns-prefetch" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css?family=Raleway:300,400,600"
	rel="stylesheet" type="text/css">
<div class="cotainer">
	<div class="my-form">


		<div class="row justify-content-center">
			<div class="col-md-8">
				<div class="card">

					<div class="card-header" style="text-align: center">
						<c:if test="${success}">
							<div class="alert alert-success">
								<strong>Success!</strong>Data Inserted.
							</div>
						</c:if>
						<c:if test="${error1}">
							<div class="alert alert-danger">
								<strong>Danger!</strong>Incorrect Data.
							</div>
						</c:if>

						<c:if test="${error2}">
							<div class="alert alert-warning">
								<strong>Warning!</strong>Data Already Exists.
							</div>
						</c:if>
						
						<c:if test="${error3}">
							<div class="alert alert-warning">
								<strong>Warning!</strong>Please contact the administrator
							</div>
						</c:if>
						
						<c:if test="${edit}">
							<c:set var="url" value="updateproduct"></c:set>
						</c:if>
						<c:if test="${!edit}">
							<c:set var="url" value="createproduct"></c:set>
						</c:if>

						<h1 class="h3 mb-3 font-weight-normal">Supplier Form</h1>
					</div>
					<div class="card-body">
						<form:form name="my-form" modelAttribute="mysupplier"
							method="Post" action="createsupplier">

							<c:if test="${edit}">
								<div class="form-group row">
									<label for="full_name" class="col-md-4 col-form-label text-md-right">
										Supplier Id</label>
									<div class="col-md-6">
										<form:input type="text" id="full_name" class="form-control"
											name="full-name" path="supplier_id" readonly="true"></form:input>
									</div>
								</div>
							</c:if>
							<div class="form-group row">
								<label for="full_name"
									class="col-md-4 col-form-label text-md-right">Supplier
									Name</label>
								<div class="col-md-6">
									<form:input type="text" id="full_name" class="form-control"
										name="full-name" path="supplier_name"></form:input>
								</div>
							</div>
							
							<div class="form-group row">
								<label for="full_name"
									class="col-md-4 col-form-label text-md-right">Supplier
									EmailId </label>
								<div class="col-md-6">
									<form:input type="text" id="full_name" class="form-control"
										name="full-name" path="supplier_emailid"></form:input>
								</div>
							</div>
							
							<div class="form-group row">
								<label for="full_name"
									class="col-md-4 col-form-label text-md-right">Password
									 </label>
								<div class="col-md-6">
									<form:input type="password" id="full_name" class="form-control"
										name="full-name" path="password"></form:input>
								</div>
							</div>
							
							<div class="form-group row">
								<label for="full_name"
									class="col-md-4 col-form-label text-md-right">Phone_no</label>
								<div class="col-md-6">
									<form:input type="text" id="full_name" class="form-control"
										name="full-name" path="phoneno"></form:input>
								</div>
							</div>

								<div class="form-group row">
								<label for="full_name"
									class="col-md-4 col-form-label text-md-right">Location
								</label>
								<div class="col-md-6">
									<form:input type="text" id="full_name" class="form-control"
										name="full-name" path="location"></form:input>
								</div>
							</div>

							

							<div class="col-md-6 offset-md-4">
								<button type="submit" class="btn btn-primary">Submit</button>
							</div>
						</form:form>
						<div class="container">
							<div class="row">
								<div class="table-responsive table-bordered movie-table">
									<table class="table movie-table">
										<thead>
											<tr class="movie-table-head">
												<th>Supplier Id</th>
												<th>Supplier Name</th>
												<th>Supplier Emailid</th>
												<th>Phoneno</th>
												<th>Location</th>
												<th>Edit/Delete</th>

											</tr>

										</thead>
										<tbody>

											<c:forEach items="${Supplier_list}" var="s">
												<tr class="dark-row">
													<td>${s.supplier_id}</td>
													<td>${s.supplier_name}</td>
													<td>${s.supplier_emailid}</td>
													<td>${s.phoneno}</td>
													<td>${s.location}</td>



													<td class="text-center"><a class='btn btn-info btn-xs'
														href="editsupplier?supplier_id=${s.supplier_id}"> <span
															class="glyphicon glyphicon-edit"></span> Edit
													</a> <a href="deletesupplier?supplier_id=${s.supplier_id}"
														class="btn btn-danger btn-xs"> <span
															class="glyphicon glyphicon-remove"></span> Delete
													</a></td>
												</tr>
											</c:forEach>



										</tbody>
									</table>
								</div>
							</div>
						</div>


					</div>
				</div>
			</div>
		</div>
	</div>
</div>
