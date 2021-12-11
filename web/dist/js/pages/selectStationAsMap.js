var map = new AMap.Map("container", {resizeEnable: true});
var infoWindow = new AMap.InfoWindow({offset: new AMap.Pixel(0, -5)});

$.ajax({
    url: 'getStationList',
    type: 'post',
    dataType: 'json',
    contentType: "application/json; charset=utf-8",
    data: {},
    success: function (data) {
        // console.log(myData);
        for (let i = 0, l = data.length; i < l; i++) {
            var marker = new AMap.Marker({
                position: [data[i].longitude, data[i].latitude],
                map: map
            });
            marker.content = '<h3>' + data[i].stationName + '</h3>';
            marker.content += '<div>经度：' + data[i].longitude + '</div>';
            marker.content += '<div>纬度：' + data[i].latitude + '</div>';
            marker.content += '<div><button class="btn btn-success btn-xs">历史轨迹</button>';
            marker.content += '&nbsp;<button class="btn btn-warning btn-xs"><a href="stationData-query?detection_id="' + data[i].stationId + 'target="_blank" />实时跟踪&nbsp;</button>';
            marker.content += '&nbsp;<button class="btn btn-danger btn-xs">设置</button></div>';
            // console.log('success');
            marker.on('mouseover', infoOpen);
            //注释后打开地图时默认关闭信息窗体
            //marker.emit('mouseover', {target: marker});
            marker.on('mouseout', infoClose);
            marker.on('click', newMAp);
        }
    }
});

//鼠标点击事件,设置地图中心点及放大显示级别
function newMAp(e) {
    //map.setCenter(e.target.getPosition());
    map.setZoomAndCenter(15, e.target.getPosition());

    var infoWindow = new AMap.InfoWindow({offset: new AMap.Pixel(0, -30)});
    infoWindow.setContent(e.target.content);
    infoWindow.open(map, e.target.getPosition());
}


function infoClose(e) {
    infoWindow.close(map, e.target.getPosition());
}

function infoOpen(e) {
    infoWindow.setContent(e.target.content);
    infoWindow.open(map, e.target.getPosition());
}

map.setFitView();