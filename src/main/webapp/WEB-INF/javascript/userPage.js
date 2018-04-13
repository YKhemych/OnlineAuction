/**
 * Created by user on 26.07.2017.
 */
var $confirmEditDeliveryAddress = $('<button/>', {id: "confirmEditDeliveryAddress", class: "btn btn-danger margin-0-10", text: "Підтвердити"});
var $cancelEditDeliveryAddress = $('<a/>', { href: "/userPage"});
$cancelEditDeliveryAddress.append($('<button/>',{id: "cancelEditDeliveryAddress", class: "btn btn-danger margin-0-10", text: "Відмінити"}));
var oldName, oldSurname, oldCountryAndCity, oldStreetAndZipCode, oldPhoneOfUser, oldEmail;

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
    $('#mainCharacteristics').css("height", $('#mainCharacteristics').height() * 4);
    var randomCode = Math.random().toString(36).slice(2, 8);
    $('#mainCharacteristics').append($('<p/>', {text: "На ваш e-mail адрес надіслано лист з кодом підтвердження!!!"}));
    $('#mainCharacteristics').append($('<input>', {type: "text", class: "col-md-2", placeholder: "Confirmation code"}));
    $('#mainCharacteristics').append($('<p/>', {class: "col-md-12 padding-top-10px", text: "Новий пароль"}));
    $('#mainCharacteristics').append($('<div/>', {class: "col-md-12 padding-0"}));
    $('#mainCharacteristics').children().last().append($('<input>', {type: "text", class: "col-md-2", placeholder: "New password"}));
    $('#mainCharacteristics').children().last().append($('<input>', {type: "text", class: "col-md-2 margin-left-20px", placeholder: "Confirm new password"}));
    $('#mainCharacteristics').append($('<button/>', {id: "confirmSubstitutePassword", class: "btn btn-sm btn-danger margin-top-10px", text: "Підтвердити"}));
    $('#mainCharacteristics').append($('<a/>', {href: "/userPage"}));
    $('#mainCharacteristics').children().last().append($('<button/>',{id: "cancelSubstitutePassword", class: "btn btn-sm btn-danger margin-top-10px margin-left-20px", text: "Відмінити"}));
    console.log(randomCode);
    var email = $('#userEmail').html();
    $.ajax({
        url: '/sendConfirmationCodeOn-' + email,
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