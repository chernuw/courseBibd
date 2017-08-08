<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Просмотр заказа | FootwearShop</title>
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
</head>
<body>
<header id="header"><!--header-->
    <jsp:include page="/WEB-INF/views/template/header.jsp"/>
</header><!--/header-->
<section>
<div class="container">
    <div class="row">

        <br/>

        <div class="breadcrumbs">
            <ol class="breadcrumb">
                <li><a href="<c:url value="/admin"/>">Админпанель</a></li>
                <li><a href="<c:url value="/admin/order"/>">Управление заказами</a></li>
                <li class="active">Просмотр заказа</li>
            </ol>
        </div>


        <h4>Просмотр заказа #${order.id} </h4>
        <br/>



    <%--TODO: добавить линк на товар (переход на страницу товара) и клиента--%>
        <h5>Информация о заказе</h5>
        <table class="table-admin-small table-bordered table-striped table">
            <tr>
                <td>Номер заказа</td>
                <td>${order.id}</td>
            </tr>
            <tr>
                <td>Дата заказа</td>
                <td>${order.date}</td>
            </tr>
            <tr>
                <td>Сумма заказа</td>
                <td>${order.finalPrice}</td>
            </tr>
            <tr>
                <td>ФИО клиента</td>
                <td>${order.name} ${order.surname}</td>
            </tr>
            <tr>
                <td>Телефон клиента</td>
                <td>${order.phone}</td>
            </tr>
            <tr>
                <td>Email клиента</td>
                <td>${order.email}</td>
            </tr>
            <%--<tr>--%>
                <%--<td>Комментарий клиента</td>--%>
                <%--<td><?php echo $order['user_comment']; ?></td>--%>
            <%--</tr>--%>
            <c:if test="${order.user ne 'NULL'}">
                <tr>
                    <td>ID клиента</td>
                    <td>${order.user.id}</td>
                </tr>
            </c:if>
            <tr>
                <td>Статус заказа</td>
                <td>${order.status}</td>
            </tr>
        </table>

        <h5>Товары в заказе</h5>

        <table class="table-admin-medium table-bordered table-striped table ">
            <tr>
                <th>ID товара</th>
                <th>Производитель</th>
                <th>Название</th>
                <th>Цена</th>
                <th>Количество</th>
            </tr>
            <c:forEach items="${sales}" var="sale">
            <tr>
                <td>${sale.footwear.id}</td>
                <td>${sale.footwear.manufacturer.name}</td>
                <td>${sale.footwear.name}</td>
                <td>${sale.footwear.price}</td>
                <td>${sale.amount}</td>
            </tr>
            </c:forEach>
        </table>


        <a href="<c:url value="/admin/order"/>" class="btn btn-default back"><i class="fa fa-arrow-left"></i> Назад</a>
    </div>
</div>
</section>

<script src="<c:url value="/resources/js/jquery.js"/>"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="/resources/js/jquery.scrollUp.min.js"/>"></script>
<script src="<c:url value="/resources/js/jquery.prettyPhoto.js"/>"></script>
<script src="<c:url value="/resources/js/main.js"/>"></script>
</body>
</html>
