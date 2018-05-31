<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="template/header.jsp"%>

<div class="container-fluid background-blond-grey" style="min-height: 500px">
    <div class="row centered padding-top-15px padding-bottom-20px">
        <div class="col-md-10 col-md-offset-1 background-white border-radius-45px">
            <div class="row">

                <div class="col-md-5 col-xs-12 padding-top-10px margin-10-0">
                    <div class="col-xs-12 col-md-12 padding-bottom-20px">
                        <img id="mainPictureImage" class="img-responsive border-radius-45px max-height-600px">
                    </div>
                    <div id="allPicturePhoto">
                        <c:forEach items="${picturePhotos}" var="picturePhoto">
                            <div class="col-xs-6 col-md-3">
                                <img src="${picturePhoto.photo}" class="img-responsive border-radius-10px" onclick="sendToMainPictureImage(this)">
                            </div>
                        </c:forEach>
                    </div>

                </div>

                <div id="PictureArea" class="col-md-7 col-xs-12 row padding-top-10px padding-left-30px font-size-20px">
                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                        <div class="display-block padding-bottom-10px col-md-12">
                            <a class="btn text-danger float-right" onclick="deletePlumb(${plumb.id})">Видалити</a>
                            <a id="createEditArea" class="btn text-danger float-right" onclick="createAreaToEditPlumb()">Редагувати</a>
                            <a id="cancelEdit" href="/plumb${plumb.id}" class="hide btn text-danger float-right">Відмінити редагування</a>
                            <c:if test="${plumb.confirmed == 'false'}">
                                <a class="btn text-danger float-right" href="/confirmPlumb${plumb.id}">Підтвердити лот</a>
                            </c:if>
                        </div>
                    </sec:authorize>
                    <p id="confirmedMark" class="hide"><c:if test="${plumb.confirmed == true}">true</c:if></p>
                    <p id="activeMark" class="hide"><c:if test="${plumb.dateOfEnd > currentDate}">true</c:if></p>
                    <p id="confirmedDeliver" class="hide"><c:if test="${plumb.delivered == true}">true</c:if></p>
                    <h2 id="pictureName" class="padding-left-20px text-align-center">${picture.name}</h2>
                    <c:if test="${plumb.confirmed == true}">
                        <c:if test="${plumb.dateOfEnd > currentDate}">
                            <div class="col-md-12 background-blond-grey border-radius-10px padding-top-10px padding-bottom-10px">
                                <div class="row padding-top-5px">
                                    <p class="col-md-6">Стартова ціна: ${plumb.minPrise} грн</p>
                                    <p id="currentBet" class="col-md-6">Поточна ціна(0 ст.): ${plumb.minPrise} грн</p>
                                </div>
                                <div class="row padding-top-10px border-top-white">
                                    <p class="col-md-6">Закінчення:</p>
                                    <p class="col-md-6">Залишилось:</p>
                                    <p id="dateOfEnd" class="col-md-6">${plumb.dateOfEnd}</p>
                                    <p id="timeToEnd" class="col-md-6"></p>
                                </div>
                                <sec:authorize access="isAuthenticated()">
                                    <div class="row padding-top-10px border-top-white padding-left-20px">
                                        <input id="betSize" type="number" class="col-md-6 pad font-size-14px-Lato outline-none border-radius-10px" placeholder="${plumb.minPrise}" min="${plumb.minPrise}" >
                                        <a class="btn col-md-4 col-md-offset-1 padding-0 text-align-center border-radius-10px border-white color-dark-grey hover-cl-gren hover-border-green" onclick="makeABet()">Зробити ставку</a>
                                    </div>
                                </sec:authorize>
                            </div>
                        </c:if>
                        <c:if test="${plumb.dateOfEnd < currentDate}">
                            <div class="col-md-12 background-blond-grey border-radius-10px padding-top-10px padding-bottom-10px">
                                <div id="soldToUserDiv" class="row text-align-center padding-0-40px">
                                        <c:if test="${plumb.bets[0].price > 0}">
                                            <p class="margin-0">Лот продано по ціні ${plumb.bets[0].price} грн</p>
                                        </c:if>
                                    <p id="describeOfSold" class="display-i-b margin-0 hide padding-top-10px"></p>
                                    <a id="soldToUser" class="btn color-red hover-cl-gren hide padding-0"></a>
                                </div>
                            </div>
                        </c:if>
                    </c:if>

                    <div class="col-md-12 padding-bottom-20px">
                        <h3 class="padding-bottom-10px padding-left-20px"> Опис </h3>
                        <p class="display-i-b white-space-pre-wrap">Власник: </p><a id="owner" href="/userPage${plumb.user.username}" class="color-dark-grey">${plumb.user.username}</a>
                        <br>
                        <p  class="display-i-b white-space-pre-wrap">Розділ: </p><p id="pictureCategory" class="display-i-b">${picture.category.name}</p>
                        <br>
                        <p class="display-i-b white-space-pre-wrap">Автор: </p><a href="/authorWithId${picture.author.id}/Page0" class="color-dark-grey">${picture.author.name}</a>
                        <p> Рік: ${picture.year}</p>
                        <p> Розмір: ${picture.size}</p>
                        <p> Матеріал: ${picture.material}</p>
                        <p> Стан: ${picture.conditions}</p>
                        <p> Опис: ${picture.descriptions}</p>
                    </div>

                    <p id="plumbId" class="hide">${plumb.id}</p>
                    <p id="pictureId" class="hide">${picture.id}</p>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="/js/pictureEdit.js"></script>
<%@include file="template/footer.jsp"%>