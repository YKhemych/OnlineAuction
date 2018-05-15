$(function () {
    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
    $(document).ajaxSend(function(e, xhr, options) {
        xhr.setRequestHeader(header, token);
    });
});

$(document).ready(function () {
    $('#pagination').css("padding-left", ($('#pagination').parent().width() - $('#pagination').width()) / 2);

    var maxHeight = [0,0,0,0,0];
    var buff = 0;
    var buffNumberOfRows = 0;

    $('#allAuthors').children().each(function () {
        if (buff == 4){
            buffNumberOfRows ++;
            buff = 0;
        }
        if (maxHeight[buffNumberOfRows] < $(this).height()){
            maxHeight[buffNumberOfRows] = $(this).height();
        }
        buff ++;
    });
    console.log(maxHeight);
    buff = 0;
    buffNumberOfRows = 0;

    $('#allAuthors').children().each(function () {
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

    buff = 0;
    buffNumberOfRows = 0;

    $('#allPlumbs').children().each(function () {
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

    $('#allPlumbs').children().each(function () {
        if (buff == 4){
            buffNumberOfRows ++;
            buff = 0;
        }
        var difHeight = (maxHeight[buffNumberOfRows] - $(this).height()) / 2;
        $(this).children().children().last().css("padding-top", difHeight/2 + "px");
        $(this).children().children().last().css("padding-bottom", difHeight/2 + "px");
        $(this).children().css("margin-bottom", difHeight + "px");
        $(this).height(maxHeight[buffNumberOfRows]);
        buff ++;
    });

});
