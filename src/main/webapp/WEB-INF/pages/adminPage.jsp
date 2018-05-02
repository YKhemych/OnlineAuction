<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="template/header.jsp"%>


<div class="container-fluid background-white">
    <div class="row centered">
        <div class="col-md-10 col-md-offset-1 row" style="min-height: 600px">
            <div class="page-header padding-left-20px">
                <h2>Admin Page</h2>
            </div>


            <div class="col-md-3 padding-bottom-10px">
                <ul class="text-align-center nav ">
                    <li> <a id="category" class="col-md-12 btn margin-top-10px border-radius-90px background-red color-white outline-none">Розділи</a> </li>
                    <li> <a id="confirmedPlumb" class="col-md-12 btn margin-top-10px border-radius-90px background-red color-white outline-none">Підтвердження лотів</a> </li>
                    <li> <a id="createAuthor" href="/admin/createAuthor" class="col-md-12 btn margin-top-10px border-radius-90px background-red color-white outline-none">Додати автора</a> </li>
                </ul>

            </div>
            <div id="workspace" class="col-md-9 padding-bottom-10px">

            </div>

        </div>
    </div>
</div>




<script src="/js/adminCategory.js" ></script>
<%@include file="template/footer.jsp"%>
