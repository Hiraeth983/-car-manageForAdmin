let dom = document.getElementById("chart");
let myChart = echarts.init(dom);
let app = {};
let arr = [];
let option;
let date = ['date'];
let apply = ['apply'];
let assign = ['assign'];
let complete = ['complete'];


$(function () {
    $.ajax({
        url: 'getDetectionInfo',
        type: 'post',
        dataType: 'json',
        data: {
            stationId: stationId
        },
        success: function (data) {
            $('#dailyTotal').text(data.dailyTotal);
            $('#dailyException').text(data.dailyException);
            $('#historyTotal').text(data.historyTotal);
            $('#historyException').text(data.historyException);
            arr = data.data;
            console.log(arr);
            arr.forEach((item, index) => {
                //执行代码

                date.push(item.date);
                apply.push(item.apply);
                assign.push(item.assign);
                complete.push(item.complete);
            });
            option = {
                legend: {},
                title: {
                    text: '本周车辆检测情况统计',
                    subtext: '模拟数据',
                    left: 'left'
                },
                tooltip: {
                    trigger: 'axis',
                    showContent: false
                },
                dataset: {
                    source: [
                        date, apply, assign, complete
                    ]
                },
                xAxis: {type: 'category'},
                yAxis: {gridIndex: 0},
                grid: {top: '55%'},
                series: [
                    {type: 'line', smooth: true, seriesLayoutBy: 'row', emphasis: {focus: 'series'}},
                    {type: 'line', smooth: true, seriesLayoutBy: 'row', emphasis: {focus: 'series'}},
                    {type: 'line', smooth: true, seriesLayoutBy: 'row', emphasis: {focus: 'series'}},
                    {
                        type: 'pie',
                        id: 'pie',
                        radius: '30%',
                        center: ['50%', '25%'],
                        emphasis: {focus: 'self'},
                        label: {
                            formatter: '{b}: {@' + date[1] + '} ({d}%)'
                        },
                        encode: {
                            itemName: 'date',
                            value: date[1],
                            tooltip: date[1]
                        }
                    }
                ]
            };

            myChart.on('updateAxisPointer', function (event) {
                var xAxisInfo = event.axesInfo[0];
                if (xAxisInfo) {
                    var dimension = xAxisInfo.value + 1;
                    myChart.setOption({
                        series: {
                            id: 'pie',
                            label: {
                                formatter: '{b}: {@[' + dimension + ']} ({d}%)'
                            },
                            encode: {
                                value: dimension,
                                tooltip: dimension
                            }
                        }
                    });
                }
            });

            myChart.setOption(option);

            if (option && typeof option === 'object') {
                myChart.setOption(option);
            }
        }
    });
});

