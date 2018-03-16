
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="template/header.jsp"%>


<div class="container-fluid background-white" style="min-height: 600px">
    <div class="row centered padding-top-30px">
        <div class="col-md-2 col-md-offset-1">
            <ul class="text-align-center nav ">
                <li> <button id="main" class="col-md-12 btn margin-top-10px border-radius-90px background-red color-white outline-none hover-back-gren">ГОЛОВНА</button> </li>
                <li> <button id="myPlumbs" class="col-md-12 btn margin-top-10px border-radius-90px background-red color-white outline-none hover-back-gren">МОЇ ЛОТИ</button> </li>
                <li> <button id="createPlumb" class="col-md-12 btn margin-top-10px border-radius-90px background-red color-white outline-none  hover-back-gren">СТВОРИТИ ЛОТ</button> </li>
            </ul>
        </div>
        <div id="worksheet" class="col-md-8">
            <div class="row">
                <div id="mainCharacteristics" class="border-blond-grey padding-top-10px padding-left-20px padding-bottom-10px">
                    <p class="float-right"> <a id="editEmail" class="color-red margin-0-10"> Редагувати </a></p>
                    <p class="float-left margin-0-10"> Логін: </p> <p id="userLogin"><sec:authentication property="principal.username"/></p>
                    <div id="divForEmail">
                        <p class="float-left margin-0-10"> Електронна пошта: </p> <p id="userEmail" class=""> <sec:authentication property="principal.email"/></p>
                    </div>
                    <a id="substitutePassword" class="color-red margin-0-10"> Змінити пароль </a>
                </div>
                <%--<div id="divDeliveryAddress" class="border-blond-grey margin-top-10px padding-left-20px padding-bottom-10px">--%>
                    <%--<h3 class="padding-bottom-10px" >Адреса доставки</h3>--%>
                    <%--<p class="float-left margin-0-10"> Ім'я: </p> <p id="nameOfUser"><sec:authentication property="principal.name"/></p>--%>
                    <%--<p class="float-left margin-0-10"> Прізвище: </p> <p id="surnameOfUser"><sec:authentication property="principal.surname"/></p>--%>
                    <%--<p class="float-left margin-0-10"> Країна/Місто: </p> <p id="countryAndCity"><sec:authentication property="principal.country"/>,<sec:authentication property="principal.city"/></p>--%>
                    <%--<p class="float-left margin-0-10"> Вулиця/Поштовий індекс: </p> <p id="streetAndZipCode"><sec:authentication property="principal.street"/>,<sec:authentication property="principal.zipCode"/></p>--%>
                    <%--<p class="float-left margin-0-10"> Тел: </p> <p id="phoneOfUser"><sec:authentication property="principal.phone"/></p>--%>
                    <%--<a id="editDeliveryAddress" class="color-red margin-0-10"> Редагувати адресу доставки </a>--%>
                <%--</div>--%>


            </div>

        </div>
    </div>
</div>

<script src="/js/userPage.js"></script>
<%@include file="template/footer.jsp"%>