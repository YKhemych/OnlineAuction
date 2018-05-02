$(function () {
    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
    $(document).ajaxSend(function(e, xhr, options) {
        xhr.setRequestHeader(header, token);
    });
});




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