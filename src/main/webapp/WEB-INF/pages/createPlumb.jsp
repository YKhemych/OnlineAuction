<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="template/header.jsp"%>

<sec:authorize access="hasRole('ROLE_USER')">
<div class="container-fluid background-blond-grey">
    <div class="row padding-top-30px" >
        <div id="createDiv" class="col-md-10 col-md-offset-1 padding-bottom-20px">
            <p class="margin-left-auto margin-right-auto width-400px">Поля поміченні * - є обов'язковими для заповнення.</p>

            <div class="col-md-12 col-xs-12 padding-bottom-20px margin-10-0 background-white overflow-hidden border-radius-45px">
                <h3 class="text-align-center">Назва і категорія лоту</h3>
                <div id="divPictureName" class="col-md-10 col-md-offset-1 margin-top-10px padding-5px background-blond-grey border-white border-radius-45px overflow-hidden">
                    <input id="pictureName" name="name" form="formForSaveProductPhoto" type="text" class="col-md-7 padding-left-20px padding-top-5px outline-none background-blond-grey" placeholder="Назва *">
                    <p class="col-md-5 margin-0 background-red color-white border-radius-90px padding-5px text-align-center white-space-nowrap">Не забувайте про правила аукціону</p>
                </div>
                <div id="divPictureCategory" class="col-md-10 col-md-offset-1 margin-top-10px padding-5px background-blond-grey border-white border-radius-45px overflow-hidden">
                    <input id="pictureCategory" list="categories" name="categoryName" form="formForSaveProductPhoto" type="text" class="col-md-7 padding-left-20px padding-top-5px outline-none background-blond-grey" placeholder="Розділ *">
                    <datalist id="categories">
                        <c:forEach items="${categories}" var="category">
                            <option>${category.name}</option>
                        </c:forEach>
                    </datalist>
                    <p class="col-md-5 margin-0 background-red color-white border-radius-90px padding-5px text-align-center white-space-nowrap">Оберіть розділ аукціону</p>
                </div>
            </div>

            <div class="col-md-12 col-xs-12 padding-left-20px padding-bottom-20px margin-10-0 background-white overflow-hidden border-radius-45px">
                <h3 class="text-align-center">Фото</h3>
                <div class="col-xs-5 col-md-5 padding-top-15px">
                    <a id="addPhotoToPicture" class="btn background-blond-grey thumbnail color-red col-md-6 col-md-offset-1 padding-0-40px border-radius-90px hover-cl-gren">
                        <span style="font-size: 50px" class="glyphicon glyphicon-picture padding-top-15px"></span>
                        <p class="margin-top-10px">Додати фото *</p>
                    </a>
                    <div class="col-md-4 col-md-offset-1">
                        <p id="photoInfo">0 із 10</p>
                    </div>
                </div>
                <form id="formForSaveProductPhoto" action="/create/savePlumbBy<sec:authentication property="principal.username" />" method="post"
                      enctype="multipart/form-data" accept-charset="UTF-8">
                    <input type="hidden"
                           name="${_csrf.parameterName}"
                           value="${_csrf.token}"/>
                </form>
                <div id="picturePhotoArea" class="col-xs-7 col-md-7">
                </div>
            </div>

            <div class="col-md-12 col-xs-12 padding-bottom-20px margin-10-0 background-white overflow-hidden border-radius-45px">
                <h3 class="text-align-center">Інформація про лот</h3>
                <div id="divPictureYear" class="col-md-10 col-md-offset-1 margin-top-10px padding-5px background-blond-grey border-white border-radius-45px overflow-hidden">
                    <input id="pictureYear" name="year" form="formForSaveProductPhoto" type="text" class="col-md-7 padding-left-20px padding-top-5px outline-none background-blond-grey" placeholder="Рік картини">
                    <p class="col-md-5 margin-0 background-red color-white border-radius-90px padding-5px text-align-center white-space-nowrap">Вкажіть рік створення картини</p>
                </div>
                <div id="divPictureSize" class="col-md-10 col-md-offset-1 margin-top-10px padding-5px background-blond-grey border-white border-radius-45px overflow-hidden">
                    <input id="pictureSize" name="size" form="formForSaveProductPhoto" type="text" class="col-md-7 padding-left-20px padding-top-5px outline-none background-blond-grey" placeholder="Розмір *" title="Зразок - '??x?? см'">
                    <p class="col-md-5 margin-0 background-red color-white border-radius-90px padding-5px text-align-center white-space-nowrap">Розмір картини вимірюється у см</p>
                </div>
                <div id="divPictureMaterial" class="col-md-10 col-md-offset-1 margin-top-10px padding-5px background-blond-grey border-white border-radius-45px overflow-hidden">
                    <input id="pictureMaterial" name="material" form="formForSaveProductPhoto" type="text" class="col-md-7 padding-left-20px padding-top-5px outline-none background-blond-grey" placeholder="Матеріал *">
                    <p class="col-md-5 margin-0 background-red color-white border-radius-90px padding-5px text-align-center text-overflow-ellipsis overflow-hidden white-space-nowrap" title="Інформація про матеріал, з якого виготовлено картину виставлену на продаж">Інформація про матеріал, з якого виготовлено картину</p>
                </div>
                <div id="divPictureAuthor" class="col-md-10 col-md-offset-1 margin-top-10px padding-5px background-blond-grey border-white border-radius-45px overflow-hidden">
                    <input id="pictureAuthor" list="authorsList" name="authorName" form="formForSaveProductPhoto" type="text" class="col-md-7 padding-left-20px padding-top-5px outline-none background-blond-grey" placeholder="Автор">
                    <datalist id="authorsList">
                        <c:forEach items="${authors}" var="author">
                            <option>${author.name}</option>
                        </c:forEach>
                    </datalist>
                    <p class="col-md-5 margin-0 background-red color-white border-radius-90px padding-5px text-align-center white-space-nowrap">Оберіть автора картини</p>
                </div>
            </div>

            <div class="col-md-12 col-xs-12 padding-bottom-20px margin-10-0 background-white overflow-hidden border-radius-45px">
                <h3 class="text-align-center">Ціна та дата закінчення торгів</h3>
                <div id="divPicturePrice" class="col-md-10 col-md-offset-1 margin-top-10px padding-5px background-blond-grey border-white border-radius-45px overflow-hidden">
                    <input id="picturePrice" name="price" form="formForSaveProductPhoto" type="text" class="col-md-7 padding-left-20px padding-top-5px outline-none background-blond-grey" placeholder="Ціна *">
                    <p class="col-md-5 margin-0 background-red color-white border-radius-90px padding-5px text-align-center white-space-nowrap text-overflow-ellipsis overflow-hidden" title="Стартова ціна повинна бути такою, на скільки Ви по мінімуму оцінюєте лот, що продається(ціна за яку Ви погоджуєтесь продати лот)"
                    >Стартова ціна повинна бути такою, на скільки Ви по мінімуму оцінюєте лот, що продається(ціна за яку Ви погоджуєтесь продати лот)</p>
                </div>
                <div id="divPictureDateOfEnd" class="col-md-10 col-md-offset-1 margin-top-10px padding-5px background-blond-grey border-white border-radius-45px overflow-hidden">
                    <input id="pictureDateOfEnd" name="stringDateOfEnd" form="formForSaveProductPhoto" type="datetime-local" class="col-md-7 padding-left-20px padding-top-5px outline-none background-blond-grey" placeholder="Дата завершення *">
                    <p class="col-md-5 margin-0 background-red color-white border-radius-90px padding-5px text-align-center white-space-nowrap">Оберіть дату завершення аукціону</p>
                </div>
            </div>

            <div class="col-md-12 col-xs-12 padding-bottom-20px margin-10-0 background-white overflow-hidden border-radius-45px">
                <h3 class="text-align-center">Стан та опис лоту</h3>
                <div id="divPictureCondition" class="col-md-10 col-md-offset-1 margin-top-10px padding-5px background-blond-grey border-white border-radius-45px overflow-hidden">
                    <textarea id="pictureCondition" name="condition" form="formForSaveProductPhoto" rows="3" type="text" class="col-md-7 padding-left-20px padding-top-5px outline-none background-blond-grey" placeholder="Стан *"></textarea>
                    <textarea rows="3" disabled class="col-md-5 margin-0 background-red color-white border-radius-45px padding-5px text-align-center text-overflow-ellipsis outline-none overflow-hidden"
                    title="Опишіть стан предмету, як омога більш детально повідомивши про приховані і видимі дефекти, що допоможе Вам уникнути в майбутньому проблем, пов'язаних з приховуванням реального стану.">Опишіть стан предмету, як омога більш детально повідомивши про приховані і видимі дефекти, що допоможе Вам уникнути в майбутньому проблем, пов'язаних з приховуванням реального стану</textarea>
                </div>
                <div id="divPictureDescription" class="col-md-10 col-md-offset-1 margin-top-10px padding-5px background-blond-grey border-white border-radius-45px overflow-hidden">
                    <textarea id="pictureDescription" name="description" form="formForSaveProductPhoto" rows="3" type="text" class="col-md-7 padding-left-20px padding-top-5px outline-none background-blond-grey" placeholder="Опис *"></textarea>
                    <textarea rows="3" disabled class="col-md-5 margin-0 background-red color-white border-radius-45px padding-5px text-align-center text-overflow-ellipsis outline-none overflow-hidden"
                    title="Детально опишіть лот, що на Вашу думку необхідно для повного розуміння покупцеві">Детально опишіть лот, що на Вашу думку необхідно для повного розуміння покупцеві</textarea>
                </div>
            </div>


            <div class="col-md-12 padding-top-15px">
                <center>
                    <input id="savePlumb" type="submit" form="formForSaveProductPhoto" class="hover-back-gren btn color-white background-red font-size-20px border-radius-90px padding-0-40px outline-none" value="Додати лот">
                </center>
            </div>

        </div>
    </div>
</div>
</sec:authorize>
<script src="/js/createEdit.js"></script>
<%@include file="template/footer.jsp"%>