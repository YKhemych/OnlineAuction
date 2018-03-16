<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport", content="width=device-width, initial-scale=1">
    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>

    <title>Title</title>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <%--<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular-route.min.js"></script>--%>

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <!-- Latest compiled and minified JavaScript -->
    <%--<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>--%>

    <link href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.4/css/select2.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="/css/mainStyle.css">
    <link rel="stylesheet" href="/css/additionalStyle.css">
</head>
<body>
<%--<nav class="navbar navbar-default" role="navigation">--%>
    <%--<div class="container-fluid background-white">--%>
        <%--<div class="row">--%>
            <%--<div class="col-md-10 col-md-offset-1 row max-width-">--%>

                <%--<div class="navbar-header">--%>
                    <%--<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">--%>
                        <%--<!-- <span class="sr-only">Навигация</span> -->--%>
                        <%--<span class="icon-bar"></span>--%>
                        <%--<span class="icon-bar"></span>--%>
                        <%--<span class="icon-bar"></span>--%>
                    <%--</button>--%>
                    <%--<a href="/" class="navbar-brand ">Аукціон</a>--%>
                <%--</div>--%>

                <%--<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">--%>

                    <%--<ul class="nav navbar-nav navbar-right">--%>
                        <%--<sec:authorize access="!isAuthenticated()">--%>
                            <%--<li class="nav-menu-li">--%>
                                <%--<a href="" class="padding-0 " data-toggle="modal" data-target="#regictration">--%>
                                    <%--<span class="glyphicon glyphicon-list-alt col-md-3 padding-0 height-20px"></span>--%>
                                    <%--<p class="col-md-9 padding-0-10px height-20px">Реєстрація</p>--%>
                                <%--</a>--%>
                                <%--<%@include file="registration.jsp"%>--%>
                            <%--</li>--%>
                            <%--<li class="nav-menu-li">--%>
                                <%--<a href="" class="" data-toggle="modal" data-target="#login">--%>
                                    <%--<span class="glyphicon glyphicon-log-in col-md-3 padding-0"></span>--%>
                                    <%--<p class="col-md-9 padding-0-10px">Увійти</p>--%>
                                <%--</a>--%>
                                <%--<%@include file="login.jsp"%>--%>
                            <%--</li>--%>
                        <%--</sec:authorize>--%>
                        <%--<sec:authorize access="isAuthenticated()">--%>
                            <%--<li class="nav-menu-li">--%>
                                <%--<a href= <sec:authorize access="hasRole('ROLE_USER')"> "/userPage" </sec:authorize> <sec:authorize access="hasRole('ROLE_ADMIN')" var="roleAdmin">"/admin/adminPage"</sec:authorize> >--%>
                                    <%--<span class="glyphicon glyphicon-user col-md-3 padding-0"></span>--%>
                                    <%--<p id="registeredUserName" class="col-md-9 padding-0-10px"><sec:authentication property="principal.username" /></p>--%>
                                <%--</a>--%>
                            <%--</li>--%>
                            <%--<li class="nav-menu-li">--%>
                                <%--<a id="exitUser" href="/logout">--%>
                                    <%--<span class="glyphicon glyphicon-log-out col-md-3 padding-0"></span>--%>
                                    <%--<p class="col-md-9 padding-0-10px">Вийти</p>--%>
                                <%--</a>--%>
                            <%--</li>--%>
                        <%--</sec:authorize>--%>
                    <%--</ul>--%>
                <%--</div>--%>

                <%--<div>--%>
                    <%--<div class="dropdown float-left">--%>
                        <%--<a id="mainCategoryButton" role="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown">--%>
                            <%--Категорії <span class="caret"></span>--%>
                        <%--</a>--%>

                    <%--</div>--%>


                    <%--<div class="input-group navbar-right col-md-6">--%>
                        <%--<input type="text" class="form-control border-red background-white padding-left-20px" >--%>
                        <%--<select class="js-example-basic-multiple form-control"--%>
                                <%--multiple="multiple" onchange="window.location.href = this.options[this.selectedIndex].value">--%>
                        <%--</select>--%>
                    <%--</div>--%>
                <%--</div>--%>

            <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</nav>--%>


<div id="header">
    <nav class="navbar navbar-default" role="navigation">
        <div class="container-fluid height-60px background-dark-grey">
            <div class="row">
                <div class="col-md-6 col-md-offset-3">
                    <div class="navbar-header">
                        <!-- <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button> -->
                    </div>

                    <div class="">
                        <ul class="nav navbar-nav">
                            <li class="nav-menu-li margin-5-5-0-5">
                                <a id="main" href="" class="hover-border-b-red"> ГОЛОВНА </a>
                            </li>
                            <li class="nav-menu-li margin-5-5-0-5">
                                <a id="mainCategoryButton" role="button" data-toggle="dropdown" class="hover-border-b-red float-left"> Розділи </a>
                            </li>
                            <%--<li class="nav-menu-li margin-5-5-0-5">--%>
                                <%--<a id="features" href="" data-toggle="modal" > Як ЦЕ ПРАЦЮЄ </a>--%>
                            <%--</li>--%>
                            <li class="nav-menu-li margin-5-5-0-5">
                                <a id="galery" href="" class="hover-border-b-red"> ГАЛЕРЕЯ </a>
                            </li>
                            <li class="nav-menu-li margin-5-5-0-5">
                                <a id="subscription" href=""class="hover-border-b-red"> АБОНЕМЕНТ </a>
                            </li>
                            <li class="nav-menu-li margin-5-5-0-5">
                                <a id="contacts" href="" class="hover-border-b-red"> КОНТАКТИ </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </nav>
    <div class="height-90px background-white border-bottom-red-3px">
        <div class="col-md-3 padding-left-30px padding-top-15px">
            <a href="/" class="color-dark-grey">
                <img src="/photo/auction.png" class="height-60px float-left">
                <h2 class="padding-left-10px margin-0 display-i-b">ONLINE</h2><br>
                <h3 class="padding-left-10px margin-0 display-i-b">AUCTION</h3>
            </a>
        </div>
        <div class="col-md-6 padding-top-30px">
            <input type="text" name="search" class="col-md-12 border-dark-grey font-size-20px padding-5px border-radius-45px padding-left-20px outline-none" autocomplete="off" style="">
        </div>
        <div class="col-md-3 padding-top-30px float-right">
            <sec:authorize access="!isAuthenticated()">
                <div>
                    <a id="login" href="#loginModal" class="padding-0 float-right margin-right-30px color-dark-grey" data-toggle="modal">
                        <span class="glyphicon glyphicon-log-in padding-0 font-size-30px margin-5-5-0-5"></span>
                    </a>
                    <%@include file="login.jsp"%>
                </div>
                <div>
                    <a id="registration" href="#registrationModal" class="padding-0 float-right margin-right-30px color-dark-grey" data-toggle="modal">
                        <span class="glyphicon glyphicon-list-alt padding-0 font-size-30px margin-5-5-0-5"></span>
                    </a>
                    <%@include file="registration.jsp"%>
                </div>


            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                <a id="exitUser" href="/logout" class="padding-0 float-right margin-right-30px color-dark-grey">
                    <span class="glyphicon glyphicon-log-out padding-0 font-size-30px margin-5-5-0-5"></span>
                </a>

                <a id="user" class="padding-0 float-right margin-right-30px color-dark-grey"
                    href= <sec:authorize access="hasRole('ROLE_USER')"> "/userPage" </sec:authorize> <sec:authorize access="hasRole('ROLE_ADMIN')" var="roleAdmin">"/admin/adminPage"</sec:authorize> >
                    <span class="glyphicon glyphicon-user padding-0 font-size-30px margin-5-5-0-5"></span>
                </a>
            </sec:authorize>
        </div>
    </div>

</div>