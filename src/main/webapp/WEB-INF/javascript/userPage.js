
var $confirmEditDeliveryAddress = $('<button/>', {id: "confirmEditDeliveryAddress", class: "btn btn-danger margin-0-10", text: "Підтвердити"});
var $cancelEditDeliveryAddress = $('<a/>', { href: "/userPage"});
$cancelEditDeliveryAddress.append($('<button/>',{id: "cancelEditDeliveryAddress", class: "btn btn-danger margin-0-10", text: "Відмінити"}));
var oldName, oldSurname, oldCountryAndCity, oldStreetAndZipCode, oldPhoneOfUser, oldEmail;
var randomCode;


$('#editDeliveryAddress').click(function () {
    $('#editDeliveryAddress').remove();
    $('#divDeliveryAddress').append($confirmEditDeliveryAddress);
    $('#divDeliveryAddress').append($cancelEditDeliveryAddress);
    oldName = $('#nameOfUser').html();
    oldSurname = $('#surnameOfUser').html();
    oldCountryAndCity = $('#countryAndCity').html();
    oldCountryAndCity = oldCountryAndCity.split(",");
    oldStreetAndZipCode = $('#streetAndZipCode').html();
    oldStreetAndZipCode = oldStreetAndZipCode.split(",");
    oldPhoneOfUser = $('#phoneOfUser').html();
    console.log(oldName,oldSurname,oldCountryAndCity[0],oldStreetAndZipCode[1], oldPhoneOfUser );
    $('#nameOfUser').empty().append($('<input>', {type: "text", placeholder: oldName}));
    $('#surnameOfUser').empty().append($('<input>', {type: "text", placeholder: oldSurname}));
    $('#countryAndCity').empty().append($('<input>', {type: "text", placeholder: oldCountryAndCity[0]})).append($('<input>', {class: "margin-0-10", type: "text", placeholder: oldCountryAndCity[1]}));
    $('#streetAndZipCode').empty().append($('<input>', {type: "text", placeholder: oldStreetAndZipCode[0]})).append($('<input>', {class: "margin-0-10", type: "text", placeholder: oldStreetAndZipCode[1]}));
    $('#phoneOfUser').empty().append($('<input>', {type: "text", placeholder: oldPhoneOfUser}));
})

$confirmEditDeliveryAddress.click(function () {
    console.log("confirm");
    var username = $('#userLogin').html();
    var name = $('#nameOfUser').children().val();
    if (name == ""){
        name = oldName;
    }
    var surname = $('#surnameOfUser').children().val();
    if (surname == ""){
        surname = oldSurname;
    }
    var country = $('#countryAndCity').children().first().val();
    if (country == ""){
        country = oldCountryAndCity[0];
    }
    var city = $('#countryAndCity').children().last().val();
    if (city == ""){
        city = oldCountryAndCity[1];
    }
    var street = $('#streetAndZipCode').children().first().val();
    if (street == ""){
        street = oldStreetAndZipCode[0];
    }
    var zipCode = $('#streetAndZipCode').children().last().val();
    if (zipCode == ""){
        zipCode = oldStreetAndZipCode[1];
    }
    var phone = $('#phoneOfUser').children().val();
    if (phone == ""){
        phone = oldPhoneOfUser;
    }
    var user = {username: username ,name: name, surname: surname, country: country, city: city, street: street, zipCode: zipCode, phone: phone};
    var jsonUserEdit = JSON.stringify(user);
    $.ajax({
        url: '/editDeliveryAddress',
        type: 'post',
        contentType: 'application/json',
        data : jsonUserEdit,
        success : function () {
            top.location = $('#exitUser').attr('href');
        },
        error : function () {
            alert("!!!!");
        }
    });

});

$('#substitutePassword').click(function () {
    $('#substitutePassword').remove();
    // console.log($('#mainCharacteristics').height() * 2);
    $('#mainCharacteristics').css("height", $('#mainCharacteristics').height() * 3);
    randomCode = Math.random().toString(36).slice(2, 8);
    $('#mainCharacteristics').append($('<div/>', {id: "activeChangePassword"}));
    $('#activeChangePassword').append($('<p/>', {text: "На ваш e-mail адрес надіслано лист з кодом підтвердження!!!"}));
    $('#activeChangePassword').append($('<input>', {id:"confirmationCode", type: "text", class: "col-md-2", placeholder: "Confirmation code"}));
    $('#activeChangePassword').append($('<p/>', {class: "col-md-12 padding-top-10px", text: "Новий пароль"}));
    $('#activeChangePassword').append($('<div/>', {class: "col-md-12 padding-0"}));
    $('#activeChangePassword').children().last().append($('<input>', {id: "newPassword", type: "text", class: "col-md-2", placeholder: "New password"}));
    $('#activeChangePassword').children().last().append($('<input>', {id: "confirmNewPassword", type: "text", class: "col-md-2 margin-left-20px", placeholder: "Confirm new password"}));
    $('#activeChangePassword').append($('<button/>', {id: "confirmSubstitutePassword", class: "btn btn-sm btn-danger margin-top-10px", text: "Підтвердити", onclick: "confirmEditPasword()"}));
    $('#activeChangePassword').append($('<a/>', {href: "/userPage"}));
    $('#activeChangePassword').children().last().append($('<button/>',{id: "cancelSubstitutePassword", class: "btn btn-sm btn-danger margin-top-10px margin-left-20px", text: "Відмінити"}));
    console.log(randomCode);
    var userName = $('#userLogin').html();
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


});

$('#editEmail').click(function () {
   oldEmail = $('#userEmail').html();
    $('#userEmail').remove();
    $('#divForEmail').append($('<input>', {id: "inputForEditEmail",class: "float-left ",type: "email", placeholder: oldEmail}));

    $('#divForEmail').append($('<button/>', {id: "confirmEditEmail", class: "btn btn-sm btn-danger margin-left-20px", text: "Підтвердити", onclick: "editEmailAddress()"}));
    var buffA = $('<a/>', {href: "/userPage"});
    buffA.append($('<button/>',{id: "cancelEditEmail", class: "btn btn-sm btn-danger margin-left-20px", text: "Відмінити"}));
    $('#divForEmail').append(buffA);

});

function editEmailAddress() {
    var userLogin = $('#userLogin').html();
    var email = $('#inputForEditEmail').val();
    if (email == ""){
        email = oldEmail;
    }
    $.ajax({
        url: '/editEmail-' + userLogin,
        type: 'post',
        contentType: 'text/plain',
        data : email,
        success : function () {
            top.location = $('#exitUser').attr('href');
        },
        error : function () {
            alert("!!!!");
        }
    });
}

function confirmEditPasword() {
    var userLogin = $('#userLogin').html();
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
