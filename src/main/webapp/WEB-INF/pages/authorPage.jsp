<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="template/header.jsp"%>


    <div class="container-fluid background-blond-grey" style="min-height: 500px">
        <div class="row padding-top-30px padding-bottom-20px" >
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <div class="display-block padding-bottom-10px col-md-10 col-md-offset-1">
                    <a onclick="deleteAuthor(${author.id})" class="btn color-red padding-left-30px outline-none float-right">Видалити</a>
                    <a id="createEditArea" onclick="createAreaToEditAuthor()" class="btn color-red padding-left-30px outline-none float-right">Редагувати</a>
                    <a id="cancelEdit" href="/authorWithId${author.id}/Page${authorsPage}" class="hide btn text-danger float-right">Відмінити редагування</a>
                </div>
            </sec:authorize>
            <div id="authorDiv" class="col-md-10 col-md-offset-1 padding-top-30px padding-bottom-20px background-white overflow-hidden border-radius-45px">
                <div class="col-md-5">
                    <img src="${author.photo}" class="img-responsive width-100prc border-radius-45px max-height-600px">
                </div>
                <div class="col-md-7 padding-left-20px">
                    <p id="authorId" class="hide">${author.id}</p>
                    <h3 class="text-align-center padding-top-5px padding-bottom-10px margin-0">${author.name}</h3>
                    <p class="white-space-pre-wrap" id="biography">${author.biography}</p>
                </div>
            </div>

            <div id="plumbDiv" class="col-md-10 col-md-offset-1 margin-top-30px padding-top-5px padding-bottom-10px background-white overflow-hidden border-radius-45px">
                <h3 class="text-align-center padding-bottom-10px">Лоти написані даним автором</h3>
                <div id="allPlumbs">
                    <c:forEach items="${plumbs}" var="plumb">
                        <c:set var="picture" value="${plumb.picture}"/>
                        <div id="" class="col-xs-6 col-md-3 padding-5-15-0-15px">
                            <a href="/plumb${plumb.id}" class="thumbnail btn padding-0 border-radius-10px overflow-hidden background-blond-grey">
                                <c:forEach items="${picture.picturePhotos}" var="picturePhoto" end="0">
                                    <img src="${picturePhoto.photo}" class="img-responsive width-100prc">
                                </c:forEach>
                                <div class="row caption margin-0 padding-0 display-block height-auto">
                                    <h4 class="hover-cl-gren white-space-pre-wrap padding-bottom-10px padding-top-10px margin-0 color-red">${picture.name}</h4>
                                    <c:if test="${plumb.dateOfEnd > currentDate}">
                                        <p class="col-md-6 margin-0 font-size-14px-Lato white-space-pre-wrap">Початкова ціна</p>
                                        <p class="col-md-6 margin-0 font-size-14px-Lato white-space-pre-wrap">Поточна ціна</p>
                                        <p class="col-md-6 font-weight-bold font-size-14px-Lato"> ${plumb.minPrise} грн </p>
                                        <c:forEach items="${plumb.bets}" var="bet" end="0">
                                            <c:if test="${bet.price > 0}">
                                                <p class="col-md-6 font-weight-bold font-size-14px-Lato">${bet.price} грн</p>
                                            </c:if>
                                            <c:if test="${bet == null}">
                                                <p class="col-md-6 font-weight-bold font-size-14px-Lato">${plumb.minPrise} грн</p>
                                            </c:if>
                                        </c:forEach>
                                    </c:if>
                                    <c:if test="${plumb.dateOfEnd < currentDate}">
                                        <p class="col-md-12 margin-0 padding-bottom-5px font-size-14px-Lato white-space-pre-wrap">Продано</p>
                                    </c:if>
                                </div>

                            </a>
                        </div>
                    </c:forEach>
                </div>

                <div class="btn-toolbar col-md-12 row" role="toolbar">
                    <ul id="pagination" class="pagination">
                        <li>
                            <a id="aPreviousPage" <c:if test="${authorsPage != 0}">
                                href ="/authorWithId${author.id}/Page${authorsPage - 1}"
                            </c:if> class="btn border-l-radius-45px" >&laquo;</a>
                        </li>
                        <c:if test="${authorsPage > 2}">
                            <li><a href="/authorWithId${author.id}/Page0" class="text-danger"> 1 </a></li>
                        </c:if>
                        <c:if test="${authorsPage > 1}">
                            <li><a href="/authorWithId${author.id}/Page${authorsPage - 2}" class="text-danger"> ${authorsPage - 1} </a></li>
                        </c:if>
                        <c:if test="${authorsPage > 0}">
                            <li><a href="/authorWithId${author.id}/Page${authorsPage - 1}" class="text-danger"> ${authorsPage} </a></li>
                        </c:if>

                        <li class="active"><a id="activePage" href="" >${authorsPage + 1}</a></li>

                        <c:if test="${(maxPage - authorsPage) > 2}">
                            <li><a href="/authorWithId${author.id}/Page${authorsPage + 1}" class="text-danger"> ${authorsPage + 2} </a></li>
                        </c:if>
                        <c:if test="${(maxPage - authorsPage) > 3}">
                            <li><a href="/authorWithId${author.id}/Page${authorsPage + 2}" class="text-danger"> ${authorsPage + 3} </a></li>
                        </c:if>
                        <c:if test="${authorsPage + 1 != maxPage}">
                            <li><a id="maxPage" href="/authorWithId${author.id}/Page${maxPage - 1}" class="text-danger"> ${maxPage} </a></li>
                        </c:if>
                        <li>
                            <a id="aNextPage" <c:if test="${authorsPage + 1 != maxPage}">
                                href="/authorWithId${author.id}/Page${authorsPage + 1}"
                            </c:if> class="btn border-r-radius-45px">&raquo;</a>
                        </li>

                    </ul>

                </div>
            </div>

        </div>
    </div>

<script src="/js/authorPage.js"></script>
<script src="/js/listEdit.js"></script>
<%@include file="template/footer.jsp"%>
