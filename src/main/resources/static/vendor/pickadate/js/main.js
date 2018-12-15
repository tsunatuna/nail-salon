$(function() {

    //datepicker表示イベント
    $('#date').pickadate();

    //予約時間表示イベント
    $('#time').pickatime({
        format: 'HH:i', //24時間表記
        interval: 60,   //表示間隔
        min: [10,00],   //
        max: [20,00]
    })
});
