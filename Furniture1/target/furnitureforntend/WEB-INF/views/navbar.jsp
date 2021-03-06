<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="cr" value="${pageContext.request.contextPath}" />
<style>
a.navbar-brand {
	float: left;
	height: 50px;
	padding: 15px 15px;
	font-size: 18px;
	line-height: 20px;
	text-decoration: none;
	font-family: cursive;
	font-weight: 700;
	margin-top: -30px;
	margin-left: 20px;
}

nav.main-navigation {
	background-image: url("http://bgfons.com/upload/wood_texture3811.jpg");
	position: relative;
}

nav.main-navigation ul.nav-list {
	margin: 0;
	padding: 0;
	list-style: none;
	position: relative;
	text-align: right;
}

.nav-list li.nav-list-item {
	display: inline-block;
	line-height: 40px;
	margin-left: 30px;
	margin-top: 15px;
}

a.nav-link {
	text-decoration: none;
	font-size: 28px;
	font-style: bold;
	font-family: sans-serif;
	font-weight: 500;
	cursor: pointer;
	position: relative;
	color: #3A1C12;
}

@
keyframes FadeIn { 0% {
	opacity: 0;
	-webkit-transition-duration: 0.8s;
	transition-duration: 0.8s;
	-webkit-transform: translateY(-10px);
	-ms-transform: translateY(-10px);
	transform: translateY(-10px);
}

100%
{
opacity




























:














 














1;
-webkit-transform




























:














 














translateY




























(0);
-ms-transform




























:














 














translateY




























(0);
transform




























:














 














translateY




























(0);
pointer-events




























:














 














auto




























;
transition




























:














 














cubic-bezier




























(0
.4
,
0,
0
.2
,
1);
}
}
.nav-list li {
	animation: FadeIn 1s cubic-bezier(0.65, 0.05, 0.36, 1);
	animation-fill-mode: both;
}

.nav-list li:nth-child(1) {
	animation-delay: .3s;
}

.nav-list li:nth-child(2) {
	animation-delay: .6s;
}

.nav-list li:nth-child(3) {
	animation-delay: .9s;
}

.nav-list li:nth-child(4) {
	animation-delay: 1.2s;
}

.nav-list li:nth-child(5) {
	animation-delay: 1.5s;
}

/* Animation */
@
keyframes fadeInUp {from { transform:translate3d(0, 40px, 0)
	
}

to {
	transform: translate3d(0, 0, 0);
	opacity: 1
}

}
@
-webkit-keyframes fadeInUp {from { transform:translate3d(0, 40px, 0)
	
}

to {
	transform: translate3d(0, 0, 0);
	opacity: 1
}

}
.animated {
	animation-duration: 1s;
	animation-fill-mode: both;
	-webkit-animation-duration: 1s;
	-webkit-animation-fill-mode: both
}

.animatedFadeInUp {
	opacity: 0
}

.fadeInUp {
	opacity: 0;
	animation-name: fadeInUp;
	-webkit-animation-name: fadeInUp;
}

#cart {
	color: #3A1C12;
	text-decoration: none;
	font-size: 28px;
	font-style: bold;
	font-family: sans-serif;
	font-weight: 500;
}
</style>
<div>
	<c:choose>
		<c:when test="${sessionScope.userlogin}">
			<nav class="main-navigation">
				<a class="navbar-brand" href="#"><img
					src="${cr}/resources/images/logo.png" alt=" " width="100px"></a>
				<ul class="nav-list">
					<li class="nav-list-item"><a href="${cr}/home"
						class="nav-link">Home</a></li>
					<li class="nav-list-item"><a href="${cr}/allproductpage"
						class="nav-link">All Product</a></li>
						<li class="nav-list-item"><a href="${cr}/login"
						class="nav-link">Login</a></li>
						
					<li class="nav-list-item"><a href="" class="nav-link">
							Welcome!${loginname}</a></li>
					<li class="nav-list-item"><a href="${cr}/user/viewcart"
						id="cart"><i class="fa fa-shopping-cart"></i> Cart <span
							class="badge">${sessionScope.itemcount}</span></a></li>

					<li class="nav-list-item"><a href="${cr}/logout"
						class="nav-link"> Logout</a></li>
				</ul>
			</nav>
		</c:when>
		<c:when test="${sessionScope.Adminlogin}">
			<nav class="main-navigation">
				<a class="navbar-brand" href="#"><img
					src="${cr}/resources/images/logo.png" alt=" " width="100px"></a>
				<ul class="nav-list">

					<li class="nav-list-item"><a href="${cr}/home"
						class="nav-link">Home</a></li>
					<li class="nav-list-item"><a href="${cr}/admin/category"
						class="nav-link">Category</a></li>
						<li class="nav-list-item"><a href="${cr}/login"
						class="nav-link">Login</a></li>
					<li class="nav-list-item"><a href="" class="nav-link">
					Welcome!{loginname}</a></li>
							<li class="nav-list-item"><a href="${cr}/logout"
						class="nav-link"> Logout</a></li>

				</ul>
			</nav>
		</c:when>
		<c:when test="${sessionScope.supplierlogin}">
			<nav class="main-navigation">
				<a class="navbar-brand" href="#"><img
					src="${cr}/resources/images/logo.png" alt=" " width="100px"></a>
				<ul class="nav-list">
					<li class="nav-list-item"><a href="${cr}/supplier/product"
						class="nav-link"> Product</a></li>
						<li class="nav-list-item"><a href="${cr}/login"
						class="nav-link">Login</a></li>
					<li class="nav-list-item"><a href="" class="nav-link">Welcome!
							${loginname}</a></li>
							<li class="nav-list-item"><a href="${cr}/logout"
						class="nav-link"> Logout</a></li>
				</ul>
			</nav>
		</c:when>
		<c:otherwise>
			<nav class="main-navigation">
				<a class="navbar-brand" href="#"><img
					src="${cr}/resources/images/logo.png" alt="" width="100px"></a>
				<ul class="nav-list">
					<li class="nav-list-item"><a href="${cr}/home"
						class="nav-link">Home</a></li>
					<li class="nav-list-item"><a href="${cr}/register"
						class="nav-link">Register</a></li>
					<li class="nav-list-item"><a href="${cr}/login"
						class="nav-link">Login</a></li>
					<li class="nav-list-item"><a href="${cr}/rsupplier"
						class="nav-link">Supplier Register</a></li>
					<li class="nav-list-item"><a href="${cr}/allproductpage"
						class="nav-link">All Product</a></li>
						
				</ul>

			</nav>
		</c:otherwise>
	</c:choose>
</div>