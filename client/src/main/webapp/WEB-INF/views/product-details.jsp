<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
	<title>${footwear.manufacturer.name} ${footwear.name} | FootwearShop</title>
	<link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet" type="text/css">
	<link href="<c:url value="/resources/css/font-awesome.min.css"/>" rel="stylesheet" type="text/css">
	<link href="<c:url value="/resources/css/prettyPhoto.css"/>" rel="stylesheet" type="text/css">
	<link href="<c:url value="/resources/css/price-range.css"/>" rel="stylesheet" type="text/css">
	<link href="<c:url value="/resources/css/animate.css"/>" rel="stylesheet" type="text/css">
	<link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet" type="text/css">
	<link href="<c:url value="/resources/css/responsive.css"/>" rel="stylesheet" type="text/css">
	<script>
        <%@include file="/resources/js/price-range.js" %>
	</script>
	<style>
		<%@include file="/resources/css/bootstrap.min.css" %>
		<%@include file="/resources/css/font-awesome.min.css" %>
		<%@include file="/resources/css/prettyPhoto.css" %>
		<%@include file="/resources/css/price-range.css" %>
		<%@include file="/resources/css/animate.css" %>
		<%@include file="/resources/css/main.css" %>
		<%@include file="/resources/css/responsive.css" %>
	</style>
</head><!--/head-->

<body>
	<header id="header"><!--header-->
		<jsp:include page="/WEB-INF/views/template/header.jsp"/>
		<jsp:include page="/WEB-INF/views/template/search_form.jsp"/>
	</header>
	<section>
		<div class="container">
			<div class="breadcrumbs">
				<ol class="breadcrumb">
					<li><a href="<c:url value="/home"/>">Каталог</a></li>
					<li><a href="<c:url value="/footwearType/${footwear.manufacturer.id}"/>">${footwear.manufacturer.name}</a></li>
					<li class="active">${footwear.name}</li>
				</ol>
			</div>
			<div class="row">
				<jsp:include page="/WEB-INF/views/template/left_menu.jsp"/>
				<div class="col-sm-9 padding-right">
					<div class="product-details"><!--product-details-->
						<div class="col-sm-5">
							<div class="view-product">
								<img src="<c:url value="/image/${footwear.id}"/>" alt="" />
							</div>

						</div>
						<div class="col-sm-7">
							<div class="product-information"><!--/product-information-->
								<h2>${footwear.name}</h2>
								<span>
									<span>${footwear.price} руб. </span>
									<form action="<c:url value="/cart/addAmount"/>" method="post">
										<label>Количество:</label>
										<input type="hidden" name="id" value="${footwear.id}">
										<input type="hidden" name="url" value="${requestScope['javax.servlet.forward.request_uri']}">
										<input name="amount" type="number" min="1" value="1" max="999">
										<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
										<button class="btn btn-fefault cart" type="submit">Добавить в корзину</button>
									</form>
								</span>
								<p><b>Тип:</b> ${footwear.footwearType.name}</p>
								<p><b>Материал: </b> ${footwear.material.name}</p>
								<p><b>Производитель:</b> ${footwear.manufacturer.name}</p>
								<p><b>Страна: </b> ${footwear.manufacturer.country.name}</p>
								<p><b>Цвет: </b> ${footwear.color.name}</p>
								<p><b>Фиксация: </b> ${footwear.fixation.name}</p>
								<p><b>Пол:</b> ${footwear.sex.name}</p>
								<p><b>Поставщик: </b> ${footwear.provider.name}</p>
								<p><b>Описание:</b> ${footwear.description}</p>
							</div><!--/product-information-->
						</div>
					</div><!--/product-details-->
					

					<div class="recommended_items"><!--recommended_items-->
						<h2 class="title text-center">Рекомендуемое</h2>
						<div id="recommended-item-carousel" class="carousel slide" data-ride="carousel">
							<div class="carousel-inner">
								<div class="item active">
									<c:forEach items="${recommendedFootwears1}" var="footwear">
										<a href="<c:url value="/footwear-details/${footwear.id}"/>">
											<div class="col-sm-4">
												<div class="product-image-wrapper">
													<div class="single-products">
														<div class="productinfo text-center">
															<img src="/image/${footwear.id}" alt="" />
															<h2>${footwear.price} руб.</h2>
															<p>${footwear.manufacturer.name} ${footwear.name}</p>
															<form action="<c:url value="${pageContext.request.contextPath}/cart/add"/>" method="post">
																<input type="hidden" name="id" value="${footwear.id}">
																<input type="hidden" name="url" value="${requestScope['javax.servlet.forward.request_uri']}">
																<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
																<button class="btn btn-default add-to-cart" type="submit">Добавить в корзину</button>
															</form>
														</div>
													</div>
												</div>
											</div>
										</a>
									</c:forEach>
								</div>
								<div class="item">
									<c:forEach items="${recommendedFootwears2}" var="footwear">
										<a href="<c:url value="/footwear-details/${footwear.id}"/>">
											<div class="col-sm-4">
												<div class="product-image-wrapper">
													<div class="single-products">
														<div class="productinfo text-center">
															<img src="/image/${footwear.id}" alt="" />
															<h2>${footwear.price} руб.</h2>
															<p>${footwear.manufacturer.name} ${footwear.name}</p>
															<form action="<c:url value="${pageContext.request.contextPath}/cart/add"/>" method="post">
																<input type="hidden" name="id" value="${footwear.id}">
																<input type="hidden" name="url" value="${requestScope['javax.servlet.forward.request_uri']}">
																<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
																<button class="btn btn-default add-to-cart" type="submit">Добавить в корзину</button>
															</form>
														</div>
													</div>
												</div>
											</div>
										</a>
									</c:forEach>
								</div>
							</div>
							 <a class="left recommended-item-control" href="#recommended-item-carousel" data-slide="prev">
								<i class="fa fa-angle-left"></i>
							  </a>
							  <a class="right recommended-item-control" href="#recommended-item-carousel" data-slide="next">
								<i class="fa fa-angle-right"></i>
							  </a>			
						</div>
					</div><!--/recommended_items-->
					
				</div>
			</div>
		</div>
	</section>
	<footer id="footer"><!--Footer-->
		<jsp:include page="/WEB-INF/views/template/footer.jsp"/>
	</footer><!--/Footer-->


	<script>
        <%@include file="/resources/js/price-range.js" %>
	</script>
	<script src="<c:url value="/resources/js/jquery.js"/>" type="text/javascript"></script>
	<script src="<c:url value="/resources/js/price-range.js"/>" type="text/javascript"></script>
	<script src="<c:url value="/resources/js/jquery.scrollUp.min.js"/>" type="text/javascript"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js"/>" type="text/javascript"></script>
	<script src="<c:url value="/resources/js/jquery.prettyPhoto.js"/>" type="text/javascript"></script>
	<script src="<c:url value="/resources/js/main.js"/>" type="text/javascript"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/price-range.js"/>"></script>
</body>
</html>