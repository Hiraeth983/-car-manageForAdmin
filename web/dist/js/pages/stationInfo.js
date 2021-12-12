$(function(){
    // console.log(stationId);

    $.ajax({
        url: 'getStationById',
        type: 'post',
        dataType: 'json',
        data: {
            stationId:stationId
        },
        success: function (data) {
            document.getElementById("stationName").innerText = data[0].stationName;
            document.getElementById("stationId").innerText = data[0].stationId;
            document.getElementById("maxNum").innerText = data[0].maxNum;
            document.getElementById("currentNum").innerText = data[0].currentNum;
            $('#latitude').val(data[0].latitude);
            $('#longitude').val(data[0].longitude);
            $('#address').val(data[0].address);
            $('#phone').val(data[0].phone);
            $('#maxNumForInput').val(data[0].maxNum);
        }
    });
})