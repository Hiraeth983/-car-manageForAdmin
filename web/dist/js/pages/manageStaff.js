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
                    <td>`;
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
        }
    });
};

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
        },
        error: function () {

        }
    });
    $("#isAble").selectpicker("refresh");
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
            },
            error: function () {

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
            }
        });
    });
});
