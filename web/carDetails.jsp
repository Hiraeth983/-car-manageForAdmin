<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    request.setAttribute("car_id", request.getParameter("car_id"));
%>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>机动车排放检验管理系统</title>

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
    <style>
        .layui-table-cell .layui-form-checkbox[lay-skin="primary"] {
            top: 50%;
            transform: translateY(-50%);
        }

        .file {
            position: relative;
            display: inline-block;
            background: #D0EEFF;
            border: 1px solid #99D3F5;
            border-radius: 4px;
            padding: 4px 12px;
            overflow: hidden;
            color: #1E88C7;
            text-decoration: none;
            text-indent: 0;
            line-height: 30px;
        }

        .file input {
            position: absolute;
            font-size: 100px;
            right: 0;
            top: 0;
            opacity: 0;
        }

        .file:hover {
            background: #AADFFD;
            border-color: #78C3F3;
            color: #004974;
            text-decoration: none;
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
                    <!-- Add icons to the links using the .nav-icon class
with font-awesome or any other icon font library -->
                    <li class="nav-item">
                        <a href="#" class="nav-link">
                            <i class="nav-icon fas fa-tachometer-alt"></i>
                            <p>
                                控制面板
                                <i class="right fas fa-angle-left"></i>
                            </p>
                        </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href="stationData-query?detection_id=${detection_id}"
                                   class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>每日预警</p>
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
                    <li class="nav-item menu-open">
                        <a href="#" class="nav-link active">
                            <i class="nav-icon fas fa-th"></i>
                            <p>
                                预警处理
                                <span class="right badge badge-danger">New</span>
                            </p>
                        </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href="dailyException.jsp" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>当日预警信息</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="exception.jsp" class="nav-link active">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>历史预警信息</p>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item">
                        <a href="#" class="nav-link">
                            <i class="nav-icon fas fa-table"></i>
                            <p>
                                检测信息
                                <i class="fas fa-angle-left right"></i>
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
                                <a href="historyDetection.jsp" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>历史检测信息</p>
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
                            <i class="nav-icon fas fa-search"></i>
                            <p>
                                综合检索
                                <i class="fas fa-angle-left right"></i>
                            </p>
                        </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href="selectInfo-query?detection_id=${detection_id}"
                                   class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>多维检索</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="#"
                                   class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>员工行为检索</p>
                                </a>
                            </li>
                        </ul>
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
                                <a href="queryCamera?detection_id=${detection_id}" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>摄像头管理</p>
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
                        <h1 class="m-0">车辆详情信息</h1>
                    </div>
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="#">首页</a></li>
                            <li class="breadcrumb-item active">预警处理</li>
                        </ol>
                    </div><!-- /.col -->
                </div><!-- /.row -->
            </div><!-- /.container-fluid -->
        </div>
        <!-- /.content-header -->

        <!-- Main content -->
        <section class="content">
            <div class="container-fluid">
                <div class="demoTable">
                    本车辆历史检测信息：
                    <div class="layui-inline">
                        <input class="layui-input" name="id" id="demoReload" autocomplete="off" placeholder="ID搜索">
                    </div>
                    <button class="layui-btn" id="btn" data-type="reload">搜索</button>
                </div>

                <table class="layui-hide" id="LAY_table_user" lay-filter="user"></table>


                <div class="demoTable">
                    本车辆历史异常信息：
                    <div class="layui-inline">
                        <input class="layui-input" name="id" id="demoReload4" autocomplete="off" placeholder="ID搜索">
                    </div>
                    <button class="layui-btn" id="btn4" data-type="reload">搜索</button>
                    <!-- 按钮触发模态框 -->
                    <button class="btn btn-primary" data-toggle="modal" data-target="#myModal">添加异常信息</button>
                    <!-- 模态框（Modal） -->
                    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
                         aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h4 class="modal-title text-left" id="myModalLabel">添加异常</h4>
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                        &times;
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <form role="form" method="post" action="">
                                        <div class="form-group">
                                            <label for="exampleDetectionId">站点编号</label><input type="text"
                                                                                               class="form-control"
                                                                                               name="detection_id"
                                                                                               value="${detection_id}"
                                                                                               id="exampleDetectionId"
                                                                                               disabled/>
                                        </div>
                                        <div class="form-group">
                                            <label for="exampleTestLine">检测线</label><input type="text"
                                                                                           class="form-control"
                                                                                           name="test_line"
                                                                                           value="${test_line}"
                                                                                           id="exampleTestLine"
                                                                                           disabled/>
                                        </div>
                                        <div class="form-group">
                                            <label for="exampleDetectionDate">检测日期</label><input type="date"
                                                                                                 class="form-control"
                                                                                                 name="detection_date"
                                                                                                 id="exampleDetectionDate"/>
                                        </div>
                                        <div class="form-group">
                                            <label for="exampleCarId">车牌号</label><input type="text" class="form-control"
                                                                                        name="car_id"
                                                                                        value="${car_id}"
                                                                                        id="exampleCarId"/>
                                        </div>
                                        <div class="form-group">
                                            <label for="exampleErrorType">异常类型</label>
                                            <select class="form-control" name="error_type" id="exampleErrorType">
                                                <option value="all" selected="">请选择</option>
                                                <option value="有黑烟尾气，不达标">有黑烟尾气，不达标</option>
                                                <option value="采样管操作错误">采样管操作错误</option>
                                                <option value="引导员上车不足一分钟">引导员上车不足一分钟</option>
                                                <option value="非法进入检测线行为">非法进入检测线行为</option>
                                                <option value="车底盘有损坏">车底盘有损坏</option>
                                                <option value="车身有损坏">车身有损坏</option>
                                                <option value="车辆有违章">车辆有违章</option>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <label for="exampleErrorDescribe">异常描述</label>
                                            <textarea class="form-control" name="error_describe" value=""
                                                      id="exampleErrorDescribe" rows="5"></textarea>
                                        </div>
                                    </form>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                    <button type="submit" class="btn btn-primary">提交</button>
                                </div>
                            </div><!-- /.modal-content -->
                        </div><!-- /.modal -->
                    </div>
                </div>

                <table class="layui-hide" id="LAY_table_user4" lay-filter="user"></table>

                <div class="card shadow">
                    <div class="card-body">
                        <div class="row">
                            <div class="col-md-6 text-nowrap">
                                <div id="dataTable_length" class="dataTables_length" aria-controls="dataTable">
                                    <label>
                                        上传视频或图片&nbsp;
                                    </label>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="text-md-right dataTables_filter" id="dataTable_filter">
                                    <form class="d-none d-sm-inline-block mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search"
                                          action="ProductServlet" method="POST" enctype="multipart/form-data">
                                        <div class="input-group">
                                            <a href="javascript:;" class="file">选择文件
                                                <input type="file" name="" id="addImage" multiple>
                                            </a>
                                            <div class="input-group-append">
                                                <button type="submit" class="btn btn-primary" id="subButton">开始上传
                                                </button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="table-responsive table mt-2 col-md-6" role="grid"
                                 aria-describedby="dataTable_info">
                                <table class="table my-0" id="dataTable">
                                    <thead>
                                    <tr>
                                        <td class="text-center">图片/视频</td>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td id="myShow"></td>
                                    </tr>
                                    </tbody>
                                    <tfoot>
                                    <tr></tr>
                                    </tfoot>
                                </table>
                            </div>
                            <div class="table-responsive table mt-2 col-md-6" role="grid"
                                 aria-describedby="dataTable_info">
                                <table class="table my-0" id="">
                                    <thead>
                                    <tr>
                                        <td class="text-center">预览</td>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td>
                                            <image src="" id="imageShow" style="max-height: 800px;"></image>
                                        </td>
                                    </tr>
                                    </tbody>
                                    <tfoot>
                                    <tr></tr>
                                    </tfoot>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div><!-- /.container-fluid -->
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
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<script src="dist/js/pages/dashboard.js"></script>
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
        table.render({
            elem: '#LAY_table_user'
            , url: 'historyNormalCarId-query?car_id=${car_id}' //数据接口
            , toolbar: true //开启头部工具栏
            , cellMinWidth: 120 //全局定义常规单元格的最小宽度
            , id: 'testReload'
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
                        var detection_result = d.detection_result;
                        if (detection_result == "正常") {
                            return `<div class="layer-photos-demo" onclick="img_click()" style="cursor:pointer; text-align: center;">
                                      <img layer-pid="normal"  layer-src="dist/img/normal.png" src="dist/img/normal.png" alt="正常" style="width: 20px; height: 20px;">
                                    </div>`;
                        } else if (detection_result == "异常") {
                            return `<div class="layer-photos-demo" onclick="img_click()" style="cursor:pointer; text-align: center;">
                                      <img layer-pid="abnormal"  layer-src="dist/img/abnormal.png" src="dist/img/abnormal.png" alt="异常" style="width: 20px; height: 20px;">
                                    </div>`;
                        }
                    }
                }
                , {field: 'detection_result', title: '检测行为', sort: true, fixed: 'left', width: 120}
                , {field: 'id', title: '检测序号', sort: true, fixed: true, width: 120}
                , {
                    field: 'detection_date',
                    title: '检测日期',
                    sort: true,
                    width: 120,
                    templet: '<div>{{dateToStr(d.detection_date)}}</div>'
                }
                , {field: 'detection_id', title: '站点编号', sort: true, width: 120}
                , {field: 'test_line', title: '检测线', sort: true, width: 120}
                , {field: 'engine', title: '发动机状态', sort: true, width: 120}
                , {field: 'exhaust_funnel_num', title: '排气管个数', sort: true, width: 120}
                , {
                    field: 'exhaust_funnel_info', title: '尾气排放情况', sort: true, width: 150, templet: function (d) {
                        var info = d.exhaust_funnel_info;
                        if (info == "0") {
                            return "无黑烟";
                        } else if (info == "1") {
                            return "有黑烟";
                        }
                    }
                }
                , {
                    field: 'exhaust_funnel_judge', title: '排气管缺失情况', sort: true, width: 150, templet: function (d) {
                        var judge = d.exhaust_funnel_judge;
                        if (judge == "0") {
                            return "无缺失";
                        } else if (judge == "1") {
                            return "有缺失";
                        }
                    }
                }
                , {field: 'car_id', title: '车牌', sort: true, width: 120}
                , {
                    field: 'signal_tube', title: '采样管是否接好', sort: true, width: 150, templet: function (d) {
                        var signal_tube = d.signal_tube;
                        if (signal_tube == "0") {
                            return "已接";
                        } else if (signal_tube == "1") {
                            return "未接";
                        }
                    }
                }
                , {
                    field: 'door_info', title: '车门状态', sort: true, width: 120, templet: function (d) {
                        var door_info = d.door_info;
                        if (door_info == "0") {
                            return "已关";
                        } else if (door_info == "1") {
                            return "未关";
                        }
                    }
                }
                , {field: 'car_color', title: '车颜色', sort: true, width: 120}
                , {field: 'car_model', title: '车型', sort: true, width: 120}
                , {field: 'tyre_info', title: '轮胎信息', sort: true, width: 120}
                , {field: 'staff_id', title: '负责人', sort: true, fixed: 'right', width: 100}
                , {
                    field: 'operation', title: '操作', fixed: 'right', width: 120, templet: function (d) {

                    }
                }
            ]]
        });

        var $ = layui.$, active = {
            reload: function () {
                var demoReload = $('#demoReload');

                //执行重载
                table.reload('testReload', {
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                    , where: {
                        id: demoReload.val()
                    }
                });
            }
        };

        $('#btn').on('click', function () {
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });
    });
</script>
<script>
    layui.use('table', function () {
        var table = layui.table;

        //第一个实例
        table.render({
            elem: '#LAY_table_user4'
            , url: 'historyExceptionCarId-query?car_id=${car_id}' //数据接口
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
                , {
                    field: 'solve_progress',
                    title: '处理进度',
                    sort: true,
                    width: 120,
                    fixed: 'left',
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
                , {field: 'id', title: '检测序号', sort: true, fixed: true, width: 120}
                , {field: 'car_id', title: '车牌号', sort: true, width: 120}
                , {
                    field: 'detection_date',
                    title: '检测日期',
                    sort: true,
                    width: 120,
                    templet: '<div>{{dateToStr(d.detection_date)}}</div>'
                }
                , {field: 'detection_id', title: '站点编号', sort: true, width: 120}
                , {field: 'test_line', title: '检测线', sort: true, width: 120}
                , {field: 'error_type', title: '异常类型', sort: true, width: 120}
                , {field: 'error_describe', title: '异常描述', sort: true, width: 120}
                , {field: 'error_picture', title: '图片', sort: true, width: 120}
                , {field: 'staff_id', title: '负责人', sort: true, width: 120}

                , {
                    field: 'solve_time',
                    title: '处理完成时间',
                    sort: true,
                    width: 160,
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
                    field: 'operation', title: '操作', fixed: 'right', width: 120, templet: function (d) {
                        let data = JSON.stringify(d);
                        return
                    }
                }

            ]]
        });

        var $ = layui.$, active = {
            reload: function () {
                var demoReload4 = $('#demoReload4');

                //执行重载
                table.reload('testReload4', {
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                    , where: {
                        id: demoReload4.val()
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
<script>
    layui.use(['form', 'layedit', 'laydate'], function () {
        var $ = layui.jquery
            , form = layui.form
            , upload = layui.upload
            , element = layui.element
            , layer = layui.layer
            , layedit = layui.layedit
            , laydate = layui.laydate;

        //日期
        laydate.render({
            elem: '#detection_date'
        });

        //创建一个编辑器
        var editIndex = layedit.build('LAY_demo_editor');

        //自定义验证规则
        form.verify({
            car_id: [
                /^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-Z0-9]{4}[A-Z0-9挂学警港澳]{1}$/
                , '确保车牌号正确'
            ]
        });

        //监听提交
        form.on('submit(demo1)', function (data) {
            layer.alert(JSON.stringify(data.field), {
                title: '最终的提交信息'
            })
            return false;
        });

        //表单取值
        layui.$('#LAY-component-form-getval').on('click', function () {
            var data = form.val('example');
            alert(JSON.stringify(data));
        });

        var uploadListIns = upload.render({
            elem: '#testList'
            , elemList: $('#demoList') //列表元素对象
            , url: 'https://httpbin.org/post' //此处用的是第三方的 http 请求演示，实际使用时改成您自己的上传接口即可。
            , accept: 'file'
            , multiple: true
            , number: 3
            , auto: false
            , bindAction: '#testListAction'
            , choose: function (obj) {
                var that = this;
                var files = this.files = obj.pushFile(); //将每次选择的文件追加到文件队列
                //读取本地文件
                obj.preview(function (index, file, result) {
                    var tr = $(['<tr id="upload-' + index + '">'
                        , '<td>' + file.name + '</td>'
                        , '<td>' + (file.size / 1014).toFixed(1) + 'kb</td>'
                        , '<td><div class="layui-progress" lay-filter="progress-demo-' + index + '"><div class="layui-progress-bar" lay-percent=""></div></div></td>'
                        , '<td>'
                        , '<button class="layui-btn layui-btn-xs demo-reload layui-hide">重传</button>'
                        , '<button class="layui-btn layui-btn-xs layui-btn-danger demo-delete">删除</button>'
                        , '</td>'
                        , '</tr>'].join(''));

                    //单个重传
                    tr.find('.demo-reload').on('click', function () {
                        obj.upload(index, file);
                    });

                    //删除
                    tr.find('.demo-delete').on('click', function () {
                        delete files[index]; //删除对应的文件
                        tr.remove();
                        uploadListIns.config.elem.next()[0].value = ''; //清空 input file 值，以免删除后出现同名文件不可选
                    });

                    that.elemList.append(tr);
                    element.render('progress'); //渲染新加的进度条组件
                });
            }
            , done: function (res, index, upload) { //成功的回调
                var that = this;
                //if(res.code == 0){ //上传成功
                var tr = that.elemList.find('tr#upload-' + index)
                    , tds = tr.children();
                tds.eq(3).html(''); //清空操作
                delete this.files[index]; //删除文件队列已经上传成功的文件
                return;
                //}
                this.error(index, upload);
            }
            , allDone: function (obj) { //多文件上传完毕后的状态回调
                console.log(obj)
            }
            , error: function (index, upload) { //错误回调
                var that = this;
                var tr = that.elemList.find('tr#upload-' + index)
                    , tds = tr.children();
                tds.eq(3).find('.demo-reload').removeClass('layui-hide'); //显示重传
            }
            , progress: function (n, elem, e, index) { //注意：index 参数为 layui 2.6.6 新增
                element.progress('progress-demo-' + index, n + '%'); //执行进度条。n 即为返回的进度百分比
            }
        });

    });
</script>
<script type="text/javascript">
    $(function () {

        $('#exampleErrorType').change(() => {
            let myType = $('#exampleErrorType').val();
            let myDate = $('#exampleDetectionDate').val();
            let myCarId = $('#exampleCarId').val();
            $.ajax({
                url: 'errorDescribe',
                data: {
                    myType: myType,
                    myDate: myDate,
                    myCarId: myCarId
                },
                type: 'GET',
                dataType: 'text',
                success: function (data) {
                    $("#exampleErrorDescribe").val(data);
                }
            })
        });


        $('#addImage').change(function () {
            let myFile = this.files[0];
            let objURL = window.webkitURL.createObjectURL(myFile);
            // var objURL = getObjectURL(this.files[0]);
            console.log("url" + objURL);
            if (objURL) {
                $('#myShow').text(myFile.name);
                $('#imageShow').attr("src", objURL);
            }

            let myFiles = this.files;
            for (let i = 0; i < files.length; i++) {
                let objURL = window.webkitURL.createObjectURL(myFiles[i]);
                console.log("url" + objURL);
                if (objURL) {
                    $('#myShow').text(myFile.name);
                    $('#imageShow').attr("src", objURL);
                }
            }
        });

        // $('subButton').click(function () {
        //     $.ajax({
        //         url: 'ProductServlet',
        //
        //     })
        // });


    });
</script>
</body>

</html>