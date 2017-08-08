<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="springform" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Обновить ${footwear.manufacturer.name} ${footwear.name} | FootwearShop</title>
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


            <h4>Редактировать товар #${footwear.id}</h4>

            <br/>

            <div class="row login-form">
                <%--<springform:form modelAttribute="prod" action="/admin/product/updateProduct" method="post" enctype="multipart/form-data">--%>
                <springform:form action="/admin/product/update/${footwear.id}/updateProduct" method="post" enctype="multipart/form-data">
                    <div class="col-lg-4 col-lg-offset-1">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <input type="hidden" name="id" value="${footwear.id}"/>
                        <p>Название товара</p>
                        <input type="text" name="name" placeholder="" value="${footwear.name}">

                        <br>
                        <p>Производитель</p>
                        <select name="manufacturer">
                            <c:forEach items="${manufacturer}" var="manufacturer">
                                <c:choose>
                                    <c:when test="${manufacturer.name eq footwear.manufacturer.name}">
                                        <option selected value="${manufacturer.name}">${manufacturer.name}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option>${manufacturer.name}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>

                        <br><br>
                        <p>Тип обуви</p>
                        <select name="footwearType">
                            <c:forEach items="${footwearType}" var="footwearType">
                                <c:choose>
                                    <c:when test="${footwearType.name eq footwear.footwearType.name}">
                                        <option selected value="${footwearType.name}">${footwearType.name}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option>${footwearType.name}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>

                        <br><br>
                        <p>Поставщик</p>
                        <select name="provider">
                            <c:forEach items="${provider}" var="provider">
                                <c:choose>
                                    <c:when test="${provider.name eq footwear.provider.name}">
                                        <option selected value="${provider.name}">${provider.name}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option>${provider.name}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>

                        <br><br>
                        <p>Пол</p>
                        <select name="sex">
                            <c:forEach items="${sex}" var="sex">
                                <c:choose>
                                    <c:when test="${sex.name eq footwear.sex.name}">
                                        <option selected value="${sex.name}">${sex.name}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option>${sex.name}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>

                        <br><br>
                        <p>Цвет</p>
                        <select name="color">
                            <c:forEach items="${color}" var="color">
                                <c:choose>
                                    <c:when test="${color.name eq footwear.color.name}">
                                        <option selected value="${color.name}">${color.name}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option>${color.name}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>

                        <br><br>
                        <p>Фиксация</p>
                        <select name="fixation">
                            <c:forEach items="${fixation}" var="fixation">
                                <c:choose>
                                    <c:when test="${fixation.name eq footwear.fixation.name}">
                                        <option selected value="${fixation.name}">${fixation.name}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option>${fixation.name}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>

                        <br><br>
                        <p>Материал</p>
                        <select name="material">
                            <c:forEach items="${material}" var="material">
                                <c:choose>
                                    <c:when test="${material.name eq footwear.material.name}">
                                        <option selected value="${material.name}">${material.name}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option>${material.name}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>

                        <%--TODO: добавить валидацию на цену (не менее 0)--%>
                        <br><br>
                        <p>Стоимость</p>
                        <input type="number" min="0" name="price" placeholder="" value="${footwear.price}">

                        <%--<p>Наличие на складе</p>
                        <select name="availability">
                            <option value="1" <?php if ($product['availability'] == 1) echo ' selected="selected"'; ?>>Да</option>
                            <option value="0" <?php if ($product['availability'] == 0) echo ' selected="selected"'; ?>>Нет</option>
                        </select>

                        <br/><br/>

                        <p>Новинка</p>
                        <select name="is_new">
                            <option value="1" <?php if ($product['is_new'] == 1) echo ' selected="selected"'; ?>>Да</option>
                            <option value="0" <?php if ($product['is_new'] == 0) echo ' selected="selected"'; ?>>Нет</option>
                        </select>

                        <br/><br/>

                        <p>Рекомендуемые</p>
                        <select name="is_recommended">
                            <option value="1" <?php if ($product['is_recommended'] == 1) echo ' selected="selected"'; ?>>Да</option>
                            <option value="0" <?php if ($product['is_recommended'] == 0) echo ' selected="selected"'; ?>>Нет</option>
                        </select>

                        <br/><br/>

                        <p>Статус</p>
                        <select name="status">
                            <option value="1" <?php if ($product['status'] == 1) echo ' selected="selected"'; ?>>Отображается</option>
                            <option value="0" <?php if ($product['status'] == 0) echo ' selected="selected"'; ?>>Скрыт</option>
                        </select>

                        <br/><br/>--%>
                    </div>
                    <div class="col-lg-6 col-lg-offset-1">
                        <p>Изображение товара</p>
                        <div class="view-product">
                            <img src="<c:url value="/image/${footwear.id}"/>" alt="" />
                        </div>
                        <%--<img src="${footwear.image}" width="200" alt="" />--%>
                        <input type="file" accept="image/*" name="image"  placeholder="">

                        <br>

                        <p>Детальное описание</p>
                        <textarea name="description" rows="10">${footwear.description}</textarea>
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