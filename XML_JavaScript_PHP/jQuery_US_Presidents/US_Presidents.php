<?php
    //reading csv file
    $file = "us_presidents.csv";

    //ensure file exists and a stream can be made out of it
    if (file_exists($file) && $fileStream = fopen($file,"r"))
    {
        //skip the first record (header line)
        $firstReading = true;

        //start sending beginning of unordered list element
        print "<ul id='nameList' style='list-sytle:none;'>";
        
        //loop through the stream creating an array
        while (($recordArray = fgetcsv($fileStream,0,",")))
        {
            if ($firstReading == true) $firstReading = false;
            else
            {
                //extract the concerned values (name,party,photo)
                $pname = $recordArray[0];
                $party = $recordArray[5];
                $photo = $recordArray[11];

                $itemValue = $pname.",".$party.",".$photo;

                //sent the ul item to HTML
                print "<a href='showinfo.php?infoKey=".$itemValue."'><li>".$pname."</li></a><br/>";
            }
        }//end of loop

        //send close ul to HTML
        print "</ul>";
    }
    else print "CSV file not available";
?>