let applicationList = [];
let newList = [];

Date.prototype.Format = function (fmt) {
    var o = {
        "M+": this.getMonth() + 1, // 月份
        "d+": this.getDate(), // 日
        "h+": this.getHours(), // 小时
        "m+": this.getMinutes(), // 分
        "s+": this.getSeconds(), // 秒
        "q+": Math.floor((this.getMonth() + 3) / 3), // 季度
        "S": this.getMilliseconds() // 毫秒
    };
    if (/(y+)/.test(fmt))
        fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
};

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
        str += `<td style="text-align: center">` + data[i]['oStaffId'] + `</td>`;
        str += `<td style="text-align: center">` + data[i]['oStaffName'] + `</td>`;
        str += `<td style="text-align: center">` + data[i]['nStaffId'] + `</td>`;
        str += `<td style="text-align: center">` + data[i]['nStaffName'] + `</td>`;
        str += `<td style="text-align: center">` + data[i]['state'] + `</td>`;
        str += `<td style="text-align: center">
                        
                        <a class="btn btn-primary btn-sm" data-toggle="modal" data-target="#R` + data[i]['orderId'] + `">
                              <i class="fas fa-folder" style="margin-right: 5px;"></i>原因
                        </a>
                    <td>`;
        str += `<div class="modal fade" id="R` + data[i]['orderId'] + `" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog modal-lg">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h4 class="modal-title text-left">申请原因</h4>
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                        &times;
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <div class="callout callout-info">
                                        <p id="reason">` + data[i]['reason'] + `</p>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                </div>
                            </div>
                        </div>
                    </div>`;
        str += '</tr>';
    }
    return str;
};

function examineInit() {
    newList = applicationList.filter(function (item) {
        return item.state === '已申请';
    });
    let temp = '';
    for (let j = 0; j < newList.length; j++) {
        temp += `<option value="` + newList[j].orderId + `">` + newList[j].orderId + `</option>`;
    }
    // console.log(newList);
    $("#selectOrderId").append($(temp));
    $("#selectOrderId").selectpicker("refresh");

};

$(function () {
    $.ajaxSettings.async = false; // ajax同步处理
    window.stepper = new Stepper($('.bs-stepper')[0]);
    $.ajax({
        url: 'getApplicationListByStationId',
        type: 'post',
        dataType: 'json',
        data: {
            stationId: stationId
        },
        success: function (data) {
            applicationList = data;
            // console.log(recordList);
            let str = generateStr(data);
            let tb = document.getElementById('tb');
            tb.innerHTML = str;
        }
    });

    examineInit();

    $('#myToggle').hide();
    //name值和input标签的name值一样
    $("[name='switch']").bootstrapSwitch({
        onText: "同意",      // 设置ON文本
        offText: "不同意",    // 设置OFF文本
        onColor: "success",// 设置ON文本颜色(info/success/warning/danger/primary)
        offColor: "warning",  // 设置OFF文本颜色 (info/success/warning/danger/primary)
        size: "normal",    // 设置控件大小,从小到大  (mini/small/normal/large)
        // 当开关状态改变时触发
        onSwitchChange: function (event, state) {
            if (state == true) {
                $('#myToggle').toggle();
                $("#confirmState").val("已同意");
            } else {
                $('#myToggle').toggle();
                $("#confirmState").val("已拒绝");
            }
        }
    });

    $("#selectOrderId").change(function () {
        let orderId = $("#selectOrderId").val();
        let obj = newList.find(item => item.orderId == orderId);
        $("#confirmOrderId").val(orderId);
        $("#submitTime").val(obj.submitTime);
        $("#oStaffName").val(obj.oStaffName);
        $("#nStaffName").val(obj.nStaffName);
        $("#reason").val(obj.reason);
        $("#confirmOStaffName").val(obj.oStaffName);
        $("#confirmNStaffName").val(obj.nStaffName);
        $("#confirmSubmitTime").val(obj.submitTime);
        $("#confirmReason").val(obj.reason);
    });

    $('#examineForm').click(function () {
        $.ajax({
            url: 'examineApplication',
            type: 'post',
            dataType: 'json',
            data: {
                orderId: $("#confirmOrderId").val(),
                state: $("#confirmState").val(),
                stationId: stationId
            },
            success: function (data) {
                $(".modal").modal('hide');
                $('.modal-backdrop').remove();//去掉遮罩层
                applicationList = data;
                console.log(data);
                let str = generateStr(data);
                let tb = document.getElementById('tb');
                tb.innerHTML = str;
            }
        });
    })
});