jQuery.extend( jQuery.fn.pickadate.defaults, {
  // フォーマット設定
  monthsFull: ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月'],
  monthsShort: ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月'],
  weekdaysFull: ['日曜日', '月曜日', '火曜日', '水曜日', '木曜日', '金曜日', '土曜日'],
  weekdaysShort: ['日', '月', '火', '水', '木', '金', '土'],
  format: 'yyyy年mm月dd日',
  formatSubmit: 'yyyy/mm/dd',
  showMonthsShort: false,
  // ボタン設定
  today: '今日',
  clear: 'クリア',
  close: '閉じる'
});

jQuery.extend( jQuery.fn.pickatime.defaults, {
  // フォーマット設定
  format: 'HH:i', //24時間表記
  // ボタン設定
  clear: 'クリア'
});
