<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="template/header.jsp"%>


<div class="container-fluid background-blond-grey" style="min-height: 600px">
    <div class="row centered padding-top-15px padding-bottom-20px">
        <div id="headline" class="col-md-10 col-md-offset-1">
            <h3 id="nameOfUser" class="display-i-b col-md-offset-5">${user.username}</h3>
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <div id="adminArea" class="display-i-b float-right">
                    <c:if test="${user.accountNonLocked == true}">
                        <a id="blockUser" class="btn text-danger float-right" onclick="blockUser()">Блокувати користувача</a>
                    </c:if>
                    <c:if test="${user.accountNonLocked == false}">
                        <a id="unblockUser" class="btn text-danger float-right" onclick="unblockUser()">Розблокувати користувача</a>
                    </c:if>
                </div>
            </sec:authorize>
            <div id="editArea" class="display-i-b float-right">
            </div>
        </div>

        <div class="col-md-10 col-md-offset-1 padding-0-15px">
            <div id="mainCharacteristics" class="padding-top-15px padding-left-30px padding-bottom-20px border-radius-45px background-white row">
                <div id="divEmail" class="col-md-10 col-md-offset-1 margin-top-10px padding-5px background-blond-grey border-white border-radius-45px overflow-hidden">
                    <p class="col-md-4 margin-0 background-red color-white border-radius-90px padding-5px text-align-center white-space-nowrap font-size-14px-Lato">Електронна пошта</p>
                    <p id="email" class="col-md-7 padding-left-20px padding-top-5px margin-0 outline-none background-blond-grey font-size-14px-Lato edit">${user.email}</p>
                </div>
                <c:if test="${describeOfUser != null}">
                    <div id="divName" class="col-md-10 col-md-offset-1 margin-top-10px padding-5px background-blond-grey border-white border-radius-45px overflow-hidden">
                        <p class="col-md-4 margin-0 background-red color-white border-radius-90px padding-5px text-align-center white-space-nowrap font-size-14px-Lato">Ім'я</p>
                        <p id="name" class="col-md-7 padding-left-20px padding-top-5px margin-0 outline-none background-blond-grey font-size-14px-Lato edit">${describeOfUser.name}</p>
                    </div>
                    <div id="divSurname" class="col-md-10 col-md-offset-1 margin-top-10px padding-5px background-blond-grey border-white border-radius-45px overflow-hidden">
                        <p class="col-md-4 margin-0 background-red color-white border-radius-90px padding-5px text-align-center white-space-nowrap font-size-14px-Lato">Прізвище</p>
                        <p id="surname" class="col-md-7 padding-left-20px padding-top-5px margin-0 outline-none background-blond-grey font-size-14px-Lato edit">${describeOfUser.surname}</p>
                    </div>
                    <div id="divPhone" class="col-md-10 col-md-offset-1 margin-top-10px padding-5px background-blond-grey border-white border-radius-45px overflow-hidden">
                        <p class="col-md-4 margin-0 background-red color-white border-radius-90px padding-5px text-align-center white-space-nowrap font-size-14px-Lato">Номер телефону</p>
                        <p id="phone" class="col-md-7 padding-left-20px padding-top-5px margin-0 outline-none background-blond-grey font-size-14px-Lato edit">${describeOfUser.phone}</p>
                    </div>
                    <div id="divCountry" class="col-md-10 col-md-offset-1 margin-top-10px padding-5px background-blond-grey border-white border-radius-45px overflow-hidden">
                        <p class="col-md-4 margin-0 background-red color-white border-radius-90px padding-5px text-align-center white-space-nowrap font-size-14px-Lato">Країна</p>
                        <p id="country" class="col-md-7 padding-left-20px padding-top-5px margin-0 outline-none background-blond-grey font-size-14px-Lato edit">${describeOfUser.country}</p>
                    </div>
                    <div id="divCity" class="col-md-10 col-md-offset-1 margin-top-10px padding-5px background-blond-grey border-white border-radius-45px overflow-hidden">
                        <p class="col-md-4 margin-0 background-red color-white border-radius-90px padding-5px text-align-center white-space-nowrap font-size-14px-Lato">Місто</p>
                        <p id="city" class="col-md-7 padding-left-20px padding-top-5px margin-0 outline-none background-blond-grey font-size-14px-Lato edit">${describeOfUser.city}</p>
                    </div>
                    <div id="divZipCode" class="col-md-10 col-md-offset-1 margin-top-10px padding-5px background-blond-grey border-white border-radius-45px overflow-hidden">
                        <p class="col-md-4 margin-0 background-red color-white border-radius-90px padding-5px text-align-center white-space-nowrap font-size-14px-Lato">Поштовий індекс</p>
                        <p id="zipCode" class="col-md-7 padding-left-20px padding-top-5px margin-0 outline-none background-blond-grey font-size-14px-Lato edit">${describeOfUser.zipCode}</p>
                    </div>
                </c:if>
            </div>
            <c:if test="${describeOfUser != null}">
                <div id="divForfacebookURL" class="padding-top-30px padding-bottom-20px row">
                    <a id="facebookURL" href="${describeOfUser.facebookURL}" class="col-md-4 col-md-offset-4 btn border-radius-90px background-red color-white hover-back-gren outline-none edit">Сторінка в facebook</a>
                </div>
            </c:if>
            <div id="plumbWhichBoughtByUser" class="hide margin-top-10px padding-5-15-0-15px background-white overflow-hidden border-radius-45px row">
                <h3 class="text-align-center padding-bottom-20px">Придбані лоти</h3>
                <div id="boughtPlumbs" class="col-md-12">
                    <c:forEach items="${plumbWhichBoughtByUser}" var="plumb">
                        <c:set var="picture" value="${plumb.picture}"/>
                        <div class="col-xs-6 col-md-3 padding-5-15-0-15px">
                            <a href="/plumb${plumb.id}" class="thumbnail btn padding-0 border-radius-10px overflow-hidden background-blond-grey">
                                <c:forEach items="${picture.picturePhotos}" var="picturePhoto" end="0">
                                    <img src="${picturePhoto.photo}" class="img-responsive width-100prc">
                                </c:forEach>
                                <div class="row caption margin-0 padding-0 display-block height-auto">
                                    <h4 class="hover-cl-gren white-space-pre-wrap padding-bottom-10px padding-top-10px margin-0 color-red">${picture.name}</h4>
                                </div>
                            </a>
                        </div>
                    </c:forEach>
                </div>
            </div>
            <div id="addPlumbArea" class="padding-top-30px padding-bottom-20px row hide">
                <p class="text-align-center">Ви маєте можливість виставляти власний лот на онлайн торги.</p>
                <c:if test="${describeOfUser == null}">
                    <p class="text-align-center">Перед цим вам потрібно заповнити додаткову інформацію про себе.</p>
                    <a id="" href="/describeOfUser${user.username}" class="col-md-4 col-md-offset-4 btn border-radius-90px background-red color-white hover-back-gren outline-none">Заповнити додаткову інформацію</a>
                </c:if>
                <c:if test="${describeOfUser != null}">
                    <a id="createPlumb" href="/createPlumb" class="col-md-4 col-md-offset-4 btn border-radius-90px background-red color-white hover-back-gren outline-none">СТВОРИТИ ЛОТ</a>
                </c:if>
            </div>
            <div id="plumbWhichAddedByUser" class="margin-top-10px padding-5-15-0-15px background-white overflow-hidden border-radius-45px row">
                <h3 class="text-align-center padding-bottom-20px">Лоти додані користувачем ${user.username}</h3>
                <div id="addedPlumbs" class="col-md-12">
                    <c:forEach items="${plumbsWhichAddedByUser}" var="plumb">
                        <c:set var="picture" value="${plumb.picture}"/>
                        <div class="col-xs-6 col-md-3 padding-5-15-0-15px">
                            <a href="/plumb${plumb.id}" class="thumbnail btn padding-0 border-radius-10px overflow-hidden background-blond-grey">
                                <c:forEach items="${picture.picturePhotos}" var="picturePhoto" end="0">
                                    <img src="${picturePhoto.photo}" class="img-responsive width-100prc">
                                </c:forEach>
                                <div class="row caption margin-0 padding-0 display-block height-auto">
                                    <h4 class="hover-cl-gren white-space-pre-wrap padding-bottom-10px padding-top-10px margin-0 color-red">${picture.name}</h4>
                                    <c:if test="${plumb.confirmed == true}">
                                        <c:if test="${plumb.dateOfEnd > currentDate}">
                                            <p class="col-md-6 margin-0 font-size-14px-Lato white-space-pre-wrap">Стартова ціна</p>
                                            <p class="col-md-6 margin-0 font-size-14px-Lato white-space-pre-wrap">Поточна ціна</p>
                                            <p class="col-md-6 font-weight-bold font-size-14px-Lato">${plumb.minPrise} грн</p>
                                            <c:forEach items="${plumb.bets}" var="bet" end="1">
                                                <c:if test="${bet.price > 0}">
                                                    <p class="col-md-6 font-weight-bold font-size-14px-Lato">${bet.price} грн</p>
                                                </c:if>
                                                <c:if test="${bet == null}">
                                                    <p class="col-md-6 font-weight-bold font-size-14px-Lato">${plumb.minPrise} грн</p>
                                                </c:if>
                                            </c:forEach>
                                        </c:if>
                                        <c:if test="${plumb.dateOfEnd < currentDate}">
                                            <p class="col-md-12 margin-0 font-size-14px-Lato white-space-pre-wrap">Продано</p>
                                        </c:if>
                                    </c:if>
                                    <c:if test="${plumb.confirmed == false}">
                                        <p class="col-md-12 margin-0 font-size-14px-Lato white-space-pre-wrap">Не підтверджено</p>
                                    </c:if>
                                </div>

                            </a>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>

    </div>
</div>

<script src="/js/userPage.js"></script>
<%@include file="template/footer.jsp"%>