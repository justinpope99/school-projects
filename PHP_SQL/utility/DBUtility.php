<?php

class DBUtility {
  
private $servername = "localhost";
private $username = "root";
private $password = "";
private $dbname = "finance";
private $conn;

function __construct(){

  $this->conn = new mysqli($this->servername, $this->username, $this->password, $this->dbname);
  // Check connection
  if ($this->conn->connect_error) {
    die("Connection failed: " . $this->conn->connect_error);
  }
}

  function execute($sql) {


      $result = $this->conn->query($sql);

      $rows = []; 

      if ($result->num_rows > 0) {

        while($row = $result->fetch_assoc()) { 
          $rows[] = $row;
        }
      } else {
        echo "0 results";
      }

      return $rows;
  }    

  function __destruct() {
    $this->conn->close();
  }
}

?>