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
    <title>Заказы | FootwearShop</title>
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
    <style>
        table {
            width: 90%; /* Ширина таблицы */
            /*border: 1px solid green; !* Рамка вокруг таблицы *!*/
            margin: auto; /* Выравниваем таблицу по центру окна  */
        }
        th{
            text-align: center; /* Выравниваем текст по центру ячейки */
        }
        td {
            text-align: center; /* Выравниваем текст по центру ячейки */
        }
    </style>
</head><!--/head-->

<body>
<header id="header"><!--header-->
    <jsp:include page="/WEB-INF/views/template/header.jsp"/>
</header><!--/header-->
    <%--<table style="width: 90%; ">--%>
<section>
    <div class="container">
        <div class="row">

            <div class="breadcrumbs">
                <ol class="breadcrumb">
                    <li><a href="<c:url value="/admin"/>">Админпанель</a></li>
                    <li class="active">Управление заказами</li>
                </ol>
            </div>

            <table>
                <caption><h3 style="color:#237efe">Таблица заказов</h3></caption>
                <tr>
                    <th>Номер заказа</th>
                    <th>Дата заказа</th>
                    <th>Сумма заказа</th>
                    <th>Имя</th>
                    <th>Фамилия</th>
                    <th>Телефон</th>
                    <th>Email</th>
                    <th>Статус</th>
                    <th></th>
                    <th></th>
                    <th></th>
                </tr>
                <c:forEach items="${order}" var="order">
                    <tr>
                        <%--<td>${order.id}</td>--%>
                        <td>
                            <a href="<c:url value="/admin/order/view/${order.id}"/> ">
                                ${order.id}
                            </a>
                        </td>
                        <td>${order.date}</td>
                        <td>${order.finalPrice}</td>
                        <td>${order.name}</td>
                        <td>${order.surname}</td>
                        <td>${order.phone}</td>
                        <td>${order.email}</td>
                        <td>${order.status}</td>
                        <form action="<c:url value="/admin/order/changeStatus"/>" method="post">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            <input type="hidden" name="id" value="${order.id}"/>
                            <td>
                                <select name="changedStatus">
                                    <c:forEach items="${statuses}" var="statusEnum">
                                        <option>${statusEnum.status}</option>
                                    </c:forEach>
                                </select>
                            </td>
                            <td><button type="submit" class="btn btn-primary">Изменить статус</button></td>
                        </form>
                        <td><a href="<c:url value="/admin/order/view/${order.id}"/>" title="Смотреть"><i class="fa fa-eye"></i></a></td>
                        <%--<td><a href="<c:url value="/admin/order/update/${order.id}"/>" title="Редактировать"><i class="fa fa-pencil-square-o"></i></a></td>--%>
                        <td><a href="<c:url value="/admin/order/delete/${order.id}"/>" title="Удалить"><i class="fa fa-times"></i></a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</section>
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