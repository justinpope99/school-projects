<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

       
            function runjQuery()
            {
                //using ajax to communicate with the server's PHP program
                $.ajax({
                    //the parameters
                    url:        "US_Presidents.php",
                    success:    function(serverdata)
                    {
                        $("$showundordedList").html(serverdata);
                    }
                });
            }
