<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<style>
@import
	url("https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css");
.banner-sec {
	background:
		url("https://d3nuqriibqh3vw.cloudfront.net/images/tired-furniture-03.jpg")
		no-repeat bottom;
	background-size: cover;
	min-height: 500px;
	border-radius: 0 10px 10px 0;
	padding: 0;
}

.myreg {
	background: #fff;
	border-radius: 10px;
}

.carousel-inner {
	border-radius: 0 10px 10px 0;
}

.carousel-caption {
	text-align: left;
	left: 5%;
}

.register-sec {
	padding: 50px 30px;
	position: relative;
}

.register-sec .copy-text {
	position: absolute;
	width: 80%;
	bottom: 20px;
	font-size: 13px;
	text-align: center;
}

.register-sec .copy-text i {
	color: #FEB58A;
}

.register-sec .copy-text a {
	color: #E36262;
}

.register-sec h2 {
	margin-bottom: 30px;
	font-weight: 800;
	font-size: 30px;
	color: #3f4c6b;
}

.register-sec h2:after {
	content: " ";
	width: 100px;
	height: 5px;
	background: #3f4c6b;
	display: block;
	margin-top: 20px;
	border-radius: 3px;
	margin-left: auto;
	margin-right: auto
}

.btn-register {
	background: #3f4c6b;
	color: #fff;
	font-weight: 600;
}

.banner-text {
	width: 70%;
	position: absolute;
	bottom: 40px;
	padding-left: 20px;
}

.banner-text h2 {
	color: #fff;
	font-weight: 600;
}

.banner-text h2:after {
	content: " ";
	width: 100px;
	height: 5px;
	background: #FFF;
	display: block;
	margin-top: 20px;
	border-radius: 3px;
}

.banner-text p {
	color: #fff;
}
.register-block
{
	margin-top: 3%;
}
</style>

<section class="register-block">
	<div class="container myreg">
	                 
		<div class="row">
		
		
			<div class="col-md-4 register-sec">
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
			   
				<h2 class="text-center">Register Now</h2>
				<form:form class="register-form" modelAttribute="myuserdetails" method="Post" action="createregister"  >
					<div class="form-group">
					
						<label for="exampleInputName1" class="text-uppercase">Name</label>
						<form:input  class="form-control"  path="username"/>
					</div>
					 
					 
					<div class="form-group">
						<label for="exampleInputPhonenumber" class="text-uppercase">Phonenumber</label>
						<form:input type="text" class="form-control" path="phoneno"/>

					</div>
					
					<div class="form-group">
						<label for="exampleInputEmail" class="text-uppercase">Email</label>
						<form:input type="email" class="form-control" path="emailid"/>
					</div>
					
					<div class="form-group">
						<label for="exampleInputPassword1" class="text-uppercase">Password</label>
						<form:input type="password" class="form-control" path="password"/>
					</div>
                     
                       

					<div class="form-check">
						<button type="submit" class="btn btn-register float-right">Submit</button>
					</div>

				</form:form>

			</div>
			<div class="col-md-8 banner-sec"></div>
		</div>
	</div>
</section>
