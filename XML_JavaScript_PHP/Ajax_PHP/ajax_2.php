<?php
    //get the passing variable: inputCity through the key
    //store it in a variable
    $passCity = $_GET["cityKey"];

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
                if (strtoupper($passCity) == strtoupper($citydistance[$index][0]) )
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
            else print "Distance from NY to ".$passCity. " is not available";


?>