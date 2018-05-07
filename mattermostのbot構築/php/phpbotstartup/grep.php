<?php
header("Content-Type: application/json; charset=utf-8");
 
//if($_POST['token'] != "e7ox8z9yctnptq9r91oiu4gijy"){
//    return;
//}

//引数を受け取る
$text   = $_POST['text'];
$query  = preg_split('/[\s\x{3000}]/u',$text,0);
$count = count($query);



$grepkey = $query[1];

//if ($count == 1){
//$errstr = '引数を入力してください。';
//echo json_encode(array("icon_url" => "/static/emoji/1f60a.png", "username" => $name, "text" => 'aa'));
//return;
//}

//for ($i = 1; $i < count($list); $i++ ) {
//    $grepkey = array_merge($grepkey,$query[i]);
//}

$name   = "echo";

$str = implode(',',$query);


$cmd = 'cd';
$result = exec($cmd);


echo json_encode(array("icon_url" => "/static/emoji/1f60a.png", "username" => $name, "text" => $str ));
return;
 
?>