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
    <title>Редактирование профиля | FootwearShop</title>
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

            <div class="col-sm-4 col-sm-offset-4 padding-right">

                <div class="login-form"><!--sign up form-->
                    <h2>Редактирование данных</h2>
                    <input type="hidden" name="user" value="${user}"/>
                    <%--<springform:form  modelAttribute="userUpd" action="/profile/edit" method="post">--%>
                    <springform:form modelAttribute="userEdit" action="/profile/editProfile" method="post">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <springform:input path="username" disabled="true" placeholder="Логин"/>
                        <%--<springform:password path="password" placeholder="Пароль"/>--%>
                        <%--<springform:errors path="password" cssClass="error"/>--%>
                        <springform:input path="name" placeholder="Имя"/>
                        <springform:errors path="name" cssClass="error"/>
                        <springform:input path="surname" placeholder="Фамилия"/>
                        <springform:errors path="surname" cssClass="error"/>
                        <springform:input path="email" placeholder="Email"/>
                        <springform:errors path="email" cssClass="error"/>
                        <springform:input path="phone" placeholder="Телефон"/>
                        <springform:errors path="phone" cssClass="error"/>
                        <input type="submit" value="Сохранить" class="btn btn-default">
                    </springform:form>
                </div><!--/sign up form-->

                <br/>
                <br/>
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