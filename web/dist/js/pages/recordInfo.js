let recordList = [];
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
                                    <form class="form-horizontal" role="form">
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
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
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

$(function () {
    $.ajaxSettings.async = false; // ajax同步处理
    $.ajax({
        url: 'getRecordList',
        type: 'post',
        dataType: 'json',
        data: {
            stationId: stationId.isNull ? 1 : stationId
        },
        success: function (data) {
            recordList = data;
            // console.log(recordList);
            let str = generateStr(data);
            let tb = document.getElementById('tb');
            tb.innerHTML = str;
        }
    });

    var beginTimeStore = '';
    var endTimeStore = '';
    $('#config-demo').daterangepicker({
        timePicker: true,
        timePicker24Hour: true,
        linkedCalendars: true,
        autoUpdateInput: false,
        ranges: {
            "昨天": [moment().subtract("days", 1), moment().subtract("days", 1)],
            "7天前": [moment().subtract("days", 6), moment()],
            "30天前": [moment().subtract("days", 29), moment()],
            "这个月": [moment().startOf("month"), moment().endOf("month")],
            "上个月": [moment().subtract("month", 1).startOf("month"), moment().subtract("month", 1).endOf("month")]
        },
        locale: {
            format: 'YYYY-MM-DD',
            separator: '~',
            applyLabel: '确定',
            cancelLabel: '取消',
            fromLabel: '起始时间',
            toLabel: '结束时间',
            customRangeLabel: '自定义',
            daysOfWeek: ['日', '一', '二', '三', '四', '五', '六'],
            monthNames: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月'],
        }
    }, function (start, end, label) {
        beginTimeStore = start;
        endTimeStore = end;
        console.log(this.startDate.format(this.locale.format));
        console.log(this.endDate.format(this.locale.format));
        if (!this.startDate) {
            this.element.val('');
        } else {
            this.element.val(this.startDate.format(this.locale.format) + this.locale.separator + this.endDate.format(this.locale.format));
        }
    });


    $('#history').click(function () {
        let str = generateStr(recordList);
        let tb = document.getElementById('tb');
        tb.innerHTML = str;
    });

    $('#daily').click(function () {
        let mydate = (new Date()).Format("yyyy-MM-dd");
        newList = recordList.filter(item => item.checkTime >= mydate);
        let str = generateStr(newList);
        let tb = document.getElementById('tb');
        tb.innerHTML = str;
    });

    $('#sub').click(function (e) {
        e.preventDefault();
        let range = $('#config-demo').val();
        let arr = range.split('~');
        newList = recordList.filter(item => item.checkTime >= arr[0] && item.checkTime <= arr[1]);
        console.log(arr);
        console.log(newList);
        let str = generateStr(newList);
        let tb = document.getElementById('tb');
        tb.innerHTML = str;
    })

});