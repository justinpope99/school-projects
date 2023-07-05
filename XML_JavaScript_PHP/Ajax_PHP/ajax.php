<!DOCTYPE html>
<html>
    <head></head>
    <body>
        <?php
            //read input city
            $inputCity = $_GET["cityTxtBx"];

            /*store data in 2D array
            $citydistance[0][0]="Dublin";
            $citydistance[0][1]="3176";*/

            //or
            $citydistance = array(
                array("Dublin","3176"),
                array("Paris","2625"),
                array("London","3459"),
                array("Dhaka","6883")
            );

            //boolean variable for a match
            $found = false;

            //index of a match
            $matchIndex=-1;

            //loop through the array looking for a match
            for ($index = "0"; $index < count($citydistance); $index++)
            {
                if (strtoupper($inputCity) == strtoupper($citydistance[$index][0]) )
                {
                    $found = true;
                    $matchIndex = $index;
                    break;
                }
            }

            if ($found == true)
            {
                print "<h2>Distance from NY</h2>";

                print "The distance between NY and " . $citydistance[$matchIndex][0]. " is ". $citydistance[$matchIndex][1];
            }
            else print "Distance from NY to ".$inputCity. " is not available";


        ?>

    </body>
</html>