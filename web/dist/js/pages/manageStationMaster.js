// 生成模板
function generateStr(data) {
    // 定义变量,存储生成的字符串内容,使用 += 拼接字符串形式
    let str = '';
    //外层循环,生成tr
    for (let i = 0; i <= data.length - 1; i++) {
        str += '<tr>';

        str += `<td style="text-align: center">` + data[i]['userName'] + `</td>`;
        str += `<td style="text-align: center">` + data[i]['password'] + `</td>`;
        str += `<td style="text-align: center">` + data[i]['stationId'] + `</td>`;
        str += `<td style="text-align: center">
                        <a class="col-2" href="javascript:void(0);" onclick="clickDelete('` + data[i]['userName'] + `')" id="delete">
                            <i class="nav-icon far fa-trash-alt" title="删除"></i>
                        </a>
                        <a class="col-2" data-toggle="modal" data-target="#S` + data[i]['userName'] + `">
                            <i class="nav-icon far fa-edit" title="修改"></i>
                        </a>
                    <td>`;
        str += `<div class="modal fade" id="S` + data[i]['userName'] + `" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h4 class="modal-title text-left">修改</h4>
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                        &times;
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <form class="form-horizontal" role="form" onsubmit="return check(this)">
                                        <div class="form-group row">
                                            <label class="col-sm-2 control-label">用户名</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" value="` + data[i]['userName'] + `"
                                                       placeholder="请输入用户名" name="userName" disabled>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-sm-2 control-label">密码</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" value="` + data[i]['password'] + `"
                                                       placeholder="请输入密码" name="password">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-sm-2 control-label">所属站号</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" value="` + data[i]['stationId'] + `"
                                                       placeholder="请输入所属站号" name="stationId">
                                            </div>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="reset" class="btn btn-default">重置</button>
                                            <button type="submit" class="btn btn-primary">修改</button>
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

function clickDelete(userName) {
    console.log('click the a');
    $.ajax({
        url: 'deleteAdminLogByUserName',
        type: 'post',
        dataType: 'json',
        data: {
            userName: userName
        },
        success: function (data) {
            // console.log(data);
            let tb = document.getElementById('tb');
            if (data === '暂无数据') {
                tb.innerHTML = '';
                $("#tb").parent().parent().html("<div class=\"tips\" style=\"text-align: center;color: #333333;line-height: 40px;border-bottom: 1px solid #bce8f1;\">暂无相应数据！</div>");
                $(".tips").show();
            } else {
                $("#noData").html('');
                let str = generateStr(data);
                // 将定义好的内容,写入到tbody标签中
                tb.innerHTML = str;
            }
        }
    });
};

function check(obj) {
    // console.log(obj);
    $.ajax({
        url: 'updateAdminLogByUserName',
        type: 'post',
        dataType: 'json',
        data: {
            userName: obj.userName.value,
            password: obj.password.value,
            stationId: obj.stationId.value
        },
        success: function (data) {
            $(".modal").modal('hide');
            $('.modal-backdrop').remove();//去掉遮罩层
            // console.log(data);
            let tb = document.getElementById('tb');
            if (data === '暂无数据') {
                tb.innerHTML = '';
                $("#tb").parent().parent().html("<div class=\"tips\" style=\"text-align: center;color: #333333;line-height: 40px;border-bottom: 1px solid #bce8f1;\">暂无相应数据！</div>");
                $(".tips").show();
            } else {
                $("#noData").html('');
                let str = generateStr(data);
                // 将定义好的内容,写入到tbody标签中
                tb.innerHTML = str;
            }

        },
        error: function () {

        }
    });
    // console.log(obj.phone.value);
    return false;
}

$(function () {
    $.ajaxSettings.async = false;
    $('#addForm').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            userName: {
                message: 'The username is not valid',
                validators: {
                    notEmpty: {
                        message: '用户名不能为空'
                    },
                    stringLength: {
                        min: 4,
                        max: 8,
                        message: '用户名由4-8位字符组成'
                    },
                    threshold: 4,//有4字符以上才发送ajax请求
                    remote: {//ajax验证。server result:{"valid",true or false}
                        url: "verifyUserNameExists",
                        message: '用户名已存在,请重新输入',
                        delay: 1000,//ajax刷新的时间是1秒一次
                        type: 'POST',
                        //自定义提交数据，默认值提交当前input value
                        data: function (validator) {
                            return {
                                userName: $("#userName").val(),
                                method: "checkUserName"//UserServlet判断调用方法关键字。
                            };
                        }
                    }
                }
            }
        }
    });
    $.ajax({
        url: 'getAdminLogList',
        type: 'post',
        dataType: 'json',
        data: {},
        success: function (data) {
            // console.log(data);
            let tb = document.getElementById('tb');
            if (data === '暂无数据') {
                tb.innerHTML = '';
                $("#tb").parent().parent().html("<div class=\"tips\" style=\"text-align: center;color: #333333;line-height: 40px;border-bottom: 1px solid #bce8f1;\">暂无相应数据！</div>");
                $(".tips").show();
            } else {
                $("#noData").html('');
                let str = generateStr(data);
                // 将定义好的内容,写入到tbody标签中
                tb.innerHTML = str;
            }

        }
    });

    $('#sub').click(function (e) {

        let temp = $("input[name='stationIdForSearch']").val();
        // console.log(temp);
        $.ajax({
            url: 'getAdminLogByStationId',
            type: 'post',
            dataType: 'json',
            data: {
                stationId: temp
            },
            success: function (data) {
                // console.log(data);
                let tb = document.getElementById('tb');
                if (data === '暂无数据') {
                    tb.innerHTML = '';
                    $("#tb").parent().parent().html("<div class=\"tips\" style=\"text-align: center;color: #333333;line-height: 40px;border-bottom: 1px solid #bce8f1;\">暂无相应数据！</div>");
                    $(".tips").show();
                } else {
                    $("#noData").html('');
                    let str = generateStr(data);
                    // 将定义好的内容,写入到tbody标签中
                    tb.innerHTML = str;
                }
            }
        });
        e.preventDefault();
    });

    $('#refresh').click(function (e) {
        e.preventDefault();
        $.ajax({
            url: 'getAdminLogList',
            type: 'post',
            dataType: 'json',
            data: {},
            success: function (data) {
                // console.log(data);
                let tb = document.getElementById('tb');
                if (data === '暂无数据') {
                    tb.innerHTML = '';
                    $("#tb").parent().parent().html("<div class=\"tips\" style=\"text-align: center;color: #333333;line-height: 40px;border-bottom: 1px solid #bce8f1;\">暂无相应数据！</div>");
                    $(".tips").show();
                } else {
                    $("#noData").html('');
                    let str = generateStr(data);
                    // 将定义好的内容,写入到tbody标签中
                    tb.innerHTML = str;
                }
            }
        });
    });

    $('#addSubmit').click(function (e) {
        e.preventDefault();
        let userName = $("input[name='userName']").val();
        let password = $("input[name='password']").val();
        let stationId = $("input[name='stationId']").val();
        $.ajax({
            url: 'insertAdminLog',
            type: 'post',
            dataType: 'json',
            data: {
                userName: userName,
                password: password,
                stationId: stationId
            },
            success: function (data) {
                // console.log(data);
                let tb = document.getElementById('tb');
                if (data === '检测站站长人数已达上限！') {
                    alert(data);
                } else if (data === '暂无数据') {
                    tb.innerHTML = '';
                    $("#tb").parent().parent().html("<div class=\"tips\" style=\"text-align: center;color: #333333;line-height: 40px;border-bottom: 1px solid #bce8f1;\">暂无相应数据！</div>");
                    $(".tips").show();
                } else {
                    $("#noData").html('');
                    let str = generateStr(data);
                    // 将定义好的内容,写入到tbody标签中
                    tb.innerHTML = str;
                    $('#myModal').modal('hide');
                }

            }
        });
    });
});
