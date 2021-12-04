<%--
  Created by IntelliJ IDEA.
  User: 李龙
  Date: 2021/12/3
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: 李龙
  Date: 2021/12/3
  Time: 14:57
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
                <h3 class="text-dark mb-4">车辆检测信息管理</h3>
                <div class="card shadow">
                    <div class="card-body">
                        <div class="row">
                            <div class="col-md-6 text-nowrap">时间选择:
                                <button class="btn btn-primary btn-sm" role="button" style="margin-left: 10px;">历史</button>
                                <button class="btn btn-primary btn-sm" role="button" style="margin-left: 10px;">今日</button>

                                <button class="btn btn-danger btn-sm" role="button" style="margin-left: 20px;" id="refresh">刷新</button>
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
                                    <th style="text-align: center">车主姓名</th>
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
<script type="text/javascript">
    // 生成模板
    function generateStr(data){
        // 定义变量,存储生成的字符串内容,使用 += 拼接字符串形式
        let str = '';
        //外层循环,生成tr
        for (let i = 0; i <= data.length - 1; i++) {
            // 外层循环生成tr标签,循环几次,就生成几个tr标签
            // 因为tr标签中还要有td内容,要将两个tr标签,分开,写成拼接的形式
            str += '<tr>';

            // 排序问题待解决
            // for (let j in data[i]) {
            //     str += `<td>`+data[i][j]+`</td>`;
            //     console.log(data[i][j]);
            // }
            str += `<td style="text-align: center">` + data[i]['order'] + `</td>`;
            str += `<td style="text-align: center">` + data[i]['idcard'] + `</td>`;
            str += `<td style="text-align: center">` + data[i]['fulllname'] + `</td>`;
            str += `<td style="text-align: center">` + data[i]['carId'] + `</td>`;
            str += `<td style="text-align: center">` + data[i]['address'] + `</td>`;
            str += `<td style="text-align: center">` + data[i]['orderTime'] + `</td>`;
            str += `<td style="text-align: center">` + data[i]['process'] + `</td>`;
            str += `<td style="text-align: center">
                        <a class="col-2" href="javascript:void(0);" onclick="clickDelete(`+ data[i]['order'] + `)" id="delete">
                            <i class="nav-icon far fa-trash-alt" title="删除"></i>
                        </a>
                        <a class="col-2" data-toggle="modal" data-target="#R`+data[i]['order'] + `">
                            <i class="nav-icon far fa-edit" title="分配任务"></i>
                        </a>
                    <td>`;
            str += `<div class="modal fade" id="R`+data[i]['order'] + `" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h4 class="modal-title text-left">分配任务</h4>
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                        &times;
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <form class="form-horizontal" role="form" onsubmit="return check(this)">
                                        <div class="form-group row">
                                            <label class="col-sm-2 control-label">检测时间</label>
                                            <div class="col-sm-10">
                                                <select class="selectpicker" data-live-search="true" data-style="btn-info" data-live-search-placeholder="选择检测时间">
                                                    <option value="1">8:00-9:00</option>
                                                    <option value="2">10:00-11:00</option>
                                                    <option value="3">13:00-14:00</option>
                                                    <option value="4">15:00-16:00</option>
                                                    <option value="5">17:00-18:00</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-sm-2 control-label">检测结果</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" value="`+data[i]['result'] + `"
                                                       name="result">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-sm-2 control-label">检测员工号</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" value="`+data[i]['staffId'] + `"
                                                       name="staffId">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-sm-2 control-label">检测员姓名</label>
                                            <div class="col-sm-10">
                                                <select class="selectpicker" data-live-search="true" data-style="btn-info" data-live-search-placeholder="选择员工">
                                                    <option value="1">李四</option>
                                                    <option value="2">王五</option>
                                                    <option value="3">张三</option>
                                                    <option value="4">刘明</option>
                                                    <option value="5">吴昊</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-sm-2 control-label">服务评分</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" value="`+data[i]['score'] + `"
                                                       name="score">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-sm-2 control-label">重审资格</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" value="`+data[i]['available'] + `"
                                                       name="available">
                                            </div>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="reset" class="btn btn-default">重置</button>
                                            <button type="submit" class="btn btn-primary">分配</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>`;
            str += '</tr>';
        }
        return str;
    };

    function clickDelete(stationId){
        console.log('click the a');
        $.ajax({
            url: 'deleteStationById',
            type: 'post',
            dataType: 'json',
            data: {
                stationId:stationId
            },
            success: function (data) {
                // console.log(data);
                let tb = document.getElementById('tb');
                let str = generateStr(data);
                // 将定义好的内容,写入到tbody标签中
                tb.innerHTML = str;
            },
            error: function () {

            }
        });
    };

    function check(obj){
        // console.log(obj);
        $.ajax({
            url: 'updateStationById',
            type: 'post',
            dataType: 'json',
            data: {
                stationId:obj.stationId.value,
                longitude:obj.longitude.value,
                latitude:obj.latitude.value,
                address:obj.address.value,
                stationName:obj.stationName.value,
                phone:obj.phone.value,
                maxNum:obj.maxNum.value
            },
            success: function (data) {
                // console.log(data);
                let tb = document.getElementById('tb');
                let str = generateStr(data);
                // 将定义好的内容,写入到tbody标签中
                tb.innerHTML = str;
                // console.log($('.modal'));
                $(".modal").modal('hide');
                $('.modal-backdrop').remove();//去掉遮罩层
            },
            error: function () {

            }
        });
        // console.log(obj.phone.value);
        return false;
    }

    $(function () {
        $.ajax({
            url: 'getAllRecord',
            type: 'post',
            dataType: 'json',
            data: {},
            success: function (data) {
                // console.log(data);
                let tb = document.getElementById('tb');
                let str = generateStr(data);
                // 将定义好的内容,写入到tbody标签中
                tb.innerHTML = str;
                $('.selectpicker').selectpicker('val','mustard');
                $('.selectpicker').selectpicker('val',['mustard','relish']);
            },
            error: function () {

            }
        });

        $('#sub').click(function (e) {

            let temp = $("input[name='stationId']").val();
            // console.log(temp);
            $.ajax({
                url: 'getStationById',
                type: 'post',
                dataType: 'json',
                data: {
                    stationId: temp
                },
                success: function (data) {
                    // console.log(data);
                    let tb = document.getElementById('tb');
                    let str = generateStr(data);
                    // 将定义好的内容,写入到tbody标签中
                    tb.innerHTML = str;
                },
                error: function () {

                }
            });
            e.preventDefault();
        });

        $('#refresh').click(function(e){
            e.preventDefault();
            $.ajax({
                url: 'getStationList',
                type: 'post',
                dataType: 'json',
                data: {},
                success: function (data) {
                    // console.log(data);
                    let tb = document.getElementById('tb');
                    let str = generateStr(data);
                    // 将定义好的内容,写入到tbody标签中
                    tb.innerHTML = str;
                }
            });
        });

        $('#addSubmit').click(function(e){
            e.preventDefault();
            let longitude = $("input[name='longitude']").val();
            let latitude = $("input[name='latitude']").val();
            let address = $("input[name='address']").val();
            let stationName = $("input[name='stationName']").val();
            let phone = $("input[name='phone']").val();
            let maxNum = $("input[name='maxNum']").val();
            $.ajax({
                url: 'addStationInfo',
                type: 'post',
                dataType: 'json',
                data: {
                    longitude:longitude,
                    latitude:latitude,
                    address:address,
                    stationName:stationName,
                    phone:phone,
                    maxNum:maxNum
                },
                success: function (data) {
                    // console.log(data);
                    let tb = document.getElementById('tb');
                    let str = generateStr(data);
                    // 将定义好的内容,写入到tbody标签中
                    tb.innerHTML = str;
                    $('#myModal').modal('hide');
                },
                error: function () {

                }
            });
        });


    });
</script>
</body>
</html>

