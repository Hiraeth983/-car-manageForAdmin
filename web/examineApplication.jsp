<%--
  Created by IntelliJ IDEA.
  User: 李龙
  Date: 2021/12/12
  Time: 18:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page isELIgnored="false" %>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>审核调度申请</title>

    <!-- Google Font: Source Sans Pro -->
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="plugins/fontawesome-free/css/all.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="dist/css/adminlte.min.css">
    <!-- Daterange picker -->
    <link rel="stylesheet" href="plugins/daterangepicker/daterangepicker.css">
    <link rel="stylesheet" href="plugins/bootstrap-select/css/bootstrap-select.min.css">
    <link rel="stylesheet" href="plugins/bs-stepper/css/bs-stepper.min.css">
    <link rel="stylesheet" href="plugins/bootstrap-switch/css/bootstrap3/bootstrap-switch.min.css">
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
                    <a href="#" class="d-block">尊敬的<strong>站长</strong>，您好！</a>
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
        <section class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h1>审核调度申请</h1>
                    </div>
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="#">首页</a></li>
                            <li class="breadcrumb-item active">审核调度申请</li>
                        </ol>
                    </div>
                </div>
            </div><!-- /.container-fluid -->
        </section>
        <!-- Main content -->
        <section class="content">
            <div class="container-fluid">
                <div class="card shadow">
                    <div class="card-body">
                        <div class="row">
                            <div class="col-md-6 text-nowrap">
                                <button type="button" class="btn btn-primary btn-sm" data-toggle="modal"
                                        data-target="#modal-lg">
                                    审核申请
                                </button>
                                <div class="modal fade" id="modal-lg">
                                    <div class="modal-dialog modal-lg">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h4 class="modal-title">审核申请</h4>
                                                <button type="button" class="close" data-dismiss="modal"
                                                        aria-label="Close">
                                                    <span aria-hidden="true">&times;</span>
                                                </button>
                                            </div>
                                            <div class="modal-body">
                                                <div class="row">
                                                    <div class="col-md-12">
                                                        <div class="card card-default">
                                                            <div class="card-body p-0">
                                                                <div class="bs-stepper">
                                                                    <div class="bs-stepper-header" role="tablist">
                                                                        <div class="step"
                                                                             data-target="#select-order-part">
                                                                            <button type="button" class="step-trigger"
                                                                                    role="tab"
                                                                                    aria-controls="select-order-part"
                                                                                    id="select-order-part-trigger">
                                                                                <span class="bs-stepper-circle">1</span>
                                                                                <span class="bs-stepper-label">选择单号</span>
                                                                            </button>
                                                                        </div>
                                                                        <div class="line"></div>
                                                                        <div class="step"
                                                                             data-target="#select-time-part">
                                                                            <button type="button" class="step-trigger"
                                                                                    role="tab"
                                                                                    aria-controls="select-time-part"
                                                                                    id="select-time-part-trigger">
                                                                                <span class="bs-stepper-circle">2</span>
                                                                                <span class="bs-stepper-label">审核</span>
                                                                            </button>
                                                                        </div>
                                                                        <div class="line"></div>
                                                                        <div class="step" data-target="#submit-part">
                                                                            <button type="button" class="step-trigger"
                                                                                    role="tab"
                                                                                    aria-controls="submit-part"
                                                                                    id="submit-part-trigger">
                                                                                <span class="bs-stepper-circle">3</span>
                                                                                <span class="bs-stepper-label">提交信息</span>
                                                                            </button>
                                                                        </div>
                                                                    </div>
                                                                    <div class="bs-stepper-content">
                                                                        <div id="select-order-part" class="content"
                                                                             role="tabpanel"
                                                                             aria-labelledby="select-order-part-trigger">
                                                                            <div class="form-group row">
                                                                                <label class="col-sm-2 control-label"
                                                                                       for="selectOrderId">单号</label>
                                                                                <div class="col-sm-10">
                                                                                    <select class="selectpicker"
                                                                                            name="selectOrderId"
                                                                                            id="selectOrderId"
                                                                                            data-live-search="true"
                                                                                            data-style="btn-info"
                                                                                            title="请选择单号"
                                                                                            data-live-search-placeholder="搜索单号">

                                                                                    </select>
                                                                                </div>
                                                                            </div>
                                                                            <div class="form-group row">
                                                                                <label class="col-sm-2 control-label"
                                                                                       for="selectOrderId">提交时间</label>
                                                                                <div class="col-sm-10">
                                                                                    <input type="text"
                                                                                           class="form-control"
                                                                                           name="submitTime"
                                                                                           id="submitTime"
                                                                                           disabled>
                                                                                </div>
                                                                            </div>
                                                                            <div class="form-group row">
                                                                                <label class="col-sm-2 control-label"
                                                                                       for="selectOrderId">原员工姓名</label>
                                                                                <div class="col-sm-10">
                                                                                    <input type="text"
                                                                                           class="form-control"
                                                                                           name="oStaffName"
                                                                                           id="oStaffName"
                                                                                           disabled>
                                                                                </div>
                                                                            </div>
                                                                            <div class="form-group row">
                                                                                <label class="col-sm-2 control-label"
                                                                                       for="selectOrderId">现员工姓名</label>
                                                                                <div class="col-sm-10">
                                                                                    <input type="text"
                                                                                           class="form-control"
                                                                                           name="nStaffName"
                                                                                           id="nStaffName"
                                                                                           disabled>
                                                                                </div>
                                                                            </div>
                                                                            <div class="form-group row">
                                                                                <label class="col-sm-2 control-label"
                                                                                       for="selectOrderId">申请理由</label>
                                                                                <div class="col-sm-10">
                                                                                    <textarea class="form-control"
                                                                                            name="reason" id="reason"
                                                                                            disabled></textarea>
                                                                                </div>
                                                                            </div>
                                                                            <button class="btn btn-primary"
                                                                                    onclick="stepper.next()">Next
                                                                            </button>
                                                                        </div>
                                                                        <div id="select-time-part" class="content"
                                                                             role="tabpanel"
                                                                             aria-labelledby="select-time-part-trigger">
                                                                            <div class="form-group row">
                                                                                <label class="col-sm-2 control-label">审核结果</label>
                                                                                <div class="col-sm-10">
                                                                                    <input name="switch" type="checkbox" checked>
                                                                                </div>
                                                                            </div>
                                                                            <div class="form-group row" id="myToggle">
                                                                                <label class="col-sm-2 control-label"
                                                                                       for="selectOrderId">审批理由</label>
                                                                                <div class="col-sm-10">
                                                                                    <textarea class="form-control"
                                                                                              name="examineReason" id="examineReason"></textarea>
                                                                                </div>
                                                                            </div>
                                                                            <button class="btn btn-primary"
                                                                                    onclick="stepper.previous()">
                                                                                Previous
                                                                            </button>
                                                                            <button class="btn btn-primary"
                                                                                    onclick="stepper.next()">Next
                                                                            </button>
                                                                        </div>
                                                                        <div id="submit-part" class="content"
                                                                             role="tabpanel"
                                                                             aria-labelledby="submit-part-trigger">
                                                                            <div class="form-group row">
                                                                                <label class="col-sm-2 control-label"
                                                                                       for="selectOrderId">单号</label>
                                                                                <div class="col-sm-10">
                                                                                    <input type="text"
                                                                                           class="form-control"
                                                                                           name="confirmOrderId"
                                                                                           id="confirmOrderId"
                                                                                           disabled>
                                                                                </div>
                                                                            </div>
                                                                            <div class="form-group row">
                                                                                <label class="col-sm-2 control-label"
                                                                                       for="selectOrderId">提交时间</label>
                                                                                <div class="col-sm-10">
                                                                                    <input type="text"
                                                                                           class="form-control"
                                                                                           name="confirmSubmitTime"
                                                                                           id="confirmSubmitTime"
                                                                                           disabled>
                                                                                </div>
                                                                            </div>
                                                                            <div class="form-group row">
                                                                                <label class="col-sm-2 control-label"
                                                                                       for="selectOrderId">原员工姓名</label>
                                                                                <div class="col-sm-10">
                                                                                    <input type="text"
                                                                                           class="form-control"
                                                                                           name="confirmOStaffName"
                                                                                           id="confirmOStaffName"
                                                                                           disabled>
                                                                                </div>
                                                                            </div>
                                                                            <div class="form-group row">
                                                                                <label class="col-sm-2 control-label"
                                                                                       for="selectOrderId">现员工姓名</label>
                                                                                <div class="col-sm-10">
                                                                                    <input type="text"
                                                                                           class="form-control"
                                                                                           name="confirmNStaffName"
                                                                                           id="confirmNStaffName"
                                                                                           disabled>
                                                                                </div>
                                                                            </div>
                                                                            <div class="form-group row">
                                                                                <label class="col-sm-2 control-label"
                                                                                       for="selectOrderId">申请理由</label>
                                                                                <div class="col-sm-10">
                                                                                    <textarea class="form-control"
                                                                                              name="confirmReason" id="confirmReason"
                                                                                              disabled></textarea>
                                                                                </div>
                                                                            </div>
                                                                            <div class="form-group row">
                                                                                <label class="col-sm-2 control-label"
                                                                                       for="selectOrderId">审批结果</label>
                                                                                <div class="col-sm-10">
                                                                                    <input type="text" class="form-control"
                                                                                              name="confirmState" id="confirmState"
                                                                                              disabled>
                                                                                </div>
                                                                            </div>
                                                                            <button class="btn btn-primary"
                                                                                    onclick="stepper.previous()">
                                                                                Previous
                                                                            </button>
                                                                            <button id="examineForm"
                                                                                    class="btn btn-primary">分配任务
                                                                            </button>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <!-- /.modal-content -->
                                    </div>
                                    <!-- /.modal-dialog -->
                                </div>
                            </div>
                        </div>
                        <div class="table-responsive table mt-2" id="dataTable" role="grid"
                             aria-describedby="dataTable_info">
                            <table class="table my-0" id="dataTable1">
                                <thead>
                                <tr>
                                    <th style="text-align: center">单号</th>
                                    <th style="text-align: center">提交时间</th>
                                    <th style="text-align: center">原员工编号</th>
                                    <th style="text-align: center">原员工姓名</th>
                                    <th style="text-align: center">现员工编号</th>
                                    <th style="text-align: center">现员工姓名</th>
                                    <th style="text-align: center">处理状态</th>
                                    <th style="text-align: center">操作</th>
                                </tr>
                                </thead>
                                <tbody id="tb">

                                </tbody>
                                <tfoot>
                                <tr></tr>
                                </tfoot>
                            </table>
                        </div>
                        <div class="row">
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
<!-- Bootstrap 4 -->
<script src="plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="plugins/bootstrap-select/js/bootstrap-select.js"></script>
<script src="plugins/bootstrap-select/js/i18n/defaults-zh_CN.min.js"></script>
<!-- AdminLTE App -->
<script src="dist/js/adminlte.js"></script>
<script src="plugins/bs-stepper/js/bs-stepper.min.js"></script>
<script src="plugins/bootstrap-switch/js/bootstrap-switch.min.js"></script>
<script type="text/javascript">
    let stationId = "${sessionScope.stationId}";
</script>
<script src="dist/js/pages/examineApplication.js"></script>
</body>
</html>



