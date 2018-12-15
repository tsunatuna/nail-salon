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
  $(confirm_modal).on('show.bs.modal', function () {
    let date = $date.val();
    let time = $time.val();

    $(this).find('.modal_param_date').text(date);
    $(this).find('.modal_param_time').text(time);
  });
});

$('.modal_submit').on('click', function () {
  $('#form_submit').submit();
});
