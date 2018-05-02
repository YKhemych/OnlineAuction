$(function () {
    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
    $(document).ajaxSend(function(e, xhr, options) {
        xhr.setRequestHeader(header, token);
    });
});


$(document).ready(function () {
    $('#pagination').css("padding-left", ($('#pagination').parent().width() - $('#pagination').width()) / 2);
});

$(document).ready(function () {
    var maxHeight = 0;
    $('#allAuthors').children().each(function () {
        if (maxHeight < $(this).height()){
            maxHeight = $(this).height();
        }
    });
    console.log(maxHeight);
    $('#allAuthors').children().each(function () {
        var difHeight = (maxHeight - $(this).height()) / 2;
        $(this).children().children().last().css("padding-top", difHeight + "px");
        $(this).children().children().last().css("padding-bottom", difHeight + "px");
        $(this).height(maxHeight);
    });

});
