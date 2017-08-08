<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
	<div class="col-sm-3">
		<div class="left-sidebar">
			<h2>Категории</h2>
			<div class="panel-group category-products" id="accordian">
				<!--type footwears-->
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4 class="panel-title">
							<a href="/index">Вся обувь</a>
						</h4>
					</div>
				</div>
				<c:forEach items="${footweartypes}" var="footwearType">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
								<a href="<c:url value="/footwearType/${footwearType.id}"/>">${footwearType.name}</a>
							</h4>
						</div>
					</div>
				</c:forEach>
			</div>
			<!--/type footwears-->

			<div class="brands_products">
				<!--counfootwearsteas-->
				<h2>Производители</h2>
				<div class="brands-name">
					<ul class="nav nav-pills nav-stacked">
						<c:forEach items="${manufacturers}" var="manufacturer">
							<li>
								<a href="<c:url value="/manufacturer/${manufacturer.id}"/>">${manufacturer.name}</a>
							</li>
						</c:forEach>
					</ul>
				</div>
			</div>
			<!--/counfootwearsteas-->
		</div>
	</div>