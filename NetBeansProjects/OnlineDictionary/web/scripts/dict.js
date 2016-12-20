/**
 * Created by 985361 on 12/16/2016.
 */
"use strict";
var getresult = (function () {

    var callajax = function () {
        $.ajax("http://localhost:8080/OnlineDictionary/DictServlet", {
            "type": "post",
            dataType: 'json',
            "data": {
                "searchkey": $("#search").val()
            }
        })
                .done(function (data) {

                    $.each(data, function (i, item) {
                        var li = $("<li><a></a></li>");
                        $("#content").append(li);
                        $(li).text("("+item.wordtype+") :: "+item.definition);
                    });

                })
                .fail(function (errMsg) {
                    alert(errMsg);
                });
    };
    
    return {
        result: function () {
            callajax();
        }
    };
})();

$(document).ready(function () {
    $("#btnsearch").click(getresult.result);
});