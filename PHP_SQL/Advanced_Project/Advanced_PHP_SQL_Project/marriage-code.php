<html lang="en"><head>
    <title>People View by Justin Pope</title>
    <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="custom.css"></head>
  <?php include "bootstrap.head.v01.php"; 
        include "./utility/DBUtility.php";
        include "./utility/Format.php";
        include "./utility/function.php";

        $code = get("code", 'S');
        if ($code == 'S')
          $description = 'Single';
        elseif ($code == 'M'){
          $description = 'Married';
        }
        elseif ($code == 'MFJ'){
          $description = 'Married Filing Jointly';
        }
        elseif ($code == 'HH'){
          $description = 'Head of House Hold';
        }
        $dbUtility = new DBUtility();
        $sql = "Select id, first_name, last_name, salary, age, description
                From people_vw
                Where code = '$code'
                limit 15";
        $rows = $dbUtility->execute($sql);
  ?>
</head>
  <body>
  
  <div class="container" style="width: 60%">
    <h2>Top 15 <?= $description ?>  <a href="./"> goto index </a></h2>
    <p>A list of people</p>  
    <h4><?php include "menu.php"; ?>       </h4>   
    <table class="table">
      <thead>
        <tr>
          <th>id</th>
          <th>name</th>
          <th>salary</th>
          <th>age</th>
          <th>description</th>
        </tr>
      </thead>
      <tbody>
      <?php foreach ($rows as $currentRow) { ?>
            <tr>
                <td><?= $currentRow["id"] ?></td>
                <td><?= $currentRow["first_name"] ?> <php? . ?><?= $currentRow["last_name"] ?></td>
                <td class='money'><?= money($currentRow["salary"]) ?></td>
                <td><?= $currentRow["age"] ?></td>
                <td><?= $currentRow["description"] ?></td>
            </tr> 
        <?php    } ?>
          </tbody>
          
          <tfoot>
            <tr>
              <td> Average Salary:</td>
              <td colspan="4" class='money'> <?= money(avgSalary($rows)); ?></td>
            </tr>
            <tr>
              <td> Total Salary:</td>
              <td colspan="4" class='money'> <?= money(sumSalary($rows)); ?></td>
            </tr>
            <tr>
              <td> Maximum Salary:</td>
              <td colspan="4" class='money'> <?= money(maxSalary($rows)); ?></td>
            </tr>
            <tr>
              <td> Minumum Salary:</td>
              <td colspan="4" class='money'>  <?= money(minSalary($rows)); ?></td>
            </tr>
          </tfoot>
  
      
    </table>
  </div>  
  
  </body></html>