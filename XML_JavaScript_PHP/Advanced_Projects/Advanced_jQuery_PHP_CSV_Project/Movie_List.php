<?php

    $searchTxt = $_GET["searchKey"];

    $file = "final.csv";
    if (($open = fopen($file, "r")) !== FALSE) 
    { 
        while (($data = fgetcsv($open, 1000, ";")) !== FALSE) 
        {        
            $lineArray[] = $data; 
        }   
        fclose($open);
    }

    print "<select id='movieList' size='10' onchange='showMovieInfo()'>";

    for($i = 1; $i < count($lineArray); $i++) {

        if ($searchTxt != "")
        {
            // Film case
            if (substr(strtolower($lineArray[$i][0]),0,strlen($searchTxt)) == strtolower($searchTxt))
            {
                $film = $lineArray[$i][0];
                $year = $lineArray[$i][1];
                $director = $lineArray[$i][2];

                $optionValue = $film.",".$year.",".$director;
                            
                print "<option value='".$optionValue."'>".$film . " (" . $year . "), " . $director."</option>"; 
            }
            // Year case
            else if (substr(strtolower($lineArray[$i][1]),0,strlen($searchTxt)) == strtolower($searchTxt))
            {
                $film = $lineArray[$i][0];
                $year = $lineArray[$i][1];
                $director = $lineArray[$i][2];

                $optionValue = $film.",".$year.",".$director;

                print "<option value='".$optionValue."'>".$film . " (" . $year . "), " . $director."</option>"; 
            }
            // Director case
            else if (substr(strtolower($lineArray[$i][2]),0,strlen($searchTxt)) == strtolower($searchTxt))
            {
                $film = $lineArray[$i][0];
                $year = $lineArray[$i][1];
                $director = $lineArray[$i][2];

                $optionValue = $film.",".$year.",".$director;

                print "<option value='".$optionValue."'>".$film . " (" . $year . "), " . $director."</option>"; 
            }
        }
        else
            {

                $film = $lineArray[$i][0];
                $year = $lineArray[$i][1];
                $director = $lineArray[$i][2];

                $optionValue = $film.",".$year.",".$director;
                                

                print "<option value='".$optionValue."'>".$film . " (" . $year . "), " . $director."</option>"; 
            }
    }

    print "</select>";

?>