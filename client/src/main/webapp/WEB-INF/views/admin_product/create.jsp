<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="springform" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Добавление товара | FootwearShop</title>
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
                    <li><a href="<c:url value="/admin/product"/>">Управление товарами</a></li>
                    <li class="active">Редактировать товар</li>
                </ol>
            </div>


            <h4>Добавить новый товар</h4>

            <br/>

            <div class="row login-form">
                    <%--<springform:form action="/admin/product/create/createProduct" modelAttribute="prodCreate"  method="post" enctype="multipart/form-data">--%>
                    <springform:form action="/admin/product/create/createProduct" modelAttribute="prodCreate"  method="post" >
                        <div class="col-lg-4 col-lg-offset-1">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                            <springform:input path="name" placeholder="Название товара"/>
                            <springform:errors path="name" cssClass="error"/>
                            <%--<p>Название товара</p>
                            <input type="text" name="name" placeholder="" value="${footwear.name}">--%>
                            <br>
                            <p>Производитель</p>
                            <springform:select path="manufacturer" itemLabel="name"  items="${manufacturer}"/>

                            <br><br>
                            <p>Тип обуви</p>
                            <springform:select path="footwearType" itemLabel="name" items="${footwearType}"/>

                            <br><br>
                            <p>Поставщик</p>
                            <springform:select path="provider" itemLabel="name" items="${provider}"/>

                            <br><br>
                            <p>Пол</p>
                            <springform:select path="sex" itemLabel="name" items="${sex}"/>

                            <br><br>
                            <p>Цвет</p>
                            <springform:select path="color" itemLabel="name" items="${color}"/>

                            <br><br>
                            <p>Фиксация</p>
                            <springform:select path="fixation" itemLabel="name" items="${fixation}"/>

                            <br><br>
                            <p>Материал</p>
                            <springform:select path="material" itemLabel="name" items="${material}"/>

                            <%--TODO: добавить валидацию на цену (не менее 0)--%>
                            <br><br>
                            <p>Стоимость</p>
                            <springform:input path="price"  placeholder="Цена"/>
                            <%--<input type="number" min="0" name="price" placeholder="" value="${footwear.price}">--%>

                        </div>
                        <div class="col-lg-6 col-lg-offset-1">
                            <%--<p>Изображение товара</p>


                            <div class="view-product">
                                <img src="<c:url value="/image/${footwear.id}"/>" alt="" />
                            </div>
                            <img src="${footwear.image}" width="200" alt="" />
                            <input type="file" accept="image/*" name="image"  placeholder=""/>--%>

                            <br>

                            <p>Детальное описание</p>
                            <springform:textarea path="description" placeholder="Описание" rows="10"/>
                            <%--<textarea name="description" rows="10">${footwear.description}</textarea>--%>
                        </div>

                        <%--<input type="submit" name="submit" class="btn btn-default" value="Сохранить">--%>
                        <input type="submit" class="btn btn-default" value="Сохранить">
                    </springform:form>
            </div>
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