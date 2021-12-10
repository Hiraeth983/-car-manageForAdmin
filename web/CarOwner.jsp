<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>车辆排检管理系统</title>

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

        .layui-form-label {
            width: 7em;
            margin-left: 10em;
        }

        .layui-input-block {
            width: 38em;
            margin-left: 18em;
        }

        .layui-input-inline {
            width: 15em;
            margin-left: 1em;
        }

        .layui-upload {
            margin-left: 1em;
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
                <a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a>
            </li>
            <li class="nav-item d-none d-sm-inline-block">
                <a href="index.jsp" class="nav-link">首页</a>
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
                    <a href="#" class="d-block">尊敬的<em>车主</em>，您好！</a>
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
                    <!-- Add icons to the links using the .nav-icon class
                       with font-awesome or any other icon font library -->
                    <li class="nav-item">
                        <a href="#" class="nav-link">
                            <i class="nav-icon fas fa-tachometer-alt"></i>
                            <p>
                                事务申请
                                <i class="right fas fa-angle-left"></i>
                            </p>
                        </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href="ApplyCheck.jsp" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>申请车辆检测</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="index.html" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>更改申请信息</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="guide.html" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>撤销申请</p>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item">
                        <a href="#" class="nav-link">
                            <i class="nav-icon fas fa-th"></i>
                            <p>
                                评价
                                <i class="fas fa-angle-left right"></i>
                            </p>
                        </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href="realTimeAlarm.html" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>评价检测人员</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="exception.html" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>评价检测服务</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="exception.html" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>投诉举报</p>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item">
                        <a href="#" class="nav-link">
                            <i class="nav-icon fas fa-search"></i>
                            <p>
                                查询信息
                                <i class="fas fa-angle-left right"></i>
                            </p>
                        </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href="CheckResult.jsp" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>车辆检测结果</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="schedule.jsp" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>办理进度</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="station.jsp" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>检测点信息</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="staffScore.jsp" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>检测员评价</p>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item menu-open">
                        <a href="#" class="nav-link active">
                            <i class="nav-icon fas fa-cog"></i>
                            <p>
                                个人信息设置
                                <i class="right fas fa-angle-left"></i>
                            </p>
                        </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href="CarOwner.jsp" class="nav-link active">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>个人信息</p>
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
                        <h1 class="m-0"></h1>
                    </div><!-- /.col -->
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="#">首页</a></li>
                            <li class="breadcrumb-item active">个人信息</li>
                        </ol>
                    </div><!-- /.col -->
                </div><!-- /.row -->
            </div><!-- /.container-fluid -->
        </div>
        <!-- /.content-header -->

        <!-- Main content -->
        <section class="content">
            <div class="container-fluid">
                <div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
                    <ul class="layui-tab-title">
                        <li class="layui-this">个人信息</li>
                    </ul>
                    <div class="layui-tab-content" style="height: 100px;">
                        <div class="layui-tab-item layui-show">
                            <form class="layui-form" id="carowner" action="UpdateOwnerInfoServlet" method="post">
                                <div class="layui-form-item">
                                    <label class="layui-form-label">身份证</label>
                                    <div class="layui-input-block">
                                        <input id="idCard" type="text" name="idCard" lay-verify="required"
                                               autocomplete="off" placeholder="请输入身份证号" class="layui-input"
                                               disabled="disabled">
                                    </div>
                                </div>
                                <div class="layui-form-item">
                                    <label class="layui-form-label">姓名</label>
                                    <div class="layui-input-block">
                                        <input id="fullName" type="text" name="fullName" lay-verify="required"
                                               lay-reqtext="用户名是必填项"
                                               placeholder="请输入" autocomplete="off" class="layui-input"
                                               disabled="disabled">
                                    </div>
                                </div>
                                <div class="layui-form-item">
                                    <div class="layui-inline">
                                        <label class="layui-form-label">手机号</label>
                                        <div class="layui-input-inline">
                                            <input id="phone" type="tel" name="phone" lay-verify="required|phone"
                                                   autocomplete="off" class="layui-input">
                                        </div>
                                    </div>
                                    <div class="layui-inline">
                                        <label class="layui-form-label" style="margin-left: 1em;">邮箱</label>
                                        <div class="layui-input-inline">
                                            <input id="email" type="text" name="email" lay-verify="email"
                                                   autocomplete="off"
                                                   class="layui-input">
                                        </div>
                                    </div>
                                </div>

                                <div class="layui-form-item">
                                    <label class="layui-form-label">车牌号</label>
                                    <div class="layui-input-block">
                                        <input id="carId" type="text" name="carId" lay-verify="identity" placeholder=""
                                               autocomplete="off" class="layui-input">
                                    </div>
                                </div>

                                <div class="layui-form-item">
                                    <label class="layui-form-label">违章记录</label>
                                    <div class="layui-input-block">
                                        <input type="radio" name="illegal" value="1" title="有">
                                        <input type="radio" name="illegal" value="0" title="无">
                                    </div>
                                </div>
                                <%--                                <div class="modal-body row">--%>
                                <%--                                    <div class="col-5">--%>
                                <%--                                        <div class="layui-upload">--%>
                                <%--                                            <button type="button" class="layui-btn" id="test1">修改</button>--%>
                                <%--                                            <blockquote class="layui-elem-quote layui-quote-nm"--%>
                                <%--                                                        style="margin-top: 10px;">--%>
                                <%--                                                身份证照：--%>
                                <%--                                                <div class="layui-upload-list" id="demo1"></div>--%>
                                <%--                                            </blockquote>--%>
                                <%--                                        </div>--%>
                                <%--                                    </div>--%>
                                <%--                                    <div class="col-5">--%>
                                <%--                                        <div class="layui-upload">--%>
                                <%--                                            <button type="button" class="layui-btn" id="test2">修改</button>--%>
                                <%--                                            <blockquote class="layui-elem-quote layui-quote-nm"--%>
                                <%--                                                        style="margin-top: 10px;">--%>
                                <%--                                                驾驶证照：--%>
                                <%--                                                <div class="layui-upload-list" id="demo2"></div>--%>
                                <%--                                            </blockquote>--%>
                                <%--                                        </div>--%>
                                <%--                                    </div>--%>
                                <%--                                </div>--%>
                                <%--                                tupian --%>
                                <input type="hidden" name="driveLicense" class="image">
                                <div class="layui-form-item">
                                    <label class="layui-form-label ">驾驶证:</label>
                                    <div class="layui-upload">
                                        <button type="button" class="layui-btn" id="test1">上传图片</button>
                                        <div class="layui-upload-list">
                                            <img class="layui-upload-img" id="demo1">
                                            <p id="demoText1"></p>
                                        </div>
                                    </div>
                                </div>
                                <input type="hidden" name="driveLicense" class="image">
                                <div class="layui-form-item">
                                    <label class="layui-form-label ">行驶证:</label>
                                    <div class="layui-upload">
                                        <button type="button" class="layui-btn" id="test2">上传图片</button>
                                        <div class="layui-upload-list">
                                            <img class="layui-upload-img" id="demo2">
                                            <p id="demoText2"></p>
                                        </div>
                                    </div>
                                </div>
                                <div class="layui-form-item">
                                    <div class="layui-input-block">
                                        <button type="submit" class="layui-btn" lay-filter="demo1"
                                                style="margin-left: 13em;">确认
                                        </button>
                                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                                    </div>
                                </div>
                            </form>
                        </div>

                    </div>
                </div>


            </div><!-- /.container-fluid -->
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


<script type="text/javascript">


    $(function () {
        let form = layui.form;
        let statu = 0;
        if (statu === 0) {
            $("input[name='illegal'][value='0']").prop("checked", "true");
            $("input[name='illegal'][value='1']").prop("checked", "false");
            form.render(); //更新全部
        }
        if (statu === 1) {


        }
    });

</script>
</body>

</html>
