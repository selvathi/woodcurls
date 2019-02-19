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
							<c:set var="url" value="updatecategory"></c:set>
						</c:if>
						<c:if test="${!edit}">
							<c:set var="url" value="createcategory"></c:set>
						</c:if>
						<h1 class="h3 mb-3 font-weight-normal">Category Form</h1>
					</div>
					<div class="card-body">
						<form:form name="my-form" modelAttribute="mycategory"
							method="Post" action="${url}">
						
							<div class="form-group row">
								<label for="full_name"
									class="col-md-4 col-form-label text-md-right">Category
									Id</label>
								<div class="col-md-6">
									<form:input type="text" id="full_name" class="form-control"
										name="full-name" path="category_id"></form:input>
								</div>
							</div>
								<div class="form-group row">
								<label for="full_name"
									class="col-md-4 col-form-label text-md-right">Category
									Name</label>
								<div class="col-md-6">
									<form:input type="text" id="full_name" class="form-control"
										name="full-name" path="category_name"></form:input>
								</div>
							</div>

							<div class="form-group row">
								<label for="email_address"
									class="col-md-4 col-form-label text-md-right">Description</label>
								<div class="col-md-6">
									<form:textarea class="form-control" type="textarea"
										id="message" placeholder="Message" maxlength="1040" rows="7"
										path="category_desc" />
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
												<th>Category Id</th>
												<th>Category Name</th>
												<th>Category Description</th>
												<th>Edit/Delete</th>

											</tr>


										</thead>
										<tbody>

											<!--row-->
											<c:forEach items="${Category_list}" var="c">
												<tr class="dark-row">
													<td>${c.category_id}</td>
													<td>${c.category_name}</td>
													<td>${c.category_desc}</td>


													<td class="text-center"><a class='btn btn-info btn-xs'
														href="editcategory?c_id=${c.category_id}"> <span
															class="glyphicon glyphicon-edit"></span> Edit
													</a> <a href="deletecategory?c_id=${c.category_id}"
														class="btn btn-danger btn-xs"> <span
															class="glyphicon glyphicon-remove"></span> Delete
													</a></td>
												</tr>
											</c:forEach>
											<!--/.row-->



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