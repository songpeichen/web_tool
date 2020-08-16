layui.use(['table', 'layer', 'commonUtil', 'form','laydate'], function () {
});
layui.jquery(function () {
    layui.form.render();
    var $ = layui.jquery;



    var callbackDate = new Date();
    callbackDate.setMonth(callbackDate.getMonth()+1);

    //设置开始时间
    var startDate = layui.laydate.render({
        elem: '#callbackDate',
        value: callbackDate,
        format:'yyyy-MM-dd HH:mm:ss',
        type: 'datetime',
        trigger: 'click',
        done: function (value, date) {
            // if(value){
            //     endDate.config.min={
            //         year:date.year,
            //         month:date.month - 1,
            //         date:date.date
            //     }
            // }
        }
    });


    layui.form.on('switch(needCallback)', function (dataSwitch) {
        //开关修改后的状态，true或者false
        var checked = dataSwitch.elem.checked;
        if(!checked){
            $('#callbackDate').val(null);
            $('#callbackDateDiv').hide();
        }else {
            $('#callbackDateDiv').show();
        }
    });

    //监听提交
    layui.form.on('submit(formSubmit)', function (data) {
        if(data.field.needCallback=='1'&&(!data.field.callbackDate)){
            layui.layer.msg('需要选择回访时间');
            return false;
        }
        layui.commonUtil.ajaxPost(getContextPath() + "/info/addInfo", data.field, function (data) {
            if (data.success) {
                layui.layer.msg('添加成功');
                $('#reset').trigger('click');
            }
        })
        return false;
    });

})
