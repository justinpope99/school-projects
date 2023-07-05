<?php
    function get($key, $defaultValue) {
                $value = isset($_GET[$key]) ?  $_GET[$key] : $defaultValue;
                return $value;
    }
?>