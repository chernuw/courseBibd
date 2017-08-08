<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="springform" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author" content="">
	<title>Корзина | FootwearShop</title>
	<link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet" type="text/css">
	<link href="<c:url value="/resources/css/font-awesome.min.css"/>" rel="stylesheet" type="text/css">
	<link href="<c:url value="/resources/css/prettyPhoto.css"/>" rel="stylesheet" type="text/css">
	<link href="<c:url value="/resources/css/price-range.css"/>" rel="stylesheet" type="text/css">
	<link href="<c:url value="/resources/css/animate.css"/>" rel="stylesheet" type="text/css">
	<link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet" type="text/css">
	<link href="<c:url value="/resources/css/responsive.css"/>" rel="stylesheet" type="text/css">
</head><!--/head-->

<body>
	<header id="header"><!--header-->
		<jsp:include page="/WEB-INF/views/template/header.jsp"/>
	</header><!--/header-->

	<section id="cart_items">
		<div class="container">
			<div class="register-req">
				<p>Заполните пожалуйста информацию для заказа</p>
			</div><!--/register-req-->

			<div class="shopper-informations">
				<div class="row">
					<c:if test="${user ne 'anonymousUser'}">
						<div class="col-sm-3">
							<div class="shopper-info">
								<p>Используйте информацию, заполненную в кабинете пользователя</p>
								<form action="<c:url value="/checkout/loggedOrder"/>" method="post">
									<input type="hidden" name="finalPrice" value="${finalPrice}">
									<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
									<label>Имя</label><input type="text" readonly value="${loggedUser.name}">
									<label>Фамилия</label><input type="text" readonly value="${loggedUser.surname}">
									<label>Телефон</label><input type="text" readonly value="${loggedUser.phone}">
									<label>Email</label><input type="text" readonly value="${loggedUser.email}">

									<input type="submit" value="Продолжить с этими данными" class="btn btn-primary">
								</form>
							</div>
						</div>
						<%--<div class="col-sm-3"><p style="padding-top:200px; padding-left: 50px;">Или</p></div>--%>
						<div class="col-sm-1">
							<h2 class="or">ИЛИ</h2>
						</div>
					</c:if>
					<div class="col-sm-3">
						<div class="shopper-info">
							<p>Введите в форму ниже информацию, необходимую для заказа</p>
							<springform:form commandName="order" action="/checkout/guestOrder" method="post">
								<input type="hidden" name="finalPrice" value="${finalPrice}">
								<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
								<tr>
									<td><label>Имя</label><springform:input path="name"/></td>
									<td><springform:errors path="name" cssClass="error"/></td>
								</tr>
								<br>
								<tr>
									<td><label>Фамилия</label><springform:input path="surname" /></td>
									<td><springform:errors path="surname" cssClass="error" /></td>
								</tr>
								<tr>
									<td><label>Телефон</label><springform:input path="phone"/></td>
									<td><springform:errors path="phone" cssClass="error"/></td>
								</tr>
								<tr>
									<td><label>Email</label><springform:input path="email" /></td>
									<td><springform:errors path="email" cssClass="error" /></td>
								</tr>
								<input type="submit" value="Продолжить с этими данными" class="btn btn-primary">
							</springform:form>
						</div>
					</div>	
				</div>
			</div>
			<div class="review-payment">
				<h2>Итог</h2>
			</div>

			<div class="table-responsive cart_info">
				<table class="table table-condensed">
					<thead>
						<tr class="cart_menu">
							<td class="image">Обувь</td>
							<td class="description"></td>
							<td class="price">Цена</td>
							<td class="quantity">Количество</td>
							<td class="total">Всего</td>
							<td></td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${sales}" var="sale">
							<tr>
								<td class="cart_product">
									<a href="<c:url value="/footwear-details/${sale.footwear.id}"/>"><img src="<c:url value="/image/${sale.footwear.id}"/>" alt=""></a>
								</td>
								<td class="cart_description">
									<h4><a href="">${sale.footwear.name}</a></h4>
								</td>
								<td class="cart_price">
									<p>${sale.footwear.price} руб.</p>
								</td>
								<td class="cart_quantity">
									<div class="cart_quantity_button">
										<input readonly class="cart_quantity_input" type="text" name="quantity" value="${sale.amount}" autocomplete="off" size="2">
									</div>
								</td>
								<td class="cart_total">
									<p class="cart_total_price">${sale.amount * sale.footwear.price} руб.</p>
								</td>
							</tr>
						</c:forEach>
						<tr>
							<td colspan="4">&nbsp;</td>
							<td colspan="2">
								<table class="table table-condensed total-result">
									<tr>
										<td>Сумма</td>
										<td>${finalPrice} руб.</td>
									</tr>
									<tr>
										<td>Скидка</td>
										<td>0 руб.</td>
									</tr>
									<tr class="shipping-cost">
										<td>Доставка</td>
										<td>Самовывоз</td>
									</tr>
									<tr>
										<td>Итоговая цена</td>
										<td><span>${finalPrice} руб.</span></td>
									</tr>
								</table>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</section> <!--/#cart_items-->

	

	<footer id="footer"><!--Footer-->
		<jsp:include page="/WEB-INF/views/template/footer.jsp"/>
	</footer><!--/Footer-->


	<script src="<c:url value="/resources/js/jquery.js"/>"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/resources/js/jquery.scrollUp.min.js"/>"></script>
	<script src="<c:url value="/resources/js/jquery.prettyPhoto.js"/>"></script>
	<script src="<c:url value="/resources/js/main.js"/>"></script>
</body>
</html>