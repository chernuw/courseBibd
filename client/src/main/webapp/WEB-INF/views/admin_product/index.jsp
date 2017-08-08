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
    <title>Товары | FootwearShop</title>
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

            <br/>

            <div class="breadcrumbs">
                <ol class="breadcrumb">
                    <li><a href="<c:url value="/admin"/>">Админпанель</a></li>
                    <li class="active">Управление товарами</li>
                </ol>
            </div>

            <a href="<c:url value="/admin/product/create"/>" class="btn btn-default back"><i class="fa fa-plus"></i> Добавить товар</a>

            <h4>Список товаров</h4>

            <br/>

            <%--TODO: разобраться с выборкой(выводит снчала чётные, потом нечётные ИД товаров)--%>
            <table>
                <tr>
                    <th>ID товара</th>
                    <th>Производитель</th>
                    <th>Название товара</th>
                    <th>Пол</th>
                    <th>Тип</th>
                    <th>Цена</th>
                    <th></th>
                    <th></th>
                    <th></th>
                </tr>
                <c:forEach items="${footwear}" var="footwear">
                <tr>
                    <td>
                        <a href="<c:url value="/admin/order/view/${footwear.id}"/> " target="_blank">
                            ${footwear.id}
                        </a>
                    </td>
                    <td>${footwear.manufacturer.name}</td>
                    <td>${footwear.name}</td>
                    <td>${footwear.sex.name}</td>
                    <td>${footwear.footwearType.name}</td>
                    <td>${footwear.price}</td>
                    <td><a href="<c:url value="/footwear-details/${footwear.id}"/>" target="_blank" title="Смотреть"><i class="fa fa-eye"></i></a></td>
                    <td><a href="<c:url value="/admin/product/update/${footwear.id}"/>" title="Редактировать"><i class="fa fa-pencil-square-o"></i></a></td>
                    <td><a href="<c:url value="/admin/product/delete/${footwear.id}"/>" title="Удалить"><i class="fa fa-times"></i></a></td>
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