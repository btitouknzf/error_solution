<?php
header("Content-Type: application/json; charset=utf-8");
 
if($_POST['token'] != "yzwmi3j9gjgz5ch9koh56tqbza"){
    return;
}

$calluser = $_POST['user_name'];

$name   = 'omikuji';

$omikuji = array('小吉', '大吉', '凶', '末吉');
$rand = array_rand($omikuji, 1);
$result = $omikuji[$rand];

$omikujikekka   = $calluser.'さんの今日の運勢は'.$result.'です。';

$arr = array("icon_url" => "/static/emoji/1f60a.png", "username" => $name, "text" => $omikujikekka);

echo json_encode($arr, JSON_UNESCAPED_UNICODE);
return;
 
?>