<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page isELIgnored="false" %>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>多维检索</title>

    <!-- Google Font: Source Sans Pro -->
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="plugins/fontawesome-free/css/all.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <!-- Tempusdominus Bootstrap 4 -->
    <link rel="stylesheet"
          href="plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css">
    <!-- iCheck -->
    <link rel="stylesheet" href="plugins/icheck-bootstrap/icheck-bootstrap.min.css">
    <!-- JQVMap -->
    <link rel="stylesheet" href="plugins/jqvmap/jqvmap.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="dist/css/adminlte.min.css">
    <!-- overlayScrollbars -->
    <link rel="stylesheet" href="plugins/overlayScrollbars/css/OverlayScrollbars.min.css">
    <!-- Daterange picker -->
    <link rel="stylesheet" href="plugins/daterangepicker/daterangepicker.css">
    <!-- summernote -->
    <link rel="stylesheet" href="plugins/summernote/summernote-bs4.min.css">
    <link rel="stylesheet" href="plugins/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="plugins/bootstrap/js/bootstrap-datetimepicker.min.css">
    <style>
        .layui-table-cell .layui-form-checkbox[lay-skin="primary"] {
            top: 50%;
            transform: translateY(-50%);
        }
    </style>
</head>

<body class="hold-transition sidebar-mini layout-fixed">
<div class="wrapper">

    <!-- Preloader -->
    <div class="preloader flex-column justify-content-center align-items-center">
        <img class="animation__shake" src="dist/img/AdminLTELogo.png" alt="AdminLTELogo" height="60"
             width="60">
    </div>

    <!-- Navbar -->
    <nav class="main-header navbar navbar-expand navbar-white navbar-light">
        <!-- Left navbar links -->
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" data-widget="pushmenu" href="#" role="button"><i
                        class="fas fa-bars"></i></a>
            </li>
            <li class="nav-item d-none d-sm-inline-block">
                <a href="allStationJump-query" class="nav-link">首页</a>
            </li>
            <li class="nav-item d-none d-sm-inline-block">
                <a href="contact.jsp" class="nav-link">联系我们</a>
            </li>
        </ul>

        <!-- Right navbar links -->
        <ul class="navbar-nav ml-auto">
            <!-- Navbar Search -->
            <li class="nav-item">
                <a class="nav-link" data-widget="navbar-search" href="#" role="button">
                    <i class="fas fa-search"></i>
                </a>
                <div class="navbar-search-block">
                    <form class="form-inline">
                        <div class="input-group input-group-sm">
                            <input class="form-control form-control-navbar" type="search"
                                   placeholder="Search" aria-label="Search">
                            <div class="input-group-append">
                                <button class="btn btn-navbar" type="submit">
                                    <i class="fas fa-search"></i>
                                </button>
                                <button class="btn btn-navbar" type="button"
                                        data-widget="navbar-search">
                                    <i class="fas fa-times"></i>
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
            </li>

            <!-- Messages Dropdown Menu -->
            <li class="nav-item dropdown">
                <a class="nav-link" data-toggle="dropdown" href="#">
                    <i class="far fa-comments"></i>
                    <span class="badge badge-danger navbar-badge">3</span>
                </a>

            </li>
            <!-- Notifications Dropdown Menu -->
            <li class="nav-item dropdown">
                <a class="nav-link" data-toggle="dropdown" href="#">
                    <i class="far fa-bell"></i>
                    <span class="badge badge-warning navbar-badge">15</span>
                </a>

            </li>
            <li class="nav-item">
                <a class="nav-link" data-widget="fullscreen" href="#" role="button">
                    <i class="fas fa-expand-arrows-alt"></i>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" data-widget="control-sidebar" data-slide="true" href="#"
                   role="button">
                    <i class="fas fa-th-large"></i>
                </a>
            </li>
        </ul>
    </nav>
    <!-- /.navbar -->

    <!-- Main Sidebar Container -->
    <aside class="main-sidebar sidebar-dark-primary elevation-4">
        <!-- Brand Logo -->
        <a href="index3.html" class="brand-link">
            <img src="dist/img/AdminLTELogo.png" alt="AdminLTE Logo"
                 class="brand-image img-circle elevation-3" style="opacity: .8">
            <span class="brand-text font-weight-light">车辆排检管理系统</span>
        </a>

        <!-- Sidebar -->
        <div class="sidebar">
            <!-- Sidebar user panel (optional) -->
            <div class="user-panel mt-3 pb-3 mb-3 d-flex">
                <div class="info">
                    <a href="#" class="d-block">尊敬的<strong>${status}</strong>，您好！</a>
                </div>
            </div>

            <!-- SidebarSearch Form -->
            <div class="form-inline">
                <div class="input-group" data-widget="sidebar-search">
                    <input class="form-control form-control-sidebar" type="search"
                           placeholder="Search" aria-label="Search">
                    <div class="input-group-append">
                        <button class="btn btn-sidebar">
                            <i class="fas fa-search fa-fw"></i>
                        </button>
                    </div>
                </div>
            </div>

            <!-- Sidebar Menu -->
            <nav class="mt-2">
                <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu"
                    data-accordion="false">
                    <li class="nav-item">
                        <a href="#" class="nav-link">
                            <i class="nav-icon fas fa-tachometer-alt"></i>
                            <p>
                                检测信息
                                <i class="right fas fa-angle-left"></i>
                            </p>
                        </a>
                        <ul class="nav nav-treeview">

                            <li class="nav-item">
                                <a href="dailyDetection.jsp" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>当日检测信息</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="queryCamera?detection_id=${detection_id}" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>实时摄像头信息</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="detectionInfo-query?detection_id=${detection_id}"
                                   class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>检测信息汇总</p>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item">
                        <a href="#" class="nav-link">
                            <i class="nav-icon fas fa-th"></i>
                            <p>
                                当日预警信息
                                <span class="right badge badge-danger">New</span>
                            </p>
                        </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href="stationData-query?detection_id=${detection_id}"
                                   class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>当日预警</p>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item menu-open">
                        <a href="#" class="nav-link active">
                            <i class="nav-icon fas fa-table"></i>
                            <p>
                                历史信息检索
                                <i class="fas fa-angle-left right"></i>
                            </p>
                        </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href="selectInfo-query?detection_id=${detection_id}"
                                   class="nav-link active">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>信息检索</p>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item">
                        <a href="attention.jsp" class="nav-link">
                            <i class="nav-icon fas fa-chart-pie"></i>
                            <p>
                                重点关注
                            </p>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="#" class="nav-link">
                            <i class="nav-icon fas fa-cog"></i>
                            <p>
                                系统设置
                                <i class="right fas fa-angle-left"></i>
                            </p>
                        </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href="queryLine?detection_id=${detection_id}" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>检测道管理</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="queryStaff?detection_id=${detection_id}" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>员工管理</p>
                                </a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </nav>
            <!-- /.sidebar-menu -->
        </div>
        <!-- /.sidebar -->
    </aside>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <div class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h1 class="m-0">多维检索</h1>
                    </div><!-- /.col -->
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="#">首页</a></li>
                            <li class="breadcrumb-item active">多维检索</li>
                        </ol>
                    </div><!-- /.col -->
                </div><!-- /.row -->
            </div><!-- /.container-fluid -->
        </div>
        <!-- /.content-header -->

        <!-- Main content -->
        <section class="content">
            <div class="container-fluid">
                <div class="layui-card">
                    <div class="layui-card-body">
                        <label>
                            <label style="height: 10px;">&nbsp;</label>
                            <div class="row">
                                检测线&nbsp;
                                <div class="col-sm-2">
                                    <select
                                            class="form-control form-control-sm custom-select custom-select-sm"
                                            name="test_line" id="test_line">
                                        <option value="all" selected="">全部</option>
                                        <c:forEach var="line" items="${lineList}">
                                            <option value="${line}">${line}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                &nbsp;事件类型&nbsp;
                                <div class="col-sm-2">
                                    <select
                                            class="form-control form-control-sm custom-select custom-select-sm"
                                            name="error_type" id="error_type">
                                        <option value="all" selected="">全部</option>
                                        <option value="颜色不符">颜色不符</option>
                                        <option value="车型不符">车型不符</option>
                                    </select>
                                </div>
                                &nbsp;负责人&nbsp;
                                <div class="col-sm-2">
                                    <select
                                            class="form-control form-control-sm custom-select custom-select-sm"
                                            name="staff" id="staff">
                                        <option value="all" selected="">全部</option>
                                        <c:forEach var="staff" items="${staffList}">
                                            <option value="${staff}">${staff}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                处理进度&nbsp;
                                <div class="col-sm-3">
                                    <select
                                            class="form-control form-control-sm custom-select custom-select-sm"
                                            name="solve_progress" id="solve_progress">
                                        <option value="all" selected="">全部</option>
                                        <option value="0">未处理</option>
                                        <option value="1">处理中</option>
                                        <option value="2">已处理</option>
                                    </select>
                                </div>
                            </div>
                            <label style="height: 10px;">&nbsp;</label>
                            <div class="row">
                                起始时间&nbsp;
                                <div class='col-sm-2'>
                                    <div class="form-group">
                                        <!--指定 date标记-->
                                        <div class='input-group date' id='datetimepicker1'>
                                            <input type='text' class="form-control" name="beginTime"
                                                   style="height: 30px;" id="beginTime"/>
                                            <span class="input-group-addon">
                                                                    <span class="glyphicon glyphicon-calendar"></span>
                                                                </span>
                                        </div>
                                    </div>
                                </div>
                                终止时间&nbsp;
                                <div class='col-sm-2'>
                                    <div class="form-group">
                                        <!--指定 date标记-->
                                        <div class='input-group date' id='datetimepicker2'>
                                            <input type='text' class="form-control" name="endTime"
                                                   style="height: 30px;" id="endTime"/>
                                            <span class="input-group-addon">
                                                                    <span class="glyphicon glyphicon-calendar"></span>
                                                                </span>
                                        </div>
                                    </div>
                                </div>
                                处理完成时间&nbsp;
                                <div class='col-sm-2'>
                                    <div class="form-group">
                                        <!--指定 date标记-->
                                        <div class='input-group date' id='datetimepicker3'>
                                            <input type='text' class="form-control" name="solveTime"
                                                   style="height: 30px;" id="solveTime"/>
                                            <span class="input-group-addon">
                                                                    <span class="glyphicon glyphicon-calendar"></span>
                                                                </span>
                                        </div>
                                    </div>
                                </div>
                                <button class="btn btn-primary btn-sm" id="btn4" data-type="reload"
                                        style="margin-left: 15px;height: 30px;">搜索
                                </button>
                            </div>
                        </label>
                    </div>
                </div>
                <table class="layui-hide" id="LAY_table_user4" lay-filter="user"></table>
            </div>
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
</div>
<!-- ./wrapper -->

<!-- jQuery -->
<script src="plugins/jquery/jquery.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="plugins/jquery-ui/jquery-ui.min.js"></script>
<!-- Bootstrap 4 -->
<script src="plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- Sparkline -->
<script src="plugins/sparklines/sparkline.js"></script>
<!-- jQuery Knob Chart -->
<script src="plugins/jquery-knob/jquery.knob.min.js"></script>
<!-- daterangepicker -->
<script src="plugins/moment/moment.min.js"></script>
<script src="plugins/daterangepicker/daterangepicker.js"></script>
<!-- Tempusdominus Bootstrap 4 -->
<script src="plugins/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js"></script>
<!-- Summernote -->
<script src="plugins/summernote/summernote-bs4.min.js"></script>
<!-- overlayScrollbars -->
<script src="plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"></script>
<!-- AdminLTE App -->
<script src="dist/js/adminlte.js"></script>
<script src="plugins/layui/layui.js"></script>
<!--转换时间格式-->
<script type="text/javascript">
    function dateToStr(date) {
        var time = new Date(date.time);
        var y = time.getFullYear();
        var M = time.getMonth() + 1;
        M = M < 10 ? ("0" + M) : M;
        var d = time.getDate();
        d = d < 10 ? ("0" + d) : d;
        var h = time.getHours();
        var str = y + "-" + M + "-" + d;
        return str;
    }
</script>
<script>
    layui.use('table', function () {
        var table = layui.table;

        //第一个实例
        tableLink = table.render({
            elem: '#LAY_table_user4'
            , url: 'historyException-query?detection_id=${detection_id}' //数据接口
            , toolbar: true //开启头部工具栏
            , cellMinWidth: 120 //全局定义常规单元格的最小宽度
            , id: 'testReload4'
            , page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
                layout: ['limit', 'count', 'prev', 'page', 'next', 'skip'] //自定义分页布局
                , groups: 1 //只显示 1 个连续页码
                , first: false //不显示首页
                , last: false //不显示尾页
            }
            , cols: [[ //表头
                {type: 'checkbox', fixed: 'left'}
                , {
                    field: 'sign', title: "状态", width: 80, fixed: 'left', templet: function (d) {
                        var solve_progress = d.solve_progress;
                        if (solve_progress == "0") {
                            return `<div class="layer-photos-demo" onclick="img_click()" style="cursor:pointer; text-align: center;">
                                      <img layer-pid="untreated"  layer-src="dist/img/untreated.png" src="dist/img/untreated.png" alt="正常" style="width: 20px; height: 20px;">
                                    </div>`;
                        } else if (solve_progress == "1") {
                            return `<div class="layer-photos-demo" onclick="img_click()" style="cursor:pointer; text-align: center;">
                                      <img layer-pid="processing"  layer-src="dist/img/processing.png" src="dist/img/processing.png" alt="异常" style="width: 20px; height: 20px;">
                                    </div>`;
                        } else if (solve_progress == "2") {
                            return `<div class="layer-photos-demo" onclick="img_click()" style="cursor:pointer; text-align: center;">
                                      <img layer-pid="processed"  layer-src="dist/img/processed.png" src="dist/img/processed.png" alt="异常" style="width: 20px; height: 20px;">
                                    </div>`;
                        }
                    }
                }
                , {field: 'id', title: '检测序号', sort: true, fixed: true, width: 120}
                , {field: 'car_id', title: '车牌号', sort: true, width: 120}
                , {
                    field: 'detection_date',
                    title: '检测日期',
                    sort: true,
                    width: 120,
                    templet: '<div>{{dateToStr(d.detection_date)}}</div>'
                }

                , {field: 'error_type', title: '异常类型', sort: true, width: 120}
                , {field: 'error_describe', title: '异常描述', sort: true, width: 120}

                , {field: 'staff_id', title: '负责人', sort: true, width: 80}
                , {
                    field: 'solve_progress',
                    title: '处理进度',
                    sort: true,
                    width: 120,
                    fixed: 'right',
                    templet: function (d) {
                        var solve_progress = d.solve_progress;
                        if (solve_progress == "0") {
                            return "未处理";
                        } else if (solve_progress == "1") {
                            return "处理中";
                        } else if (solve_progress == "2") {
                            return "已处理";
                        }
                    }
                }
                , {
                    field: 'solve_time',
                    title: '处理完成时间',
                    sort: true,
                    width: 140,
                    fixed: 'right',
                    templet: function (d) {
                        var solve_time = dateToStr(d.solve_time);
                        if (solve_time == '1970-01-01') {
                            return "— —";
                        } else {
                            return solve_time;
                        }
                    }
                }
                , {
                    field: 'report', title: '报告', sort: true, width: 80,fixed: 'right',
                    templet: '<div><a class="col-2" href="generateReport?detection_id=${detection_id}&id={{d.id}}&car_id={{d.car_id}}&detection_date={{dateToStr(d.detection_date)}}&test_result={{d.test_result}}&error_type={{d.error_type}}&error_describe={{d.error_describe}}&staff_id={{d.staff_id}}">'+
                        '<i class="nav-icon far fa-edit" title="修改"></i>'+
                        '</a></div>'
                }
                , {
                    field: 'operation',
                    title: '操作',
                    fixed: 'right',
                    width: 70,
                    templet: '<div>' +
                        '<a class="col-2" data-toggle="modal" data-target="#C{{d.car_id}}"><i class="nav-icon far fa-edit" title="车辆详情"></i> </a>' +
                        '<div class="modal fade" id="C{{d.car_id}}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"> <div class="modal-dialog"> <div class="modal-content"> <div class="modal-header"> <h4 class="modal-title text-left">车辆详情</h4> <button type="button" class="close" data-dismiss="modal" aria-hidden="true"> &times; </button> </div> <div class="modal-body"> <form class="form-horizontal" role="form" action="updateStation?id=${station.id}" method="post">  <div class="form-group row"> <label class="col-sm-4 control-label">站点编号</label> <div class="col-sm-8"> <input type="text" class="form-control" value="{{d.detection_id}}" name="detection_id" disabled=""> </div> </div> <div class="form-group row"> <label class="col-sm-4 control-label">检测线</label><div class="col-sm-8"><input type="text" class="form-control" value="{{d.test_line}}" name="test_line" disabled=""></div> </div> <div class="form-group row"> <label class="col-sm-4 control-label">图片</label><div class="col-sm-8"><input type="text" class="form-control" value="{{d.error_picture}}" name="car_color" disabled=""></div> </div> <div class="modal-footer"><button type="button" class="btn btn-default" data-dismiss="modal">关闭</button></div></form></div></div></div>'
                }
            ]]
        });
        var $ = layui.$, active = {
            reload: function () {

                var test_line = $('#test_line');
                var error_type = $('#error_type');
                var staff = $('#staff');
                var solve_progress = $('#solve_progress');
                var beginTime = $('#beginTime');
                var endTime = $('#endTime');
                var solveTime = $('#solveTime');
                //执行重载
                table.reload('testReload4', {
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                    , where: {
                        flag: "true",
                        test_line: test_line.val(),
                        error_type: error_type.val(),
                        staff: staff.val(),
                        solve_progress: solve_progress.val(),
                        beginTime: beginTime.val(),
                        endTime: endTime.val(),
                        solveTime: solveTime.val(),
                        detection_id: ${ detection_id }
                    }
                });
            }
        };

        $('#btn4').on('click', function () {
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });
    });
</script>
<script src="plugins/bootstrap/js/moment-with-locales.min.js"></script>
<script src="plugins/bootstrap/js/bootstrap-datetimepicker.min.js"></script>
<script src="plugins/bootstrap/js/bootstrap-datetimepicker.zh-CN.js"></script>
<script type="text/javascript">
    $(function () {
        var picker1 = $('#datetimepicker1').datetimepicker({
            language: 'zh-CN',//显示中文
            format: 'yyyy-mm-dd',//显示格式
            minView: "month",//设置只显示到月份
            initialDate: new Date(),
            autoclose: true,//选中自动关闭
            todayBtn: true,//显示今日按钮
            locale: moment.locale('zh-cn')
        });
        var picker2 = $('#datetimepicker2').datetimepicker({
            language: 'zh-CN',//显示中文
            format: 'yyyy-mm-dd',//显示格式
            minView: "month",//设置只显示到月份
            initialDate: new Date(),
            autoclose: true,//选中自动关闭
            todayBtn: true,//显示今日按钮
            locale: moment.locale('zh-cn')
        });
        var picker3 = $('#datetimepicker3').datetimepicker({
            language: 'zh-CN',//显示中文
            format: 'yyyy-mm-dd',//显示格式
            minView: "month",//设置只显示到月份
            initialDate: new Date(),
            autoclose: true,//选中自动关闭
            todayBtn: true,//显示今日按钮
            locale: moment.locale('zh-cn')
        });

    });
</script>
</body>

</html>