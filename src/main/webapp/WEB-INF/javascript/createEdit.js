

var numberOfPhoto = 0;
var $activeProduct;


$('#addPhotoToPicture').click(function () {
    if (numberOfPhoto < 10){
       numberOfPhoto += 1;
       $('#photoInfo').text(numberOfPhoto + " із 10");
       var bufElem = $('#picturePhotoArea').append($('<div/>', {class: "row background-blond-grey border-radius-45px margin-right-30px border-white"}));
       $('#picturePhotoArea').children().last().append($('<input>',{id: "imagePicture-" + numberOfPhoto, name: "picturePhotoList", form: "formForSaveProductPhoto", type: "file", accept: "image/*", class: "hide", onchange: "getFileName(this)"}));
       $('#picturePhotoArea').children().last().append($('<label/>',{for: "imagePicture-" + numberOfPhoto, text: "Вибрати файл", class: "col-md-4 text-align-center padding-0-40px margin-5px background-red color-white hover-back-gren border-radius-45px font-size-14px-Lato white-space-nowrap"}));
       $('#picturePhotoArea').children().last().append($('<p/>',{id: "imageName-" + numberOfPhoto, class: "col-md-6 margin-0 padding-top-10px overflow-hidden text-overflow-ellipsis white-space-nowrap"}));
       $('#picturePhotoArea').children().last().append($('<button/>',{class: "close col-md-1 margin-top-5px hover-cl-red outline-none",text: "x", onclick: "deleteProductPicture(this)"}));
    }
});

function deleteProductPicture(obj) {
    numberOfPhoto--;
    $('#photoInfo').text(numberOfPhoto + " із 10");
    obj.parentNode.remove();
}

function getFileName(currentFile) {
    var file = currentFile.value;
    file = file.replace (/\\/g, "/").split ('/').pop ();
    var arrayNumbersFromId = currentFile.id.split('-');
    var lastNumber = arrayNumbersFromId[arrayNumbersFromId.length - 1];
    console.log(lastNumber);
    $('#imageName-' + lastNumber).text('Імя файлу: ' + file)
}

function time(obj) {
    var datetime = obj.value.split("T");
    obj.value = datetime[0] + " " + datetime[1];
    console.log(obj.value);



}




// $('#saveProduct').click(function () {
//     console.log("function Save Product");
//     var categoryId = $('#categoryIdToAddProduct').text();
//
//     $('#formForSaveProductPhoto').attr('action', "/saveProduct" + $activeProduct.text() + "ToCategory" + categoryId);
//
//     $('#formForSaveProductPhoto').submit();
//
// });


// function sendToMainProductImage(obj) {
//     $('#mainProductImage').attr("src", obj.src);
//     $('#mainProductImage').width($('#mainProductImage').parent().width());
// }



//resize Image
// $(document).ready(function () {
//     $('#mainProductImage').attr("src", $('#allProductPhoto').children().first().children().children().attr("src"));
//     $('#mainProductImage').width($('#mainProductImage').parent().width());
// });



// function deleteProduct(id) {
//     $.ajax({
//         url: '/deleteProduct' + id,
//         type: 'delete',
//         success : function () {
//             alert("deleting was success");
//             history.back();
//         },
//         error : function () {
//             console.log("error deleting");
//         }
//     });
// }



