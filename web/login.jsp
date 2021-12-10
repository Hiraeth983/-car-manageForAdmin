<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page isELIgnored="false" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>登录</title>


    <!-- Theme style -->
    <link rel="stylesheet" href="dist/css/adminlte.min.css">

    <link rel="stylesheet" href="plugins/bootstrapValidate/css/bootstrapValidator.min.css">
    <link rel="stylesheet" href="plugins/bootstrap/css/bootstrap.min.css">
</head>
<body class="hold-transition login-page">
<div class="login-box">
    <div class="login-logo">
        <a href="#"><b>机动车排检</b>管理系统</a>
    </div>
    <!-- /.login-logo -->
    <div class="card">
        <div class="card-body login-card-body">
            <h3 class="login-box-msg">平台管理员/站长登录</h3>

            <form id="defaultForm" action="verifyLogin" method="post">
                <div class="form-group mb-3">
                    <input type="text" class="form-control" placeholder="用户名" name="userName">
                </div>
                <div class="form-group mb-3">
                    <input type="password" class="form-control" placeholder="密码" name="password">
                </div>
                <div class="row" style="text-align: right;">
                    <div class="col-8"></div>
                    <div class="col-4">
                        <div class="icheck-primary">
                            <input type="checkbox" id="remember">
                            <label for="remember">
                                记住密码
                            </label>
                        </div>
                    </div>
                    <!-- /.col -->
                </div>
                <div style="height: 10px;">&nbsp;</div>
                <div class="col-12">
                    <button type="submit" class="btn btn-primary btn-block">登录</button>
                </div>
            </form>

            <div class="social-auth-links text-center mb-3">
                <p>- OR -</p>
                <a href="#" class="btn btn-block btn-danger">
                    <i class="fab mr-2"></i> 忘记密码？
                </a>
            </div>
            <!-- /.social-auth-links -->


        </div>
        <!-- /.login-card-body -->
    </div>
</div>
<!-- /.login-box -->

<!-- jQuery -->
<script src="plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="plugins/bootstrap/js/bootstrap.min.js"></script>
<!-- AdminLTE App -->
<script src="dist/js/adminlte.js"></script>
<script src="plugins/bootstrapValidate/js/bootstrapValidator.min.js"></script>
<script type="text/javascript">
    $(function () {
        $('#defaultForm').bootstrapValidator({
            message: 'This value is not valid',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                userName: {
                    validators: {
                        notEmpty: {
                            message: '用户名不能为空！'
                        }
                    }
                },
                password: {
                    validators: {
                        notEmpty: {
                            message: '密码不能为空！'
                        }
                    }
                }
            }
        });
    });
</script>
</body>
</html>

