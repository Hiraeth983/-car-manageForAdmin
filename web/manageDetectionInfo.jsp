<%--
  Created by IntelliJ IDEA.
  User: 李龙
  Date: 2021/12/3
  Time: 21:33
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
    <link rel="stylesheet" href="plugins/bootstrap-select/css/bootstrap-select.min.css">
    <link rel="stylesheet" href="plugins/bs-stepper/css/bs-stepper.min.css">
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
                        <a href="stationInfo.jsp" class="nav-link">
                            <i class="nav-icon fas fa-tachometer-alt"></i>
                            <p>
                                检测站信息
                            </p>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="manageStaff.jsp" class="nav-link">
                            <i class="nav-icon fas fa-th"></i>
                            <p>
                                员工信息管理
                            </p>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="recordInfo.jsp" class="nav-link">
                            <i class="nav-icon fas fa-copy"></i>
                            <p>
                                车辆检测记录
                            </p>
                        </a>
                    </li>
                    <li class="nav-item menu-open">
                        <a href="manageDetectionInfo.jsp" class="nav-link active">
                            <i class="nav-icon fas fa-edit"></i>
                            <p>
                                分配员工检测任务
                            </p>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="examineApplication.jsp" class="nav-link">
                            <i class="nav-icon fas fa-table"></i>
                            <p>
                                审核调度申请
                            </p>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="countComplaintInfo.jsp" class="nav-link">
                            <i class="nav-icon fas fa-chart-pie"></i>
                            <p>
                                统计评价信息
                            </p>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="countDetectionInfo.jsp" class="nav-link">
                            <i class="nav-icon fas fa-calendar-alt"></i>
                            <p>
                                统计检测记录
                            </p>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="examineComplaint.jsp" class="nav-link">
                            <i class="nav-icon fas fa-columns"></i>
                            <p>
                                审批车主投诉
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
                <h3 class="text-dark mb-4">分配员工检测任务</h3>
                <div class="card shadow">
                    <div class="card-body">
                        <div class="row">
                            <div class="col-md-6 text-nowrap">
                                <button type="button" class="btn btn-primary btn-sm" data-toggle="modal"
                                        data-target="#modal-lg">
                                    分配任务
                                </button>
                                <div class="modal fade" id="modal-lg">
                                    <div class="modal-dialog modal-lg">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h4 class="modal-title">分配任务</h4>
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
                                                                                <span class="bs-stepper-label">选择时间段</span>
                                                                            </button>
                                                                        </div>
                                                                        <div class="line"></div>
                                                                        <div class="step"
                                                                             data-target="#select-staff-part">
                                                                            <button type="button" class="step-trigger"
                                                                                    role="tab"
                                                                                    aria-controls="select-staff-part"
                                                                                    id="select-staff-part-trigger">
                                                                                <span class="bs-stepper-circle">3</span>
                                                                                <span class="bs-stepper-label">派遣员工</span>
                                                                            </button>
                                                                        </div>
                                                                        <div class="line"></div>
                                                                        <div class="step" data-target="#submit-part">
                                                                            <button type="button" class="step-trigger"
                                                                                    role="tab"
                                                                                    aria-controls="submit-part"
                                                                                    id="submit-part-trigger">
                                                                                <span class="bs-stepper-circle">4</span>
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
                                                                                       for="selectOrderId">身份证号</label>
                                                                                <div class="col-sm-10">
                                                                                    <input type="text"
                                                                                           class="form-control"
                                                                                           name="idCard" id="idCard"
                                                                                           disabled>
                                                                                </div>
                                                                            </div>
                                                                            <div class="form-group row">
                                                                                <label class="col-sm-2 control-label"
                                                                                       for="fullName">车主姓名</label>
                                                                                <div class="col-sm-10">
                                                                                    <input type="text"
                                                                                           class="form-control"
                                                                                           name="fullName" id="fullName"
                                                                                           disabled>
                                                                                </div>
                                                                            </div>
                                                                            <div class="form-group row">
                                                                                <label class="col-sm-2 control-label"
                                                                                       for="carId">车牌号</label>
                                                                                <div class="col-sm-10">
                                                                                    <input type="text"
                                                                                           class="form-control"
                                                                                            id="carId"
                                                                                           disabled>
                                                                                </div>
                                                                            </div>
                                                                            <div class="form-group row">
                                                                                <label class="col-sm-2 control-label"
                                                                                       for="address">站点地址</label>
                                                                                <div class="col-sm-10">
                                                                                    <input type="text"
                                                                                           class="form-control"
                                                                                           name="address" id="address"
                                                                                           disabled>
                                                                                </div>
                                                                            </div>
                                                                            <div class="form-group row">
                                                                                <label class="col-sm-2 control-label"
                                                                                       for="orderTime">预约时间</label>
                                                                                <div class="col-sm-10">
                                                                                    <input type="text"
                                                                                           class="form-control"
                                                                                           name="orderTime"
                                                                                           id="orderTime" disabled>
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
                                                                                <label class="col-sm-2 control-label">选择检测时间</label>
                                                                                <div class="col-sm-10">
                                                                                    <select class="selectpicker"
                                                                                            id="selectCheckTime"
                                                                                            data-live-search="true"
                                                                                            data-style="btn-info"
                                                                                            title="请选择检测时间"
                                                                                            data-live-search-placeholder="搜索检测时间">
                                                                                        <option value="8:00:00">
                                                                                            8:00:00
                                                                                        </option>
                                                                                        <option value="10:00:00">
                                                                                            10:00:00
                                                                                        </option>
                                                                                        <option value="13:00:00">
                                                                                            13:00:00
                                                                                        </option>
                                                                                        <option value="15:00:00">
                                                                                            15:00:00
                                                                                        </option>
                                                                                        <option value="17:00:00">
                                                                                            17:00:00
                                                                                        </option>
                                                                                    </select>
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
                                                                        <div id="select-staff-part" class="content"
                                                                             role="tabpanel"
                                                                             aria-labelledby="select-staff-part-trigger">
                                                                            <div class="form-group row">
                                                                                <label class="col-sm-2 control-label"
                                                                                       for="staffId">检测员工号</label>
                                                                                <div class="col-sm-10">
                                                                                    <input type="text"
                                                                                           class="form-control"
                                                                                           name="staffId"
                                                                                           id="staffId" disabled>
                                                                                </div>
                                                                            </div>
                                                                            <div class="form-group row">
                                                                                <label class="col-sm-2 control-label">选择员工姓名</label>
                                                                                <div class="col-sm-10">
                                                                                    <select class="selectpicker"
                                                                                            id="selectStaff"
                                                                                            data-live-search="true"
                                                                                            data-style="btn-info"
                                                                                            title="请选择员工姓名"
                                                                                            data-live-search-placeholder="搜索员工姓名">
                                                                                    </select>
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
                                                                            <form class="form-horizontal" role="form" id="assignForm">
                                                                                <div class="form-group row">
                                                                                    <label class="col-sm-2 control-label"
                                                                                           for="confirmOrderId">单号</label>
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
                                                                                           for="confirmIdCard">身份证号</label>
                                                                                    <div class="col-sm-10">
                                                                                        <input type="text"
                                                                                               class="form-control"
                                                                                               name="confirmIdCard"
                                                                                               id="confirmIdCard"
                                                                                               disabled>
                                                                                    </div>
                                                                                </div>
                                                                                <div class="form-group row">
                                                                                    <label class="col-sm-2 control-label"
                                                                                           for="confirmFullName">车主姓名</label>
                                                                                    <div class="col-sm-10">
                                                                                        <input type="text"
                                                                                               class="form-control"
                                                                                               name="confirmFullName"
                                                                                               id="confirmFullName"
                                                                                               disabled>
                                                                                    </div>
                                                                                </div>
                                                                                <div class="form-group row">
                                                                                    <label class="col-sm-2 control-label"
                                                                                           for="confirmCarId">车牌号</label>
                                                                                    <div class="col-sm-10">
                                                                                        <input type="text"
                                                                                               class="form-control"
                                                                                               name="confirmCarId"
                                                                                               id="confirmCarId"
                                                                                               disabled>
                                                                                    </div>
                                                                                </div>
                                                                                <div class="form-group row">
                                                                                    <label class="col-sm-2 control-label"
                                                                                           for="confirmAddress">站点地址</label>
                                                                                    <div class="col-sm-10">
                                                                                        <input type="text"
                                                                                               class="form-control"
                                                                                               name="confirmAddress"
                                                                                               id="confirmAddress"
                                                                                               disabled>
                                                                                    </div>
                                                                                </div>
                                                                                <div class="form-group row">
                                                                                    <label class="col-sm-2 control-label"
                                                                                           for="confirmOrderTime">预约时间</label>
                                                                                    <div class="col-sm-10">
                                                                                        <input type="text"
                                                                                               class="form-control"
                                                                                               name="confirmOrderTime"
                                                                                               id="confirmOrderTime"
                                                                                               disabled>
                                                                                    </div>
                                                                                </div>
                                                                                <div class="form-group row">
                                                                                    <label class="col-sm-2 control-label"
                                                                                           for="confirmCheckTime">检测时间</label>
                                                                                    <div class="col-sm-10">
                                                                                        <input type="text"
                                                                                               class="form-control"
                                                                                               name="confirmCheckTime"
                                                                                               id="confirmCheckTime"
                                                                                               disabled>
                                                                                    </div>
                                                                                </div>
                                                                                <div class="form-group row">
                                                                                    <label class="col-sm-2 control-label"
                                                                                           for="confirmStaffId">检测员工号</label>
                                                                                    <div class="col-sm-10">
                                                                                        <input type="text"
                                                                                               class="form-control"
                                                                                               name="confirmStaffId"
                                                                                               id="confirmStaffId"
                                                                                               disabled>
                                                                                    </div>
                                                                                </div>
                                                                                <div class="form-group row">
                                                                                    <label class="col-sm-2 control-label"
                                                                                           for="confirmStaffName">检测员姓名</label>
                                                                                    <div class="col-sm-10">
                                                                                        <input type="text"
                                                                                               class="form-control"
                                                                                               name="confirmStaffName"
                                                                                               id="confirmStaffName"
                                                                                               disabled>
                                                                                    </div>
                                                                                </div>
                                                                                <button class="btn btn-primary"
                                                                                        onclick="stepper.previous()">
                                                                                    Previous
                                                                                </button>
                                                                                <button type="submit"
                                                                                        class="btn btn-primary">分配任务
                                                                                </button>
                                                                            </form>
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
                                <button class="btn btn-danger btn-sm" role="button" style="margin-left: 10px;"
                                        id="refresh">刷新
                                </button>
                            </div>
                            <div class="col-md-6">
                                <div class="text-md-right dataTables_filter" id="dataTable_filter">
                                    <form class="d-none d-sm-inline-block mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
                                        <div class="input-group"><input
                                                class="bg-light form-control form-control-sm border-0 small" type="text"
                                                placeholder="车牌号搜索..." name="carId">
                                            <div class="input-group-append">
                                                <button class="btn btn-primary py-0" type="submit" id="sub"><i
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
                                    <th style="text-align: center">单号</th>
                                    <th style="text-align: center">身份证号</th>
                                    <th style="text-align: center">车主姓名</th>
                                    <th style="text-align: center">车牌号</th>
                                    <th style="text-align: center">站点地址</th>
                                    <th style="text-align: center">预约时间</th>
                                    <th style="text-align: center">服务进度</th>
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
<!-- jQuery UI 1.11.4 -->
<script src="plugins/jquery-ui/jquery-ui.min.js"></script>
<!-- Bootstrap 4 -->
<script src="plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- Sparkline -->
<script src="plugins/sparklines/sparkline.js"></script>
<!-- jQuery Knob Chart -->
<script src="plugins/jquery-knob/jquery.knob.min.js"></script>
<script src="plugins/bootstrap-select/js/bootstrap-select.js"></script>
<script src="plugins/bootstrap-select/js/i18n/defaults-zh_CN.min.js"></script>
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
<script src="plugins/bs-stepper/js/bs-stepper.min.js"></script>
<script src="dist/js/pages/manageDetectionInfo.js"></script>
</body>
</html>

