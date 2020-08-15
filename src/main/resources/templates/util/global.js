layui.config({
    base: '/util/'      //自定义layui组件的目录
}).extend({

    //自定义组件
    commonUtil:  'modules/commonUtil',
    // httpUtil: 'httpUtil',
    // pageUtil: 'pageUtil',
    // tableUtil: 'tableUtil',
    //
    //soultable第三方组件
    //excel: 'soultable/excel',
    // fileSaver: 'soultable/fileSaver',
    // soulTable: 'soultable/soulTable',
    // tableChild: 'soultable/tableChild',
    // //tableFilter: 'soultable/tableFilter',
    // tableMerge: 'soultable/tableMerge',
    // xlsx: 'soultable/xlsx',
    //formSelects多选下拉
    // formSelects: 'formselects/formSelects-v4',
    // transferExt:'transfer/transferExt',
    // //多选择组件 xm-select  效率比formSelects高
    // xmSelect: 'xm-select/xm-select',
    //
    //树形
    // eleTree: 'eleTree/eleTree',
    // cascader: 'eleTree/cascader',
    // dropdown: 'eleTree/dropdown',
    // eFlowChart: 'eleTree/eFlowChart',
    // scrollBar: 'eleTree/scrollBar',
    // step: 'eleTree/step'

});
function getContextPath() {
    var contextPath = "/web_tool";
    return contextPath;
}