<style>
    .active {
        color:black;
        font-weight: bold;
    }
    .nav {
        border: solid 1px black;
    }
</style>

<?php 
    $code = get("code", 'S');

    $s = "";
    $m = "";
    $mfj = "";
    $hh = "";

    if ($code == 'S')
        $s = "active";
    elseif ($code == 'M')
        $m = "active";
    elseif ($code == 'MFJ')
        $mfj = "active";
    elseif ($code == 'HH')
        $hh = "active";
?>

<nav class="nav">
    <a class="nav-link <?= $s ?>"    aria-current="page" href="?code=S">Single</a>
    <a class="nav-link <?= $m ?>"    href="?code=M">Married</a>
    <a class="nav-link <?= $mfj ?>"  href="?code=MFJ">Married Filing Jointly</a>
    <a class="nav-link <?= $hh ?>"   href="?code=HH">Head of House Hold</a>    
</nav>