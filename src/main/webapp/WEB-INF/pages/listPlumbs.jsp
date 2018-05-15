<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="template/header.jsp"%>

<div class="container-fluid background-white" style="min-height: 500px">
    <div class="row centered" >
        <div class="col-md-10 col-md-offset-1">
            <div class="row">
                <div class="col-md-12 margin-top-10px row">

                    <%--<div class="padding-0-10px border-bottom-blond-grey col-md-12 col-xs-12">--%>
                    <%--<h1 class="float-left font-size-25px col-md-12 col-xs-12"> ${fatherCategory.name} </h1>--%>
                    <%--<h1 id="activeCategoryId" class="visibility-hidden float-left margin-0" style="font-size: 0px">${fatherCategory.id}</h1>--%>
                    <%--</div>--%>

                    <div id="allPlumbs" class="padding-10px-0 col-md-12">
                        <c:forEach items="${plumbs}" var="plumb">
                            <c:set var="picture" value="${plumb.picture}"/>
                            <div class="col-xs-6 col-md-3 padding-5-15-0-15px">
                                <a href="/plumb${plumb.id}" class="thumbnail btn padding-0 margin-0 border-radius-10px overflow-hidden background-blond-grey">
                                    <c:forEach items="${picture.picturePhotos}" var="picturePhoto" end="0">
                                        <img src="${picturePhoto.photo}" class="img-responsive width-100prc">
                                    </c:forEach>
                                    <div class="row caption margin-0 padding-0 display-block height-auto">
                                        <h4 class="hover-cl-gren white-space-pre-wrap padding-bottom-10px padding-top-10px margin-0 color-red">${picture.name}</h4>
                                        <c:if test="${plumb.dateOfEnd > currentDate}">
                                            <p class="col-md-6 margin-0 font-size-14px-Lato white-space-pre-wrap">Стартова ціна</p>
                                            <p class="col-md-6 margin-0 font-size-14px-Lato white-space-pre-wrap">Поточна ціна</p>
                                            <p class="col-md-6 font-weight-bold font-size-14px-Lato">${plumb.minPrise} грн</p>
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
                                            <p class="col-md-12 margin-0 font-size-14px-Lato white-space-pre-wrap">Продано</p>
                                        </c:if>
                                    </div>

                                </a>
                            </div>
                        </c:forEach>

                    </div>

                    <div class="btn-toolbar col-md-12 row" role="toolbar">
                        <ul id="pagination" class="pagination">
                            <li>
                                <a id="aPreviousPage" <c:if test="${plumbsPage != 0}">
                                    href ="allActivePlumb-Page${plumbsPage - 1}"
                                </c:if> class="border-l-radius-45px" >&laquo;</a>
                            </li>
                            <c:if test="${plumbsPage > 2}">
                                <li><a href="allActivePlumb-Page0" class="text-danger"> 1 </a></li>
                            </c:if>
                            <c:if test="${plumbsPage > 1}">
                                <li><a href="allActivePlumb-Page${plumbsPage - 2}" class="text-danger"> ${plumbsPage - 1} </a></li>
                            </c:if>
                            <c:if test="${plumbsPage > 0}">
                                <li><a href="allActivePlumb-Page${plumbsPage - 1}" class="text-danger"> ${plumbsPage} </a></li>
                            </c:if>

                            <li class="active"><a id="activePage" href="" >${plumbsPage + 1}</a></li>

                            <c:if test="${(maxPage - plumbsPage) > 2}">
                                <li><a href="allActivePlumb-Page${plumbsPage + 1}" class="text-danger"> ${plumbsPage + 2} </a></li>
                            </c:if>
                            <c:if test="${(maxPage - plumbsPage) > 3}">
                                <li><a href="allActivePlumb-Page${plumbsPage + 2}" class="text-danger"> ${plumbsPage + 3} </a></li>
                            </c:if>
                            <c:if test="${plumbsPage + 1 != maxPage}">
                                <li><a id="maxPage" href="allActivePlumb-Page${maxPage - 1}" class="text-danger"> ${maxPage} </a></li>
                            </c:if>
                            <li>
                                <a id="aNextPage" <c:if test="${plumbsPage + 1 != maxPage}">
                                    href="allActivePlumb-Page${plumbsPage + 1}"
                                </c:if> class="border-r-radius-45px">&raquo;</a>
                            </li>
                        </ul>
                    </div>


                </div>
            </div>

        </div>
    </div>
</div>



<script src="/js/listEdit.js"></script>
<%@include file="template/footer.jsp"%>
