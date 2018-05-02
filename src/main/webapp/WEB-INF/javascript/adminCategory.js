$(function () {
    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
    $(document).ajaxSend(function(e, xhr, options) {
        xhr.setRequestHeader(header, token);
    });
});

//                                      ---Category---

function createCategoryTable() {
    $('#category').attr("disabled", "true");
    var $workspace = $('#workspace');
    $('#categoryDiv').remove();


    $workspace.append($('<div/>',{id:"categoryDiv", class: "row margin-top-10px padding-top-10px border-blond-grey"}));
    $('#categoryDiv').append($('<div/>', {id:"categoryFunction", class: "col-md-11"}));

    $('#categoryFunction').append($('<div/>',{id:"mainCategoryFunction", class: "btn-group float-left padding-0-10px"}));
    $('#mainCategoryFunction').append($('<label/>',{class: "btn btn-danger", text: "  Редагування"}));
    $('#mainCategoryFunction').children().last().prepend($('<input>',{type:"radio", name:"options", id:"markToEditCategory", onclick: "markToEditCategory()"}));
    $('#mainCategoryFunction').append($('<label/>',{class: "btn btn-danger ", text: "  Видалення"}));
    $('#mainCategoryFunction').children().last().prepend($('<input>',{type:"radio", name:"options", id:"markToDeleteCategory", onclick: "markToDeleteCategory()"}));

    $('#categoryFunction').append($('<div/>',{id:"additionCategoryFunction", class: "btn-sm"}));
    $('#additionCategoryFunction').append($('<button/>',{id:"confirmationDeleteCategory", class:"btn btn-danger visibility-hidden", text:"Підтвердити видалення", onclick:"confirmationDeleteCategory()"}));

    $('#categoryDiv').append($('<div/>',{id:"categoryDivClose", class: "col-md-1"}));
    $('#categoryDivClose').append($('<button/>',{id: "closeCategoryDiv", class: "close",text: "X", onclick: "closeCategoryDiv()"}));

    $('#categoryDiv').append($('<div/>',{id:"categoryDivTable", class: "col-md-11"}));
    $('#categoryDivTable').append($('<table/>',{id: "categoryTable", class: "table"}));
    $('#categoryTable').append($('<thead/>',{id: "categoryThead"}));
    $('#categoryThead').append($('<tr/>',{class: "tr"}));
    $('#categoryThead tr').append("<th>Id</th>");
    $('#categoryThead tr').append("<th>Ім'я розділу</th>");
    $('#categoryThead tr').append("<th>Id бат/кат</th>");
    $('#categoryTable').append($('<tbody/>',{id: "categoryTbody"}));

    $.ajax({
        url: '/allCategory',
        type: 'get',
        success : function (result) {
            var lastId;
            $(result).each(function () {
                $('#categoryTbody').append($('<tr/>', {id: "categ" + this.id}));
                $("#"+ "categ" + this.id).append($('<td/>',{class: "categoryId", text: `${this.id}`}));
                $("#"+ "categ" + this.id).append($('<td/>',{class: "categoryName", text: `${this.name}`, onclick: "selectOption(this)"}));
                $("#"+ "categ" + this.id).append($('<td/>',{class: "idFatherCategory", text: `${this.idFatherCategories}`, onclick: "selectOption(this)"}));
                lastId = this.id;
            });
            $('#categoryTbody').append($('<tr/>',{id:"categ" + (lastId + 1)}));
            $("#"+ "categ" + (lastId +1)).append($('<td/>',{class: "categoryId", text: "#"}));
            $("#"+ "categ" + (lastId + 1)).append($('<td/>',{id: "thForCategoryName", class: "categoryName"}));
            $('#thForCategoryName').append($('<input>',{id: "categoryName", type: "text", name: "categoryName", class: "border-dark-grey outline-none"}));
            $("#"+ "categ" + (lastId + 1)).append($('<td/>',{id: "thForIdFatherCategory", class: "idFatherCategory"}));
            $('#thForIdFatherCategory').append($('<input>',{id: "idFatherCategory", type: "text", name: "idFatherCategory", class: "border-dark-grey outline-none"}));
            $("#"+ "categ" + (lastId + 1)).append($('<td/>',{id:"thForCategoryButton",  class: ""}));
            $('#thForCategoryButton').append($('<button/>',{id: "saveCategory", class: "btn btn-danger outline-none",text: "Додати", onclick: "saveCategory()"}));


        },
        error : function () {
            alert("error !!!!!!!!!!!!");
        }
    });
}

$('#category').click(createCategoryTable);

function createConfirmedPlumbTable() {
    $('#confirmedPlumb').attr("disabled", "true");
    var $workspace = $('#workspace');
    $('#confirmedPlumbDiv').remove();


    $workspace.append($('<div/>',{id:"confirmedPlumbDiv", class: "row margin-top-10px padding-top-10px border-blond-grey"}));

    $('#confirmedPlumbDiv').append($('<div/>',{id:"confirmedPlumbDivTable", class: "col-md-11"}));
    $('#confirmedPlumbDiv').append($('<div/>',{id:"confirmedPlumbDivClose", class: "col-md-1"}));
    $('#confirmedPlumbDivClose').append($('<button/>',{id: "closeConfirmedPlumbDiv", class: "close",text: "X", onclick: "closeConfirmedPlumbDiv()"}));
    $('#confirmedPlumbDivTable').append($('<table/>',{id: "confirmedPlumbTable", class: "table"}));
    $('#confirmedPlumbTable').append($('<thead/>',{id: "confirmedPlumbThead"}));
    $('#confirmedPlumbThead').append($('<tr/>',{class: "tr"}));
    $('#confirmedPlumbThead tr').append("<th>Id</th>");
    $('#confirmedPlumbThead tr').append("<th>Картина</th>");
    $('#confirmedPlumbThead tr').append("<th>Ім'я власника</th>");
    $('#confirmedPlumbTable').append($('<tbody/>',{id: "confirmedPlumbTbody"}));

    $.ajax({
        url: '/plumbWithoutConfirmed',
        type: 'get',
        success : function (result) {
            $(result).each(function () {
                console.log(this.picture);
                var picture = this.picture;
                var user = this.user;
                $('#confirmedPlumbTbody').append($('<tr/>', {id: "confirmedPlumbId" + this.id}));
                $("#"+ "confirmedPlumbId" + this.id).append($('<td/>',{class: "confirmedPlumbId", text: `${this.id}`}));
                $("#"+ "confirmedPlumbId" + this.id).append($('<td/>',{id:"tdForPictureName"+ this.id}));
                $("#tdForPictureName" + this.id).append($('<a/>',{href:"/plumb" + this.id, class:"color-red", text: `${picture.name}`}));
                $("#"+ "confirmedPlumbId" + this.id).append($('<td/>',{id: "tdForOwnerName" + this.id, text:`${user.username}`}));
            });
        },
        error : function () {
            alert("error !!!!!!!!!!!!");
        }
    });
}
$('#confirmedPlumb').click(createConfirmedPlumbTable);

///////////////////////////

var catN = 0;
var $bCategoryChange = $('<button/>', {id: "change", class: "btn btn-danger btn-sm",text: "Enter", onclick: "confirmChangeCategory()"});
var $bCategoryClose = $('<button/>', {id: "closeChange", class: "btn btn-danger btn-sm",text: "X", onclick: "closeChangeCategory()"});
var $tdCategoryBuff;
var buffTextCategory;
var deleteCategoryArr = [];
var lenghtCategoryArr = deleteCategoryArr.length;

var EditCategory= false;
var DeleteCategory= false;


function closeCategoryDiv() {
    $('#categoryDiv').remove();
    $('#category').removeAttr("disabled");
    deleteCategoryArr = [];
    lenghtCategoryArr = 0;
    console.log("closeDiv");
}

function closeConfirmedPlumbDiv() {
    $('#confirmedPlumbDiv').remove();
    $('#confirmedPlumb').removeAttr("disabled");
    console.log("closeDiv");
}

function saveCategory() {
    console.log("hello111");
    var categoryName = $('#categoryName').val();
    var idFatherCategory = $('#idFatherCategory').val();
    var category = {name: categoryName, idFatherCategories: idFatherCategory};
    var jsonCategorySave = JSON.stringify(category);

    $.ajax({
        url: '/saveCategory',
        type: 'post',
        contentType: 'application/json',
        data : jsonCategorySave,
        success : function () {
            createCategoryTable();
        },
        error : function () {
            alert("!!!!");
        }
    });

};

function markToEditCategory() {
    for (var i = 0; i < deleteCategoryArr.length; i++) {
        if (deleteCategoryArr[i] != null){
            $('#' + "categ" + deleteCategoryArr[i]).removeClass("background-delete");
        }
    }
    deleteCategoryArr = [];
    lenghtCategoryArr = 0;
    $('#markToEditCategory').attr("disabled", "true");
    $('#markToDeleteCategory').removeAttr("disabled");
    EditCategory = true;
    DeleteCategory = false;
    $('#confirmationDeleteCategory').addClass("visibility-hidden");
}

function markToDeleteCategory() {
    $('#markToDeleteCategory').attr("disabled", "true");
    $('#markToEditCategory').removeAttr("disabled");
    EditCategory = false;
    DeleteCategory = true;
    $('#confirmationDeleteCategory').removeClass("visibility-hidden");
}

function confirmationDeleteCategory() {
    for (var i = 0; i < deleteCategoryArr.length; i++) {
        if (deleteCategoryArr[i] != null){
            var url = "/deleteCategory-" + deleteCategoryArr[i];
            console.log(url);
            $.ajax({
                url: url,
                type: 'delete',
                success : function () {
                    createCategoryTable();
                },
                error : function () {
                    console.log("error deleting");
                }
            });
        }
    }
}


function selectOption(obj){
    console.log(obj);

    if ( EditCategory == true && DeleteCategory == false ) {

        if (($(obj).attr("class").includes("categoryName") && !$(obj).parent().children().first().text().includes("#"))
            || ($(obj).attr("class").includes("idFatherCategory") && !$(obj).parent().children().first().text().includes("#"))) {
            catN++;
            // console.log(n);
            if (catN == 1) {
                $('#saveCategory').attr("disabled", "true");

                $tdCategoryBuff = $(obj);
                buffTextCategory = $(obj).html();
                // console.log(buffText);

                $(obj).parent().append($('<td/>', {id: "bufferCategory"}));
                $(obj).parent().children().last().append($bCategoryChange);
                $(obj).parent().children().last().append($bCategoryClose);

                $tdCategoryBuff.empty();
                $tdCategoryBuff.append($('<input>', {id: "newNameCategory", type: "text", class: "border-dark-grey outline-none"}));


            }
        }

    }
    if ( EditCategory == false && DeleteCategory == true ) {
        if (!$(obj).parent().children().first().text().includes("#")){
            if(!deleteCategoryArr.includes($(obj).parent().children().first().text())){
                console.log(lenghtCategoryArr);
                deleteCategoryArr[lenghtCategoryArr]= $(obj).parent().children().first().text();
                console.log(deleteCategoryArr);
                $(obj).parent().addClass("background-delete");
                lenghtCategoryArr++;

            }else{
                $(obj).parent().removeClass("background-delete");
                for (var i = 0; i < deleteCategoryArr.length; i++) {
                    if (deleteCategoryArr[i] == $(obj).parent().children().first().text()){
                        console.log("delete -"+deleteCategoryArr[i]);
                        delete deleteCategoryArr[i];
                    }
                }

            }
        }
    }
}


function confirmChangeCategory() {
    // workChange = false;
    catN=0;
    console.log("change");
    var newTextCategory = $tdCategoryBuff.children().val();

    if ($tdCategoryBuff.attr("class").includes("categoryName")){
        var id = $tdCategoryBuff.parent().children().first().html();
        var name = newTextCategory;
        var idFatherCategory = $tdCategoryBuff.parent().children().eq(2).html();
        var category = {id: id,name: name, idFatherCategories: idFatherCategory};
        var jsonCategoryRename = JSON.stringify(category);
        $.ajax({
            url: '/changeNameCategory',
            type: 'post',
            contentType: 'application/json',
            data : jsonCategoryRename,
            success:function () {
                alert("RENAME ok");
            },
            error:function () {
                alert("errrrrrrorrr!!!!!!!!!");
            }
        });
    }else{
        var id = $tdCategoryBuff.parent().children().first().html();
        var name = $tdCategoryBuff.parent().children().eq(1).html();
        var idFatherCategory = newTextCategory;
        var category = {id: id,name: name, idFatherCategories: idFatherCategory};
        console.log(category);
        var jsonCategoryChangeIDFC = JSON.stringify(category);
        $.ajax({
            url: '/changeIdFatherCategory',
            type: 'post',
            contentType: 'application/json',
            data : jsonCategoryChangeIDFC,
            success:function () {
                alert("CHANGE IDFC ok");
            },
            error:function () {
                alert("errrrrrrorrr!!!!!!!!!");
            }
        });
    };

    $('#bufferCategory').remove();
    $('#saveCategory').removeAttr("disabled");
    $tdCategoryBuff.empty();
    $tdCategoryBuff.text(newTextCategory);
};

function closeChangeCategory() {
    catN=0;
    $tdCategoryBuff.empty();
    $tdCategoryBuff.text(buffTextCategory);
    $('#bufferCategory').remove();
    $('#saveCategory').removeAttr("disabled");
    console.log("close");
};












