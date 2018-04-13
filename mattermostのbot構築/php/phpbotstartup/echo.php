<?php
header("Content-Type: application/json; charset=utf-8");
 
if($_POST['token'] != "e7ox8z9yctnptq9r91oiu4gijy"){
    return;
}
 
$text   = $_POST['text'];
$query  = preg_split('/[\s\x{3000}]/u',$text,2);
$q  = $query[1];
$name   = 'echo';
 
echo json_encode(array("icon_url" => "/static/emoji/1f60a.png", "username" => $name, "text" => $q));
return;
 
?>