let recordList = [];
let newList = [];
let staffList = [];

function getStaffNameList() {
    let staffNameList = '';
    $.ajax({
        url: 'getStaffListByStationId',
        type: 'post',
        dataType: 'json',
        data: {
            stationId
        },
        success: function (data) {
            staffList = data;
            console.log(staffList);
            for (let j = 0; j < data.length; j++) {
                staffNameList += `<option value='` + data[j].fullName + `'>` + data[j].fullName + `</option>`;
            }
            // console.log(staffName);
        }
    });
    console.log(staffNameList);
    return staffNameList;
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
        str += `<td style="text-align: center">` + data[i]['idCard'] + `</td>`;
        str += `<td style="text-align: center">` + data[i]['fullName'] + `</td>`;
        str += `<td style="text-align: center">` + data[i]['carId'] + `</td>`;
        str += `<td style="text-align: center">` + data[i]['address'] + `</td>`;
        str += `<td style="text-align: center">` + data[i]['orderTime'] + `</td>`;
        str += `<td style="text-align: center">` + data[i]['process'] + `</td>`;
        str += `<td style="text-align: center">
                        <a class="col-2" data-toggle="modal" data-target="#R` + data[i]['orderId'] + `">
                            <i class="nav-icon far fa-edit" title="其他信息"></i>
                        </a>
                    <td>`;
        str += `<div class="modal fade" id="R` + data[i]['orderId'] + `" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog modal-lg">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h4 class="modal-title text-left">其他信息</h4>
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
                                            <label class="col-sm-2 control-label">检测时间</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" value="` + data[i]['checkTime'] + `"
                                                       name="checkTime" disabled>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-sm-2 control-label">检测结果</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" value="` + data[i]['result'] + `"
                                                       name="result" disabled>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-sm-2 control-label">检测员工号</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" value="` + data[i]['staffId'] + `"
                                                       name="staffId" disabled>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-sm-2 control-label">检测员姓名</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" value="` + data[i]['staffName'] + `"
                                                       name="staffName" disabled>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-sm-2 control-label">服务评分</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" value="` + data[i]['score'] + `"
                                                       name="score" disabled>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-sm-2 control-label">重审资格</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" value="` + data[i]['available'] + `"
                                                       name="available" disabled>
                                            </div>
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

function taskInit() {
    newList = recordList.filter(function (item) {
        return item.process === '已申请';
    });
    let temp = '';
    for (let j = 0; j < newList.length; j++) {
        temp += `<option value="` + newList[j].orderId + `">` + newList[j].orderId + `</option>`;
    }
    // console.log(newList);
    $("#selectOrderId").append($(temp));
    let staffNameList = getStaffNameList();
    $("#selectStaff").append($(staffNameList));
    $("#selectStaff").selectpicker("refresh");
    $("#selectOrderId").selectpicker("refresh");

};

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

$(function () {
    $.ajaxSettings.async = false; // ajax同步处理
    window.stepper = new Stepper($('.bs-stepper')[0]);

    $.ajax({
        url: 'getRecordList',
        type: 'post',
        dataType: 'json',
        data: {
            stationId: stationId
        },
        success: function (data) {
            recordList = data.filter(function (item) {
                return item.process === '已申请';
            });
            // console.log(recordList);
            let tb = document.getElementById('tb');
            if (recordList.length === 0) {
                tb.innerHTML = '';
                $("#noData").html("<div class=\"tips\" style=\"text-align: center;color: #333333;line-height: 40px;border-bottom: 1px solid #bce8f1;\">暂无相应数据！</div>");
                $(".tips").show();
            } else {
                $("#noData").html('');
                let str = generateStr(recordList);
                // 将定义好的内容,写入到tbody标签中
                tb.innerHTML = str;
            }
        }
    });

    taskInit();

    $('#refresh').click(function (e) {
        $.ajax({
            url: 'getRecordList',
            type: 'post',
            dataType: 'json',
            data: {
                stationId
            },
            success: function (data) {
                recordList = data.filter(function (item) {
                    return item.process === '已申请';
                });
                // console.log(recordList);
                let tb = document.getElementById('tb');
                if (recordList.length === 0) {
                    tb.innerHTML = '';
                    $("#noData").html("<div class=\"tips\" style=\"text-align: center;color: #333333;line-height: 40px;border-bottom: 1px solid #bce8f1;\">暂无相应数据！</div>");
                    $(".tips").show();
                } else {
                    $("#noData").html('');
                    let str = generateStr(recordList);
                    // 将定义好的内容,写入到tbody标签中
                    tb.innerHTML = str;
                }
            }
        });
        e.preventDefault();
    });

    $('#sub').click(function (e) {

        let carId = $("input[name='carId']").val();
        let tb = document.getElementById('tb');
        newList = recordList.filter(function (item) {
            return item.carId === carId;
        });

        if (newList.length === 0) {
            tb.innerHTML = '';
            $("#noData").html("<div class=\"tips\" style=\"text-align: center;color: #333333;line-height: 40px;border-bottom: 1px solid #bce8f1;\">暂无相应数据！</div>");
            $(".tips").show();
        } else {
            $("#noData").html('');
            let str = generateStr(newList);
            // 将定义好的内容,写入到tbody标签中
            tb.innerHTML = str;
        }
        // console.log(temp);
        // $.ajax({
        //     url: 'getRecordByCarId',
        //     type: 'post',
        //     dataType: 'json',
        //     data: {
        //         carId: temp
        //     },
        //     success: function (data) {
        //         recordList = data.filter(function (item) {
        //             return item.process === '已申请';
        //         });
        //         // console.log(recordList);
        //         let tb = document.getElementById('tb');
        //         if () {
        //             
        //             $("#noData").html("<div class=\"tips\" style=\"text-align: center;color: #333333;line-height: 40px;border-bottom: 1px solid #bce8f1;\">暂无相应数据！</div>");
        //             $(".tips").show();
        //         } else {
        //             let str = generateStr(data);
        //             // 将定义好的内容,写入到tbody标签中
        //             tb.innerHTML = str;
        //         }
        //     }
        // });
        e.preventDefault();
    });

    $("#selectOrderId").change(function () {
        let orderId = $("#selectOrderId").val();
        let obj = newList.find(item => item.orderId == orderId);
        $("#idCard").val(obj.idCard);
        $("#fullName").val(obj.fullName);
        $("#carId").val(obj.carId);
        $("#address").val(obj.address);
        $("#orderTime").val(obj.orderTime);
        $("#confirmOrderId").val(orderId);
        $("#confirmIdCard").val(obj.idCard);
        $("#confirmFullName").val(obj.fullName);
        $("#confirmCarId").val(obj.carId);
        $("#confirmAddress").val(obj.address);
        $("#confirmOrderTime").val(obj.orderTime);
    });

    $('#selectCheckTime').change(function () {
        let checkTime = $("#selectCheckTime").val();
        let mydate = (new Date()).Format("yyyy-MM-dd");
        $("#confirmCheckTime").val(mydate + ' ' + checkTime);
    });

    $('#selectStaff').change(function () {
        let staffName = $("#selectStaff").val();
        let obj = staffList.find(item => item.fullName == staffName);
        $('#confirmStaffId').val(obj.staffId);
        $('#confirmStaffName').val(staffName);
        $('#staffId').val(obj.staffId);
    });

    $('#assignForm').submit(function (event) {
        let orderId = $('#confirmOrderId').val();
        let checkTime = $('#confirmCheckTime').val();
        let staffId = $('#confirmStaffId').val();
        let staffName = $('#confirmStaffName').val();
        $.ajax({
            url: 'assignTaskByOrderId',
            type: 'post',
            dataType: 'json',
            data: {
                orderId: orderId,
                checkTime: checkTime,
                staffId: staffId,
                staffName: staffName,
                stationId: stationId
            },
            success: function (data) {
                $(".modal").modal('hide');
                $('.modal-backdrop').remove();//去掉遮罩层
                // console.log(data);
                recordList = data.filter(function (item) {
                    return item.process === '已申请';
                });
                let tb = document.getElementById('tb');
                if (recordList.length === 0) {
                    tb.innerHTML = '';
                    $("#noData").html("<div class=\"tips\" style=\"text-align: center;color: #333333;line-height: 40px;border-bottom: 1px solid #bce8f1;\">暂无相应数据！</div>");
                    $(".tips").show();
                } else {
                    $("#noData").html('');
                    let str = generateStr(recordList);
                    // 将定义好的内容,写入到tbody标签中
                    tb.innerHTML = str;
                }
            }
        });
        event.preventDefault();  // 阻止form表单的默认提交路径：action指定的路径
    });


});