$(function() {

    /**datepicker表示イベント
     * new Date()の仕様によりMonthは0~11
     */
    $('#date').pickadate({
      // 日付選択時モーダルを閉じない
      // closeOnSelect: false,
      // カレンダー期間(今日から180日後まで)
      min: true,
      max: 180,
      // TODO 営業時間マスタから取得
      disable: [
        4, // 木曜日 (1~7：日~土)
        [2018, 11, 24],
        {from: [2018, 11, 31], to: [2019, 0, 3]}
      ]
    });

    //予約時間表示イベント
    $('#time').pickatime({
      //表示間隔
      interval: 60,
      // 時間範囲
      min: [10,00],
      max: [20,00],
      // TODO 予約情報から取得
      disable :[

      ]
    })
});
