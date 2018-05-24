$(function () {
    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
    $(document).ajaxSend(function(e, xhr, options) {
        xhr.setRequestHeader(header, token);
    });
});

function changePassword() {
    $('#substitutePassword').remove();
    var userName = $('#userName').html();
    randomCode = Math.random().toString(36).slice(2, 8);
    $('#headline').after($('<div/>',{id:"divForChangePassword", class: "col-md-10 col-md-offset-1 padding-top-30px padding-left-30px padding-bottom-20px border-radius-45px background-white row"}));
    $('#divForChangePassword').append($('<div/>', {id: "activeChangePassword", class: "col-md-10 col-md-offset-1 padding-top-30px padding-left-30px padding-bottom-20px"}));
    $('#activeChangePassword').append($('<p/>', {text: "На ваш e-mail адрес надіслано лист з кодом підтвердження!!!"}));
    $('#activeChangePassword').append($('<input>', {id:"confirmationCode", type: "text", class: "col-md-3 outline-none", placeholder: "Confirmation code"}));
    $('#activeChangePassword').append($('<p/>', {class: "col-md-12 padding-top-10px", text: "Новий пароль"}));
    $('#activeChangePassword').append($('<div/>', {class: "col-md-12 padding-0"}));
    $('#activeChangePassword').children().last().append($('<input>', {id: "newPassword", type: "password", class: "col-md-2 outline-none", placeholder: "New password"}));
    $('#activeChangePassword').children().last().append($('<input>', {id: "confirmNewPassword", type: "password", class: "col-md-2 outline-none margin-left-20px", placeholder: "Confirm new password"}));
    $('#activeChangePassword').append($('<button/>', {id: "confirmSubstitutePassword", class: "btn border-radius-45px color-white background-red hover-back-gren margin-top-10px padding-0-40px", text: "Підтвердити", onclick: "confirmEditPasword()"}));
    $('#activeChangePassword').append($('<a/>', {href: "/userPage"+ userName}));
    $('#activeChangePassword').children().last().append($('<button/>',{id: "cancelSubstitutePassword", class: "btn border-radius-45px color-white background-red hover-back-gren margin-top-10px margin-left-20px padding-0-40px", text: "Відмінити"}));
    $.ajax({
        url: '/sendConfirmationCodeTo-' + userName,
        type: 'post',
        contentType: 'text/plain',
        data : randomCode,
        success : function () {
            alert("oK");
        },
        error : function () {
            alert("!!!!");
        }
    });


};

function confirmEditPasword() {
    var userLogin = $('#userName').html();
    var confirmationCode = $('#confirmationCode').val();
    var newPassword = $('#newPassword').val();
    var confirmNewPassword = $('#confirmNewPassword').val();
    if (randomCode == confirmationCode){
        if (newPassword == confirmNewPassword && newPassword != ""){
            $.ajax({
                url: '/editPassword-' + userLogin,
                type: 'post',
                contentType: 'text/plain',
                data : newPassword,
                success : function () {
                    $('#activeChangePassword').remove();
                    $('#messageArea').remove();
                    $('#mainCharacteristics').css("height", $('#mainCharacteristics').height() / 2.4);
                    $('#mainCharacteristics').append($('<p/>', {class: "padding-left-10px", text: "Пароль змінено!!!"}));
                },
                error : function () {
                    alert("!!!!");
                }
            });
        } else {
            $('#messageArea').remove();
            $('#mainCharacteristics').append($('<p/>', {id: "messageArea", class: "color-red margin-top-5px", text: "Паролі не збігаються"}));
        }
    }else{
        $('#mainCharacteristics').append($('<p/>', {id: "messageArea", class: "color-red margin-top-5px", text: "Код підтвердження не коректний"}));
    }
}

function addEditCharacteristic() {
    var loginUser = $('#userName').text();
    var userFromUserPage = $('#nameOfUser').text();
    if (loginUser == userFromUserPage){
        $('#editArea').append($('<a/>', {id:"editButton", class: "color-red margin-0-10", text: "Редагувати", onclick: "editCharacteristic()"}));
        $('#editArea').append($('<a/>', {class: "color-red margin-0-10", text: "Змінити пароль", onclick: "changePassword()"}));
        $('#addPlumbArea').removeClass("hide");
        $('#plumbWhichBoughtByUser').removeClass("hide");

    }
}

function editCharacteristic(){
    $('#editButton').removeAttr("onclick");
    var userName = $('#userName').html();
    $('#headline').after($('<div/>', {id: "describeOfEdit", class: "col-md-6 col-md-offset-3 padding-left-30px border-radius-45px background-white row"}));
    $('#describeOfEdit').append($('<p/>', {class: "display-i-b padding-top-10px",text: "Натисніть на поле яке ви хочете редагувати."}));
    $('#describeOfEdit').append($('<a/>',{href: "/userPage"+ userName, class: "btn btn-sm border-radius-45px color-white background-red hover-back-gren margin-left-20px margin-top-5px padding-0-15px float-right", text: "Відмінити редагування"}));
    $('#email').attr("onclick", "editEmail()");
    $('.edit').attr("onclick", "createEditArea(this)").removeAttr("href");


}

function createEditArea(obj){
    $('.edit').removeAttr("onclick");
    var buffText = obj.innerHTML;
    var buffId = obj.id;
    switch (buffId){
        case 'email':
            $('#'+ buffId).replaceWith($('<input>', {id: "inputForEdit",class: "col-md-4 padding-left-20px padding-top-5px margin-0 outline-none background-blond-grey color-dark-grey font-size-14px-Lato",type: "email", placeholder: buffText}));
            break;
        case 'phone':
            $('#'+ buffId).replaceWith($('<input>', {id: "inputForEdit",class: "col-md-4 padding-left-20px padding-top-5px margin-0 outline-none background-blond-grey color-dark-grey font-size-14px-Lato",type: "tel", placeholder: buffText}));
            break;
        case 'zipCode':
            $('#'+ buffId).replaceWith($('<input>', {id: "inputForEdit", max: "99999", class: "col-md-4 padding-left-20px padding-top-5px margin-0 outline-none background-blond-grey color-dark-grey font-size-14px-Lato",type: "number", placeholder: buffText}));
            break;
        case 'facebookURL':
            $('#'+ buffId).replaceWith($('<input>', {id: "inputForEdit", class: "col-md-4 col-md-offset-4 padding-left-20px padding-top-5px outline-none background-blond-grey color-dark-grey font-size-14px-Lato",type: "text", placeholder: buffText}));
            break;
        default:
            $('#'+ buffId).replaceWith($('<input>', {id: "inputForEdit",class: "col-md-4 padding-left-20px padding-top-5px margin-0 outline-none background-blond-grey color-dark-grey font-size-14px-Lato",type: "text", placeholder: buffText}));
            break
    }
    $('#inputForEdit').after($('<button/>',{id: "cancelForEdit", class: "btn border-radius-45px color-white background-red hover-back-gren margin-left-20px padding-0-15px outline-none", text: "Відмінити", onclick: "closeEdit('" + buffId + "')"}));
    $('#inputForEdit').after($('<button/>', {id: "confirmForEdit", class: "btn border-radius-45px color-white background-red hover-back-gren padding-0-15px outline-none", text: "Підтвердити", onclick: "successEdit('" + buffId + "')"}));
}

function successEdit(idElement) {
    var userLogin = $('#userName').html();
    var buffText = $('#inputForEdit').val();
    if (buffText == ""){
        buffText = $('#inputForEdit').attr("placeholder");;
    }
    switch (idElement){
        case "email":
            $.ajax({
                url: '/editEmail-' + userLogin,
                type: 'post',
                contentType: 'text/plain',
                data : buffText,
                success : function () {
                    $('#cancelForEdit').remove();
                    $('#confirmForEdit').remove();
                    $('#inputForEdit').replaceWith($('<p>', {id: idElement, class: "col-md-7 padding-left-20px padding-top-5px margin-0 outline-none background-blond-grey color-dark-grey font-size-14px-Lato",text: "На вашу нову ел. пошту був надісланий лист з підтвердженням"}));
                    $('.edit').attr("onclick", "createEditArea(this)");
                },
                error : function () {
                    alert("!!!!");
                }
            });
            break;
        case "name":
            $.ajax({
                url: '/editName-' + userLogin,
                type: 'post',
                contentType: 'text/plain',
                data : buffText,
                success : function () {
                    changeInputToP(idElement, buffText);
                },
                error : function () {
                    alert("!!!!");
                }
            });
            break;
        case "surname":
            $.ajax({
                url: '/editSurname-' + userLogin,
                type: 'post',
                contentType: 'text/plain',
                data : buffText,
                success : function () {
                    changeInputToP(idElement, buffText);
                },
                error : function () {
                    alert("!!!!");
                }
            });
            break;
        case "phone":
            $.ajax({
                url: '/editPhone-' + userLogin,
                type: 'post',
                contentType: 'text/plain',
                data : buffText,
                success : function () {
                    changeInputToP(idElement, buffText);
                },
                error : function () {
                    alert("!!!!");
                }
            });
            break;
        case "country":
            $.ajax({
                url: '/editCountry-' + userLogin,
                type: 'post',
                contentType: 'text/plain',
                data : buffText,
                success : function () {
                    changeInputToP(idElement, buffText);
                },
                error : function () {
                    alert("!!!!");
                }
            });
            break;
        case "city":
            $.ajax({
                url: '/editCity-' + userLogin,
                type: 'post',
                contentType: 'text/plain',
                data : buffText,
                success : function () {
                    changeInputToP(idElement, buffText);
                },
                error : function () {
                    alert("!!!!");
                }
            });
            break;
        case "zipCode":
            $.ajax({
                url: '/editZipCode-' + userLogin,
                type: 'post',
                contentType: 'text/plain',
                data : buffText,
                success : function () {
                    changeInputToP(idElement, buffText);
                },
                error : function () {
                    alert("!!!!");
                }
            });
            break;
        case "facebookURL":
            $.ajax({
                url: '/editFacebookURL-' + userLogin,
                type: 'post',
                contentType: 'text/plain',
                data : buffText,
                success : function () {
                    $('#cancelForEdit').remove();
                    $('#confirmForEdit').remove();
                    $('#inputForEdit').replaceWith($('<a>', {id: idElement, class: "col-md-4 col-md-offset-4 btn border-radius-90px background-red color-white hover-back-gren outline-none edit",text: "Сторінка в facebook"}));
                    $('.edit').attr("onclick", "createEditArea(this)");
                },
                error : function () {
                    alert("!!!!");
                }
            });
            break;
    }

}

function closeEdit(idElement){
    var buffText = $('#inputForEdit').attr("placeholder");
    if (idElement != 'facebookURL'){
        changeInputToP(idElement, buffText);
    } else {
        $('#cancelForEdit').remove();
        $('#confirmForEdit').remove();
        $('#inputForEdit').replaceWith($('<a>', {id: idElement, class: "col-md-4 col-md-offset-4 btn border-radius-90px background-red color-white hover-back-gren outline-none edit",text: "Сторінка в facebook"}));
        $('.edit').attr("onclick", "createEditArea(this)");
    }

}

function changeInputToP(idElement, buffText) {
    $('#cancelForEdit').remove();
    $('#confirmForEdit').remove();
    $('#inputForEdit').replaceWith($('<p>', {id: idElement, class: "col-md-7 padding-left-20px padding-top-5px margin-0 outline-none background-blond-grey color-dark-grey font-size-14px-Lato edit",text: buffText}));
    $('.edit').attr("onclick", "createEditArea(this)");
}

function blockUser(){
    var userLogin = $('#nameOfUser').text();
    $('#blockUser').attr("onclick", "unblockUser()").text("Розблокувати користувача").attr("id", "unblockUser");
    $.ajax({
        url: '/admin/blockUser-' + userLogin,
        type: 'post',
        success : function () {
            alert("user was blocked");
        },
        error : function () {
            alert("!!!!");
        }
    });
}

function unblockUser(){
    var userLogin = $('#nameOfUser').text();
    $('#unblockUser').attr("onclick", "blockUser()").text("Блокувати користувача").attr("id", "blockUser");
    $.ajax({
        url: '/admin/unblockUser-' + userLogin,
        type: 'post',
        success : function () {
            alert("user was unblocked");
        },
        error : function () {
            alert("!!!!");
        }
    });
}

$(document).ready(function () {
    addEditCharacteristic();

    var maxHeight = [0,0,0];
    var buff = 0;
    var buffNumberOfRows = 0;

    $('#boughtPlumbs').children().each(function () {
        if (buff == 4){
            buffNumberOfRows ++;
            buff = 0;
        }
        if (maxHeight[buffNumberOfRows] < $(this).height()){
            maxHeight[buffNumberOfRows] = $(this).height();
        }
        buff ++;
    });
    buff = 0;
    buffNumberOfRows = 0;

    $('#boughtPlumbs').children().each(function () {
        if (buff == 4){
            buffNumberOfRows ++;
            buff = 0;
        }
        var difHeight = (maxHeight[buffNumberOfRows] - $(this).height()) / 2;
        $(this).children().children().last().css("padding-top", difHeight/ 2 + "px");
        $(this).children().children().last().css("padding-bottom", difHeight/ 2 + "px");
        $(this).children().css("margin-bottom", difHeight + "px");
        $(this).height(maxHeight[buffNumberOfRows]);
        buff ++;
    });

    maxHeight = [0,0];
    buff = 0;
    buffNumberOfRows = 0;

    $('#addedPlumbs').children().each(function () {
        if (buff == 4){
            buffNumberOfRows ++;
            buff = 0;
        }
        if (maxHeight[buffNumberOfRows] < $(this).height()){
            maxHeight[buffNumberOfRows] = $(this).height();
        }
        buff ++;
    });
    buff = 0;
    buffNumberOfRows = 0;

    $('#addedPlumbs').children().each(function () {
        if (buff == 4){
            buffNumberOfRows ++;
            buff = 0;
        }
        var difHeight = (maxHeight[buffNumberOfRows] - $(this).height()) / 2;
        $(this).children().children().last().css("padding-top", difHeight/ 2 + "px");
        $(this).children().children().last().css("padding-bottom", difHeight/ 2 + "px");
        $(this).children().css("margin-bottom", difHeight + "px");
        $(this).height(maxHeight[buffNumberOfRows]);
        buff ++;
    });
});

