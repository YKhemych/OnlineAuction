<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="loginModal" class="modal fade" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog ">
        <div class="modal-content background-dark-grey color-white">

            <div class="modal-header ">
                <button class="close color-white" data-dismiss="modal">х</button>
                <h4 class="modal-title">Вхід</h4>
            </div>

            <div class="modal-body">
                <form id="loginform" action="/logMe" method="post" class="row">
                    <input id="loginUserName" type="text" name="username" class="col-md-10 col-md-offset-1 padding-left-20px border-red margin-top-10px color-white background-dark-grey border-radius-90px outline-none" placeholder="User Name">
                    <input id="password" type="password" name="password" class="col-md-10 col-md-offset-1 padding-left-20px  border-red margin-top-10px color-white background-dark-grey border-radius-90px outline-none" placeholder="Password">
                    <div id="divForError" class="col-md-10 col-md-offset-1 padding-left-20px"></div>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                </form>
            </div>

            <div class="modal-footer ">
                <button id="loginButton" class="btn hover-back-gren padding-0-15px border-radius-90px background-red outline-none">ВВійти</button>
            </div>
        </div>
    </div>
</div>
