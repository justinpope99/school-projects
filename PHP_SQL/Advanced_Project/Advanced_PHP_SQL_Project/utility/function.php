<?php
function get($key, $defaultValue)
{
  $value = isset($_GET[$key]) ? $_GET[$key] : $defaultValue;
  return $value;
}

function getData($dictonary, $key, $defaultValue)
{
  $value = isset($dictonary[$key]) ? $dictonary[$key] : $defaultValue;
  return $value;
}

function qpa($data)
{
  $number = (float) $data;
  $format = number_format($number, 2, '.', ',');
  return $format;
}

function fmoney($data)
{
  $number = (float) $data;
  $format = number_format($number, 2, '.', ',');
  return $format;
}

function money_in_billions($data)
{
  $number = (float) $data / 1_000_000_000;
  $format = number_format($number, 5, '.', ',');
  return $format;
}

function sumSalary($input) {
  
  $total = 0;
  foreach ($input as $value) {
    $total += $value["salary"];
  }

  return $total;
}

function avgSalary($input) {
  
  $average = 0;
  $total = 0;
  $count = 0;
  foreach ($input as $value) {
    $total += $value["salary"];
    $count++;
  }
  $average = $total / $count;

  return $average;
}

function minSalary($input) {
    
  $minArray = array();
  foreach($input as $value){
    $minArray[] = $value["salary"];
  }
  
  return min($minArray);
}

function maxSalary($input) {
    
  $maxArray = array();
  foreach($input as $value){
    $maxArray[] = $value["salary"];
  }
  
  return max($maxArray);
}

?>