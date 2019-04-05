<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
	<jsp:include page="navbar.jsp" />
	<div style="min-height: 400px">

		<c:if test="${slider}">
			<jsp:include page="slider.jsp" />
		</c:if>
		<c:if test="${cartpage}">
			<jsp:include page="cartpage.jsp" />
		</c:if>

		<c:if test="${aboutus}">
			<jsp:include page="aboutus.jsp" />
		</c:if>

		<c:if test="${contactus}">
			<jsp:include page="contactus.jsp" />
		</c:if>

		<c:if test="${register}">
			<jsp:include page="register.jsp" />
		</c:if>

		<c:if test="${login}">
			<jsp:include page="login.jsp" />
		</c:if>

		<c:if test="${catpage}">
			<jsp:include page="category.jsp" />
		</c:if>
		<c:if test="${productpage}">
			<jsp:include page="product.jsp" />
		</c:if>

		<c:if test="${allproductpage}">
			<jsp:include page="allproductpage.jsp" />
		</c:if>

		<c:if test="${supplierpage}">
			<jsp:include page="supplier.jsp" />
		</c:if>
		
		<c:if test="${viewoneproduct}">
			<jsp:include page="viewoneproduct.jsp" />
		</c:if>
			<c:if test="${addresspage}">
			<jsp:include page="address.jsp" />
		</c:if>

			<c:if test="${orderpage}">
			<jsp:include page="order.jsp" />
		</c:if>
	     <c:if test="${receiptpage}">
			<jsp:include page="receipt.jsp" />
		</c:if>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>
