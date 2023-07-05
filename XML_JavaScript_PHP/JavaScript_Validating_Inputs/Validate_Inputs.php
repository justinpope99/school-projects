<!DOCTYPE html>
<html>
    <head>

    </head>
    <body>
        <h2>Login</h2>

        <!-- start PHP code -->
        <?php

            //reading inputs
            $usernameIn = $_POST["usernameTxtBx"];
            $pwdIn = $_POST["pwdTxtBx"];

            //store pairs (username, password) as an array in PHP
            //$credentials = array("John", "Mary"); // 1D array

            /* Method 1: 2D array
            $credentials = array(
                array("John", "123456"),
                array("Mary", "789012"),
                array("Kate", "112233")
            ); */

            //Method 2: another way to create 2D array - just populate it
            $credentials[0][0] = "Johnny";
            $credentials[0][1] = "123456";
            $credentials[1][0] = "Maryan";
            $credentials[1][1] = "789012";
            $credentials[2][0] = "Kately";
            $credentials[2][1] = "112233";

            //array size
            $credentialsSize = count($credentials);

            //boolean variable for a match
            $found = false;

            //loop through the array to ensure a match between input and stored pair
            for($index=0; $index<$credentialsSize;$index++)
            {
                if ($usernameIn == $credentials[$index][0] && $pwdIn == $credentials[$index][1])
                {
                    $found = true;
                    break;
                }
            }
            
            if ($found == true) print "Welcome, ".$usernameIn;
            else print "Invalid credentials";

        ?>
    </body>
</html>