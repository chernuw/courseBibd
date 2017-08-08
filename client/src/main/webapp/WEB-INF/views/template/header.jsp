<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--<div class="header_top"><!--header_top-->
	<div class="container">
		<div class="row">
			<div class="col-sm-6 ">
				<div class="contactinfo">
					<ul class="nav nav-pills">
						<li><a href=""><i class="fa fa-phone"></i> +375-25-123-45-67</a></li>
						<li><a href=""><i class="fa fa-envelope"></i> gotovko_roman@tut.by</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</div><!--/header_top-->--%>
		
<div class="header-middle"><!--header-middle-->
	<div class="container">
		<div class="row">
			<div class="col-sm-4">
				<div class="logo pull-left">
					<a href="<c:url value="/index"/>"><img src="<c:url value="/resources/images/logo.png"/>" height="100" width="160" alt="" /></a>
				</div>
			</div>
			<div class="col-sm-8">
				<div class="shop-menu pull-right">
					<ul class="nav navbar-nav">
						<sec:authorize access="hasRole('ADMIN')">
							<li><a href="<c:url value="/admin"/>"><i class="fa fa-user-circle"></i> Админ. раздел</a></li>
						</sec:authorize>

						<li><a href="<c:url value="/cart/view"/> "><i class="fa fa-shopping-cart"></i> Корзина(${cartSize})</a></li>
						<c:if test="${user eq 'anonymousUser'}">
							<li><a href="<c:url value="/login"/>"><i class="fa fa-sign-in"></i> Вход</a></li>
						</c:if>
						<c:if test="${user ne 'anonymousUser'}">
							<li><a href="<c:url value="/profile"/>"><i class="fa fa-user"></i> Аккаунт</a></li>
							<li><a href="<c:url value="/logout" />"><i class="fa fa-sign-out"></i> Выйти [${user}]</a></li>
						</c:if>
					</ul>
				</div>
			</div>
		</div>
	</div>
</div><!--/header-middle-->