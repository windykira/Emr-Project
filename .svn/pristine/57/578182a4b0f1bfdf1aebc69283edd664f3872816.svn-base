$(function(){

    $(document.body).find("table").each(function(i,e){
        $(e).on('check.bs.table', function (e,row, element){
            /*$(element).parent().closest("tr").css("background-color","#7ebfc1");*/
            $(element).parent().parent().css("background-color","#7ebfc1");
        });

        $(e).on('uncheck.bs.table', function (e,row, element){
            $(element).parent().closest("tr").css("background-color","");
        });

        $(e).on('check-all.bs.table', function (_e,rows){
            $(e).find("tbody").find("tr").css("background-color","#7ebfc1");
        });

        $(e).on('uncheck-all.bs.table', function (_e,rows){
            $(e).find("tbody").find("tr").css("background-color","");
        });
    });


})