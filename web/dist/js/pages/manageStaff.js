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

function clickDelete(stationId) {
    console.log('click the a');
    $.ajax({
        url: 'deleteStationById',
        type: 'post',
        dataType: 'json',
        data: {
            stationId: stationId
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

$(function () {
    $.ajax({
        url: 'getStaffList',
        type: 'post',
        dataType: 'json',
        data: {},
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

    $('#refresh').click(function (e) {
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

    $('#addSubmit').click(function (e) {
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
                longitude: longitude,
                latitude: latitude,
                address: address,
                stationName: stationName,
                phone: phone,
                maxNum: maxNum
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
