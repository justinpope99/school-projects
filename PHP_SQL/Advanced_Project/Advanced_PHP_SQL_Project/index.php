<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <?php include "bootstrap.head.php"; ?>
</head>
<body>

<div class="jumbotron text-center">
  <h2>Companies Investments/Employee Report</h2>
  <p></p> 
</div>


<?php 
      include "./utility/DBUtility.php";
      include "./utility/Format.php";
      $sql = "select * from investment_summary_vw";
      $dbUtility = new DBUtility();
      $rows = $dbUtility->execute($sql);
?>
  
<div class="container">
  <div class="row">
  <?php foreach ($rows as $index => $currentRow) {
      $companyId = $currentRow["id"];
      $total = $currentRow["total"];
    ?>
    <div class="col-sm-4">
      <h3>Report <?= $index + 1 ?> <a href="custom-report.php?companyId=<?=$companyId?>"> goto </a></h3>
      <p><?= $currentRow["companyName"] ?></p>
      <p>The company above has a total investments of <?= money($total) ?> 
        and total 50 accounts.  The largest company is worth 100,000 
        billion and the smallest company is worth 50 billion dollars.
      </p>
    </div>
    <?php } ?>


    <div class="col-sm-4">
          <h3>8 Marriage Report<a href="marriage-code.php"> goto </a></h3>
          <p>This report contains the follow codes: Single , Married and Head of House Hold
          </p>
    </div>

  </div>
</div>

</body>
</html>
