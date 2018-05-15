<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="template/header.jsp"%>


    <div class="container-fluid background-blond-grey" style="min-height: 500px">
        <div class="row padding-top-30px padding-bottom-20px" >
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <div class="display-block padding-bottom-10px col-md-10 col-md-offset-1">
                    <%--<h3 class="padding-0 float-left margin-0">Id: ${author.id}</h3>--%>
                    <a onclick="deleteAuthor(${author.id})" class="hover-back-gren btn background-red color-white border-radius-90px padding-0-40px outline-none float-right">Видалити</a>
                </div>
            </sec:authorize>
            <div id="authorDiv" class="col-md-10 col-md-offset-1 padding-top-30px padding-bottom-20px background-white overflow-hidden border-radius-45px">
                <div class="col-md-5">
                    <img src="${author.photo}" class="img-responsive width-100prc border-radius-45px max-height-600px">
                </div>
                <div class="col-md-7 padding-left-20px">
                    <h3 class="text-align-center padding-top-5px padding-bottom-10px margin-0">${author.name}</h3>
                    <p>${author.biography}</p>
                </div>
            </div>

            <div id="plumbDiv" class="col-md-10 col-md-offset-1 margin-top-30px padding-top-5px padding-bottom-20px background-white overflow-hidden border-radius-45px">
                <h3 class="text-align-center">Лоти написані даним автором</h3>
                <c:forEach items="${plumbs}" var="plumb">
                    <c:set var="picture" value="${plumb.picture}"/>
                    <div class="col-xs-6 col-md-3 padding-5-15-0-15px">
                        <a href="/plumb${plumb.id}" class="thumbnail btn padding-0 border-radius-10px overflow-hidden background-blond-grey">
                            <c:forEach items="${picture.picturePhotos}" var="picturePhoto" end="0">
                                <img src="${picturePhoto.photo}" class="img-responsive width-100prc">
                            </c:forEach>
                            <div class="row caption margin-0 padding-0 display-block height-auto">
                                <h4 class="hover-cl-gren white-space-pre-wrap padding-bottom-10px padding-top-10px margin-0 color-red">${picture.name}"</h4>
                                <c:if test="${plumb.dateOfEnd > currentDate}">
                                    <p class="col-md-6 margin-0 font-size-14px-Lato white-space-pre-wrap">Початкова ціна</p>
                                    <p class="col-md-6 margin-0 font-size-14px-Lato white-space-pre-wrap">Поточна ціна</p>
                                    <p class="col-md-6 font-weight-bold font-size-14px-Lato"> ${plumb.minPrise} грн </p>
                                    <p class="col-md-6 font-weight-bold font-size-14px-Lato"> 205 грн </p>
                                </c:if>
                                <c:if test="${plumb.dateOfEnd < currentDate}">
                                    <p class="col-md-12 margin-0 font-size-14px-Lato white-space-pre-wrap">Продано</p>
                                </c:if>
                            </div>

                        </a>
                    </div>
                </c:forEach>
            </div>

        </div>
    </div>

<script src="/js/authorPage.js"></script>
<%@include file="template/footer.jsp"%>
