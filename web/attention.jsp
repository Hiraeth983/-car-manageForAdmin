<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
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
                    <li class="nav-item menu-open">
                        <a href="attention.jsp" class="nav-link active">
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
                        <h1 class="m-0">重点关注</h1>
                    </div><!-- /.col -->
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="#">首页</a></li>
                            <li class="breadcrumb-item active">重点关注</li>
                        </ol>
                    </div><!-- /.col -->
                </div><!-- /.row -->
            </div><!-- /.container-fluid -->
        </div>
        <!-- /.content-header -->

        <!-- Main content -->
        <section class="content">
            <div class="container-fluid">
                <div class="layui-tab layui-tab-brief" lay-filter="current">
                    <ul class="layui-tab-title">
                        <li lay-id="1" class="layui-this">车辆</li>
                        <li lay-id="2">员工</li>
                        <li lay-id="3">事件</li>
                    </ul>
                    <div class="layui-tab-content">
                        <div class="layui-tab-item layui-show">
                            <div class="row chart tab-pane active" id="chart2"
                                 style="margin:0 auto;width: 1200px; height: 500px;">

                            </div>
                        </div>
                        <div class="layui-tab-item">
                            <label for="date1">时间：</label>
                            <select class="shortselect" id="date1" style="text-align: center">
                                <option value="year">本年</option>
                                <option value="month">本月</option>
                                <option value="week">本周</option>
                            </select>

                            <label for="num1">&nbsp;&nbsp;员工个数：</label>
                            <select class="shortselect" id="num1" style="text-align: center">
                                <option value="9">9</option>
                                <option value="6">6</option>
                                <option value="3">3</option>
                            </select>
                            <div class="row chart tab-pane active" id="chart1"
                                 style="margin:0 auto;width: 1200px; height: 500px;">

                            </div>
                        </div>
                        <div class="layui-tab-item">
                            <label for="date">时间：</label>
                            <select class="shortselect" id="date" style="text-align: center">
                                <option value="year">本年</option>
                                <option value="month">本月</option>
                                <option value="week">本周</option>
                            </select>

                            <label for="num">&nbsp;&nbsp;排名个数：</label>
                            <select class="shortselect" id="num" style="text-align: center">
                                <option value="9">9</option>
                                <option value="6">6</option>
                                <option value="3">3</option>
                            </select>
                            <div class="row chart tab-pane active" id="chart"
                                 style="margin:0 auto;width: 1200px; height: 500px;">

                            </div>
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
<script>
    layui.use('element', function () {
        var element = layui.element;
        //获取hash来切换选项卡，假设当前地址的hash为lay-id对应的值
        var layid = location.hash.replace(/^#current=/, '');//current为刚才定义的lay-filter
        element.tabChange('current', layid); //假设当前地址为：http://a.com#current=two，那么选项卡会自动切换到“资产发现”这一项
        //监听Tab切换，以改变地址hash值
        element.on('tab(current)', function () {
            location.hash = 'current=' + this.getAttribute('lay-id');
        });
    });
</script>
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
<script src="plugins/bootstrap/js/echarts.js"></script>
<script>
    function loadErrorTypeEcharts(array) {
        let dom = document.getElementById("chart");
        let myChart = echarts.init(dom);
        let app = {};

        let option = {
            title: {
                text: '关注事件类型',
                subtext: '数据来源自数据库',
                left: 'center'
            },
            tooltip: {
                trigger: 'item'
            },
            legend: {
                data: array.map(function (item) {
                    return item[0];
                })
            },
            dataset: [
                {
                    dimensions: ['error_type', 'count'],
                    source: array
                },
                {
                    transform: {
                        type: 'sort',
                        config: {dimension: 'count', order: 'desc'}
                    }
                }
            ],
            xAxis: {
                type: 'category',
                axisLabel: {interval: 0, rotate: 30}
            },
            yAxis: {},
            series: {
                type: 'bar',
                encode: {x: 'error_type', y: 'count'},
                datasetIndex: 1,
                itemStyle: {
                    normal: {
                        color: function (params) {
                            let colorList = ["#7EC0EE", "#FF9F7F", "#FFD700", "#C9C9C9", "#E066FF", "#C0FF3E"];
                            return colorList[params.dataIndex % 6];
                        }
                    }
                }
            }
        };

        myChart.setOption(option);
    }
    function loadStaffEcharts(array) {
        let dom = document.getElementById("chart1");
        let myChart = echarts.init(dom);
        let app = {};

        let option = {
            title: {
                text: '员工判定事件异常',
                subtext: '数据来源自数据库',
                left: 'center'
            },
            tooltip: {
                trigger: 'item'
            },
            dataset: [
                {
                    dimensions: ['staff_name', 'number'],
                    source: array
                },
                {
                    transform: {
                        type: 'sort',
                        config: {dimension: 'number', order: 'desc'}
                    }
                }
            ],
            xAxis: {
                type: 'category',
                axisLabel: {interval: 0, rotate: 30}
            },
            yAxis: {},
            series: {
                type: 'bar',
                encode: {x: 'staff_name', y: 'number'},
                datasetIndex: 1,
                // itemStyle: {
                //     normal: {
                //         color: function (params) {
                //             let colorList = ["#7EC0EE", "#FF9F7F", "#FFD700"];
                //             return colorList[params.dataIndex % 3];
                //         }
                //     }
                // }
            }
        };

        myChart.setOption(option);
    }
    function loadCarEcharts(array) {
        let dom = document.getElementById("chart2");
        let myChart = echarts.init(dom);
        let app = {};

        let option = {
            title: {
                text: '车辆异常',
                subtext: '数据来源自数据库',
                left: 10
            },
            toolbox: {
                feature: {
                    dataZoom: {
                        yAxisIndex: false
                    },
                    saveAsImage: {
                        pixelRatio: 2
                    }
                }
            },
            tooltip: {
                trigger: 'axis',
                axisPointer: {
                    type: 'shadow'
                }
            },
            grid: {
                bottom: 90
            },
            dataZoom: [
                {
                    type: 'inside'
                },
                {
                    type: 'slider'
                }
            ],
            xAxis: {
                data: array.car_id,
                silent: false,
                splitLine: {
                    show: false
                },
                splitArea: {
                    show: false
                }
            },
            yAxis: {
                splitArea: {
                    show: false
                }
            },
            series: [
                {
                    type: 'bar',
                    data: array.error_count,
                    // Set `large` for large data amount
                    large: true
                }
            ]
        };

        myChart.setOption(option);
    }

</script>
<script type="text/javascript">
    $(function () {
        $.ajax({
            url: 'loadErrorTypeJson',
            //参数
            data: {date: 'year', num: 9},
            //请求类型
            type: 'POST',
            //响应体结果类型
            dataType: 'json',
            //成功回调
            success: function (data) {
                loadErrorTypeEcharts(data);
            }
        });

        $.ajax({
            url: 'loadStaffJson',
            //参数
            data: {date: 'year', num: 9},
            //请求类型
            type: 'POST',
            //响应体结果类型
            dataType: 'json',
            //成功回调
            success: function (data) {
                loadStaffEcharts(data);
            }
        });

        $.ajax({
            url: 'loadCarJson',
            //参数
            data: {date: 'year', num: 9},
            //请求类型
            type: 'POST',
            //响应体结果类型
            dataType: 'json',
            //成功回调
            success: function (data) {
                loadCarEcharts(data);
            }
        });

        $('#date,#num').change(function () {
            let date = $('#date').find('option:selected').val();
            let num = $('#num').find('option:selected').val();
            $.ajax({
                url: 'loadErrorTypeJson',
                //参数
                data: {date: date, num: num},
                //请求类型
                type: 'POST',
                //响应体结果类型
                dataType: 'json',
                //成功回调
                success: function (data) {
                    loadErrorTypeEcharts(data);
                }
            });
        });

        $('#date1,#num1').change(function () {
            let date = $('#date1').find('option:selected').val();
            let num = $('#num1').find('option:selected').val();
            $.ajax({
                url: 'loadStaffJson',
                //参数
                data: {date: date, num: num},
                //请求类型
                type: 'POST',
                //响应体结果类型
                dataType: 'json',
                //成功回调
                success: function (data) {
                    loadStaffEcharts(data);
                }
            });
        });
    });
</script>

</body>

</html>