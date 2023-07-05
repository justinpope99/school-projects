<!DOCTYPE html>
<html>
    <body>
        <h2>US Presidents (Partial List)</h2>
        <p></p>
        <?php
            $info = $_GET["infoKey"];
            
            //string variable $info is the same as variable $itemValue
            //therefore it has president's name, party, and photo all separated by comma
            //using PHP explode function to separate those values
            //explode() returns an array
            $name = explode(",",$info)[0];
            $party = explode(",",$info)[1];
            $photo = explode(",",$info)[2];

            print "US President: ". $name."<br/>";
            print "<img src='".$photo."'/><br/>";
            print "Party: " .$party;


        ?>
    </body>
</html>