<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:set var="cr" value="${pageContext.request.contextPath}" />

<style type="text/css">
/*
	** Style Simple Ecommerce Theme for Bootstrap 4
	** Created by T-PHP https://t-php.fr/43-theme-ecommerce-bootstrap-4.html
	*/
.bloc_left_price {
	color: #c01508;
	text-align: center;
	font-weight: bold;
	font-size: 150%;
}

.category_block li:hover {
	background-color: #007bff;
}

.category_block li:hover a {
	color: #ffffff;
}

.category_block li a {
	color: #343a40;
}

.add_to_cart_block .price {
	color: #c01508;
	text-align: center;
	font-weight: bold;
	font-size: 200%;
	margin-bottom: 0;
}

.add_to_cart_block .price_discounted {
	color: #343a40;
	text-align: center;
	text-decoration: line-through;
	font-size: 140%;
}

.product_rassurance {
	padding: 10px;
	margin-top: 15px;
	background: #ffffff;
	border: 1px solid #6c757d;
	color: #6c757d;
}

.product_rassurance .list-inline {
	margin-bottom: 0;
	text-transform: uppercase;
	text-align: center;
}

.product_rassurance .list-inline li:hover {
	color: #343a40;
}

.reviews_product .fa-star {
	color: gold;
}

.pagination {
	margin-top: 20px;
}

#over img {
	margin-left: auto;
	margin-right: auto;
	display: block;
}
</style>

<div class="container mb-4">
	<c:if test="${empty cartitems}">
		<div class="row">
			<div class="col-12">
				<div id="over" style="position: absolute; width: 100%; height: 100%">
					<img data-u="image"
						src="https://i0.wp.com/pngimage.net/wp-content/uploads/2018/05/empty-cart-png.png"
						alt=" ">
				</div>
			</div>
		</div>

	</c:if>
	<c:if test="${!empty cartitems}">
		<div class="row">
			<div class="col-12">
				<div class="table-responsive">


					<table class="table table-striped">
						<thead>
							<tr>
								<th scope="col"></th>
								<th scope="col">Product</th>
								<th scope="col">Available</th>
								<th scope="col" class="text-center">Quantity</th>
								<th scope="col" class="text-right">Price</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${cartitems}" var="cart">
								<tr>
									<td><img src="${cr}/resources/pimages/${cart.product.product_id}.jpg" height="50px" />
									</td>
									<td>${cart.product.product_name}</td>
									<td>In stock</td>
									<td><input class="form-control" type="text" value="${cart.quantity}" /></td>
									<td class="text-right">${cart.sub_Total}</td>
									<td class="text-right"><a
											class="btn btn-sm btn-danger" href="${cr}/user/deleteitem?catid=${cart.item_id}">
											<i class="fa fa-trash"></i>
										</a></td>
								</tr>
							</c:forEach>
					</table>
				</div>
			</div>
			<div class="col mb-2">
				<div class="row">
					<div class="col-sm-12  col-md-6">
						<a href="${cr}/allproductpage" class="btn btn-block btn-light">Continue Shopping</a>
					</div>
					<div class="col-sm-12 col-md-6 text-right">
						<a  href="${cr}/user/address"class="btn btn-lg btn-block btn-success text-uppercase">Checkout</a>
					</div>

				</div>
			</div>
		</div>
	</c:if>
</div>


