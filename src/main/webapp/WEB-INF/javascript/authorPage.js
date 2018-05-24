$(function () {
    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
    $(document).ajaxSend(function(e, xhr, options) {
        xhr.setRequestHeader(header, token);
    });
});


function createAreaToEditAuthor(){
    var buffBiography = $('#biography').text();
    $('#createEditArea').text("Підтвердити редагування").attr("onclick", "confirmEditAuthor()");
    $('#cancelEdit').removeClass("hide");
    $('#biography').replaceWith($('<textarea/>',{id: "biography", type:"text", rows:"9",
        class: "outline-none col-md-12 padding-left-30px padding-top-10px border-radius-45px border-red overflow-hidden", placeholder:buffBiography}));
}

function confirmEditAuthor() {
    var authorId = $('#authorId').text();
    var newBiography = $('#biography').val();
    if (newBiography != ''){
        $.ajax({
            url: '/editAuthorBiography-' + authorId,
            type: 'post',
            contentType: 'text/plain',
            data : newBiography,
            success : function () {
                historyGo();
            },
            error : function () {
                alert("!!!!");
            }
        });
    }else {
        historyGo();
    }
}

function historyGo() {
    var authorId = $('#authorId').text();
    var page = $('#activePage').text();
    var url = "/authorWithId" + authorId + "/Page" + page;
    history.go(url);
}

function deleteAuthor(id) {
    var url = "/deleteAuthor" + id;
    console.log(url);
    $.ajax({
        url: url,
        type: 'delete',
        success : function () {
            history.back();
        },
        error : function () {
            console.log("error deleting");
        }
    });
}