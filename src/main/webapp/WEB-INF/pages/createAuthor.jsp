<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="template/header.jsp"%>

<sec:authorize access="hasRole('ROLE_ADMIN')">
    <form id="saveAuthorForm" action="/create/saveAuthor" method="post" enctype="multipart/form-data" accept-charset="UTF-8">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    </form>
    <div class="container-fluid background-blond-grey">
        <div class="row padding-top-30px" >
            <div id="createDiv" class="col-md-10 col-md-offset-1 padding-bottom-20px">
                <div class="col-md-12 col-xs-12 padding-bottom-20px margin-10-0 background-white overflow-hidden border-radius-45px">
                    <h3 class="text-align-center">Ім'я і прізвище</h3>
                    <div id="divAuthorName" class="col-md-10 col-md-offset-1 margin-top-10px padding-5px background-blond-grey border-white border-radius-45px overflow-hidden">
                        <input id="authorName" name="name" form="saveAuthorForm" type="text" class="col-md-7 padding-left-20px padding-top-5px outline-none background-blond-grey" placeholder="*">
                        <p class="col-md-5 margin-0 background-red color-white border-radius-90px padding-5px text-align-center white-space-nowrap">Повне ім'я</p>
                    </div>
                </div>

                <div class="col-md-12 col-xs-12 padding-left-20px padding-bottom-20px margin-10-0 background-white overflow-hidden border-radius-45px">
                    <h3 class="text-align-center">Фото</h3>
                    <div id="divAuthorPhoto" class="col-md-10 col-md-offset-1 margin-top-10px padding-5px background-blond-grey border-white border-radius-45px overflow-hidden">
                        <input id="authorPhoto-0" name="photo" form="saveAuthorForm" type="file" accept=image/*" class="hide" onchange="getFileName(this)">
                        <label for="authorPhoto-0" class="col-md-4 text-align-center padding-0-40px margin-5px background-red color-white hover-back-gren border-radius-45px font-size-14px-Lato white-space-nowrap">Вибрати файл</label>
                        <p id="imageName-0" class="col-md-7 margin-0 padding-top-10px overflow-hidden text-overflow-ellipsis white-space-nowrap"></p>
                    </div>
                </div>

                <div class="col-md-12 col-xs-12 padding-bottom-20px margin-10-0 background-white overflow-hidden border-radius-45px">
                    <h3 class="text-align-center">Коротка біографія</h3>
                    <div id="divAuthorBiography" class="col-md-10 col-md-offset-1 margin-top-10px padding-5px background-blond-grey border-white border-radius-45px overflow-hidden">
                        <textarea id="authorBiography" name="biography" form="saveAuthorForm" rows="7" type="text" class="col-md-12 padding-left-20px padding-top-5px outline-none background-blond-grey" placeholder="*"></textarea>
                    </div>
                </div>


                <div class="col-md-12 padding-top-15px">
                    <center>
                        <input id="saveAuthor" type="submit" form="saveAuthorForm" class="hover-back-gren btn color-white background-red font-size-20px border-radius-90px padding-0-40px outline-none" value="Додати автора">
                    </center>
                </div>

            </div>
        </div>
    </div>
</sec:authorize>
<script src="/js/createEdit.js"></script>
<%@include file="template/footer.jsp"%>