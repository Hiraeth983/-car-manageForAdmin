<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>机动车排放检验管理系统</title>
    <style type="text/css">
        .layui-btn {
            margin-left: 200px;
        }

        .video {
            margin-right: 30px;
        }
    </style>
    <!-- Google Font: Source Sans Pro -->
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="plugins/fontawesome-free/css/all.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <!-- Tempusdominus Bootstrap 4 -->
    <link rel="stylesheet" href="plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css">
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
        /* Make the image fully responsive */
        .carousel-inner img {
            width: 100%;
            height: 100%;
        }
    </style>
</head>

<body class="hold-transition sidebar-mini layout-fixed">
<div class="wrapper">

    <!-- Preloader -->
    <div class="preloader flex-column justify-content-center align-items-center">
        <img class="animation__shake" src="dist/img/AdminLTELogo.png" alt="AdminLTELogo" height="60" width="60">
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
                <a href="index.html" class="nav-link">首页</a>
            </li>
            <li class="nav-item d-none d-sm-inline-block">
                <a href="contact.html" class="nav-link">联系我们</a>
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
                            <input class="form-control form-control-navbar" type="search" placeholder="Search"
                                   aria-label="Search">
                            <div class="input-group-append">
                                <button class="btn btn-navbar" type="submit">
                                    <i class="fas fa-search"></i>
                                </button>
                                <button class="btn btn-navbar" type="button" data-widget="navbar-search">
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
                <a class="nav-link" data-widget="control-sidebar" data-slide="true" href="#" role="button">
                    <i class="fas fa-th-large"></i>
                </a>
            </li>
        </ul>
    </nav>
    <!-- /.navbar -->

    <!-- Main Sidebar Container -->
    <aside class="main-sidebar sidebar-dark-primary elevation-4">
        <!-- Brand Logo -->
        <a href="#" class="brand-link">
            <img src="dist/img/AdminLTELogo.png" alt="AdminLTE Logo" class="brand-image img-circle elevation-3"
                 style="opacity: .8">
            <span class="brand-text font-weight-light">车辆排检管理系统</span>
        </a>

        <!-- Sidebar -->
        <div class="sidebar">
            <!-- Sidebar user panel (optional) -->
            <div class="user-panel mt-3 pb-3 mb-3 d-flex">
                <div class="info">
                    <a href="#" class="d-block">尊敬的<em>***</em>，您好！</a>
                </div>
            </div>

            <!-- SidebarSearch Form -->
            <div class="form-inline">
                <div class="input-group" data-widget="sidebar-search">
                    <input class="form-control form-control-sidebar" type="search" placeholder="Search"
                           aria-label="Search">
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
                    <li class="nav-item menu-open">
                        <a href="#" class="nav-link active">
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
                                <a href="queryCamera?detection_id=${detection_id}" class="nav-link active">
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
                    <li class="nav-item">
                        <a href="#" class="nav-link">
                            <i class="nav-icon fas fa-table"></i>
                            <p>
                                历史信息检索
                                <i class="fas fa-angle-left right"></i>
                            </p>
                        </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href="selectInfo-query?detection_id=${detection_id}"
                                   class="nav-link">
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
                        <h1 class="m-0">摄像头管理</h1>
                    </div><!-- /.col -->
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="#">首页</a></li>
                            <li class="breadcrumb-item active">摄像头管理</li>
                        </ol>
                    </div><!-- /.col -->
                </div><!-- /.row -->
            </div><!-- /.container-fluid -->
        </div>
        <!-- /.content-header -->


        <section class="content">
            <div class="layui-tab layui-tab-card" lay-filter="current">
                <ul class="layui-tab-title">
                    <li lay-id="1" class="layui-this">车辆基本信息</li>
                </ul>
                <div class="layui-tab-content" style="height: 500px;">
                    <div class="layui-tab-item layui-show">
                        <div class="modal-body row">
                            <div class="col-5">
                                <form class="form-horizontal" role="form"
                                      action="updateStation?id=${station.id}" method="post">
                                    <div class="form-group row">
                                        <label class="col-sm-2 control-label">车牌</label>
                                        <div class="col-sm-9">
                                            <input type="text" class="form-control" value=""
                                                   placeholder="车牌" id="car_id">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-sm-2 control-label">车型</label>
                                        <div class="col-sm-9">
                                            <input type="text" class="form-control" value=""
                                                   placeholder="车型" id="car_model">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-sm-2 control-label">车龄</label>
                                        <div class="col-sm-9">
                                            <input type="text" class="form-control" value=""
                                                   placeholder="车龄" id="car_age">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-sm-2 control-label">车主</label>
                                        <div class="col-sm-9">
                                            <input type="text" class="form-control" value=""
                                                   placeholder="车主" id="car_owner">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-sm-2 control-label">违章记录</label>
                                        <div class="col-sm-9">
                                            <input type="text" class="form-control" value=""
                                                   placeholder="违章记录" id="endorsement_YorN">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-sm-2 control-label">最近年检查日期</label>
                                        <div class="col-sm-9">
                                            <input type="text" class="form-control" value=""
                                                   placeholder="最近年检查日期" id="recently_AS">
                                        </div>
                                    </div>
                                </form>
                            </div>
                            <div class="col-6">
                                <div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
                                    <ul class="layui-tab-title">
                                        <li class="layui-this">车牌检测
                                        </li>
                                        <li>刹车检测
                                        </li>
                                        <li>行为检测
                                            <div class="modal fade" id="myModal" tabindex="-1" role="dialog"
                                                 aria-labelledby="myModalLabel" aria-hidden="true">
                                                <div class="modal-dialog">
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <h4 class="modal-title" id="myModalLabel"
                                                                style="text-align: left">检测异常结果</h4>
                                                            <button type="button" class="close" data-dismiss="modal"
                                                                    aria-hidden="true">&times;
                                                            </button>
                                                        </div>
                                                        <div class="modal-body" id="text"></div>
                                                        <div class="modal-footer">
                                                            <button type="button" class="btn btn-default"
                                                                    data-dismiss="modal">关闭
                                                            </button>
                                                        </div>
                                                    </div><!-- /.modal-content -->
                                                </div><!-- /.modal -->
                                            </div>
                                        </li>
                                        <li>摄像头4
                                        </li>
                                    </ul>
                                    <div class="layui-tab-content">
                                        <div class="layui-tab-item layui-show">
                                            <section>
                                                <div class="video">
                                                    <video width="600" id="video1" controls="controls"
                                                           autoplay="autoplay">
                                                        <source src="" type="video/mp4" id="source1">
                                                    </video>
                                                </div>
                                                <button class="layui-btn" id="start1" data-type="reload"
                                                        style="margin-bottom: 10px ;">开始/暂停
                                                </button>
                                                <button class="layui-btn" id="camera"
                                                        style="margin-bottom: 10px ;">摄像头
                                                </button>
                                                <button class="layui-btn" id="start2" data-type="reload"
                                                        style="margin-bottom: 10px ;">仿真按钮
                                                </button>
                                            </section>
                                        </div>
                                        <div class="layui-tab-item">
                                            <section>
                                                <div class="video">
                                                    <video id="video2" width="600" controls="controls"
                                                           autoplay="autoplay">
                                                        <source src="" type="video/mp4" id="source2">
                                                        <p>您的浏览器不支持video元素</p>
                                                    </video>
                                                </div>
                                                <button class="layui-btn" id="start3" data-type="reload"
                                                        style="margin-bottom: 10px ;">开始/暂停
                                                </button>
                                                <button class="layui-btn" id="start4" data-type="reload"
                                                        style="margin-bottom: 10px ;">仿真按钮
                                                </button>
                                            </section>
                                        </div>
                                        <div class="layui-tab-item">
                                            <section>
                                                <div class="video">
                                                    <video id="video3" width="600" controls="controls"
                                                           autoplay="autoplay">
                                                        <source src="" type="video/mp4" id="source3">
                                                        <p>您的浏览器不支持video元素</p>
                                                    </video>
                                                </div>
                                                <button class="layui-btn" id="start5" data-type="reload"
                                                        style="margin-bottom: 10px ;">开始/暂停
                                                </button>
                                                <button class="layui-btn" id="start6" data-type="reload"
                                                        style="margin-bottom: 10px ;">仿真按钮
                                                </button>
                                            </section>
                                        </div>
                                        <div class="layui-tab-item">
                                            <section>
                                                <div class="video">
                                                    <video id="video4" width="600" controls="controls"
                                                           autoplay="autoplay">
                                                        <source src="" type="video/mp4" id="source4">
                                                        <p>您的浏览器不支持video元素</p>
                                                    </video>
                                                </div>
                                                <button class="layui-btn" id="start7" data-type="reload"
                                                        style="margin-bottom: 10px ;">开始/暂停
                                                </button>
                                                <button class="layui-btn" id="start8" data-type="reload"
                                                        style="margin-bottom: 10px ;">仿真按钮
                                                </button>
                                            </section>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </section>


    </div>
    <!-- /.content-wrapper -->

    <!-- Control Sidebar -->
    <aside class="control-sidebar control-sidebar-dark">
        <!-- Control sidebar content goes here -->
    </aside>
    <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->

<!-- jQuery -->
<script src="plugins/jquery/jquery.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="plugins/jquery-ui/jquery-ui.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
    $.widget.bridge('uibutton', $.ui.button)
</script>
<!-- Bootstrap 4 -->
<script src="plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- ChartJS -->
<script src="plugins/chart.js/Chart.min.js"></script>
<!-- Sparkline -->
<script src="plugins/sparklines/sparkline.js"></script>
<!-- JQVMap -->
<script src="plugins/jqvmap/jquery.vmap.min.js"></script>
<script src="plugins/jqvmap/maps/jquery.vmap.usa.js"></script>
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
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<script src="dist/js/pages/dashboard.js"></script>
<script src="plugins/layui/layui.js"></script>
<script>
    let fileName;
    layui.use(['upload', 'element', 'layer'], function () {
        var $ = layui.jquery
            , upload = layui.upload
            , element = layui.element
            , layer = layui.layer;
        upload.render({
            elem: '#start2'
            , url: 'uploadFile' //此处配置你自己的上传接口即可
            , accept: 'video' //视频
            , done: function (res) {
                layer.msg('上传成功');
                console.log(res);
                fileName = res.fileName;
                $('#video1').attr('src', res.src);
                $('#video1').get(0).play();
            }
        });

    });

    let fileName2;
    layui.use(['upload', 'element', 'layer'], function () {
        var $ = layui.jquery
            , upload = layui.upload
            , element = layui.element
            , layer = layui.layer;
        upload.render({
            elem: '#start4'
            , url: 'uploadFile' //此处配置你自己的上传接口即可
            , accept: 'video' //视频
            , done: function (res) {
                layer.msg('上传成功');
                console.log(res);
                fileName2 = res.fileName;
                $('#video2').attr('src', res.src);
                $('#video2').get(0).play();
            }
        });

    });

    let fileName3;
    layui.use(['upload', 'element', 'layer'], function () {
        var $ = layui.jquery
            , upload = layui.upload
            , element = layui.element
            , layer = layui.layer;
        upload.render({
            elem: '#start6'
            , url: 'uploadFile' //此处配置你自己的上传接口即可
            , accept: 'video' //视频
            , done: function (res) {
                layer.msg('上传成功');
                console.log(res);
                fileName3 = res.fileName;
                $('#video3').attr('src', res.src);
                $('#video3').get(0).play();
            }
        });

    });
    $(function () {
        $("[data-toggle='popover']").popover({html: true});
        $('#start1').click(function () {
            $.ajax({
                url: 'distinguishCarId',
                //参数
                data: {fileName: fileName},
                //请求类型
                type: 'POST',
                //响应体结果类型
                dataType: 'json',
                //成功回调
                success: function (data) {
                    $('#car_id').val(data.car_id);
                    $('#car_model').val(data.car_model);
                    $('#car_age').val(data.car_age);
                    $('#car_owner').val(data.car_owner);
                    $('#endorsement_YorN').val(data.endorsement_YorN);
                    $('#recently_AS').val(data.recently_AS);
                },
                error: function () {
                    var layer = layui.layer;
                    layer.msg('识别失败');
                }
            });
        });

        $('#start5').click(function () {
            $.ajax({
                url: 'distinguishException',
                //参数
                data: {
                    fileName: fileName3
                },
                //请求类型
                type: 'POST',
                //响应体结果类型
                dataType: 'json',
                //成功回调
                success: function (data) {
                    // $('#exception').attr('data-content',data.info)
                    // $('#exception').popover('show');
                    $('#text').html(data.info);
                    $('#myModal').modal('show');
                }
            });
        });

        $('#start3').click(function () {
            $.ajax({
                url: 'distinguishBrakeException',
                //参数
                data: {fileName: fileName2},
                //请求类型
                type: 'POST',
                //响应体结果类型
                dataType: 'json',
                //成功回调
                success: function (data) {
                    // $('#exception').attr('data-content',data.info)
                    // $('#exception').popover('show');
                    $('#text').html(data.info);
                    $('#myModal').modal('show');
                }
            });
        });

        $('#camera').click(function () {
            $.ajax({
                url: 'callCamera',
                //参数
                // data: {fileName: fileName2},
                //请求类型
                type: 'POST',
                //响应体结果类型
                dataType: 'json',
                //成功回调
                success: function (data) {

                }
            });
        });
    });
</script>
</body>

</html>
