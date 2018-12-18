/** 初期表示 */
$(document).ready(function() {

});

//予約日
const $date = $('#date');
//予約時間
const $time = $('#time');

// 予約ボタン押下
$('.btn_reserve').on('click', function(){
  // 入力チェック
  if (errorMark($date, "予約日") || errorMark($time, "予約時間")) {
    return false;
  }

  // 確認ダイアログ表示
  $('#confirm_modal').on('show.bs.modal', function () {
    let time = $date.val();
    let reservedTime = $time.val();

    $(this).find('.modal_param_date').text($date.val());
    $(this).find('.modal_param_time').text($time.val());
  });
});

$('.modal_submit').on('click', function () {
  $time.val($time.val() + ":00");
  $('#form_submit').submit();
  $('#confirm_modal').modal('hide');
  // TODO ローディング処理
});
