layui.use(['table', 'layer', 'commonUtil'], function () {
});
layui.jquery(function () {
    var $ = layui.jquery;
    $('#login').click(function () {

    })

    JSON.parse(localStorage.getItem('user'));
    if (localStorage.getItem('user')) {
        layer.msg("登陆成功");
        var user = JSON.parse(localStorage.getItem('user'));
        $('#userName').text(user.userName)
    } else {
        layer.msg("登陆失败")
    }


    document.logout = function () {
        localStorage.setItem('user', null);
        localStorage.setItem('token', null);
        window.location.href = "/login.html"

    }
    document.msg = function (msg) {
        layui.layer.msg(msg);
    }
    $('.frameBtn').click(function () {
        $('.iframe').hide();
        var $btn = $(this);
        var id = $btn.attr('id');
        var $frame = $('#'+id+'Frame');
        if(!$frame.attr('src')){
            $frame.attr('src','../subModules/'+id+'.html')
        }
        $('#'+id+'Frame').show();
    })
    document.onkeydown = function (e) {
        var ev = document.all ? window.event : e;
        if (ev.keyCode == 13) {
            $('#login').trigger('click');
        }
    }
})
