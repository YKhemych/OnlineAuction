<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="template/header.jsp"%>

<div class="container-fluid background-blond-grey">
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
                            <h1 class="padding-0 margin-0 float-left">Id: ${picture.id}</h1>
                            <a class="btn text-danger float-right" onclick="deletePlumb(${plumb.id})">Видалити</a>
                            <c:if test="${plumb.confirmed == 'false'}">
                                <a class="btn text-danger float-right" href="/confirmPlumb${plumb.id}">Підтвердити</a>
                            </c:if>
                        </div>
                    </sec:authorize>
                    <p id="activeMark" class="hide"><c:if test="${plumb.dateOfEnd > currentDate}">true</c:if></p>
                    <h2 id="pictureName" class="padding-left-20px text-align-center">${picture.name}</h2>
                    <c:if test="${plumb.dateOfEnd > currentDate}">
                        <%--<sec:authorize access="hasRole('ROLE_USER')">--%>
                            <div class="col-md-12 background-blond-grey border-radius-10px padding-top-10px padding-bottom-10px">
                                <div class="row padding-top-5px">
                                    <p class="col-md-6">Стартова ціна: ${plumb.minPrise} грн</p>
                                    <p class="col-md-6">Поточна ціна(  ставок ): </p>
                                </div>
                                <div class="row padding-top-10px border-top-white">
                                    <p class="col-md-6">Закінчення:</p>
                                    <p class="col-md-6">Залишилось:</p>
                                    <p id="dateOfEnd" class="col-md-6">${plumb.dateOfEnd}</p>
                                    <p id="timeToEnd" class="col-md-6"></p>
                                </div>
                                <div class="row padding-top-10px border-top-white padding-left-20px">
                                    <input type="number" class="col-md-6 pad font-size-14px-Lato outline-none border-radius-10px">
                                    <a class="btn col-md-4 col-md-offset-1 padding-0 text-align-center border-radius-10px border-white color-dark-grey hover-cl-gren hover-border-green" onclick="">Зробити ставку</a>
                                </div>
                            </div>
                        <%--</sec:authorize>--%>
                    </c:if>


                    <div class="col-md-12">
                        <h3 class="padding-bottom-10px padding-left-20px"> Опис </h3>
                        <p> Автор: </p>
                        <p> Рік: ${picture.year}</p>
                        <p> Розмір: ${picture.size}</p>
                        <p> Матеріал: ${picture.material}</p>
                        <p> Стан: ${picture.conditions}</p>
                        <p> Опис: ${picture.descriptions}</p>
                    </div>

                    <p id="plumbId" class="padding-left-20px visibility-hidden">${plumb.id}</p>

                </div>
            </div>

        </div>
    </div>
</div>



<script src="/js/pictureEdit.js"></script>

<%@include file="template/footer.jsp"%>
