<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport", content="width=device-width, initial-scale=1">
    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>

    <title>Painting Auction</title>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <%--<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular-route.min.js"></script>--%>

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <!-- Latest compiled and minified JavaScript -->
    <%--<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>--%>

    <link href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.4/css/select2.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="/css/mainStyle.css">
    <link rel="stylesheet" href="/css/additionalStyle.css">
</head>
<body>

<div id="header" class="">
    <nav class="navbar navbar-default" role="navigation">
        <div class="container-fluid height-60px background-dark-grey">
            <div class="row">
                <div class="navbar-header">
                    <!-- <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button> -->
                </div>

                <div id="navResize" class="collapse navbar-collapse padding-0">
                    <ul class="nav navbar-nav">
                        <li class="nav-menu-li margin-5-5-0-5">
                            <a id="mainCategoryButton" role="button" data-toggle="dropdown" class="hover-border-b-red float-left"> Розділи </a>
                        </li>
                        <li class="nav-menu-li margin-5-5-0-5">
                            <a id="authors" href="/allAuthorsPage-0" class="hover-border-b-red"> АВТОРИ </a>
                        </li>
                        <li class="nav-menu-li margin-5-5-0-5">
                            <a id="rules" href="/rules"class="hover-border-b-red"> ПРАВИЛА </a>
                        </li>
                        <li class="nav-menu-li margin-5-5-0-5">
                            <a href="#contacts" class="hover-border-b-red"> КОНТАКТИ </a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </nav>
    <div class="height-90px background-white border-bottom-red-3px">
        <div class="col-md-3 padding-left-30px padding-top-15px">
            <a href="/" class="color-dark-grey">
                <img src="/photo/auction.png" class="height-60px float-left">
                <h2 class="padding-left-10px margin-0 display-i-b">PAINTING</h2><br>
                <h3 class="padding-left-10px margin-0 display-i-b">AUCTION</h3>
            </a>
        </div>
        <div class="col-md-6 margin-top-30px">
            <select class="js-search-multiple col-md-12"
                    multiple="multiple" onchange="window.location.href = this.options[this.selectedIndex].value">
            </select>
        </div>
        <div class="col-md-3 padding-top-30px float-right">
            <sec:authorize access="!isAuthenticated()">
                <div>
                    <a id="login" href="#loginModal" class="padding-0 float-right margin-right-30px color-dark-grey outline-none" data-toggle="modal">
                        <span class="glyphicon glyphicon-log-in padding-0 font-size-30px margin-5-5-0-5"></span>
                    </a>
                    <%@include file="login.jsp"%>
                </div>
                <div>
                    <a id="registration" href="#registrationModal" class="padding-0 float-right margin-right-30px color-dark-grey outline-none" data-toggle="modal">
                        <span class="glyphicon glyphicon-list-alt padding-0 font-size-30px margin-5-5-0-5"></span>
                    </a>
                    <%@include file="registration.jsp"%>
                </div>


            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                <p id="userName" class="hide"><sec:authentication property="principal.username"/></p>
                <a id="exitUser" href="/logout" class="padding-0 float-right margin-right-30px color-dark-grey outline-none">
                    <span class="glyphicon glyphicon-log-out padding-0 font-size-30px margin-5-5-0-5"></span>
                </a>

                <a id="user" class="padding-0 float-right margin-right-30px color-dark-grey outline-none"
                    href= <sec:authorize access="hasRole('ROLE_USER')"> "/userPage<sec:authentication property="principal.username"/>" </sec:authorize> <sec:authorize access="hasRole('ROLE_ADMIN')" var="roleAdmin">"/admin/adminPage"</sec:authorize> >
                    <span class="glyphicon glyphicon-user padding-0 font-size-30px margin-5-5-0-5"></span>
                </a>
            </sec:authorize>
        </div>
    </div>

</div>