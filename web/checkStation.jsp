<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page isELIgnored="false" %>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>检测站管理</title>

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
                <a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a>
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
        <a href="index3.html" class="brand-link">
            <img src="dist/img/AdminLTELogo.png" alt="AdminLTE Logo" class="brand-image img-circle elevation-3"
                 style="opacity: .8">
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
                <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview"
                    role="menu" data-accordion="false">
                    <!-- Add icons to the links using the .nav-icon class
        with font-awesome or any other icon font library -->
                    <li class="nav-item">
                        <a href="allStationJump-query" class="nav-link">
                            <i class="nav-icon fas fa-tachometer-alt"></i>
                            <p>
                                首页
                            </p>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="stationSelect.jsp" class="nav-link">
                            <i class="nav-icon fas fa-search"></i>
                            <p>
                                检测站选择
                            </p>
                        </a>
                    </li>
                    <li class="nav-item menu-open">
                        <a href="#" class="nav-link active">
                            <i class="nav-icon fas fa-cog"></i>
                            <p>
                                系统设置
                                <i class="right fas fa-angle-left"></i>
                            </p>
                        </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href="queryStation" class="nav-link active">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>检测站管理</p>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item">
                        <a href="contact.jsp" class="nav-link">
                            <i class="nav-icon fas fa-search"></i>
                            <p>
                                联系我们
                            </p>
                        </a>
                    </li>
                </ul>
            </nav>
            <!-- /.sidebar-menu -->
        </div>
        <!-- /.sidebar -->
    </aside>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Main content -->
        <section class="content">
            <div class="container-fluid">
                <div>&nbsp;</div>
                <h3 class="text-dark mb-4">检测站管理</h3>
                <div class="card shadow">
                    <div class="card-body">
                        <div class="row">
                            <div class="col-md-6 text-nowrap">
                                <button class="btn btn-primary btn-sm" role="button" style="margin-left: 18px;"
                                        data-toggle="modal" data-target="#myModal">添加
                                </button>
                                <div class="modal fade" id="myModal" tabindex="-1" role="dialog"
                                     aria-labelledby="myModalLabel" aria-hidden="true">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h4 class="modal-title text-left" id="myModalLabel">添加</h4>
                                                <button type="button" class="close" data-dismiss="modal"
                                                        aria-hidden="true">
                                                    &times;
                                                </button>
                                            </div>
                                            <div class="modal-body">
                                                <form class="form-horizontal" role="form"
                                                      action="insertStation" method="post">
                                                    <div class="form-group row">
                                                        <label class="col-sm-2 control-label">站点编号</label>
                                                        <div class="col-sm-10">
                                                            <input type="text" class="form-control"
                                                                   placeholder="请输入站点编号" name="id">
                                                        </div>
                                                    </div>
                                                    <div class="form-group row">
                                                        <label class="col-sm-2 control-label">站点名称</label>
                                                        <div class="col-sm-10">
                                                            <input type="text" class="form-control"
                                                                   placeholder="请输入站点名称" name="name">
                                                        </div>
                                                    </div>
                                                    <div class="form-group row">
                                                        <label class="col-sm-2 control-label">站点经度</label>
                                                        <div class="col-sm-10">
                                                            <input type="text" class="form-control"
                                                                   placeholder="请输入站点经度" name="longitude">
                                                        </div>
                                                    </div>
                                                    <div class="form-group row">
                                                        <label class="col-sm-2 control-label">站点纬度</label>
                                                        <div class="col-sm-10">
                                                            <input type="text" class="form-control"
                                                                   placeholder="请输入站点纬度" name="latitude">
                                                        </div>
                                                    </div>
                                                    <div class="form-group row">
                                                        <label class="col-sm-2 control-label">站点描述</label>
                                                        <div class="col-sm-10">
                                                            <textarea class="form-control" name="describe"></textarea>
                                                        </div>
                                                    </div>
                                                    <div class="modal-footer">
                                                        <button type="reset" class="btn btn-default">重置</button>
                                                        <button type="submit" class="btn btn-primary">添加</button>
                                                    </div>
                                                </form>
                                            </div>
                                        </div><!-- /.modal-content -->
                                    </div><!-- /.modal -->
                                </div>

                                <a class="btn btn-danger btn-sm" role="button" style="margin-left: 10px;"
                                   href="queryStation">刷新</a>
                            </div>
                            <div class="col-md-6">
                                <div class="text-md-right dataTables_filter" id="dataTable_filter">
                                    <form class="d-none d-sm-inline-block mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search"
                                          action="queryStation" method="POST">
                                        <div class="input-group"><input
                                                class="bg-light form-control form-control-sm border-0 small" type="text"
                                                placeholder="站点编号搜索..." name="id">
                                            <div class="input-group-append">
                                                <button class="btn btn-primary py-0" type="submit"><i
                                                        class="fas fa-search"></i></button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <div class="table-responsive table mt-2" id="dataTable" role="grid"
                             aria-describedby="dataTable_info">
                            <table class="table my-0" id="dataTable1">
                                <thead>
                                <tr>
                                    <th>站点编号</th>
                                    <th>站点名称</th>
                                    <th>站点纬度</th>
                                    <th>站点经度</th>
                                    <th>站点描述</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="station" items="${stationList}">
                                    <tr>
                                        <td>${station.id}</td>
                                        <td>${station.name}</td>
                                        <td>${station.latitude}</td>
                                        <td>${station.longitude}</td>
                                        <td>${station.describe}</td>
                                        <td>
                                            <a href="deleteStation?id=${station.id}"
                                               class="col-2"> <i
                                                    class="nav-icon far fa-trash-alt" title="删除"></i></a>
                                            <a class="col-2" data-toggle="modal"
                                               data-target="#S${station.id}">
                                                <i class="nav-icon far fa-edit" title="修改"></i>
                                            </a>
                                        </td>
                                    </tr>
                                    <div class="modal fade" id="S${station.id}" tabindex="-1"
                                         role="dialog"
                                         aria-labelledby="myModalLabel" aria-hidden="true">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h4 class="modal-title text-left">修改</h4>
                                                    <button type="button" class="close" data-dismiss="modal"
                                                            aria-hidden="true">
                                                        &times;
                                                    </button>
                                                </div>
                                                <div class="modal-body">
                                                    <form class="form-horizontal" role="form"
                                                          action="updateStation?id=${station.id}"
                                                          method="post">
                                                        <div class="form-group row">
                                                            <label
                                                                    class="col-sm-2 control-label">站点编号</label>
                                                            <div class="col-sm-10">
                                                                <input type="text" class="form-control"
                                                                       value="${station.id}"
                                                                       placeholder="请输入站点编号"
                                                                       name="id" disabled="">
                                                            </div>
                                                        </div>
                                                        <div class="form-group row">
                                                            <label
                                                                    class="col-sm-2 control-label">站点名称</label>
                                                            <div class="col-sm-10">
                                                                <input type="text" class="form-control"
                                                                       value="${station.name}"
                                                                       placeholder="请输入站点名称"
                                                                       name="name">
                                                            </div>
                                                        </div>
                                                        <div class="form-group row">
                                                            <label
                                                                    class="col-sm-2 control-label">站点纬度</label>
                                                            <div class="col-sm-10">
                                                                <input type="text" class="form-control"
                                                                       value="${station.latitude}"
                                                                       placeholder="请输入站点维度"
                                                                       name="latitude">
                                                            </div>
                                                        </div>
                                                        <div class="form-group row">
                                                            <label
                                                                    class="col-sm-2 control-label">站点经度</label>
                                                            <div class="col-sm-10">
                                                                <input type="text" class="form-control"
                                                                       value="${station.longitude}"
                                                                       placeholder="请输入站点经度"
                                                                       name="longitude">
                                                            </div>
                                                        </div>
                                                        <div class="form-group row">
                                                            <label
                                                                    class="col-sm-2 control-label">站点描述</label>
                                                            <div class="col-sm-10">
                                                                <input type="text" class="form-control"
                                                                       value="${station.describe}"
                                                                       placeholder="请输入站点描述"
                                                                       name="describe">
                                                            </div>
                                                        </div>
                                                        <div class="modal-footer">
                                                            <button type="reset" class="btn btn-default">重置
                                                            </button>
                                                            <button type="submit" class="btn btn-primary">修改
                                                            </button>
                                                        </div>
                                                    </form>
                                                </div>
                                            </div><!-- /.modal-content -->
                                        </div><!-- /.modal -->
                                    </div>
                                </c:forEach>
                                </tbody>
                                <tfoot>
                                <tr></tr>
                                </tfoot>
                            </table>
                        </div>
                        <div class="row">
                            <div class="col-md-6 align-self-center">
                                Showing 1 to ${fn:length(stationList)} of ${fn:length(stationList)}
                            </div>
                            <div class="col-md-6">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
    <footer class="main-footer">
        <strong>Copyright &copy; 2021 <a href="#">ZJUT</a>.</strong>
        All rights reserved.
        <div class="float-right d-none d-sm-inline-block">
            <b>Version</b> 1.1.0
        </div>
    </footer>

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
<!-- Bootstrap 4 -->
<script src="plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- ChartJS -->

<!-- Sparkline -->
<script src="plugins/sparklines/sparkline.js"></script>
<!-- JQVMap -->


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


</body>

</html>