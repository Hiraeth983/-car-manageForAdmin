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
        str += `<td style="text-align: center">` + data[i]['stationId'] + `</td>`;
        str += `<td style="text-align: center">` + data[i]['longitude'] + `</td>`;
        str += `<td style="text-align: center">` + data[i]['latitude'] + `</td>`;
        str += `<td style="text-align: center">` + data[i]['stationName'] + `</td>`;
        str += `<td style="text-align: center">` + data[i]['address'] + `</td>`;
        str += `<td style="text-align: center">` + data[i]['phone'] + `</td>`;
        str += `<td style="text-align: center">` + data[i]['maxNum'] + `</td>`;
        str += `<td style="text-align: center">` + data[i]['currentNum'] + `</td>`;
        str += `<td style="text-align: center">
                        <a class="col-2" href="javascript:void(0);" onclick="clickDelete(` + data[i]['stationId'] + `)" id="delete">
                            <i class="nav-icon far fa-trash-alt" title="删除"></i>
                        </a>
                        <a class="col-2" data-toggle="modal" data-target="#S` + data[i]['stationId'] + `">
                            <i class="nav-icon far fa-edit" title="修改"></i>
                        </a>
                    <td>`;
        str += `<div class="modal fade" id="S` + data[i]['stationId'] + `" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
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
                                            <label class="col-sm-2 control-label">站点编号</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" value="` + data[i]['stationId'] + `"
                                                       placeholder="请输入站点编号" name="stationId" disabled>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-sm-2 control-label">站点经度</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" value="` + data[i]['longitude'] + `"
                                                       placeholder="请输入站点经度" name="longitude" disabled>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-sm-2 control-label">站点纬度</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" value="` + data[i]['latitude'] + `"
                                                       placeholder="请输入站点纬度" name="latitude" disabled>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-sm-2 control-label">站点地址</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" value="` + data[i]['address'] + `"
                                                       placeholder="请输入站点地址" name="address">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-sm-2 control-label">站点名称</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" value="` + data[i]['stationName'] + `"
                                                       placeholder="请输入站点名称" name="stationName">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-sm-2 control-label">联系电话</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" value="` + data[i]['phone'] + `"
                                                       placeholder="请输入联系电话" name="phone">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-sm-2 control-label">每日最大容纳量</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" value="` + data[i]['maxNum'] + `"
                                                       placeholder="请输入每日最大容纳量" name="maxNum">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-sm-2 control-label">今日剩余容量</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" value="` + data[i]['currentNum'] + `"
                                                       placeholder="请输入今日剩余容量" name="currentNum">
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
            if(data === '暂无数据'){
                tb.innerHTML = '';
                $("#noData").html("<div class=\"tips\" style=\"text-align: center;color: #333333;line-height: 40px;border-bottom: 1px solid #bce8f1;\">暂无相应数据！</div>");
                $(".tips").show();
            }else{
                $("#noData").html('');
                let str = generateStr(data);
                // 将定义好的内容,写入到tbody标签中
                tb.innerHTML = str;
            }

        },
        error: function () {

        }
    });
};

function check(obj) {
    // console.log(obj);
    $.ajax({
        url: 'updateStationById',
        type: 'post',
        dataType: 'json',
        data: {
            stationId: obj.stationId.value,
            longitude: obj.longitude.value,
            latitude: obj.latitude.value,
            address: obj.address.value,
            stationName: obj.stationName.value,
            phone: obj.phone.value,
            maxNum: obj.maxNum.value,
            currentNum: obj.currentNum.value
        },
        success: function (data) {
            $(".modal").modal('hide');
            $('.modal-backdrop').remove();//去掉遮罩层
            // console.log(data);
            let tb = document.getElementById('tb');
            if(data === '暂无数据'){
                tb.innerHTML = '';
                $("#noData").html("<div class=\"tips\" style=\"text-align: center;color: #333333;line-height: 40px;border-bottom: 1px solid #bce8f1;\">暂无相应数据！</div>");
                $(".tips").show();
            }else{
                $("#noData").html('');
                let str = generateStr(data);
                // 将定义好的内容,写入到tbody标签中
                tb.innerHTML = str;
                // console.log($('.modal'));
            }

        }
    });
    // console.log(obj.phone.value);
    return false;
}

$(function () {
    // $.ajax({
    //     url: `https://restapi.amap.com/v3/geocode/geo?address=北京市朝阳区阜通东大街6号&key=7ee9d0394759c4e62058cdf53813b151&s=rsv3`,
    //     type: 'get',
    //     success: res => {
    //         console.log(res, '得到经纬度');
    //     }
    // })
    $.ajax({
        url: 'getStationList',
        type: 'post',
        dataType: 'json',
        contentType: "application/json; charset=utf-8",
        data: {},
        success: function (data) {
            // console.log(data);
            let tb = document.getElementById('tb');
            if(data === '暂无数据'){
                tb.innerHTML = '';
                $("#noData").html("<div class=\"tips\" style=\"text-align: center;color: #333333;line-height: 40px;border-bottom: 1px solid #bce8f1;\">暂无相应数据！</div>");
                $(".tips").show();
            }else{
                $("#noData").html('');
                let str = generateStr(data);
                // 将定义好的内容,写入到tbody标签中
                tb.innerHTML = str;
            }

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
                if(data === '暂无数据'){
                    tb.innerHTML = '';
                    $("#noData").html("<div class=\"tips\" style=\"text-align: center;color: #333333;line-height: 40px;border-bottom: 1px solid #bce8f1;\">暂无相应数据！</div>");
                    $(".tips").show();
                }else{
                    $("#noData").html('');
                    let str = generateStr(data);
                    // 将定义好的内容,写入到tbody标签中
                    tb.innerHTML = str;
                }

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
                if(data === '暂无数据'){
                    tb.innerHTML = '';
                    $("#noData").html("<div class=\"tips\" style=\"text-align: center;color: #333333;line-height: 40px;border-bottom: 1px solid #bce8f1;\">暂无相应数据！</div>");
                    $(".tips").show();
                }else{
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
        let longitude = $("input[name='longitude']").val();
        let latitude = $("input[name='latitude']").val();
        let address = $("input[name='address']").val();
        let stationName = $("input[name='stationName']").val();
        let phone = $("input[name='phone']").val();
        let maxNum = $("input[name='maxNum']").val();
        let currentNum = $("input[name='currentNum']").val();
        $.ajax({
            url: 'insertStation',
            type: 'post',
            dataType: 'json',
            data: {
                longitude: longitude,
                latitude: latitude,
                address: address,
                stationName: stationName,
                phone: phone,
                maxNum: maxNum,
                currentNum: currentNum
            },
            success: function (data) {
                // console.log(data);
                let tb = document.getElementById('tb');
                if(data === '暂无数据'){
                    tb.innerHTML = '';
                    $("#noData").html("<div class=\"tips\" style=\"text-align: center;color: #333333;line-height: 40px;border-bottom: 1px solid #bce8f1;\">暂无相应数据！</div>");
                    $(".tips").show();
                }else{
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
