layui.use(['table', 'layer', 'commonUtil'], function () {});
layui.jquery(function () {
    var $=layui.jquery;
    $('#login').click(function () {
        layui.commonUtil.ajaxPost(getContextPath()+"/login",{userCode:$('#userName').val(),password:$('#password').val()},function () {

        })
    })

    document.onkeydown = function(e) {
        var ev = document.all ? window.event : e;
        if (ev.keyCode == 13) {
            $('#login').trigger('click');
        }
    }
})
