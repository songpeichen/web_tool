layui.define(['jquery', 'form', 'tree', 'util', 'layer', 'table'], function (exports) {
    var $ = layui.jquery;
    var tree = layui.tree;
    var layer = layui.layer;
    var util = layui.util;
    var form = layui.form;
    var table = layui.table;
    // var formSelects = layui.formSelects;
    // var xmSelect = layui.xmSelect;

    var commonUtil = {
        getUrlPram: function (name) {
            var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
            var URL = decodeURI(window.location.search);
            var r = URL.substr(1).match(reg);
            if (r != null) {
                //decodeURI() 函数可对 encodeURI() 函数编码过的 URI 进行解码
                return decodeURI(r[2]);
            }
            return null;
        },
        serializeJson: function (form) {
            var serializeObj = {};
            var array = form.serializeArray();
            var str = form.serialize();
            $(array).each(function () {
                if (serializeObj[this.name]) {
                    if ($.isArray(serializeObj[this.name])) {
                        serializeObj[this.name].push(this.value.trim());
                    } else {
                        serializeObj[this.name] = [serializeObj[this.name], this.value.trim()];
                    }
                } else {
                    serializeObj[this.name] = this.value.trim();
                }
            });
            return serializeObj;
        },
        ajaxPost: function (url, params, callback) {
            $.ajax({
                url: url,
                type: 'POST',
                async: true,
                data: params,
                dataType: 'json',
                beforeSend: function (request) {
                    request.setRequestHeader("token", localStorage.getItem('token'));
                },
                success: function (data, textStatus, jqXHR) {
                    if (data) {
                        callback(data);
                    } else {
                        layer.message(url + "返回数据为空")
                    }
                },
                error: function (data) {
                    if (data && data.responseText == 'timeOutReLogin') {
                        layui.layer.msg('长时间未操作已掉线');
                    }

                }
            });
        },
    };

    //输出接口
    exports('commonUtil', commonUtil);
});










