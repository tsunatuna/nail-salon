/** 初期表示 */
$(document).ready(function(){
  $('.kome').append('<span style="color:red">※</span>');
});

// 入力チェック
function isEmpty(param) {
  let flg = param == "" || param.length == 0 || param === undefined || param == null ? true : false
  return flg;
}

// 入力フォームエラーチェック
function errorMark($id, message) {
  // リセット
  $('#result').empty();
  $id.css('background-color','#eee');
  // エラー時
  if (isEmpty($id.val())) {
    $id.css('background-color','#ffb2c5');
    $('#result').append('<div style="color:red"><p>' + message + 'を入力してください。</p></div>');
    return true;
  } else {
    // 正常時
    return false;
  }
}
