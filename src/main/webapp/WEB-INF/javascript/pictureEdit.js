function sendToMainPictureImage(obj) {
    $('#mainPictureImage').attr("src", obj.src);
    $('#mainPictureImage').width($('#mainPictureImage').parent().width());
}

$(document).ready(function () {
    $('#mainPictureImage').attr("src", $('#allPicturePhoto').children().first().children().attr("src"));
    $('#mainPictureImage').width($('#mainPictureImage').parent().width());
    if ($('#activeMark').text() == 'true'){
        setTime();
    }
    currentBet();
});

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
