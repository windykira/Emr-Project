$(function () {

});

function loadPage(url){
    $.ajax({
        cache: true,
        type: "GET",
        url: url,
        error: function (request) {
            parent.layer.alert("Connection error");
        },
        success: function (data) {
            $(".main").initPage(data);
        }
    });
}
