<div id="regictration" class="modal fade" tabindex="-1">
    <div class="modal-dialog ">
        <div class="modal-content background-dark-grey color-white">
            <div class="modal-header">
                <button id="closeRegistration" class="close color-white" data-dismiss="modal">х</button>
                <h4 class="modal-title">Регістрація</h4>
            </div>

            <div id="divRegistrationUser" class="modal-body">
                <form action="/saveUser" method="post" class="row centered">
                    <input id="regUsername" type="text" name="username" class="col-md-10 col-md-offset-1 padding-left-20px margin-top-10px border-red background-dark-grey" placeholder="User Name">
                    <div id="divForErrorUserName" class="col-md-10 col-md-offset-1 padding-left-20px"></div>
                    <input id="regEmail" type="email" name="email" class="col-md-10 col-md-offset-1 padding-left-20px margin-top-10px border-red background-dark-grey" placeholder="Email">
                    <input id="regPassword" type="password" name="password" class="col-md-10 col-md-offset-1 padding-left-20px margin-top-10px border-red  background-dark-grey" placeholder="Create password">
                    <input id="conPassword" type="password" name="password" class="col-md-10 col-md-offset-1 padding-left-20px margin-top-10px border-red  background-dark-grey" placeholder="Confirm password">
                    <div id="divForErrorPassword" class="col-md-10 col-md-offset-1 padding-left-20px"></div>
                    <input type="hidden"
                           name="${_csrf.parameterName}"
                           value="${_csrf.token}" >
                </form>
            </div>

            <div class="modal-footer">
                <button id="registerButton" class="btn btn-danger">Регістрація</button>
            </div>

        </div>
    </div>
</div>
