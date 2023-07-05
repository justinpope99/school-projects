<?php
    //read csv file
    $file = "distance_NY_worldcapitals_partial.csv";

    //create stream out of the file
    //first make sure the file exists and it can be turn into a stream (long string)
    if (file_exists($file) && $fileStream = fopen($file,'r'))
    {
        //variable to skip the first two lines
        $reading = 1;

        //start sending select element to HTML
        print "<select id='countryList' onchange='showdistance()'>";
        print "<option value=''>Select a Capital/Country</option>";

        //loop through the fileStream
        while (($lineArray = fgetcsv($fileStream,0,',')))
        {
            if ($reading < 3) $reading ++;
            else
            {
                //send this record to HTML as an option of the select element
                //first extract the values
                $country = $lineArray[0];
                $capital = $lineArray[1];
                $miles = $lineArray[2];
                $km = $lineArray[3];

                //option value (to ensure only one flight to the server)
                $optionValue = $country.",".$capital.",".$miles.",".$km;

                //send the option to HTML
                print "<option value='".$optionValue."'>".$capital.", ".$country."</option>";
            }
        }//end of loop

        //send close select to HTML
        print "</select>";
    }
    else print "CSV file not accessible";
?>