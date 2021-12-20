let complaintList = [];
let newList = [];

// 生成模板
function generateStr(data) {
    // 定义变量,存储生成的字符串内容,使用 += 拼接字符串形式
    let str = '';

    for (let i = 0; i <= data.length - 1; i++) {
        // 外层循环生成tr标签,循环几次,就生成几个tr标签
        // 因为tr标签中还要有td内容,要将两个tr标签,分开,写成拼接的形式
        str += '<tr>';

        str += `<td style="text-align: center">` + data[i]['orderId'] + `</td>`;
        str += `<td style="text-align: center">` + data[i]['submitTime'] + `</td>`;
        str += `<td style="text-align: center">` + data[i]['staffId'] + `</td>`;
        if (data[i]['result'] === '') {
            str += `<td style="text-align: center">` + '未人工审批' + `</td>`;
        } else {
            str += `<td style="text-align: center">` + '已人工审批' + `</td>`;
        }
        let temp = data[i]['result'] === '' ? '请输入您的意见...' : data[i]['result'];
        str += `<td style="text-align: center">
                        
                        <a class="btn btn-info btn-sm" data-toggle="modal" data-target="#R` + data[i]['orderId'] + `">
                              <i class="fas fa-folder" style="margin-right: 5px;"></i>详情
                        </a>
                    <td>`;
        str += `<div class="modal fade" id="R` + data[i]['orderId'] + `" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog modal-lg">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h4 class="modal-title text-left">详细信息</h4>
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                        &times;
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <form class="form-horizontal" role="form" onsubmit="return check(this)">
                                        <div class="form-group row">
                                            <label class="col-sm-2 control-label">单号</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" value="` + data[i]['orderId'] + `"
                                                       name="orderId" disabled>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-sm-2 control-label">描述</label>
                                            <div class="col-sm-10">
                                                <textarea class="form-control" name="complaintDescribe" disabled>` + data[i]['complaintDescribe'] + `</textarea>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-sm-2 control-label">意见</label>
                                            <div class="col-sm-10">
                                                <textarea class="form-control" name="result">` + temp + `</textarea>
                                            </div>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
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

function check(obj) {
    // console.log(obj);
    $.ajax({
        url: 'examineComplaint',
        type: 'post',
        dataType: 'json',
        data: {
            orderId: obj.orderId.value,
            result: obj.result.value,
            stationId: stationId
        },
        success: function (data) {
            $(".modal").modal('hide');
            $('.modal-backdrop').remove();//去掉遮罩层
            complaintList = data;
            // console.log(data);
            let tb = document.getElementById('tb');
            if(data === '暂无数据'){
                tb.innerHTML = '';
                $("#tb").parent().parent().html("<div class=\"tips\" style=\"text-align: center;color: #333333;line-height: 40px;border-bottom: 1px solid #bce8f1;\">暂无相应数据！</div>");
                $(".tips").show();
            }else{
                $("#noData").html('');
                let str = generateStr(data);
                // 将定义好的内容,写入到tbody标签中
                tb.innerHTML = str;
            }
        }
    });
    // console.log(obj.phone.value);
    return false;
}

$(function () {
    $.ajaxSettings.async = false; // ajax同步处理
    $.ajax({
        url: 'getComplaintListByStationId',
        type: 'post',
        dataType: 'json',
        data: {
            stationId: stationId
        },
        success: function (data) {
            complaintList = data;
            // console.log(recordList);
            let tb = document.getElementById('tb');
            if(data === '暂无数据'){
                tb.innerHTML = '';
                $("#tb").parent().parent().html("<div class=\"tips\" style=\"text-align: center;color: #333333;line-height: 40px;border-bottom: 1px solid #bce8f1;\">暂无相应数据！</div>");
                $(".tips").show();
            }else{
                $("#noData").html('');
                let str = generateStr(data);
                // 将定义好的内容,写入到tbody标签中
                tb.innerHTML = str;
            }
        }
    });

    $('#refresh').click(function (){
        $.ajax({
            url: 'getComplaintListByStationId',
            type: 'post',
            dataType: 'json',
            data: {
                stationId: stationId
            },
            success: function (data) {
                complaintList = data;
                // console.log(recordList);
                let tb = document.getElementById('tb');
                if(data === '暂无数据'){
                    tb.innerHTML = '';
                    $("#tb").parent().parent().html("<div class=\"tips\" style=\"text-align: center;color: #333333;line-height: 40px;border-bottom: 1px solid #bce8f1;\">暂无相应数据！</div>");
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

});