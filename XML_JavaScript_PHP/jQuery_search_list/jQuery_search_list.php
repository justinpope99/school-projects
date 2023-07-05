<?php
    //read passing variable: input search , read the key
    $searchTxt = $_GET["searchKey"];

    //read file data.json
    $file = "data.json";

    //create a stream of string from the json file
    $jsonStream = file_get_contents($file);

    //turn the stream into an array
    $jsonArray = json_decode($jsonStream,true);

    //true: returns an array
    //false: returns an object

    //print the city of the first record
    //print "City of second record: ".$jsonArray[1]["name"];

    //start sending select element to HTML
    print "<select id='nameList' size='10' onchange='showcityinfo()'>";

    //loop through the json array and send the city names as option to the select element
    for($i = 0; $i < count($jsonArray); $i++)
    {
        if ($searchTxt != "")
        {
            if(substr(strtolower($jsonArray[$i]['name']),0,strlen($searchTxt)) == strtolower($searchTxt))
            {
                //extract the fields of concern
                $name = $jsonArray[$i]["name"];
                $state = $jsonArray[$i]["usps"];
                $pop2022 = $jsonArray[$i]["pop2022"];

                $optionValue = $name.",".$state.",".$pop2022;

                //send select option to HTML
                print "<option value='".$optionValue."'>".$name."</option>"; 
            }
        }
        else
        {
            //extract the fields of concern
            $name = $jsonArray[$i]["name"];
            $state = $jsonArray[$i]["usps"];
            $pop2022 = $jsonArray[$i]["pop2022"];

            $optionValue = $name.",".$state.",".$pop2022;

            //send select option to HTML
            print "<option value='".$optionValue."'>".$name."</option>"; 
        }
        
    }//end of loop

    //send close of select to HTML
    print "</select>";
?>