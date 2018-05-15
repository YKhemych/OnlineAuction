<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="template/header.jsp"%>

<sec:authorize access="hasRole('ROLE_USER')">
    <div class="container-fluid background-blond-grey">
        <div class="row padding-top-30px" >
            <form id="createDescribeOfUser" action="/createDescribeOfUser${userName}" method="post" accept-charset="UTF-8" class="col-md-10 col-md-offset-1 padding-bottom-20px">
                <p class="margin-left-auto margin-right-auto width-400px">Усі поля є обов'язковими для заповнення</p>

                <div class="col-md-12 col-xs-12 padding-bottom-20px padding-top-15px margin-10-0 background-white overflow-hidden border-radius-45px">
                    <div id="divName" class="col-md-10 col-md-offset-1 margin-top-10px padding-5px background-blond-grey border-white border-radius-45px overflow-hidden">
                        <input id="name" name="name" type="text" class="col-md-7 padding-left-20px padding-top-5px margin-0 outline-none background-blond-grey font-size-14px-Lato">
                        <p class="col-md-5 margin-0 background-red color-white border-radius-90px padding-5px text-align-center white-space-nowrap font-size-14px-Lato">Ім'я</p>
                    </div>
                    <div id="divSurname" class="col-md-10 col-md-offset-1 margin-top-10px padding-5px background-blond-grey border-white border-radius-45px overflow-hidden">
                        <input id="surname" name="surname" type="text" class="col-md-7 padding-left-20px padding-top-5px margin-0 outline-none background-blond-grey font-size-14px-Lato">
                        <p class="col-md-5 margin-0 background-red color-white border-radius-90px padding-5px text-align-center white-space-nowrap font-size-14px-Lato">Прізвище</p>
                    </div>
                    <div id="divPhone" class="col-md-10 col-md-offset-1 margin-top-10px padding-5px background-blond-grey border-white border-radius-45px overflow-hidden">
                        <input id="phone" name="phone" type="tel" class="col-md-7 padding-left-20px padding-top-5px margin-0 outline-none background-blond-grey font-size-14px-Lato">
                        <p class="col-md-5 margin-0 background-red color-white border-radius-90px padding-5px text-align-center white-space-nowrap font-size-14px-Lato">Номер телефону</p>
                    </div>
                    <div id="divCountry" class="col-md-10 col-md-offset-1 margin-top-10px padding-5px background-blond-grey border-white border-radius-45px overflow-hidden">
                        <input id="country" name="country" type="text" class="col-md-7 padding-left-20px padding-top-5px margin-0 outline-none background-blond-grey font-size-14px-Lato">
                        <p class="col-md-5 margin-0 background-red color-white border-radius-90px padding-5px text-align-center white-space-nowrap font-size-14px-Lato">Країна</p>
                    </div>
                    <div id="divCity" class="col-md-10 col-md-offset-1 margin-top-10px padding-5px background-blond-grey border-white border-radius-45px overflow-hidden">
                        <input id="city" name="city" type="text" class="col-md-7 padding-left-20px padding-top-5px margin-0 outline-none background-blond-grey font-size-14px-Lato">
                        <p class="col-md-5 margin-0 background-red color-white border-radius-90px padding-5px text-align-center white-space-nowrap font-size-14px-Lato">Місто</p>
                    </div>
                    <div id="divZipCode" class="col-md-10 col-md-offset-1 margin-top-10px padding-5px background-blond-grey border-white border-radius-45px overflow-hidden">
                        <input id="zipCode" name="zipCode" type="number" max="99999" class="col-md-7 padding-left-20px padding-top-5px margin-0 outline-none background-blond-grey font-size-14px-Lato">
                        <p class="col-md-5 margin-0 background-red color-white border-radius-90px padding-5px text-align-center white-space-nowrap font-size-14px-Lato">Поштовий індекс</p>
                    </div>
                    <input type="hidden"
                           name="${_csrf.parameterName}"
                           value="${_csrf.token}" >
                    <div class="col-md-12 padding-top-15px">
                        <center>
                            <input id="saveDescribeOfUser" type="submit" class="hover-back-gren btn color-white background-red font-size-20px border-radius-90px padding-0-40px outline-none" value="Завершити">
                        </center>
                    </div>
                </div>

            </form>
        </div>
    </div>
</sec:authorize>
<%@include file="template/footer.jsp"%>
