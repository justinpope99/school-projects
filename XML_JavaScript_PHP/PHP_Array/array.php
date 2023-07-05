<!DOCTYPE html>
<html>
    <body>
        <?php
            $cityIn = $_POST["cityTxtBx"];
            $cities = array(
                array("Dublin", "3176"),
                array("Paris", "3625"),
                array("London", "3459"),
                array("Dhaka", "6883")
            );

            $citiesSize = count($cities);

            $found = false;

            for($index=0; $index<$citiesSize;$index++)
            {
                if ($cityIn == $cities[$index][0])
                {
                    $found = true;
                    $miles = $cities[$index][1];
                    break;
                }
            }
            
            if ($found == true) print "The city ".$cityIn." is located ".$miles." miles away from NY.";
            else print "No city found";
        ?>
    </body>
</html>