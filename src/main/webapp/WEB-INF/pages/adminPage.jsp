<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="template/header.jsp"%>


<div class="container-fluid background-white">
    <div class="row centered">
        <div class="col-md-10 col-md-offset-1 row" style="min-height: 600px">
            <div class="page-header padding-left-20px">
                <h2>Admin Page</h2>
            </div>


            <div class="col-md-2 padding-bottom-10px">
                <ul class="text-align-center nav ">
                    <li> <button id="category" class="col-md-12 btn btn-danger margin-top-10px outline-none">Категорії</button> </li>
                </ul>

            </div>
            <div id="workspace" class="col-md-10 padding-bottom-10px">

                <form id="formForSaveSlide" action="/create/saveStockSlide" method="post" enctype="multipart/form-data">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                </form>


            </div>

        </div>
    </div>
</div>




<script src="/js/adminCategory.js" ></script>
<%@include file="template/footer.jsp"%>
