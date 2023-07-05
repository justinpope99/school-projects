<!DOCTYPE html>
<html>
    <body>
        <h2>NBA Teams</h2>
        <p></p>
        <?php
        // This reads the selected question.
        $question = $_GET["question"];

        $file = "nba.csv";
        $content = file($file);

        $array = array();

        // This will copy the contents of the file into an array.
        for($i = 1; $i < count($content); $i++) {
            $line = explode(';', $content[$i]);
            for($j = 0; $j < count($line); $j++) {
                $array[$i][$j + 1] = $line[$j];
            }   
        }   

        if ($question == 1)
        {
            echo "<p>Here is all the information about all of the NBA teams.
                     This displays the team and the year they were founded.</p><br/>";

            // This will print the array.
            foreach ( $array as $var ) {
                echo $var[1], ", founded in ", $var[2], "<br/><p></p>";
            }
        }

        elseif ($question == 2)
        {
            echo "<p>Here are the five oldest NBA teams.</p><br/>";

            // This will sort the array by the year in ascending order.
            $col = array_column( $array, 2 );
            array_multisort( $col, SORT_ASC, $array );

            // This will slice the array
            $oldest5 = array_slice($array, 0, 5);

            // This will print the array.
            foreach ( $oldest5 as $var ) {
                echo $var[1], ", founded in ", $var[2], "<br/><p></p>";
            }
        }

        elseif ($question == 3)
        {
            echo "<p>Here are the five most recently founded NBA teams.</p><br/>";

            // This will sort the array by the year in descending order.
            $col = array_column( $array, 2 );
            array_multisort( $col, SORT_DESC, $array );

            // This will slice the array
            $newest5 = array_slice($array, 0, 5);

            // This will print the array.
            foreach ( $newest5 as $var ) {
                echo $var[1], ", founded in ", $var[2], "<br/><p></p>";
            }
        }

        ?>
    </body>
</html>