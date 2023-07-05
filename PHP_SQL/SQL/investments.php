<?php

include "./utility/DBUtility.php";

$sql = new DBUtility();
$sqlstatement = "select * from investments limit 20";
$data = $sql->execute($sqlstatement);
print_r($data);

?>