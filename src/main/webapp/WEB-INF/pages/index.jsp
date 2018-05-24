<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="template/header.jsp"%>


<div class="col-md-12 height-550px padding-top-150px ">
    <center>
        <img src="/photo/auction.png" class="height-150px ">
    </center>
    <center>
        <b>
            <p class="font-size-50px padding-top-15px">PAINTING AUCTION</p>
        </b>
    </center>
</div>

<div class="col-md-12 background-white padding-bottom-50px">
    <div class="col-md-10 col-md-offset-1">
        <center>
            <b>
                <p class="font-size-30px margin-top-80px">ЯК ЦЕ ПРАЦЮЄ</p>
            </b>
            <div class="width-100px border-bottom-red-3px"></div>
        </center>
    </div>
    <div class="col-md-10 col-md-offset-1 padding-top-30px">
        <div class="col-md-4">
            <center>
                <div class="hover-back-gren width-150px height-150px background-red border-radius-90px">
                    <img src="/photo/avatar.png" class="height-90px margin-top-30px">
                </div>
            </center>
            <center>
                <div class="padding-top-10px">
                    <h3 class="padding-bottom-10px ">РЕЄСТРАЦІЯ</h3>
                </div>
                <div class="width-50px border-bottom-red-3px"></div>
            </center>
            <center>
                <div>
                    <h5 class="padding-top-10px padding-0-15px color-middel-grey font-size-14px-Lato">Для початку використання нашого аукціону тобі потрібно зареєструватися. Це цілком безплатно!</h5>
                </div>
            </center>
        </div>
        <div class="col-md-4">
            <center>
                <div id="mainPhoto" class="hover-back-gren width-150px height-150px background-red border-radius-90px">
                    <img src="/photo/funds.png" class="height-90px margin-top-30px">
                </div>
            </center>
            <center>
                <div class="padding-top-10px">
                    <h3 class="padding-bottom-10px">СТАВКА</h3>
                </div>
                <div class="width-50px border-bottom-red-3px"></div>
            </center>
            <center>
                <div>
                    <h5 class="padding-top-10px padding-0-15px color-middel-grey font-size-14px-Lato">Ти можеш зробити ставку на будь-який витвір мистецтва прямо після реєстрації.</h5>
                </div>
            </center>
        </div>
        <div class="col-md-4">
            <center>
                <div id="" class="hover-back-gren width-150px height-150px background-red border-radius-90px">
                    <img src="/photo/sell.png" class="height-90px margin-top-30px">
                </div>
            </center>
            <center>
                <div class="padding-top-10px">
                    <h3 class="padding-bottom-10px ">ВИГРАШ</h3>
                </div>
                <div class="width-50px border-bottom-red-3px"></div>
            </center>
            <center>
                <div>
                    <h5 class="padding-top-10px padding-0-15px color-middel-grey font-size-14px-Lato">Легко вигравай в нашому аукціоні і насолоджуйся придбаним витвором мистецтва.</h5>
                </div>
            </center>
        </div>
    </div>
</div>

<div class="col-md-12 background-blond-grey padding-bottom-50px">
    <div class="col-md-10 col-md-offset-1 margin-bottom-50px">
        <center>
            <b>
                <p class="font-size-30px margin-top-80px">АКТИВНІ ЛОТИ</p>
            </b>
            <div class="width-100px border-bottom-red-3px"></div>
        </center>
    </div>

    <div id="allPlumbs" class="col-md-10 col-md-offset-1">

        <c:forEach items="${plumbs}" var="plumb">
            <c:set var="picture" value="${plumb.picture}"/>
            <div class="col-xs-6 col-md-3 padding-5-15-0-15px">
                <a href="/plumb${plumb.id}" class="thumbnail btn padding-0 margin-0 border-radius-10px overflow-hidden background-white">
                    <c:forEach items="${picture.picturePhotos}" var="picturePhoto" end="0">
                        <img src="${picturePhoto.photo}" class="img-responsive width-100prc">
                    </c:forEach>
                    <div class="row caption margin-0 padding-0 display-block height-auto">
                        <h4 class="hover-cl-gren white-space-pre-wrap padding-bottom-10px padding-top-10px margin-0 color-red">${picture.name}</h4>
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
                    </div>

                </a>
            </div>
        </c:forEach>
    </div>

    <div class="col-md-12 padding-top-30px">
        <center>
            <a id="allActivePlumb" href="/allActivePlumb-Page0" class="hover-back-gren btn background-red border-radius-90px padding-0-40px outline-none">
                <h4 class="padding-5px color-blond-grey">ВСІ АКТИВНІ ЛОТИ</h4>
            </a>
        </center>
    </div>

</div>

<div class="col-md-12 background-white padding-bottom-50px">

    <div class="col-md-10 col-md-offset-1 margin-bottom-50px">
        <center>
            <b>
                <p class="font-size-30px margin-top-80px"> ПОПУЛЯРНІ АВТОРИ </p>
            </b>
            <div class="width-100px border-bottom-red-3px"></div>
        </center>
    </div>

    <div id="allAuthors" class="col-md-10 col-md-offset-1">
        <c:forEach items="${authors}" var="author">
            <div class="col-xs-6 col-md-3 padding-5-15-0-15px">
                <a href="/authorWithId${author.id}/Page0" class="thumbnail btn padding-0 margin-0 border-radius-10px overflow-hidden background-blond-grey">

                    <img src="${author.photo}" class="img-responsive width-100prc">

                    <div class="row caption margin-0 padding-0 display-block height-auto">
                        <h4 class="hover-cl-gren white-space-pre-wrap padding-bottom-10px padding-top-10px margin-0 color-red" title="${author.name}">${author.name}</h4>
                    </div>
                </a>
            </div>
        </c:forEach>
    </div>

    <div class="col-md-12 padding-top-30px">
        <center>
            <a href="/allAuthorsPage-0" class="hover-back-gren btn background-red border-radius-90px padding-0-40px outline-none">
                <h4 class="padding-5px color-blond-grey">ВСІ АВТОРИ</h4>
            </a>
        </center>
    </div>

</div>


<div id="followDiv" class="col-md-12 img-responsive width-100prc">
    <div class="col-md-10 col-md-offset-1 padding-right-100px">
        <div id="followDivTextArea" class="background-dark-grey color-blond-grey col-md-6 padding-0-40px float-right margin-right-30px border-radius-10px">
            <center>
                <h2 class="padding-top-15px padding-bottom-10px">Оновлення</h2>
            </center>
            <p class="font-size-14px-Lato padding-bottom-10px text-align-center">Слідкуйте за нашими оновленнями. Введіть ваш логін і підпишіться на нашу розсилку. </p>

            <div class="row margin-5-5-30-5 background-blond-grey border-blond-grey border-radius-45px  overflow-hidden">
                <input id="userNameToMailing" type="text" class="col-md-7 font-size-20px padding-5px padding-left-20px outline-none background-blond-grey color-dark-grey" autocomplete="off" style="">
                <button id="addUserToMailing" class="hover-back-gren btn col-md-5 background-red border-radius-90px padding-10px-0 outline-none" onclick="addUserToMailing()">
                    ПІДПИСАТИСЯ
                </button>
            </div>
            <div id="divForInfoAboutAllow"></div>
        </div>
    </div>

</div>







<script src="/js/listEdit.js"></script>
<%@include file="template/footer.jsp"%>