$(function () {
    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
    $(document).ajaxSend(function(e, xhr, options) {
        xhr.setRequestHeader(header, token);
    });
});

function sendToMainPictureImage(obj) {
    $('#mainPictureImage').attr("src", obj.src);
    $('#mainPictureImage').width($('#mainPictureImage').parent().width());
}

$(document).ready(function () {
    $('#mainPictureImage').attr("src", $('#allPicturePhoto').children().first().children().attr("src"));
    $('#mainPictureImage').width($('#mainPictureImage').parent().width());
    if($('#confirmedMark').text() == 'true'){
        if ($('#activeMark').text() == 'true'){
            setTime();
            currentBet();
            setInterval(function setLastTime(){currentBet();}, 5000);
        }else{
            var owner = $('#owner').text();
            var currentUser = $('#userName').text();
            var plumbId = $('#plumbId').text();
            $.ajax({
                url: '/winnerOfPlumb'+ plumbId,
                type: 'get',
                success : function (result) {
                    if (owner == currentUser || currentUser == "admin") {
                        $('#describeOfSold').removeClass("hide").text("Продано користувачу: ");
                        $('#soldToUser').text(result.username).removeClass("hide").attr("href", "/userPage" + result.username);
                    } else if (currentUser == result.username){
                        $('#describeOfSold').removeClass("hide").text("Ви виграли цей лот. Прийміть наші привітання.");
                        if ($('#confirmedDeliver').text() != 'true') {
                            $('#soldToUserDiv').append($('<a/>', {
                                class: "col-md-6 col-md-offset-3 btn border-radius-90px margin-top-10px background-red color-white hover-back-gren outline-none white-space-pre-wrap",
                                text: "Підтвердини отримання", onclick: "confirmDeliverPlumb()"
                            }));
                        }
                    }
                },
                error : function () {
                    if (owner == currentUser || currentUser == "admin") {
                        $('#describeOfSold').removeClass("hide").text("Лот не проданий. ");
                        $('#soldToUser').removeClass("hide").text("Попробувати ще раз").attr("onclick", "createAreaToReSetPlumb()");
                    }
                }
            });
        }
    }
});

function createAreaToEditPlumb() {
    var buffName = $('#pictureName').text();
    var buffCategory = $('#pictureCategory').text();
    $('#createEditArea').text("Підтвердити редагування").attr("onclick", "confirmEditPlumb()");
    $('#cancelEdit').removeClass("hide");
    $('#pictureName').replaceWith($('<input>',{id: "pictureName", type:"text", class: "outline-none col-md-6 col-md-offset-3", placeholder:buffName}));
    $('#pictureCategory').replaceWith($('<input>',{id: "pictureCategory", type:"text", list:"categories", class: "outline-none", placeholder:buffCategory}));
    $('#pictureCategory').after($('<datalist/>', {id:"categories"}))
    $.ajax({
        url: '/allCategory',
        type: 'get',
        success : function (result) {
            for (var i = 0; i < result.length; i++) {
                $('#categories').append($('<option/>', {text: result[i].name}))
            }
        },
        error : function () {
            alert("!!!!");
        }
    });
}

function confirmEditPlumb() {
    var pictureId = $('#pictureId').text();
    var newName = $('#pictureName').val();
    if (newName != ''){
        $.ajax({
            url: '/editPlumbName-' + pictureId,
            type: 'post',
            contentType: 'text/plain',
            data : newName,
            success : function () {
                nextStep()
            },
            error : function () {
                alert("!!!!");
            }
        });
    } else {nextStep();}
    function nextStep() {
        var newCategory = $('#pictureCategory').val();
        if (newCategory != '') {
            $.ajax({
                url: '/editPlumbCategory-' + pictureId,
                type: 'post',
                contentType: 'text/plain',
                data: newCategory,
                success: function () {
                    historyGo();
                },
                error: function () {
                    alert("!!!!");
                }
            });
        } else {historyGo();}
    }
}

function historyGo() {
    var plumbId = $('#plumbId').text();
    var url = "/plumb" + plumbId;
    history.go(url);
}

function createAreaToReSetPlumb() {
    $('#soldToUser').removeAttr("onclick");
    $('#soldToUserDiv').append($('<div/>',{id: "divPictureDateOfEnd", class: "margin-top-10px padding-5px background-blond-grey border-white border-radius-45px overflow-hidden"}))
    $('#divPictureDateOfEnd').append($('<input>',{id: "pictureDateOfEnd", type:"datetime-local", class:"col-md-7 padding-left-20px padding-top-5px outline-none background-blond-grey", placeholder:"Дата завершення"}))
        .append($('<p/>',{text:"Оберіть дату завершення аукціону", title: "Оберіть дату завершення аукціону",
            class:"col-md-5 margin-0 background-red color-white border-radius-90px padding-5px text-align-center white-space-nowrap text-overflow-ellipsis overflow-hidden"}));
    $('#soldToUserDiv').append($('<a/>', {class:"hover-back-gren btn color-white background-red border-radius-90px padding-0-15px margin-top-10px outline-none", text:"Повторно виставити лот", onclick: "reSetPlumb()"}))
}

function reSetPlumb(){
    var dateOfEnd = $('#pictureDateOfEnd').val();
    var plumbId = $('#plumbId').text();
    if (dateOfEnd == ""){
        $('#errorMessage').remove();
        $('#divPictureDateOfEnd').after($('<p/>',{id: "errorMessage",text:"Введіть дату та час завершення аукціону", class:"padding-5px margin-0 text-align-center white-space-nowrap text-overflow-ellipsis overflow-hidden"}))
    } else {
        $.ajax({
            url: '/resetPlumb-' + plumbId,
            type: 'post',
            contentType: 'text/plain',
            data : dateOfEnd,
            success : function () {
                history.back();
            },
            error : function () {
                alert("!!!!");
            }
        });
    }
}

function confirmDeliverPlumb() {
    var plumbId = $('#plumbId').text();
    $.ajax({
        url: '/confirmDeliverPlumb',
        type: 'post',
        contentType: 'text/plain',
        data : plumbId,
        success : function () {
            historyGo();
        },
        error : function () {
            alert("!!!!");
        }
    });
}

function setTime() {
    var dateOfEnd = $('#dateOfEnd').text();
    var mainTime = dateOfEnd.split(" ");
    var date = mainTime[0];
    date = date.split("-");
    var time = mainTime[1].split(".");
    time = time[0].split(":");
    $('#dateOfEnd').text(date[0] + "-" + date[1] + "-" + date[2] + " " + time[0] + ":" + time[1]);
    time[0] = time[0] - 0;
    time[1] = time[1] - 0;
    time[2] = time[2] - 0;
    date[1] = date[1] - 1;
    var buffDate = new Date(date[0], date[1], date[2], time[0], time[1], time[2], 0);
    setInterval(function setLastTime(){
        var currentDate = new Date();
        var lastTime = buffDate - currentDate;
        var days = Math.floor(lastTime / 60000 / 60 / 24);
        if (days > 0){
            lastTime = lastTime - days * 60000 * 60 * 24;
        }
        var hours = Math.floor(lastTime / 60000 / 60);
        if (hours > 0){
            lastTime = lastTime - hours * 60000 * 60;
        }
        var minutes = Math.floor(lastTime / 60000);
        if (minutes > 0){
            lastTime = lastTime - minutes * 60000;
        }
        var seconds = Math.floor(lastTime / 1000);
        if (seconds > 0){
            lastTime = lastTime - seconds * 1000;
        }
        $('#timeToEnd').text(days + " д. "+ hours + ":" + minutes + ":" + seconds);
    }, 1000);
}

function currentBet() {
    var plumbId = $('#plumbId').text();
    $.ajax({
        url: '/numberOfBetIn'+ plumbId,
        type: 'get',
        success : function (result) {
            if (result != 0){
                $('#currentBet').text("Поточна ціна (" + result);
                $.ajax({
                    url: '/maxBetIn'+ plumbId,
                    type: 'get',
                    success : function (result) {
                        $('#currentBet').text($('#currentBet').text() + " ст.): " + result.price + "грн");
                        $('#betSize').attr("placeholder", result.price);
                        $('#betSize').attr("min", result.price);
                    },
                    error : function () {
                        alert("!!!!");
                    }
                });
            }
        },
        error : function () {
            alert("!!!!");
        }
    });

}


function makeABet() {
    var betSize = $('#betSize').val();
    var plumbId = $('#plumbId').text();
    var userName = $('#userName').text();
    console.log(userName);
    $.ajax({
        url: '/makeBetTo' + plumbId + "By" + userName,
        type: 'post',
        contentType: 'text/plain',
        data : betSize,
        success : function () {
            console.log('yes');
            currentBet();
        },
        error : function () {
            alert("!!!!");
        }
    });
    console.log(plumbId);
}

function deletePlumb(id) {
    $.ajax({
        url: '/deletePlumb' + id,
        type: 'delete',
        success : function () {
            alert("deleting was success");
            history.back();
        },
        error : function () {
            console.log("error deleting");
        }
    });
}
