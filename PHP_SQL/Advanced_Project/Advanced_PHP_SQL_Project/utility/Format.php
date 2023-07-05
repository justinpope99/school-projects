<?php
function money ($number) {
    return number_format((float)$number, 2, '.', ',');
}

?>