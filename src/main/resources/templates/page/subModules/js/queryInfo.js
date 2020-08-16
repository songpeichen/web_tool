layui.use(['table', 'layer', 'commonUtil'], function () {
});
layui.jquery(function () {
    var $ = layui.jquery;

    document.queryInfo = function () {
        layui.table.render({
            elem: '#infoList',
            url: getContextPath()+"/info/queryInfo",
            toolbar: '',
            defaultToolbar: [],
            title: '信息查询',
            where:{},
            method: 'POST',
            headers: {token: localStorage.getItem("token")},
            request: {
                pageName: "pageNum", //页码的参数名称，默认：pageNum
                limitName: "pageSize" //每页数据量的参数名，默认：pageSize
            },
            parseData: function (res) { //res 即为原始返回的数据
                return {
                    "code": res.code, //解析接口状态
                    "msg": res.msg, //解析提示文本
                    "count": res.data.total, //解析数据长度
                    "data": res.data.rows //解析数据列表
                };
            },
            page: true,
            text: {none: '暂无相关数据'},
            cols: [[
                {type: 'checkbox', fixed: 'left',width:'3%' ,backgroundColor:'red'},
                {field: 'Num', align:"center", title: '序号',type:'numbers'},
                {field: 'patientName', title:'患者姓名',align:"center",width: '16%',event: 'infoView', style:'cursor: pointer;color:blue',templet:function (d) {
                    return d.patientName;
                    }},
                {field: 'needCallback', title:'需要回访',align:"center",width: '10%',templet:function(d){
                    if(d.needCallback==1){
                        return '是'
                    }else {
                        return '否'
                    }
                }},
                {field: 'callbackDate', title:'回访时间',align:"center",width: '11%', templet:function (d) {
                    return d.callbackDate;
                }},
                {field: 'sex', title:'性别',align:"center",width: '8%',templet:function (d) {
                    if(d.sex=='M'){
                        return '男';
                    }else if(d.sex=='F'){
                        return '女';
                    }else {
                        return ''
                    }
                    }},
                {field: 'summary', title:'摘要',align:"center",width: '16%',templet:function (d) {
                    return (d.summary?d.summary:'');
                }},
                {field: 'createDate', title:'登记时间',align:"center",width: '15%',templet:function (d) {
                    return d.createDate;
                }},
                {field: 'createUserCode', title:'登记人',align:"center",width: '15%',templet:function (d) {
                    return d.createUserCode;
                }},
                {field: 'remarks', title:'详情',align:"center",width: '25%',templet:function (d) {
                    return d.remarks?d.remarks:'';
                }},
                // {fixed: 'right', align:"center", title: '操作', width: '10%',templet:function(d){
                //         var buttons = "";
                //         if(d.processStatus=="0"){
                //             buttons+='<a class="layui-btn layui-btn-xs"  lay-event="receive" topMode="readonly" topWidth="800px" topHeight="600px" topTitle="领取" inputs="id:">领取</a>';
                //         }
                //         if(printFlag=='1'){
                //             buttons+='<a class="layui-btn layui-btn-xs"  lay-event="print" topMode="readonly" topWidth="800px" topHeight="600px" topTitle="打印" inputs="id:">打印</a>';
                //         }
                //         return buttons;
                //     }},
            ]],
            done: function(res, curr, count){
                // document.distributeHistoryModel = res.distributeHistoryModel;
            }
        });
    }

    document.onkeydown = function (e) {
        var ev = document.all ? window.event : e;
        if (ev.keyCode == 13) {
            document.queryInfo();
        }
    }
})
