<?php

function getDataFromFile($fileName) {

    $myfile = fopen($fileName, "r") or die("Unable to open file!");
    // Output one line until end-of-file
    $rows = [];
    while(!feof($myfile)) {
        $row = fgets($myfile) ;
        $columns = explode(",",$row);
        $rows[] = $columns;
    }

    fclose($myfile);
    return $rows;
}


function insertData($rows) {
    $servername = "localhost";  $username = "root";
    $password = "";     $dbname = "finance";
    $conn = new mysqli($servername, $username, $password, $dbname);
    if ($conn->connect_error) {
        die("Connection failed: " . $conn->connect_error);
    }

    $count = 0; $i = 0;
    foreach ($rows as $value) {

        if ($i == 0){
            $i ++;
            continue;
        }

        $id = $value[0];    $companyId = $value[1];     $symbol = $value[2];    $issuerName = $value[3];
        $cl = $value[4];    $cusip = $value[5]; $sharesValue = (float)$value[6];    $percentage = $value[7];
        $shares = (float)$value[8];

        $sql = " INSERT INTO investments (id, companyId, symbol, issuerName, cl, cusip, sharesValue, percentage,shares) "
        . "VALUES ('$id', '$companyId', '$symbol', '$issuerName', '$cl', '$cusip', $sharesValue, $percentage, $shares)";

        if ($conn->multi_query($sql) === TRUE) {
            $count ++;
        } else {
            echo "Error: " . $sql . "<br>" . $conn->error;
            break;
        }
    }
    $conn->close();

    return $count;
}

$x = getDataFromFile("T007.csv");
$count = insertData($x);
echo "Inserted data $count";

?>