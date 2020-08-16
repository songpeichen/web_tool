layui.use(['table', 'layer', 'commonUtil'], function () {
});
layui.jquery(function () {
    var $ = layui.jquery;
    $('#login').click(function () {
        layui.commonUtil.ajaxPost(getContextPath() + "/login", {
            userCode: $('#userName').val(),
            password: $('#password').val()
        }, function (data) {
            if (data.success) {
                localStorage.setItem('user', JSON.stringify(data.data));
                localStorage.setItem('token', data.data['token']);
                // localStorage.getItem('user');
                // JSON.parse(localStorage.getItem('user'));
                window.location.href = "/page/index/index.html"

            } else {
                layer.msg('用户名或密码错误');
            }
        })
    })

    document.onkeydown = function (e) {
        var ev = document.all ? window.event : e;
        if (ev.keyCode == 13) {
            $('#login').trigger('click');
        }
    }
})
