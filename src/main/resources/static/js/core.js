(function ($) {
    "use strict";
    var time = "";

    $.fn.extend({
        initForm: function (options) {
            //默认参数
            var defaults = {
                jsonValue: "",
                isDebug: false   //是否需要调试，这个用于开发阶段，发布阶段请将设置为false，默认为false,true将会把name value打印出来
            }
            //如果传入的json字符串，将转为json对象
            if ($.type(options) === "string") {
                defaults.jsonValue = JSON.parse(options);
            } else {
                defaults.jsonValue = options;
            }
            //设置参数
            //var setting = $.extend({}, defaults, options);
            var setting = defaults;
            var form = this;
            var jsonValue = setting.jsonValue;
            //如果传入的json对象为空，则不做任何操作
            if (!$.isEmptyObject(jsonValue)) {
                var debugInfo = "";
                $.each(jsonValue, function (key, value) {
                    //是否开启调试，开启将会把name value打印出来
                    if (setting.isDebug) {
                        alert("name:" + key + "; value:" + value);
                        debugInfo += "name:" + key + "; value:" + value + " || ";
                    }
                    var formField = form.find("[name='" + key + "']");
                    if ($.type(formField[0]) === "undefined") {
                        if (setting.isDebug) {
                            alert("can not find name:[" + key + "] in form!!!");    //没找到指定name的表单
                        }
                    } else {
                        var fieldTagName = formField[0].tagName.toLowerCase();
                        if (fieldTagName == "input") {
                            if (formField.attr("type") == "radio") {
                                $("input:radio[name='" + key + "'][value='" + value + "']").attr("checked", "checked");
                            } else {
                                formField.val(value);
                            }
                        } else if (fieldTagName == "select") {
                            //do something special
                            formField.val(value);
                        } else if (fieldTagName == "textarea") {
                            //do something special
                            formField.val(value);
                        } else {
                            formField.val(value);
                        }
                    }
                })
                if (setting.isDebug) {
                    alert(debugInfo);
                }
            }
            //返回对象，提供链式操作
            return form;
        }
    });

    $.extend({
        getCurrentTime: function () {
            var nowDate = new Date();
            var year = nowDate.getFullYear();
            var month = standardNumber(nowDate.getMonth() + 1);
            var day = standardNumber(nowDate.getDate());
            var hour = standardNumber(nowDate.getHours());
            var miunte = standardNumber(nowDate.getMinutes());
            var second = standardNumber(nowDate.getSeconds());
            return year + "-" + month + "-" + day + " " + hour + ":" + miunte + ":" + second;
        }
    });

    function standardNumber(t) {
        return t < 10 ? "0" + t : t;
    }

    $.fn.showCurrentTime = function () {
        var timeContainer = $(this);
        setInterval(function () {
            time = getCurrentTime();
            timeContainer.html(time);
        }, 1000);
    };

    $.fn.initPage = function (r) {

        if ($(r).find("#emrLoginPage").val() == undefined) {
            this.html(r);
        } else {
            parent.location.href = "/login";
        }
    }

})(jQuery);