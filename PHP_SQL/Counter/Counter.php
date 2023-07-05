<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>02 While Loop With CSS</title>
    <link rel="stylesheet" href="counter.css">

    <script>
        function selectElement(id, value) {
            let element = document.getElementById(id);
            element.value = value;
        }

    </script>
</head>
<body>

    <?php include 'function.php';?>

    <?php
        $countTo = get("end", 10);
        $highLight = get("highLight", "n");
        $startWith = get("startWith", 10);
        $incrementBy = get("incrementBy", 3);
    ?>

    <form>
        <label> Start with: </label> <input class="data-entry" name="startWith" type="text" value = "<?= $startWith ?>"/>
        <label> Count to: </label>   <input class="data-entry" name="end" type="text" value = "<?= $countTo ?>"/>
        <label> Highlight: </label>
        <select name="highLight" id="highLight">
            <option value="n">None</option>
            <option value="e">Even</option>
            <option value="o">Odd</option>
            <option value="m4">Multiple of 4</option>
            <option value="m5">Multiple of 5</option>
            <option value="m6">Multiple of 6</option>
            <option value="m7">Multiple of 7</option>
            <option value="m8">Multiple of 8</option>
            <option value="m9">Multiple of 9</option>
            <option value="m10">Multiple of 10</option>
            <option value="c9">Contains a 9</option>
        </select>



        <label>Increment by: </label>
        <input class="data-entry" name="incrementBy" type="text" value = "<?= $incrementBy ?>"/>

        <input type="submit" value="count" />
    </form>


    <h1> Developer: Pope, Justin, Count to: <?= $countTo ?> </h1>
    
    <div id="screen-display">
    <?php
        $x = $startWith;



        while($x <= $countTo) {

            $select = "";

            if ($highLight == "e" && $x % 2 == 0) {
                $select = "highLight";
            }
            elseif ($highLight == "o" && $x % 2 != 0) {
                $select = "highLight";
            }
            elseif ($highLight == "m4" && $x % 4 == 0) {
                $select = "highLight";
            }
            elseif ($highLight == "m5" && $x % 5 == 0) {
                $select = "highLight";
            }
            elseif ($highLight == "m6" && $x % 6 == 0) {
                $select = "highLight";
            }
            elseif ($highLight == "m7" && $x % 7 == 0) {
                $select = "highLight";
            }
            elseif ($highLight == "m8" && $x % 8 == 0) {
                $select = "highLight";
            }
            elseif ($highLight == "m9" && $x % 9 == 0) {
                $select = "highLight";
            }
            elseif ($highLight == "m10" && $x % 10 == 0) {
                $select = "highLight";
            }
            elseif ($highLight == "c9" && str_contains($x, '9') ) {
                $select = "highLight";
            }
            echo "<div class='n123 $select'> $x </div>";
            $x = $x + $incrementBy;
        }
    ?>
    </div>

    <script>
        selectElement("highLight", "<?= $highLight ?>");
    </script>

</body>
</html>