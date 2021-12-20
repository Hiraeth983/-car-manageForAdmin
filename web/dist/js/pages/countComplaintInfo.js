let date = [];
let complaintNum = [];
let staffData = [];
$(function () {
    $.ajax({
        url: 'countComplaintNumByDate',
        type: 'post',
        dataType: 'json',
        data: {
            stationId: stationId
        },
        success: function (data) {
            data.data.forEach(item => {
                date.push(item.date);
                complaintNum.push(item.count);
            });
            // 基于准备好的dom，初始化echarts实例
            var chartDom = document.getElementById('chart');
            var myChart = echarts.init(chartDom);
            var option;
            option = {
                title: {
                    text: '近一周投诉数量变化',
                    subtext: '模拟数据'
                },
                tooltip: {
                    trigger: 'axis',
                    axisPointer: {
                        type: 'shadow'
                    }
                },
                grid: {
                    left: '3%',
                    right: '4%',
                    bottom: '3%',
                    containLabel: true
                },
                xAxis: [
                    {
                        type: 'category',
                        data: date,
                        axisTick: {
                            alignWithLabel: true
                        }
                    }
                ],
                yAxis: [
                    {
                        type: 'value'
                    }
                ],
                series: [
                    {
                        name: '投诉数量',
                        type: 'bar',
                        barWidth: '60%',
                        data: complaintNum
                    }
                ]
            };

            option && myChart.setOption(option);
        }
    });
    $.ajax({
        url: 'countComplaintNumByStaffName',
        type: 'post',
        dataType: 'json',
        data: {
            stationId: stationId
        },
        success: function (data) {
            staffData = data.data;

            // 基于准备好的dom，初始化echarts实例
            var chartDom1 = document.getElementById('chart2');
            var myChart1 = echarts.init(chartDom1);
            var option1;
            option1 = {
                title: {
                    text: '投诉员工统计',
                    subtext: '模拟数据',
                    left: 'center'
                },
                tooltip: {
                    trigger: 'item'
                },
                legend: {
                    orient: 'vertical',
                    left: 'left'
                },
                series: [
                    {
                        name: '投诉数量',
                        type: 'pie',
                        radius: '50%',
                        data: staffData,
                        emphasis: {
                            itemStyle: {
                                shadowBlur: 10,
                                shadowOffsetX: 0,
                                shadowColor: 'rgba(0, 0, 0, 0.5)'
                            }
                        }
                    }
                ]
            };

            option1 && myChart1.setOption(option1);
        }
    });
});