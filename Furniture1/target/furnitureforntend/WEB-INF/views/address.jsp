<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:set var="cr" value="${pageContext.request.contextPath}" />

<style>
#contatti {
	margin-top: 5%;
}

#contatti a {
	color: #fff;
	text-decoration: none;
}

@media ( max-width : 575.98px) {
	#contatti .maps iframe {
		width: 100%;
		height: 400px;
	}
}

@media ( min-width : 576px) {
	#contatti .maps iframe {
		width: 100%;
		height: 450px;
	}
}

@media ( min-width : 768px) {
	#contatti .maps iframe {
		width: 100%;
		height: 400px;
	}
}

@media ( min-width : 992px) {
	#contatti .maps iframe {
		width: 100%;
		height: 400px;
	}
}

#author a {
	color: #fff;
	text-decoration: none;
}
</style>
<div class="row" id="contatti">
	<div class="container">

		<div class="row">

			<div class="col-md-6">
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
					<c:set var="url" value="${cr}/user/updateaddress"></c:set>
				</c:if>
				<c:if test="${!edit}">	
					<c:set var="url" value="${cr}/user/createaddress"></c:set>
				</c:if>

				<h2 class="text-uppercase mt-2 font-weight-bold text-black">CUSTOMER
					ADDRESS</h2>
				<form:form action="${url}" method="Post" modelAttribute="myaddress">
					<c:if test="${edit}">
						<form:hidden path="address_id" />
					</c:if>
					<form:hidden path="userdetails.u_id" value="${sessionScope.userid}" />
					<div class="row">
						<div class="col-lg-6">
							<div class="form-group">
								<label>User Name</label>
								<form:input type="text" class="form-control mt-2" placeholder=""
									path="b_name" />
							</div>
						</div>


						<div class="col-lg-6">
							<div class="form-group">
								<label>Address_Line1</label>
								<form:input type="text" class="form-control mt-2" placeholder=""
									path="address_Line1" />
							</div>
						</div>
						<div class="col-lg-6">
							<div class="form-group">
								<label>Address_Line2</label>
								<form:input type="text" class="form-control mt-2" placeholder=""
									path="address_Line2" />
							</div>
						</div>
						<div class="col-lg-6">
							<div class="form-group">
								<label>City</label>
								<form:input type="text" class="form-control mt-2" placeholder=""
									path="city" />
							</div>
						</div>
						<div class="col-lg-6">
							<div class="form-group">
								<label>State</label>
								<form:input type="text" class="form-control mt-2" placeholder=""
									path="state" />
							</div>
							<div class="col-lg-6">
								<div class="form-group">
									<label>Pincode</label>
									<form:input type="text" class="form-control mt-2"
										placeholder="Pincode" path="pincode" />
								</div>
							</div>

							<div class="col-12">
								<button class="btn btn-light" type="submit">Submit</button>
							</div>

						</div>
					</div>

	 		</form:form>
			</div>
		<div class="col-md-6">
			<div class="row">
				<c:forEach items="${Address_list}" var="v">
					<div class="col-lg-4">
						<div class="thumbnail card">
							<div class="img-event">
								<img class="group list-group-image img-fluid"
									src="http://pngimagesfree.com/house/t/HOUSE-PNG.png"
									alt="Unsupported browser"
									style="max-height: 100px; width: 100%" />
							</div>
							<div class="caption card-body">
								<h5 class="group card-title inner list-group-item-heading">
									${v.b_name}</h5>
								<div class="row">
									<div class="col-xs-12">
										<p class="lead">${v.address_Line1}</p>
										<p class="lead">${v.address_Line2}</p>
										<p class="lead">${v.city}</p>
										<p class="lead">${v.state}</p>
										<p class="lead">${v.pincode}</p>
									</div>
								</div>
								<div class="row">
									<div class="col-xs-12">

										<td class="text-center">
										<a class="btn btn-info btn-xs"
											href="${cr}/user/editaddress?address_id=${v.address_id}">
												<span class="fa fa-edit"></span> 
										</a> <a href="${cr}/user/deleteaddress?address_id=${v.address_id}"
											class="btn btn-danger btn-xs"> <span
												class="fa fa-trash-o"></span>
										</a> <a class="btn btn-success" href="${cr}/user/placeorder?addressid=${v.address_id}">
										<span class="fa fa-truck"></span></a></td>
									</div>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
		</div>

	</div>
</div>