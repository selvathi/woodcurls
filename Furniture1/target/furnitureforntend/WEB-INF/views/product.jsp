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

						<h1 class="h3 mb-3 font-weight-normal">Product Form</h1>
					</div>
					<div class="card-body">
						<form:form name="my-form" modelAttribute="myproduct" method="Post"
							action="${url}" enctype="multipart/form-data">

							<c:if test="${edit}">
								<div class="form-group row">
									<label for="full_name"
										class="col-md-4 col-form-label text-md-right">Product
										Id</label>
									<div class="col-md-6">
										<form:input type="text" id="full_name" class="form-control"
											name="full-name" path="product_id" readonly="true"></form:input>
									</div>
								</div>
							</c:if>
							<div class="form-group row">
								<label for="full_name"
									class="col-md-4 col-form-label text-md-right">Product
									Name</label>
								<div class="col-md-6">
									<form:input type="text" id="full_name" class="form-control"
										name="full-name" path="product_name"></form:input>
								</div>
							</div>

							<div class="form-group row">
								<label for="email_address"
									class="col-md-4 col-form-label text-md-right">Description</label>
								<div class="col-md-6">
									<form:textarea class="form-control" type="textarea"
										id="message" placeholder="Message" maxlength="140" rows="7"
										path="product_desc" />
								</div>
							</div>

							<div class="form-group row">
								<label for="full_name"
									class="col-md-4 col-form-label text-md-right">Category
								</label>
								<div class="col-md-6">
									<form:select type="text" id="full_name" class="form-control"
										name="full_name" path="category.category_id">
										<form:option value="0">Select category</form:option>
										<c:forEach items="${Category_list}" var="p">
											<form:option value="${p.category_id}">${p.category_name}</form:option>
										</c:forEach>
									</form:select>
								</div>
							</div>
							<div class="form-group row">
								<label for="full_name"
									class="col-md-4 col-form-label text-md-right">Quantity
								</label>
								<div class="col-md-6">
									<form:input type="text" id="full_name" class="form-control"
										name="full-name" path="product_quantity"></form:input>
								</div>
							</div>

							<div class="form-group row">
								<label for="full_name"
									class="col-md-4 col-form-label text-md-right">Price </label>
								<div class="col-md-6">
									<form:input type="text" id="full_name" class="form-control"
										name="full-name" path="product_price"></form:input>
								</div>
							</div>

								<div class="form-group row">
								<label for="full_name"
									class="col-md-4 col-form-label text-md-right">Image</label>
								<div class="col-md-6">
							<form:input type="file" name="fileToUpload" id="fileToUpload"
								path="pimage" class="form-control" />
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
												<th>ProductId</th>
												<th>Product Name</th>
												<th>Product Description</th>
												<th>Product Category</th>
												<th>Product Quantity</th>
												<th>Product Price</th>
												<th>Product Image</th>
												<th>Edit/Delete</th>

											</tr>


										</thead>
										<tbody>

											<!--row-->
											<c:forEach items="${Product_list}" var="p">
												<tr class="dark-row">
													<td>${p.product_id}</td>
													<td>${p.product_name}</td>
													<td>${p.product_desc}</td>
													<td>${p.category.category_id}</td>
													<td>${p.product_quantity}</td>
													<td>${p.product_price}</td>
													<td><img src="resources/pimages/${p.product_id}.jpg"
														width="50px" height="50px" /></td>


													<td class="text-center"><a class='btn btn-info btn-xs'
														href="editproduct?product_id=${p.product_id}"> <span
															class="glyphicon glyphicon-edit"></span> Edit
													</a> <a href="deleteproduct?product_id=${p.product_id}"
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
