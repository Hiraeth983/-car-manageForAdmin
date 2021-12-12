let stationList = [];

// 生成模板
function generateStr(data) {
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
        str += `<td style="text-align: center">` + data[i]['staffId'] + `</td>`;
        str += `<td style="text-align: center">` + data[i]['fullName'] + `</td>`;
        str += `<td style="text-align: center">` + data[i]['password'] + `</td>`;
        str += `<td style="text-align: center">` + data[i]['avgScore'] + `</td>`;
        str += `<td style="text-align: center">` + data[i]['orderSum'] + `</td>`;
        str += `<td style="text-align: center">` + data[i]['stationId'] + `</td>`;
        if (data[i]['isAble'] === 0) {
            str += `<td style="text-align: center">` + '无' + `</td>`;
        } else if (data[i]['isAble'] === 1) {
            str += `<td style="text-align: center">` + '有' + `</td>`;
        }
        str += `<td style="text-align: center">
                        <a class="col-2" href="javascript:void(0);" onclick="clickDelete(` + data[i]['staffId'] + `)" id="delete">
                            <i class="nav-icon far fa-trash-alt" title="删除"></i>
                        </a>
                        <a class="col-2" data-toggle="modal" data-target="#S` + data[i]['staffId'] + `">
                            <i class="nav-icon far fa-edit" title="修改"></i>
                        </a>
                    <td>`;
        str += `<div class="modal fade" id="S` + data[i]['staffId'] + `" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
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
                                            <label class="col-sm-2 control-label">员工编号</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" value="` + data[i]['staffId'] + `"
                                                       name="staffId" disabled>
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
                                            <label class="col-sm-2 control-label">资格证</label>
                                            <div class="col-sm-10">
                                                <select class="selectpicker" name="isAble" data-style="btn-info" title="请选择是否具有资格证">`;
        if (data[i]['isAble'] === 0) {
            str+=`<option value="0" selected>无资格证</option><option value="1">持有资格证</option>`;
        }else if (data[i]['isAble'] === 1){
            str+=`<option value="0">无资格证</option><option value="1" selected>持有资格证</option>`;
        }
        str += `</select>
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

function clickDelete(staffId) {
    // console.log('click the a');
    $.ajax({
        url: 'deleteStaffByStaffId',
        type: 'post',
        dataType: 'json',
        data: {
            staffId: staffId,
            stationId: $("input[name='stationId']").val()
        },
        success: function (data) {
            // console.log(data);
            let tb = document.getElementById('tb');
            let str = generateStr(data);
            // 将定义好的内容,写入到tbody标签中
            tb.innerHTML = str;
            $(".selectpicker").selectpicker("refresh");
        }
    });
};

function check(obj) {
    // console.log(obj);
    $.ajax({
        url: 'updateStaffByStaffId',
        type: 'post',
        dataType: 'json',
        data: {
            staffId: obj.staffId.value,
            password: obj.password.value,
            isAble: obj.isAble.value,
            stationId: $("input[name='stationId']").val()
        },
        success: function (data) {
            $(".modal").modal('hide');
            $('.modal-backdrop').remove();//去掉遮罩层
            // console.log(data);
            let tb = document.getElementById('tb');
            let str = generateStr(data);
            // 将定义好的内容,写入到tbody标签中
            tb.innerHTML = str;
            $(".selectpicker").selectpicker("refresh");
        }
    });
    // console.log(obj.phone.value);
    return false;
}

$(function () {
    $.ajax({
        url: 'getStaffListByStationId',
        type: 'post',
        dataType: 'json',
        data: {
            stationId: $("input[name='stationId']").val()
        },
        success: function (data) {
            // console.log(data);
            let tb = document.getElementById('tb');
            let str = generateStr(data);
            // 将定义好的内容,写入到tbody标签中
            tb.innerHTML = str;
            $(".selectpicker").selectpicker("refresh");
        },
        error: function () {

        }
    });
    $('#sub').click(function (e) {

        let temp = $("input[name='staffId']").val();
        // console.log(temp);
        $.ajax({
            url: 'getStaffByStaffId',
            type: 'post',
            dataType: 'json',
            data: {
                staffId: temp
            },
            success: function (data) {
                // console.log(data);
                let tb = document.getElementById('tb');
                let str = generateStr(data);
                // 将定义好的内容,写入到tbody标签中
                tb.innerHTML = str;
                $(".selectpicker").selectpicker("refresh");
            }
        });
        e.preventDefault();
    });

    $('#refresh').click(function (e) {
        e.preventDefault();
        $.ajax({
            url: 'getStaffListByStationId',
            type: 'post',
            dataType: 'json',
            data: {
                stationId: $("input[name='stationId']").val()
            },
            success: function (data) {
                // console.log(data);
                let tb = document.getElementById('tb');
                let str = generateStr(data);
                // 将定义好的内容,写入到tbody标签中
                tb.innerHTML = str;
                $(".selectpicker").selectpicker("refresh");
            }
        });
    });

    $('#addSubmit').click(function (e) {
        e.preventDefault();
        let password = $("input[name='password']").val();
        let fullName = $("input[name='fullName']").val();
        let avgScore = $("input[name='avgScore']").val();
        let orderSum = $("input[name='orderSum']").val();
        let stationId = $("input[name='stationId']").val();
        let isAble = $("#isAble").val();
        $.ajax({
            url: 'insertStaff',
            type: 'post',
            dataType: 'json',
            data: {
                password: password,
                fullName: fullName,
                avgScore: avgScore,
                orderSum: orderSum,
                stationId: stationId,
                isAble: isAble
            },
            success: function (data) {
                // console.log(data);
                let tb = document.getElementById('tb');
                let str = generateStr(data);
                // 将定义好的内容,写入到tbody标签中
                tb.innerHTML = str;
                $('#myModal').modal('hide');
                $(".selectpicker").selectpicker("refresh");
            }
        });
    });
});
