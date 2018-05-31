$(function () {
    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
    $(document).ajaxSend(function(e, xhr, options) {
        xhr.setRequestHeader(header, token);
    });
});

$('#registerButton').click(function () {
    var username = $('#regUsername').val();
    var email = $('#regEmail').val();
    var password = $('#regPassword').val();
    var confPassword = $('#conPassword').val();
    if (password == confPassword){
        var user = {username: username, email: email, password: password};
        var jsonUser = JSON.stringify(user);
        $('#divForErrorInRegistration').children().remove();
        $.ajax({
            url: '/saveUser',
            type: 'post',
            contentType: 'application/json',
            data : jsonUser,
            success : function (result) {
                if (result == ""){
                    $('#regUsername').val('');
                    $('#regEmail').val('');
                    $('#regPassword').val('');
                    $('#conPassword').val('');
                    document.getElementById("closeRegistration").click();
                }else{
                    if (result == "username"){
                        $('#divForErrorInRegistration').children().remove();
                        $('#divForErrorInRegistration').append($('<p/>', {class: "margin-0 padding-top-10px", text: "Користувач з таким іменем вже існує"}));
                    }
                }

            },
            error : function () {
                alert("!!!!");
            }
        });

    }else {
        $('#divForErrorInRegistration').empty();
        $('#divForErrorInRegistration').append($('<p/>', {id:"errorInPassword", class:"margin-0 padding-top-10px", text:"Паролі не збігаються"}));
    }

});

$('#loginButton').click(function () {
    var userName = $('#loginUserName').val();
    if (userName == 'admin'){
        $('#loginform').submit();
    } else {
        $.ajax({
            url: '/user' + userName,
            type: 'get',
            success: function (user) {
                if (user.accountNonLocked == false){
                    $('#divForError').children().remove();
                    $('#divForError').append($('<p/>', {class: "margin-0 padding-top-10px", text: "Користувач заблокований, зверніться до адміністрації"}));
                } else if (user.enabled == false){
                    $('#divForError').children().remove();
                    $('#divForError').append($('<p/>', {class: "margin-0 padding-top-10px", text: "Користувач не активований"}));
                } else {
                    $('#loginform').submit();
                }
            },
            error: function () {
                $('#divForError').children().remove();
                $('#divForError').append($('<p/>', {class: "margin-0 padding-top-10px", text: "Невірний логін або пароль"}));
            }
        });
    }
});

var numbOfClicksToTheMainCategory = 0;

$('#mainCategoryButton').click(function () {
    numbOfClicksToTheMainCategory++;
    console.log("hello!!!");
    console.log(numbOfClicksToTheMainCategory);
    if (numbOfClicksToTheMainCategory==1) {
        $.ajax({
            url: '/allCategory',
            type: 'get',
            success: function (result) {
                console.log(result.length);
                $('#mainCategoryButton').parent().append($('<div/>', {id: 'mainCategoryMenu', class: 'dropdown-menu multi-level'}));

                for (var i = 0; i < result.length; i++) {
                    if (result[i].idFatherCategories == 0){
                        console.log("0");
                        $('#mainCategoryMenu').append($('<li/>', {id: 'id'+`${result[i].id}`}));
                        $('#mainCategoryMenu').children().last().append($('<a/>', {
                            href: "/plumbs/category" + `${result[i].id}` + "/page0",
                            class: "linkCategory padding-5px",
                            text: `${result[i].name}`,
                        }));
                    }
                }

                $('#mainCategoryMenu').children().each(function createSubCategory() {
                    var bufUl=0;
                    for (var i = 0; i < result.length; i++) {
                        if ($(this).attr("id") == ('id'+ result[i].idFatherCategories)){
                            bufUl++;
                            if (bufUl == 1){
                                $(this).append($('<ul/>', {class: "dropdown-menu"}));
                                $(this).attr("class", "dropdown-submenu");
                            }
                            $(this).children().last().append($('<li/>', {id: 'id'+`${result[i].id}`}));
                            $(this).children().last().children().last().append($('<a/>', {
                                href: "/plumbs/category" + `${result[i].id}` + "/page0",
                                text: `${result[i].name}`,
                            }));
                        }
                    }
                    bufUl=0;
                });

                $('#mainCategoryMenu').children().each(function () { //<li>
                    $(this).children().last().children().each(function createSubCategory() {
                        var bufUl=0;
                        for (var i = 0; i < result.length; i++) {
                            if ($(this).attr("id") == ('id'+ result[i].idFatherCategories)){
                                bufUl++;
                                if (bufUl == 1){
                                    $(this).append($('<ul/>', {class: "dropdown-menu"}));
                                    $(this).attr("class", "dropdown-submenu");
                                }
                                $(this).children().last().append($('<li/>', {id: 'id'+`${result[i].id}`}));
                                $(this).children().last().children().last().append($('<a/>', {
                                    href: "/plumbs/category" + `${result[i].id}` + "/page0",
                                    text: `${result[i].name}`,
                                }));
                            }
                        }
                        bufUl=0;
                    });
                });

            },
            error: function () {
                alert("error !!!!!!!!!!!!");
            }
        });
    };
});


function addUserToMailing(){
    var userName = $('#userNameToMailing').val();
    $.ajax({
        url: '/allowSendEmailTo' + userName,
        type: 'post',
        success : function () {
            $('#divForInfoAboutAllow').children().remove();
            $('#divForInfoAboutAllow').append($('<p/>', {class: "font-size-14px-Lato text-align-center", text: "Вас успішно додано"}))
        },
        error : function () {
            alert("!!!!");
        }
    });
}


$(document).ready(function () {
    $('#followDivTextArea').parent().css("padding-top", ($('#followDivTextArea').height() / 2.3));
    $('#followDivTextArea').parent().css("padding-bottom", ($('#followDivTextArea').height() / 2.3));

    var allWidth = $('#navResize').width();
    var currentWidth = $('#navResize').children().width();
    $('#navResize').children().css("padding-left", (allWidth - currentWidth) /2);
});
window.onresize = function () {
    var allWidth = $('#navResize').width();
    var currentWidth = $('#navResize').children().width();
    $('#navResize').children().css("padding-left", (allWidth - currentWidth) /2 -1);
};


$(document).ready(function selectProduct() {
    $('.js-search-multiple').select2({
        placeholder: "Пошук по аукціону...",
    });

    $.ajax({
        url: '/allPlumbs',
        type: 'get',
        success : function(result){
            var products = [];
            var n =0;
            $(result).each(function () {
                products[n] ={id: "plumb"+ this.id, text: this.picture.name};
                n++;
            });
            $('.js-search-multiple').select2({
                placeholder: "Пошук по аукціону...",
                data: products
            });
        },
        error : function () {
            alert("errror load Product to Select");
        }
    });
});